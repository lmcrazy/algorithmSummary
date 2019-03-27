package com.patten.scala

class Singleton private() {

}

// 单例模式
object Singleton {

  private var single: Singleton = _

  def getSingle(): Singleton = {
    if (single == null) {
      single = new Singleton
    }
    single
  }

}
