fun main(args: Array<String>) {
    //  println("Hello World!")

    val tree: Node<String> = Node("String")
    tree
        .addChild("Another string")
        .addChild("Third string")
    tree.addChild("ooo new node")

    println(tree)
}