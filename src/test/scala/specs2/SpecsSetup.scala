package specs2

object SpecsSetup {

  // Files should be at test/resources

  private val myTestFileName = "rovers-entries"
  def myTest = s"/$myTestFileName"

  private val yourFileName = "your-file-will-be-processed"
  def realTestFile = s"/$yourFileName"
}
