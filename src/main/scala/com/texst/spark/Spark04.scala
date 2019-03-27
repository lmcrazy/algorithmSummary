package com.texst.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.slf4j.LoggerFactory


object Spark04 {

  val logger = LoggerFactory.getLogger(Spark04.getClass)


  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("shadowsocks").setMaster("spark://graph3:7077")
   // conf.set("spark.eventLog.enabled","true")
    //conf.set("spark.yarn.historyServer.address","graph2:18081")
    //conf.set("spark.eventLog.dir","hdfs://mycluster/spark2/historylogs")

    //conf.set("spark.scheduler.revive.interval","100000s")
    //executor debug,是在提交作的地方读取
    conf.set("spark.executor.memory", "512m")

    //conf.set("spark.executor.extraJavaOptions","-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=10002")
    conf.setJars(Array("/Users/lm/Downloads/yarn/target/yarn-1.0-SNAPSHOT.jar"))
    //val conf = new SparkConf().setMaster("spark://graph3:7077").setAppName("shadowsocks")

    val sc =new SparkContext(conf)
    val distFile = sc.textFile("hdfs://mycluster/graph/a.txt")

    println(distFile)

    val result = distFile.flatMap(_.split(" ")).collect()
        //.map((_,1)).reduceByKey(_+_)
    println(s" result is $result")

    val threadName = Thread.currentThread().getId + Thread.currentThread().getName

    println(s"${threadName}===================结果:执行了毫秒:${System.currentTimeMillis() }")


    distFile.saveAsTextFile("/user/lm")



    sc.stop()




  }


}
