import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalStateException

internal class BinaryTreeTest{
    @Test
    fun addingMoreThanTwoElementsShouldThrowException() {
        //given
        val tree = BinaryTree<String>("root")
        tree.addChildToElement("root", "1st node")
        tree.addChildToElement("root", "2nd node")

        //when & then
        assertThatThrownBy { tree.addChildToElement("", "3") }.isInstanceOf(IllegalStateException::class.java)
    }
}