/**
 * Java Main -> extends App 역할
 * ; 필요없음
 * space 2개를 사용
 * @see https://docs.scala-lang.org/getting-started/intellij-track/getting-started-with-scala-in-intellij.html
 */
object Hello extends App {
  // 함수 정의 예약어 def
  // 함수 이름
  // 파라미터 이름
  // 파라미터 타입
  // 리턴 타입
  // 함수 바디
  def square(x: Int) = x * x
  println("Hello, World!")
  println(square(2))
}

