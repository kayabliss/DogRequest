package com.example.dogrequest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.DogPhoto
import com.example.network.DogsApi
import kotlinx.coroutines.launch

class DogsViewModel : ViewModel() {

    //make a network call to get info about Dog photos

    // only Accessible by viewModel, only I can update by viewModel
    private val _currentDogImage = MutableLiveData<DogPhoto>()

    // Accessible to the public
    val currentDogImage: LiveData<DogPhoto> = _currentDogImage

   init {
       getDogInfo()
   }

    fun getDogInfo(){
        viewModelScope.launch {

            _currentDogImage.value = DogsApi.retrofitService.getPhotos()
        }
    }

}