package data

abstract class Attachment(
    val type: String
)

class Photo(
    type: String = "photo",
    val data: PhotoAttachment
) : Attachment(type)

data class PhotoAttachment(
    val id: Long,
    val owner_id: Long,
    val photo_130: String,
    val photo_604: String
)

class Video(
    type: String = "video",
    val data: VideoAttachment
) : Attachment(type)

data class VideoAttachment(
    val id: Long,
    val owner_id: Long,
    val title: String,
    val description: String
)

class Audio(
    type: String = "audio",
    val data: AudioAttachment
) : Attachment(type)

data class AudioAttachment(
    val id: Long,
    val owner_id: Long,
    val artist: String,
    val title: String
)

class Link(
    type: String = "link",
    val data: LinkAttachment
) : Attachment(type)

data class LinkAttachment(
    val url: String,
    val title: String
)

class Geo(
    type: String = "geo",
    val data: GeoAttachment
) : Attachment(type)

data class GeoAttachment(
    val type: String,
    val coordinates: Coordinates,
)

data class Coordinates(
    val latitude:Int,
    val longitude:Int
)