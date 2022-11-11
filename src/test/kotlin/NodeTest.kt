import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NodeTest {
    @Test
    fun stringRepresentationShouldBeCorrect() {
        val tree: Node<String> = Node("String")
        tree
            .addChild("Another string")
            .addChild("Third string")
        tree.addChild("ooo new node")

        val expectedStringRepresentation =
            "String\n" +
            "  Another string\n" +
            "    Third string\n" +
            "  ooo new node\n"

        assertThat(tree.toString()).isEqualTo(expectedStringRepresentation)
    }
}