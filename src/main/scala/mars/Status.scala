package mars

sealed trait Status
case object Ok extends Status
case object Nok extends Status

