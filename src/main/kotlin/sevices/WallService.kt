package sevices

import data.Comment
import data.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var postCount = 1L
    private var commentCount = 1L

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
        posts = emptyArray<Post>()
        postCount = 1L
    }

    fun createComment(comment: Comment) {
        for ((index, postХ) in posts.withIndex()){
            if (comment.id == postХ.id)
        }
    }
}