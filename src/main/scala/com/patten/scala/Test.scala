package com.patten.scala

object Test {

  def main(args: Array[String]): Unit = {
    val s1 =   Singleton.getSingle()
    val s2 =   Singleton.getSingle()

    println(s1 eq s2)


  }

}
