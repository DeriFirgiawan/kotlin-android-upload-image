package com.example.imageupload.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imageupload.models.BasicResponse
import com.example.imageupload.repository.MainRepository
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val repository = MainRepository()
    val isUploaded = MutableLiveData<Boolean>()

    fun uploadImage(image: MultipartBody.Part) {
        repository.uploadImage(image).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {
                    isUploaded.postValue(true)
                } else {
                    isUploaded.postValue(false)
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                isUploaded.postValue(false)
                Log.e("Error", t.toString())
            }
        })
    }
}