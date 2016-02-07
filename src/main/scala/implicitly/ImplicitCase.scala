package implicitly

/**
 * Created by guilhermehkr on 06/02/16.
 */
object ImplicitCase {

  implicit class ListWithOtherMethods[Type](list: List[Type]) {
    def removeFirst() : List[Type] = list diff List(list.head)
  }
  implicit class CaseInsensitive(stringContext: StringContext) {
    def ignoreCase = s"(?i)${stringContext.parts.mkString}".r
  }
}
