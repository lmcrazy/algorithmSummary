package com.sumfa

import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.feature._
import org.apache.spark.sql.{DataFrame, SparkSession}


object TestIDF {
  val spark = SparkSession.builder().master("local").appName("IndexToString").getOrCreate()
  Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

  Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF);

  def main(args: Array[String]): Unit = {
    val df = spark.createDataFrame(Seq(
      (0, "I head about Spark"),
      (0, "I wish java could use case classes"),
      (1, "Logistic regression models aare neat")
    )).toDF("label", "sentence")

    val tokenizer: Tokenizer = new Tokenizer().setInputCol("sentence").setOutputCol("words")
    val frame: DataFrame = tokenizer.transform(df)

    frame.show()

    val f: HashingTF = new HashingTF().setInputCol("words").setOutputCol("rawfeatures").setNumFeatures(20)

    val frame1: DataFrame = f.transform(frame)

    val idf: IDF = new IDF().setInputCol("rawfeatures").setOutputCol("features")

    val model: IDFModel = idf.fit(frame1)

    val frame2: DataFrame = model.transform(frame1)

    frame2.createOrReplaceTempView("t_idf")


    spark.sql(
      """
        |SELECT
        |*
        |FROM
        |t_idf
      """.stripMargin).show()








  }

}
