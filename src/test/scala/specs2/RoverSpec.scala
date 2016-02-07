package specs2

import mars._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class RoverSpec extends Specification with ScalaCheck {

  import implicitly.ImplicitCase.ListWithOtherMethods
  "Rover creation" should {

    val lines = FileReader readFrom SpecsSetup.myTest

    "create rovers from file" in {

      val groupedEntries = lines.removeFirst().grouped(2)
      val result = Rover(groupedEntries)

      result must not be empty
      result.headOption must not be None
      result.lastOption must not be None

      result.head.coordinate.x mustEqual 1
      result.head.coordinate.y mustEqual 2
      result.head.currentDirection mustEqual North
      result.head.commands must not be empty
      result.head.status mustEqual Ok

      result.last.coordinate.x mustEqual 3
      result.last.coordinate.y mustEqual 3
      result.last.currentDirection mustEqual East
      result.last.commands must not be empty
      result.last.status mustEqual Ok
    }

    "validate rovers" in {

      val plateau = Plateau( lines )

      val rovers = lines.removeFirst().grouped(2)
      val checkedRovers = Rover(rovers).map(_.validate(plateau))

      checkedRovers must not be empty
      checkedRovers.exists(_.status == Nok) must be equalTo true
      checkedRovers.exists(_.status == Ok) must be equalTo true
      checkedRovers.count(_.status == Ok) must be equalTo 5
      checkedRovers.count(_.status == Nok) must be equalTo 1
    }
  }
}
