package specs2

import mars._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class MarsSpec extends Specification with ScalaCheck {

  "Mars" should {

    " Executing the mission: real test in mars land (You're going to see the output results above test results)" in {

      val rovers = Mars executeMission SpecsSetup.realTestFile
      println("------------------------------------------------------------------")
      println("Output:")
      rovers.foreach( rover => println(s"--> ${rover.output}") )
      println("------------------------------------------------------------------")


      1 mustEqual 1
    }
  }
}
