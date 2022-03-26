package sevices

import data.Post

object WallService {
    private var posts = emptyArray<Post>()
    private var postCount = 1L

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

    fun removeAll(){
        posts = emptyArray<Post>()
        postCount = 1L
    }
}