class Node<T>(val value: T) : Cloneable {
    val children: MutableList<Node<T>> = mutableListOf()

    fun addChild(childValue: T): Node<T> {
        val element = Node(childValue)
        children.add(element)
        return element
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node<*>

        if (value != other.value) return false
        if (children != other.children) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value?.hashCode() ?: 0
        result = 31 * result + children.hashCode()
        return result
    }

    override fun clone(): Node<T> {
        TODO("to be implemented correctly")
        // return Node(value, children)
    }
}