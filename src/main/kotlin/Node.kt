class Node<T>(private val value: T) {
    private val children: MutableList<Node<T>> = mutableListOf()

    fun addChild(childValue: T): Node<T> {
        val element = Node(childValue)
        children.add(element)
        return element
    }

    fun getChildren(): List<Node<T>> {
        return children
    }

    fun contains(value: T): Boolean {
        if (this.value != null && this.value == value)
            return true

        return false
    }

    override fun toString(): String {
        return printLevel(0)
    }

    private fun printLevel(level: Int): String {

        return " ".repeat(2 * level) + this.value.toString() + System.lineSeparator() + if (children.isEmpty()) "" else children.map { x ->
            x.printLevel(
                level + 1
            )
        }.reduce(String::plus)
    }
}