package com.sean.petinfo.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Author: Sean-Shen
 * Date: 2021/3/31
 * Desc:
 */
class PetViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PetListViewModel(context) as T
    }
}