package data

sealed class Attachment(
    val type: String
)

data class PhotoAttachment(
    val data: Photo
) : Attachment("photo")

data class Photo(
    val id: Long,
    val owner_id: Long,
    val photo_130: String,
    val photo_604: String
)

data class VideoAttachment(
    val data: Video
) : Attachment("video")

data class Video(
    val id: Long,
    val owner_id: Long,
    val title: String,
    val description: String
)

data class AudioAttachment(
    val data: Audio
) : Attachment("audio")

data class Audio(
    val id: Long,
    val owner_id: Long,
    val artist: String,
    val title: String
)

data class LinkAttachment(
    val data: Link
) : Attachment("link")

data class Link(
    val url: String,
    val title: String
)

data class GeoAttachment(
    val data: Geo
) : Attachment("geo")

data class Geo(
    val type: String,
    val coordinates: Coordinates,
)

data class Coordinates(
    val latitude:Int,
    val longitude:Int
)