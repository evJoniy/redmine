package com.evj.redmine

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evj.redmine.data.AuthService
import com.evj.redmine.data.IssuesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.math.log

class MainViewModel : ViewModel() {
    private val authService = AuthService.create()
    private val issuesService = IssuesService.create()
    private val _issues: MutableLiveData<String> = MutableLiveData()

    val issues: LiveData<String> get() = _issues

    fun loadIssues() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _issues.value = issuesService.loadIssues()
            } catch (e:HttpException) {
                Log.e("Load users", e.toString())
            }
        }
    }

    fun auth() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}