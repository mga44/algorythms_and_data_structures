
class BinaryTree<T>(rootVal: T) {
    val root: Node<T>
    //TODO: ensure that get returns copy of the object
    //get() { return root.clone() as Node<T> }

    init {
        root = Node(rootVal)
    }

    fun addChildToElement(element: T, child: T) {
        val searchedElement: Node<T> = findElement(element, root)
            ?: throw IllegalStateException("Element $element was not found in Binary tree")

        if (searchedElement.children.size >= 2)
            throw IllegalStateException("Cannot add $child as child to $element: Element already have 2 children")

        searchedElement.addChild(child)
    }

    private fun findElement(element: T, currentNode: Node<T>): Node<T>? {
        if (currentNode.value == element) {
            return currentNode
        }
        for (child in currentNode.children) {
            val candidate = findElement(element, child)
            if (candidate != null)
                return candidate
        }

        return null
    }

    override fun toString(): String {
        return root.toString()
    }

    override fun equals(other: Any?): Boolean {
        return root == other
    }

    override fun hashCode(): Int {
        return root.hashCode()
    }
}