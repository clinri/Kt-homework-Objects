import data.*
import data.Attachment.*
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import sevices.CommentNotFoundException
import sevices.PostNotFoundException
import sevices.ReasonNotFoundException
import sevices.WallService

class PostTest {
    @Before
    fun clearArrays() {
        WallService.removeAll()
    }

    @Test
    fun test_post_id_not_equals_zero() {
        val id = WallService.add(
            Post(
                text = "Текст поста1", attachments = arrayOf(
                    PhotoAttachment(data = Photo(1, 23, "url1", "url2")),
                    VideoAttachment(data = Video(2, 25, "video", "good")),
                    AudioAttachment(data = Audio(2, 25, "Metallica", "Song")),
                    LinkAttachment(data = Link("url", "Url")),
                    GeoAttachment(data = Geo("place", Coordinates(2324234, 123324324)))
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
                    PhotoAttachment(data = Photo(1, 23, "url1", "url2")),
                    VideoAttachment(data = Video(2, 25, "video", "good")),
                    AudioAttachment(data = Audio(2, 25, "Metallica", "Song")),
                    LinkAttachment(data = Link("url", "Url")),
                    GeoAttachment(data = Geo("place", Coordinates(2324234, 123324324)))
                )
            )
        )
        val result = WallService.update(
            Post(
                id = 1, text = "Текст поста4", attachments = arrayOf(
                    PhotoAttachment(data = Photo(1, 23, "url1", "url2")),
                    VideoAttachment(data = Video(2, 25, "video", "good")),
                    AudioAttachment(data = Audio(2, 25, "Metallica", "Song")),
                    LinkAttachment(data = Link("url", "Url")),
                    GeoAttachment(data = Geo("place", Coordinates(2324234, 123324324)))
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
                    PhotoAttachment(data = Photo(1, 23, "url1", "url2")),
                    VideoAttachment(data = Video(2, 25, "video", "good")),
                    AudioAttachment(data = Audio(2, 25, "Metallica", "Song")),
                    LinkAttachment(data = Link("url", "Url")),
                    GeoAttachment(data = Geo("place", Coordinates(2324234, 123324324)))
                )
            )
        )
        assertFalse(result)
    }

    @Test
    fun test_add_comment() {
        val post1: Post = WallService.add(Post(text = "Пост 1", attachments = null))
        val comment1: Comment = WallService.createComment(Comment(postId = 1, text = "good post 1"))
        val (id) = post1
        val (postId)=comment1
        assertEquals(id,postId)
    }

    @Test(expected = PostNotFoundException::class)
    fun test_throw_exception_while_add_comment_and_post_id_failing() {
        val post1: Post = WallService.add(Post(text = "Пост 1", attachments = null))
        val comment1: Comment = WallService.createComment(Comment(postId = 3, text = "good post 1"))
    }

    @Test
    fun test_add_report_comment(){
        val post1: Post = WallService.add(Post(text = "Пост 1", attachments = null))
        val comment1: Comment = WallService.createComment(Comment(postId = 1, text = "good post 1"))
        val reportComment:ReportComment = WallService.createReportComment(ReportComment(commentId = 1, reason = 5))
        assertEquals(comment1.id,reportComment.commentId)
    }

    @Test(expected = CommentNotFoundException::class)
    fun test_throw_exception_while_add_report_and_comment_id_failing() {
        val post1: Post = WallService.add(Post(text = "Пост 1", attachments = null))
        val comment1: Comment = WallService.createComment(Comment(postId = 1, text = "good post 1"))
        val reportComment:ReportComment = WallService.createReportComment(ReportComment(commentId = 3, reason = 5))
    }

    @Test(expected = ReasonNotFoundException::class)
    fun test_throw_exception_while_add_report_and_reason_id_failing() {
        val post1: Post = WallService.add(Post(text = "Пост 1", attachments = null))
        val comment1: Comment = WallService.createComment(Comment(postId = 1, text = "good post 1"))
        val reportComment:ReportComment = WallService.createReportComment(ReportComment(commentId = 1, reason = 9))
    }
}