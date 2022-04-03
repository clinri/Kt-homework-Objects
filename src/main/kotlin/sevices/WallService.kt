package sevices

import data.Comment
import data.Post
import data.ReportComment

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<ReportComment>()
    private var postCount = 1L
    private var commentCount = 1L
    private var reportCount = 1L

    fun add(post: Post): Post {
        val postWirhId = post.copy(id = postCount++)
        posts += postWirhId
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postX) in posts.withIndex()) {
            if (post.id == postX.id) {
                posts[index] = post.copy(date = postX.date)
                //обновляем все свойства поста кроме даты, а id тот же.
                return true
            }
        }
        return false
    }

    fun get(id: Int): Post = posts[id]

    fun removeAll() {
        posts = emptyArray()
        postCount = 1L
        comments = emptyArray()
        commentCount = 1L
        reports = emptyArray()
        reportCount = 1L
    }

    fun createComment(comment: Comment): Comment {
        for ((index, postХ) in posts.withIndex()) {
            if (comment.postId == postХ.id) {
                comments += comment.copy(id = commentCount++)
                return comments.last()
            }
        }
        throw PostNotFoundException("Пост с id ${comment.id} отсутствует")
    }

    fun createReportComment(reportComment: ReportComment): ReportComment {
        for ((index, comentX) in comments.withIndex()) {
            if (reportComment.commentId == comentX.id && reportComment.reason in 0..8) {
                reports += reportComment.copy(id = reportCount++)
                return reports.last()
            } else if (reportComment.reason>8 || reportComment.reason<0){
                throw ReasonNotFoundException("Причина жалобы имеет недопустимый код ${reportComment.reason}")
            }
        }
        throw CommentNotFoundException("Комментарий с id ${reportComment.id} отсутствует")
    }
}

class PostNotFoundException(textException: String) : Exception(textException)
class CommentNotFoundException(textException: String) : Exception(textException)
class ReasonNotFoundException(textException: String) : Exception(textException)