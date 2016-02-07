package mars

import scala.io.Source

object FileReader {
  def readFrom(path: String) = Source.fromURL( getClass.getResource(path) ).getLines().filterNot( _.isEmpty ).toList
}
