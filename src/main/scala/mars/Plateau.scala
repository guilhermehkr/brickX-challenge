package mars

case class Plateau(boundX: Int, boundY: Int)
object Plateau {

  def apply(lines: List[String]) : Plateau =
    lines.headOption.map( _.split("\\s+") match {

      case Array(boundX, boundY) => Plateau(boundX.toInt, boundY.toInt)
      case _ => throw new IllegalStateException("There is no correspondent line for plateau creation")

    }).getOrElse(throw new IllegalStateException("Plateau creation is impossible"))
}
