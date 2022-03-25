class Donut(  //Информация о записи VK Donut:
    val is_donut: Boolean = false, //запись доступна только платным подписчикам VK Donut;
    val paid_duration: Int = 0, //время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val placeholder: String = "", //заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
    val can_publish_free_copy: Boolean = false, //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut
    val edit_mode: EditMode = EditMode.ALL //информация о том, какие значения VK Donut можно изменить в записи. Возможные значения
)

enum class EditMode {
    ALL, //всю информацию о VK Donut.
    DURATION //время, в течение которого запись будет доступна только платным подписчикам VK Donut.
}
