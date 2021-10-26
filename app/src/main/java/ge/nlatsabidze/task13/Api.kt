package ge.nlatsabidze.task13

import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/v3/c111ca66-46e7-400e-ab5d-809865408c66")
    suspend fun getItems(): Response<List<Content>>
}