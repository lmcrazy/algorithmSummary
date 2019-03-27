package com.spark.masterworker.master

import akka.actor.{Actor, ActorSystem}

class Master extends Actor{
  
  override def receive:Receive= {
    
    case "start" =>{
      println("server start")
    }

    
      
  }
}



object SparkMaster {

  def main(args: Array[String]): Unit = {
    
    // 1. 创建actorstyem
    ActorSystem("server")
    
    
  }

}
