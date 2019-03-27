package com.test



object TestFanxing {
  def main(args: Array[String]): Unit = {
    val test = IntMessage(10)
    println(test.get)

  }


}


abstract class Message[T](s:T){
  def get = s
}

case class IntMessage[Int](var v:Int) extends Message

