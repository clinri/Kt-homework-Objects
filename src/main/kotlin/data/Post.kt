package data

import java.time.Instant

enum class PostType {
    POST,
    COPY,
    REPLY,
    POSTPONE,
    SUGGEST
}

data class Post(
    public val id: Long = 0, //Идентификатор записи
    public val owner_id: Int = 0, //Идентификатор владельца стены, на которой размещена запись
    public val from_id: Int = 0, //Идентификатор автора записи (от чьего имени опубликована запись).
    public val created_by: Int = 0, //Идентификатор администратора, который опубликовал запись (только для сообществ)
    public val date: Long = Instant.now().epochSecond, //Время публикации записи в формате unixtime.
    public val text: String, //Текст записи.
    public val reply_owner_id: Int = 0, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    public val reply_post_id: Int = 0, //Идентификатор записи, в ответ на которую была оставлена текущая.
    public val friends_only: Boolean = false, //запись была создана с опцией «Только для друзей».
    public val comments: Comments = Comments(), //Информация о комментариях к записи, объект с полями
    public val copyright: Copyright = Copyright(), //Источник материала, объект с полями
    public val likes: Likes = Likes(), //Информация о лайках к записи, объект с полями
    public val reposts: Reposts = Reposts(), //Информация о репостах записи («Рассказать друзьям»), объект с полями
    public val views: Views = Views(), //Информация о просмотрах записи. Объект с единственным полем:
    public val post_type: PostType = PostType.POST, //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    public val attachments: Array<Attachment>?, //Медиавложения записи (фотографии, ссылки и т.п.).
    public val signer_id: Int = 0, //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    public val can_pin: Boolean = false, //Информация о том, может ли текущий пользователь закрепить
    public val can_delete: Boolean = false, //Информация о том, может ли текущий пользователь удалить запись
    public val can_edit: Boolean = false, //Информация о том, может ли текущий пользователь редактировать запись
    public val is_pinned: Boolean = false, //Информация о том, что запись закреплена.
    public val marked_as_ads: Boolean = false, //Информация о том, содержит ли запись отметку "реклама"
    public val is_favorite: Boolean = false, //объект добавлен в закладки у текущего пользователя.
    public val donut: Donut = Donut(), //Информация о записи VK data.Donut
    public val postponed_id: Int = 0, //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
)