package specs2

import mars._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class MarsSpec extends Specification with ScalaCheck {

  "Mars" should {

    val lines = FileReader readFrom SpecsSetup.myTest

    "real test in land" in {

      val rovers = Mars.executeMission(SpecsSetup.myTest)
      rovers.foreach( rover => println(rover.output) )

      1 mustEqual 1
    }
  }
}
