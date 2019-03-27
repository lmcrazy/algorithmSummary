package com.sparksql

import org.apache.spark.sql.SparkSession

object TestDataSet {

  def main(args: Array[String]) {

    val sparkSession = SparkSession.builder.
      master("local")
      .appName("example")
      .getOrCreate()

    import sparkSession.implicits._
    val data = sparkSession.read.text("/Users/lm/Downloads/111/abc.txt").as[String]

    val words = data.flatMap(value => value.split("\\s+"))
    println(words)
    val groupedWords = words.groupByKey(_.toLowerCase)


    val counts = groupedWords.count()

    counts.show()

  }
}
