package mars

import implicitly.ImplicitCase.CaseInsensitive

sealed trait Compass {
  val symbol: String
  def move(coordinate: Coordinate) : Coordinate
}

object Compass {
  def apply(symbol: String) = symbol match {
    case ignoreCase"N" => North
    case ignoreCase"S" => South
    case ignoreCase"W" => West
    case ignoreCase"E" => East
    case _ => Unknown
  }
}

case object North extends Compass {
  override val symbol = "N"
  override def move(coordinate: Coordinate) = Coordinate(coordinate.x, coordinate.y + 1)
}

case object South extends Compass {
  override val symbol = "S"
  override def move(coordinate: Coordinate) = Coordinate(coordinate.x, coordinate.y - 1)
}

case object West extends Compass {
  override val symbol = "W"
  override def move(coordinate: Coordinate) = Coordinate(coordinate.x - 1, coordinate.y)
}

case object East extends Compass {
  override val symbol = "E"
  override def move(coordinate: Coordinate) = Coordinate(coordinate.x + 1, coordinate.y)
}

case object Unknown extends Compass {
  override val symbol = "U"
  override def move(coordinate: Coordinate) = throw new UnsupportedOperationException("Unknown direction doesn't move")
}


