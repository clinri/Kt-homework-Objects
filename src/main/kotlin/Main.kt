import data.Post
import sevices.WallService

fun main() {
    val (id1, _, _, _, _, text1) = WallService.add(Post(text = "Текст поста1"))
    val (id2, _, _, _, _, text2) = WallService.add(Post(text = "Текст поста2"))
    println("$id1, $text1")
    println("$id2, $text2")
    println(WallService.update(Post(id = 3, text = "Текст поста4")))
}
