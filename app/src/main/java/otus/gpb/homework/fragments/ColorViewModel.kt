package otus.gpb.homework.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel : ViewModel() {
    private val _currentColor = MutableLiveData<Int>()
    val currentColor: LiveData<Int> get() = _currentColor

    fun setColor(color: Int) {
        _currentColor.value = color
    }
}