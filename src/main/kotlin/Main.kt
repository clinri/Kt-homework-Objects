import data.*
import sevices.WallService

fun main() {
    val (id1, _, _, _, _, text1) = WallService.add(Post(text = "Текст поста1", attachments = null))
    val (id2, _, _, _, _, text2) = WallService.add(Post(text = "Текст поста2", attachments = null))
    println("$id1, $text1")
    println("$id2, $text2")
    println(WallService.update(
        Post(
            id = 3,
            text = "Текст поста4",
            attachments = arrayOf(
                PhotoAttachment(data = Photo(1,23,"url1","url2")),
                VideoAttachment(data = Video(2,25,"video","good")),
                AudioAttachment(data = Audio(2,25,"Metallica","Song")),
                LinkAttachment(data = Link("url","Url")),
                GeoAttachment(data = Geo("place",Coordinates(2324234,123324324)))
            ))))
}
