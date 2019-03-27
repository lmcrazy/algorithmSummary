package com.sumfa

import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.ml.{Pipeline, PipelineModel, PipelineStage, Transformer}
import org.apache.spark.ml.classification.{DecisionTreeClassificationModel, DecisionTreeClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature._;
// 参考博客 https://www.cnblogs.com/itboys/p/8312894.html
object MyDecisionTreeClassifer {
  def main(args: Array[String]): Unit = {

    // 1.sparksession
    val spark = SparkSession.builder().master("local[4]").appName("myDecisionTreeClassifer").getOrCreate()

    // 2.设置日志级别

    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF);

    // 3.数据目录，读取数据
    val dataPath = "/Users/lm/Downloads/111/sample_multiclass_classification_data.txt"

    // 4.读取数据

    val rawData: Dataset[Row] = spark.read.format("libsvm").load(dataPath)

    // 5.分割数据

    val array = rawData.randomSplit(Array(0.8, 0.2))

    val trainData: Dataset[Row] = array(0)

    val testData: Dataset[Row] = array(1)

    // -------
    // 6.1 对label进行重新编号

    val labelIndexerModel: StringIndexerModel = new StringIndexer()
      .setInputCol("label")
      .setOutputCol("indexedLabel")
      .setHandleInvalid("skip").fit(rawData)

    // 6.2 对特征向量进行重新编号
    //  针对离散型特征而言的，对离散型特征值进行编号。
    //  .setMaxCategories(5)表示假如特征值的取值多于四种，则视为连续值
    //  也就是这样设置就无效了


    val featureIndexerModel: VectorIndexerModel = new VectorIndexer()
      .setInputCol("features")
      .setMaxCategories(5)
      .setOutputCol("indexedFeatures")
      .fit(rawData)

    // 6.3 决策分类器参数设置

    for (maxDepth <- 2 to 10) {
      val dtClassifier: DecisionTreeClassifier = new DecisionTreeClassifier().setLabelCol("indexedLabel")
        .setFeaturesCol("indexedFeatures")
        .setMaxDepth(maxDepth)
        .setImpurity("entropy")

      //6.4 将编号后的预测label转换回来

      val converter: IndexToString = new IndexToString().setInputCol("prediction").setOutputCol("convetedPrediction")
        .setLabels(labelIndexerModel.labels)

      // 6.5 构建pipeline

      val pipeline: Pipeline = new Pipeline().setStages(Array[PipelineStage](labelIndexerModel, featureIndexerModel, dtClassifier, converter))

      // 7 在训练集上训练pipeline模型

      val pipelineModel: PipelineModel = pipeline.fit(trainData)

      // 8 预测

      val testPrediction: DataFrame = pipelineModel.transform(testData)

      // 9 评估

      val evaluator: MulticlassClassificationEvaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction")
        .setMetricName("accuracy")

      System.out.println("MaxDepth is: " + maxDepth)

      val accuracy = evaluator.evaluate(testPrediction)
      System.out.println("accuracy is: " + accuracy)


      val treeModel: DecisionTreeClassificationModel = pipelineModel.stages(2).asInstanceOf[DecisionTreeClassificationModel]

      System.out.println("Learned classification tree model depth"
        + treeModel.depth + " numNodes " + treeModel.numNodes)


    }


  }

}
