package com.mahmoud.mohammed.movieapp.common

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*

class ViewModelHelper {

    inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
        return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    }

    inline fun < reified T : ViewModel> FragmentActivity.withViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
        val vm = getViewModel<T>(viewModelFactory)
        vm.body()
        return vm
    }

    fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
        liveData.observe(this, Observer(body))
    }
}