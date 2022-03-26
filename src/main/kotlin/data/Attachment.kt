package data

sealed class Attachment(
    val type: String
)

data class PhotoAttachment(
    val id: Long,
    val owner_id: Long,
    val photo_130: String,
    val photo_604: String
) : Attachment("photo")

data class VideoAttachment(
    val id: Long,
    val owner_id: Long,
    val title: String,
    val description: String
) : Attachment("video")

data class AudioAttachment(
    val id: Long,
    val owner_id: Long,
    val artist: String,
    val title: String
) : Attachment("audio")

data class LinkAttachment(
    val url: String,
    val title: String
) : Attachment("link")

data class GeoAttachment(
    val typeGeo: String,
    val coordinates: Coordinates,
) : Attachment("geo")

data class Coordinates(
    val latitude: Int,
    val longitude: Int
)