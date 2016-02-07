package mars


object Executor {

  def play(plateau: Plateau, rovers: List[Rover]) = {

    val checkedRovers = rovers.map(_.validate(plateau))

    checkedRovers.partition(_.status == Ok) match {
      case (oks, noks) =>
        oks.map {
          rover =>
            var newRover = rover
            rover.commands.foreach {
              command =>
                newRover = if(newRover.status == Ok) command.execute(plateau, newRover) else newRover //Side effects =(
            }

            if(newRover.status == Ok)
              newRover.copy(output = s"${newRover.coordinate.x} ${newRover.coordinate.y} ${newRover.currentDirection.symbol}")
            else
              newRover

        } ++ noks
    }
  }
}
