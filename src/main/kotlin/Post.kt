import java.time.Instant

enum class PostType {
    POST,
    COPY,
    REPLY,
    POSTPONE,
    SUGGEST
}

data class Post(
    private val owner_id: Int = 0, //Идентификатор владельца стены, на которой размещена запись
    private val from_id: Int = 0, //Идентификатор автора записи (от чьего имени опубликована запись).
    private val created_by: Int = 0, //Идентификатор администратора, который опубликовал запись (только для сообществ)
    private val date: Long = Instant.now().epochSecond, //Время публикации записи в формате unixtime.
    private val text: String, //Текст записи.
    private val reply_owner_id: Int = 0, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    private val reply_post_id: Int = 0, //Идентификатор записи, в ответ на которую была оставлена текущая.
    private val friends_only: Boolean = false, //запись была создана с опцией «Только для друзей».
    private val comments: Comments = Comments(), //Информация о комментариях к записи, объект с полями
    private val copyright: Copyright = Copyright(), //Источник материала, объект с полями
    private val likes: Likes = Likes(), //Информация о лайках к записи, объект с полями
    private val reposts: Reposts = Reposts(), //Информация о репостах записи («Рассказать друзьям»), объект с полями
    private val views: Views = Views(), //Информация о просмотрах записи. Объект с единственным полем:
    private val post_type: PostType = PostType.POST,
    private val signer_id: Int = 0, //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    private val can_pin: Boolean = false, //Информация о том, может ли текущий пользователь закрепить
    private val can_delete: Boolean = false, //Информация о том, может ли текущий пользователь удалить запись
    private val can_edit: Boolean = false, //Информация о том, может ли текущий пользователь редактировать запись
    private val is_pinned: Boolean = false, //Информация о том, что запись закреплена.
    private val marked_as_ads: Boolean = false, //Информация о том, содержит ли запись отметку "реклама"
    private val is_favorite: Boolean = false, //объект добавлен в закладки у текущего пользователя.
    private val donut: Donut = Donut(), //Информация о записи VK Donut
    private val postponed_id: Int = 0, //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
) {
   private val id: Int = count //Идентификатор записи.
   init {
       count++
   }
}

var count: Int = 1

fun main() {
    var post = Post(
        text = "Текст поста",
    )
    println(post)
}

object WallService()