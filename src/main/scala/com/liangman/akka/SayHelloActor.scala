package com.liangman.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class SayHelloActor extends Actor {

  // 这个会被mailbox调用
  override def receive :Receive= {
    case "hello" => println("hello too")
    case "ok" => println("ok too")
    case "exit" => {
      println("退出系统")
      context.stop(self) //停止actorref
      context.system.terminate() //退出系统
    }
    case _ => println("no match")
  }
}


object SayHelloActorDemo{
  private val factory = ActorSystem("factory")

  private val sayHelloActor: ActorRef = factory.actorOf(Props[SayHelloActor],"sayHelloActor")

  def main(args: Array[String]): Unit = {
    sayHelloActor ! "hello"

    sayHelloActor ! "exit"

  }



}
