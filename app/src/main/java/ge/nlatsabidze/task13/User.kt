package ge.nlatsabidze.task13


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "data")
    val data: List<Data>?,
    @Json(name = "page")
    val page: Int?,
    @Json(name = "per_page")
    val perPage: Int?,
    @Json(name = "total")
    val total: Int?,
    @Json(name = "total_pages")
    val totalPages: Int?
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "avatar")
        val avatar: String?,
        @Json(name = "email")
        val email: String?,
        @Json(name = "first_name")
        val firstName: String?,
        @Json(name = "id")
        val id: Int?,
        @Json(name = "last_name")
        val lastName: String?
    )
}