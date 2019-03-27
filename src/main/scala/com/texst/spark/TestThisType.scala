package com.texst.spark

object TestThisType {

//  val fd = new Food()
//  fd.setName("aa").setAge(12)
//  println(fd.getAge())

  val rice = new Rice
  //这是没问题的因为返回的是Food
  rice.setName("guangxidami").setAge(3)
  //这样也没问题，setgrow()返回大米这个对象，可以调用父类的setName，setAge方法
  rice.setgrow().setName("beijingdami").setAge(1)

  // TODO this.type 适合用在父类方法中
  rice.setName("zhejiangdami").setAge(4).setgrow()


}


class Food{

  private var name: String = _
  private var age: Int = _

  def setName(getName: String):this.type = {
    this.name = getName
    this
  }
  def setAge(getAge: Int):this.type = {
    this.age = getAge
    this
  }


  def getAge() ={
    this.age
  }

  /*
  def setName(getName: String) = {
    this.name = getName
    this
  }
  def setAge(getAge: Int)= {
    this.age = getAge
    this
  }
   */

  override def toString: String = "name = " + name + "||=|| age = " + age
}


class Rice extends Food{

  def setgrow() ={
    println(" I am growing!! Don't eat me :(")
    this
  }
}