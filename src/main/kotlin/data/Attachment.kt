package data

abstract class Attachment(
    val type:String = ""
)

class Photo(type: String, photo: Photo):Attachment(type){

}