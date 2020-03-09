import org.scalatest.FunSuite

class CubeCalculatorTest extends FunSuite {
  test("CubeCalculator.cube") {
    assert(CubeCalculator.cube(3) === 27)
  }
  /**
   * 27 did not equal 26
   * ScalaTestFailureLocation: CubeCalculatorTest at (CubeCalculatorTest.scala:9)
   * Expected :26
   * Actual   :27
   */
  test("CubeCalculator.cube2") {
    assert(CubeCalculator.cube(3) === 26)
  }
}
