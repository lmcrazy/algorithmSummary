package com.texst.spark

object EnumTest {

  object EnumLm extends Enumeration{
    type EnumLm = Value
    val Monday = Value("1")
    val Satday = Value("2")

    def checkExist(day:String): Boolean = this.values.exists(_.toString == day)
  }

  def main(args: Array[String]): Unit = {
    println(EnumLm.checkExist("2"))//检测是否存在

  }

}
