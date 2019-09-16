package com.base.captain.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.captain.readJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Request
import org.json.JSONObject

open class BaseViewModel : ViewModel() {
    val loading = MutableLiveData<Boolean>()
    inline fun loadJson(bulid:Request.Builder,crossinline successFun: (JSONObject) -> Unit, crossinline errorFun: (String) -> Unit) {
        loading.postValue(true)
        viewModelScope.launch (context = Dispatchers.IO){
            val resp= readJson(bulid)
            if(null==resp){
                errorFun("unknown")
            }else{
                successFun(resp)
            }
            loading.postValue(false)
        }
    }
}