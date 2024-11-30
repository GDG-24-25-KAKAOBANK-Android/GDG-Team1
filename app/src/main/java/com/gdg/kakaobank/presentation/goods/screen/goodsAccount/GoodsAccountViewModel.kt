package com.gdg.kakaobank.presentation.goods.screen.goodsAccount

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.kakaobank.api.ServicePool
import com.gdg.kakaobank.api.User
import kotlinx.coroutines.launch

class GoodsAccountViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun getUsers() {
        viewModelScope.launch {
            runCatching { ServicePool.userService.getUsers(page = 2) }
                .onSuccess {
                    _users.value = it.data
                    Log.d("MainViewModel", "getUsers: ${it.data}")
                }
                .onFailure {
                    _users.value = emptyList()
                    Log.e("MainViewModel", "getUsers: ${it.message}")
                }
        }
    }
}