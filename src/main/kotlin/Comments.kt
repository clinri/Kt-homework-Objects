class Comments(
    var count: Int = 0, // количество комментариев
    val can_post: Boolean = false, //может ли текущий пользователь комментировать запись
    val groups_can_post: Boolean = false, //могут ли сообщества комментировать запись
    val can_close: Boolean = false, // может ли текущий пользователь закрыть комментарии к записи
    val can_open: Boolean = false //может ли текущий пользователь открыть комментарии к записи
)