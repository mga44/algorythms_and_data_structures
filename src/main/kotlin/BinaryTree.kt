class BinaryTree<T>(rootVal: T) {
    private var root: Node<T>

    init {
        root = Node(rootVal)
    }

    fun addChildToElement(element: T, child: T) {
        val searchedElement: Node<T> = findElement(element, root)
            ?: throw IllegalStateException("Element $element was not found in Binary tree")

        if (searchedElement.children.size >= 2)
            throw IllegalStateException("Cannot add $child as child to $element: Element has already 2 children")

        searchedElement.addChild(child)
    }

    private fun findElement(element: T, currentNode: Node<T>): Node<T>? {
        if (currentNode.value == element) {
            return currentNode
        } else {
            for (child in currentNode.children) {
                val candidate = findElement(element, child)
                if (candidate != null)
                    return candidate
            }
        }

        return null
    }

    override fun toString(): String {
        return root.toString()
    }
}