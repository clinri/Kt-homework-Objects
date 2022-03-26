import data.*
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import sevices.WallService

class PostTest {
    @Before
    fun clearArrayWhithPosts() {
        WallService.removeAll()
    }

    @Test
    fun test_post_id_not_equals_zero() {
        val id = WallService.add(
            Post(
                text = "Текст поста1", attachments = arrayOf(
                    PhotoAttachment(1, 23, "url1", "url2"),
                    VideoAttachment(2, 25, "video", "good"),
                    AudioAttachment(2, 25, "Metallica", "Song"),
                    LinkAttachment("url", "Url"),
                    GeoAttachment("place", Coordinates(2324234, 123324324))
                )
            )
        )
        Assert.assertNotEquals(id, 0)
    }

    @Test
    fun test_change_post_with_actual_id() {
        WallService.add(
            Post(
                text = "Текст поста1", attachments = arrayOf(
                    PhotoAttachment(1, 23, "url1", "url2"),
                    VideoAttachment(2, 25, "video", "good"),
                    AudioAttachment(2, 25, "Metallica", "Song"),
                    LinkAttachment("url", "Url"),
                    GeoAttachment("place", Coordinates(2324234, 123324324))
                )
            )
        )
        val result = WallService.update(
            Post(
                id = 1, text = "Текст поста4", attachments = arrayOf(
                    PhotoAttachment(1, 23, "url1", "url2"),
                    VideoAttachment(2, 25, "video", "good"),
                    AudioAttachment(2, 25, "Metallica", "Song"),
                    LinkAttachment("url", "Url"),
                    GeoAttachment("place", Coordinates(2324234, 123324324))
                )
            )
        )
        assertTrue(result)
    }

    @Test
    fun test_change_post_with_false_id() {
        WallService.add(Post(text = "Текст поста1", attachments = null))
        val result = WallService.update(
            Post(
                id = 2, text = "Текст поста4", attachments = arrayOf(
                    PhotoAttachment(1, 23, "url1", "url2"),
                    VideoAttachment(2, 25, "video", "good"),
                    AudioAttachment(2, 25, "Metallica", "Song"),
                    LinkAttachment("url", "Url"),
                    GeoAttachment("place", Coordinates(2324234, 123324324))
                )
            )
        )
        assertFalse(result)
    }
}