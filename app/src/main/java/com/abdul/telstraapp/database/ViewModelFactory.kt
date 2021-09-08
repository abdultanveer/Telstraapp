package com.abdul.telstraapp.database

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdul.telstraapp.MainActivity

class ViewModelFactory(
       private val value: Int, var application: Application
        ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WordViewModel::class.java)){
                return WordViewModel(application) as T
            }
            throw IllegalArgumentException("Invalid model class")
        }
    }