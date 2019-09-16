package com.liu.app

import androidx.lifecycle.MutableLiveData
import com.base.captain.HttpType
import com.base.captain.utils.BaseViewModel

class MyVM : BaseViewModel() {
    val res = MutableLiveData<Result>()
    fun getData() {
        loadJson("http://yr.xxni.net/index.php?g=Mapp&a=index", {
        }, {
        },HttpType.GET,"m" to "Upload","type" to 1)
    }
}