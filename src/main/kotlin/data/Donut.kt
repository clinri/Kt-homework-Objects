package data

class Donut(  //Информация о записи VK data.Donut:
    val is_donut: Boolean = false, //запись доступна только платным подписчикам VK data.Donut;
    val paid_duration: Int = 0, //время, в течение которого запись будет доступна только платным подписчикам VK data.Donut;
    val placeholder: String = "", //заглушка для пользователей, которые не оформили подписку VK data.Donut. Отображается вместо содержимого записи.
    val can_publish_free_copy: Boolean = false, //можно ли открыть запись для всех пользователей, а не только подписчиков VK data.Donut
    val edit_mode: EditMode = EditMode.ALL //информация о том, какие значения VK data.Donut можно изменить в записи. Возможные значения
)

enum class EditMode {
    ALL, //всю информацию о VK data.Donut.
    DURATION //время, в течение которого запись будет доступна только платным подписчикам VK data.Donut.
}
