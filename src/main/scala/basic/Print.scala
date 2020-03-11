package basic

object Print extends App {
  println(1) // 1
  println(1 + 1) // 2
  println("Hello!") // Hello!
  println("Hello," + " world!") // Hello, world!

  val x = 1 + 1
  println(x)
  // Value는 재할당 할 수 없다.
  // x = 2 // compile error


  // Type 추론을 하여 할당한다.
  val infered: Int = 1 + 1


  /**
   * Variables는 재할당 가능하다.
   */
  var iamVariable = 1 + 1
  iamVariable = 3;

  /**
   * 똑같이 Type 추론을 할 수 있다.
   */
  var iamVari: Int = 1 + 1

  /**
   * Block 표현으로 가능
   */
  println({
    val x = 1 + 1
    x + 1
  }) // 3

  /**
   * 익명함수표현
   * 파라미터 -> Return
   */
  (x: Int) => x + 1

  val addOne = (x: Int) => x + 1
  println(addOne(1)) // 2

  /**
   * 여러개도 가능
   */
  {
    // block scope
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3
  }
  /**
   * 없어도 가능 :)
   */
  val getTheAnswer = () => 42
  println(getTheAnswer()) // 42


  def add(x: Int, y: Int): Int = x + y
  println(add(1, 2)) // 3


  /**
   * WOW Scala의 처음보는 표현이네요?
   * 이렇게 나눠서 표현하면 뭐가 좋지?
   * 역할에 맞게 분리할 수 있지 않을까?
   * 객체로 표현하는거랑 뭐가 다르지?
   * 좀 더 명확하게 가져갈 수 있을듯
   */
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(1, 2)(3)) // 9


  /**
   * no parameter
   */
  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")


  /**
   * Multi line Function
   */
  def getSquareString(input: Double): String = {
    val square = input * input

    if(true)
      return square.toString // 요럴땐 Return을 삭제안하라고 권고하네

    square.toString // return 을 표기 안하는게 컨벤션
  }
  println(getSquareString(2.5)) // 6.25

  {
  /**
   * 클래스는 자바와 똑같다.
   * 생성자는 바로 뒤에 붙는 내용
   * 무조건 강제화하는군?
   * 다양한 생성자 선언은 할 수 없을까?
   * 변수 보기가 너무 불편하네
   */
  class Greeter(prefix: String, suffix: String){
    def greet(name: String): Unit = // Unit == void
      println(prefix + name + suffix)
  }

  new Greeter("hello", "hello")
  }
  /**
   * Case Classes라는게 존재한다.
   * immutable
   * 패턴 매칭할때 유용하게 쓰인다.
   * 비교할때 reference가 아닌 value를 기준으로 비교한다.
   */
  case class Point(x: Int, y: Int)

  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(2, 2)

  if (point == anotherPoint) {
    println(point + " and " + anotherPoint + " are the same.")
  } else {
    println(point + " and " + anotherPoint + " are different.")
  } // Point(1,2) and Point(1,2) are the same.

  if (point == yetAnotherPoint) {
    println(point + " and " + yetAnotherPoint + " are the same.")
  } else {
    println(point + " and " + yetAnotherPoint + " are different.")
  } // Point(1,2) and Point(2,2) are different.

  /**
   * 하나의 인스턴스를 말한다.
   * 쉽게 생각하면 하나의 싱글턴 클래스라고 생각하면된다.
   */
  object IdFactory {
    private var counter = 0 // 공유 변수
    def create(): Int = {
      counter += 1
      counter
    }
  }

  val newId: Int = IdFactory.create()
  println(newId) // 1
  val newerId: Int = IdFactory.create()
  println(newerId) // 2

  /**
   * 추상 데이터 타입
   * java의 interface 느낌?
   * 클래스는 다른 클래스를 오직 하나만 상속 가능하지만
   * 여러개의 traits를 상속받을 수 있다.
   */
  trait Greeter {
    def greet(name: String): Unit
  }

  /**
   * default method도 선언 가능
   */
  trait Greeter2 {
    def greet(name: String): Unit =
      println("Hello, " + name + "!")
  }

  class DefaultGreeter extends Greeter2

  class CustomizableGreeter(prefix: String, postfix: String) extends Greeter2 {
    override def greet(name: String): Unit = { // override가 키워드
      println(prefix + name + postfix)
    }
  }

  val greeter = new DefaultGreeter()
  greeter.greet("Scala developer") // Hello, Scala developer!

  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer") // How are you, Scala developer?s
}





