package com.texst.spark

object ImpilicitTest {
  def main(args: Array[String]): Unit = {
    implicit val str ="jack"

     def hell(implicit str:String):Unit={
      println("hell"+str)
    }

  hell("liangman")

  }

}
