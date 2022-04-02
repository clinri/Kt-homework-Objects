package data

class Comments(
    var count: Int = 0, // количество комментариев
    val can_post: Boolean = false, //может ли текущий пользователь комментировать запись
    val groups_can_post: Boolean = false, //могут ли сообщества комментировать запись
    val can_close: Boolean = false, // может ли текущий пользователь закрыть комментарии к записи
    val can_open: Boolean = false, //может ли текущий пользователь открыть комментарии к записи
    val items: Array<Comment>? = null, //массив объектов комментариев к записи
    val show_reply_button: Boolean = true //нужно ли отображать кнопку «ответить» в ветке.
)