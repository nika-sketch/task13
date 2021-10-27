package ge.nlatsabidze.task13

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData

class HomeViewModel : ViewModel() {
    fun getData() = Pager(
        config = PagingConfig(pageSize = 1),
        pagingSourceFactory = {Source()})
        .liveData.cachedIn(viewModelScope)
}