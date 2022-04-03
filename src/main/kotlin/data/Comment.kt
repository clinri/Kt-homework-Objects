package data

import java.time.Instant

data class Comment(
    val id: Long = 0, //Идентификатор комментария.
    val postId : Long = 0, // такого в API ВК нет! но по условию ДЗ должно быть.
    val from_id: Int = 0, //Идентификатор автора комментария.
    val date: Long = Instant.now().epochSecond, // Дата создания комментария в формате Unixtime.
    val text: String = "", //Текст комментария.
    val donut: Donut = Donut(), //Информация о VK Donut:
    val reply_to_user: Int = 0, //Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val reply_to_comment: Int = 0, //Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachments: Attachment? = null, //Медиавложения комментария (фотографии, ссылки и т.п.). Описание массива
    val parents_stack: Array<Int>? = null, //Массив идентификаторов родительских комментариев.
    val thread: Comments = Comments() //Информация о вложенной ветке комментариев
)