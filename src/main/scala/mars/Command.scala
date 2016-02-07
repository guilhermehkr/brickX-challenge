package mars

import implicitly.ImplicitCase.CaseInsensitive

sealed trait Command {
  def execute(plateau: Plateau, rover: Rover) : Rover
}

object Command {
  def apply(command: String) : Command = command match {
    case ignoreCase"L" => Left
    case ignoreCase"R" => Right
    case ignoreCase"M" => Movement
    case _ => UnknownCommand
  }
}

case object Left extends Command {

  def execute(plateau: Plateau, rover: Rover) = {
    val newDirection = rover.currentDirection match {
      case North => West
      case South => East
      case West => South
      case East => North
    }
    rover.copy(currentDirection = newDirection)
  }
}

case object Right extends Command {

  def execute(plateau: Plateau, rover: Rover) = {
    val newDirection = rover.currentDirection match {
      case North => East
      case South => West
      case West => North
      case East => South
    }
    rover.copy(currentDirection = newDirection)
  }
}

case object Movement extends Command {

  def execute(plateau: Plateau, rover: Rover) = {
    rover.copy(coordinate = rover.currentDirection.move(rover.coordinate)).validate(plateau)
  }
}

case object UnknownCommand extends Command {
  def execute(plateau: Plateau, rover: Rover) = throw new UnsupportedOperationException
}