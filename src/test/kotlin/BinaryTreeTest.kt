import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class BinaryTreeTest {
    @Test
    fun addingMoreThanTwoElementsShouldThrowException() {
        //given
        val tree = BinaryTree<String>("root")
        tree.addChildToElement("root", "1st node")
        tree.addChildToElement("root", "2nd node")

        //when & then
        assertThatThrownBy { tree.addChildToElement("", "3") }.isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun addingElementsToTreeShouldWorkProperly() {
        //given
        val tree = BinaryTree("root")
        val expectedNode = Node<String>("root")
        expectedNode
            .addChild("firstElement")
            .addChild("secondElement")

        //when
        tree.addChildToElement("root", "firstElement")
        tree.addChildToElement("firstElement", "secondElement")

        //then
        assertThat(tree.root).isEqualTo(expectedNode)
    }
}