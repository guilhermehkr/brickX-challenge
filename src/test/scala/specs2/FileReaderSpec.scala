package specs2


import java.io.FileNotFoundException

import mars.FileReader
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.specs2.ScalaCheck

@RunWith(classOf[JUnitRunner])
class FileReaderSpec extends Specification with ScalaCheck {
  
  "File reader" should {

    "throw exception when file isn't found" in {
      FileReader readFrom "/not-found.file" must throwA[NullPointerException]
    }

    "read entire file removing empty lines" in {
      val lines = FileReader readFrom SpecsSetup.myTest
      lines must not contain ""
    }
  }
}
