package com.test

object TestThrows {


  def main(args: Array[String]): Unit = {
//    println("test-------")
//    abc

    //TestObject.sayHi();

    implicit var a_name : String = "liangman"

     def get(implicit str : String ): Unit = {
      println(str)
    }
    get
  }

  @throws(classOf[NumberFormatException])
  def abc(): Unit ={
    println("---*****-----")
    "abc".toInt
    println("---+++++-----")

  }

}
