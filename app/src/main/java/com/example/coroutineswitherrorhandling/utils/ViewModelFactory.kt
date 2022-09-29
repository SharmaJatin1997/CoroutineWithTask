package com.example.coroutineswitherrorhandling.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutineswitherrorhandling.data.api.ApiHelper
import com.example.coroutineswitherrorhandling.learn.task.twotasks.TwoLongRunningTasksViewModel
import com.mindorks.example.coroutines.learn.task.onetask.LongRunningTaskViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        if (modelClass.isAssignableFrom(LongRunningTaskViewModel::class.java)) {
            return LongRunningTaskViewModel(apiHelper) as T
        }
        if (modelClass.isAssignableFrom(TwoLongRunningTasksViewModel::class.java)) {
            return TwoLongRunningTasksViewModel(apiHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}