package mars

case class Coordinate(x: Int, y: Int)

case class Rover(coordinate: Coordinate, currentDirection: Compass, commands: List[Command], status: Status, output: String = "") {

  def validate(plateau: Plateau): Rover = {

    val rover = this
    if (rover.currentDirection == Unknown) {
      rover.copy(status = Nok, output = "The initial direction could not be read, impossible to proceed")
    } else if (rover.status == Nok) {
      rover.copy(output = "The rover entry was malformed")
    } else if (rover.commands.contains(UnknownCommand)) {
      rover.copy(status = Nok, output = "There is one invalid command at least, impossible to proceed")
    } else if (rover.coordinate.x > plateau.boundX || rover.coordinate.y > plateau.boundY) {
      rover.copy(status = Nok, output = "The rover is outside of plateau upper-right")
    } else if ((rover.currentDirection == South || rover.currentDirection == West)
                && (rover.coordinate.x < 0 || rover.coordinate.y < 0)) {
      rover.copy(status = Nok, output = "The rover is outside of plateau bottom-left")
    } else if(rover.coordinate.x < 0 || rover.coordinate.y < 0) {
      rover.copy(status = Nok, output = "It is not accepted negative coordinates")
    } else {
      rover
    }
  }
}

object Rover {

  val nokRover = Rover(Coordinate(-1,-1), Compass("U"), List.empty, Nok)

  def apply(entries: Iterator[List[String]]) : List[Rover] = {

    entries.map {
      entry =>
        val rover = entry.headOption.map {
          coordinate =>

            coordinate.split("\\s+") match {
              case Array(x, y, direction) => Rover(Coordinate(x.toInt, y.toInt), Compass(direction), List.empty, Ok)
              case _ => nokRover
            }

        }.getOrElse(nokRover)

        val commands = entry.lastOption.map {
          commands =>
            commands.toCharArray.map {
              commandLetter => Command(commandLetter.toString)
            }.toList
        }.getOrElse(List.empty)

        rover.copy(commands = commands)

    }.toList
  }
}