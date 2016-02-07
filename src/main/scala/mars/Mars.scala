package mars

import implicitly.ImplicitCase.ListWithOtherMethods

object Mars {

  def executeMission(path: String) = {

    val lines = FileReader readFrom path
    val plateau = Plateau( lines )

    val entriesGruoped = lines.removeFirst().grouped(2)

    Executor.play( plateau, Rover(entriesGruoped) )
  }
}
