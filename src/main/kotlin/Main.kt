import data.*
import data.Attachment.*
import sevices.WallService

fun main() {
    val (id1, _, _, _, _, text1) = WallService.add(Post(text = "Текст поста1", attachments = null))
    val (id2, _, _, _, _, text2) = WallService.add(Post(text = "Текст поста2", attachments = null))
    println("$id1, $text1")
    println("$id2, $text2")
    println(
        WallService.update(
            Post(
                id = 2,
                text = "Текст поста4",
                attachments = arrayOf(
                    PhotoAttachment(data = Photo(1, 23, "url1", "url2")),
                    VideoAttachment(data = Video(2, 25, "video", "good")),
                    AudioAttachment(data = Audio(2, 25, "Metallica", "Song")),
                    LinkAttachment(data = Link("url", "Url")),
                    GeoAttachment(data = Geo("place", Coordinates(2324234, 123324324))),
                ),
            ),
        )
    )
    val post = WallService.get(1)
    val attachArray: Array<Attachment>? = post.attachments
    for (e in attachArray!!){
        println("${(e as Attachment).type} - поле type")
        when(e) {
            is PhotoAttachment -> println((e as PhotoAttachment).data.id)
            is VideoAttachment -> println((e as VideoAttachment).data.id)
            is AudioAttachment -> println((e as AudioAttachment).data.id)
            is LinkAttachment -> println((e as LinkAttachment).data.title)
            is GeoAttachment -> println((e as GeoAttachment).data.type)
        }
    }
}
