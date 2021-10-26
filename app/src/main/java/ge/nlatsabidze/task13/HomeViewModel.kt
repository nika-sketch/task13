package ge.nlatsabidze.task13

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    private var _info = MutableLiveData<List<Content>>()
    val info: LiveData<List<Content>>
        get() = _info

    fun setResult() {
        viewModelScope.launch {
//            if (RetrofitInstance.API.getTodos().isSuccessful) {
////                _info.value = RetrofitInstance.API.getTodos().body()!!.content
//            }

//            val data = RetrofitInstance.API.getTodos()

            val data = withContext(Dispatchers.IO) {
                ApiInstance.API.getItems()
            }

            try {
                if (data.isSuccessful) {
                    val getData = Resource.Success(data.body()!!)
                    _info.postValue(getData._data)
                } else {
                    Log.d("tag", Resource.Error("Exception").toString())
                }
            } catch (e: Exception) {
                Log.d("Error", e.toString())
            }
//

//            val data = withContext(Dispatchers.IO) {
//                RetrofitInstance.API.getTodos()
//            }
//            _info.postValue(data.body()!!.content)
        }

    }
}