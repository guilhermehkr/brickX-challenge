package specs2

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class ExecutorSpec extends Specification with ScalaCheck {

  "Executor" should {

    "execute nothing for the time being" in {

      1 mustEqual 1
    }
  }
}
