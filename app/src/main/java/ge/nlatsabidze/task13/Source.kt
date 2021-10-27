package ge.nlatsabidze.task13

import android.util.Log.d
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import java.lang.Exception


class Source: PagingSource<Int, User.Data>() {

    override fun getRefreshKey(state: PagingState<Int, User.Data>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User.Data> {
        delay(1000)
        val currentPage: Int = params.key ?: 1
        val response = ApiInstance.ApiClient.getItems(currentPage)
        val body = response.body()

        try {
            return if (response.isSuccessful && body != null) {
                
                var prevKey: Int? = null
                var nextKey: Int? = null

                val isTotalMoreThanCurrent = body.totalPages!! > body.page!!

                if (isTotalMoreThanCurrent) {
                    nextKey = currentPage + 1
                }
                if (currentPage != 1) {
                    prevKey = currentPage - 1
                }

                LoadResult.Page(body.data!!, prevKey, nextKey)
            } else {
                LoadResult.Error(Throwable())
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}