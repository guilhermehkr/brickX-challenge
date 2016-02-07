package specs2

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class ListWithRemoveSpec extends Specification with ScalaCheck {

  "List with remove method" should {
    "remove first element and return all other elements" in {

      val list = List(1,2,3,4,5)

      import implicitly.ImplicitCase.ListWithOtherMethods
      val newList = list.removeFirst()

      newList must not contain 1
      newList must containAllOf( List(2,3,4,5) )
    }
  }
}
