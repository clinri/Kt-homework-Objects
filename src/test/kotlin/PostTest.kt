import data.Post
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import sevices.WallService

class PostTest {
    @Before
    fun clearArrayWhithPosts(){
        WallService.removeAll()
    }
    @Test
    fun test_post_id_not_equals_zero() {
        val id = WallService.add(Post(text = "Текст поста1"))
        Assert.assertNotEquals(id,0)
    }
    @Test
    fun test_change_post_with_actual_id(){
        WallService.add(Post(text = "Текст поста1"))
        val result = WallService.update(Post(id = 2, text = "Текст поста4"))
        assertTrue(result)
    }
    @Test
    fun test_change_post_with_false_id(){
        WallService.add(Post(text = "Текст поста1"))
        val result = WallService.update(Post(id = 1, text = "Текст поста4"))
        assertFalse(result)
    }
}