/**
 * Seq라는 콜렉션이 있는듯?
 * 내부 문서가 그렇게 잘 되어있는 경우는 아닌듯
 */
object Main extends App {
  val ages = Seq(42, 75, 29, 64)
  println(s"The oldest person is ${ages.max}") // 변수값을 대입하기 위해선 s로 표현이 가능 -> 이것 또한 함수 StringContext.s
}


