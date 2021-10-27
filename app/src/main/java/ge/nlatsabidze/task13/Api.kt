package ge.nlatsabidze.task13

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("users")
    suspend fun getItems(@Query("page") page: Int): Response<User>
}