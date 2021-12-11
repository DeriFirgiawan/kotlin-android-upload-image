package com.example.imageupload.repository

import ApiUpload
import com.example.imageupload.network.Retro
import okhttp3.MultipartBody

class MainRepository {
    private val retro = Retro().getRetroClientInstance()
    fun uploadImage(image: MultipartBody.Part) = retro.create(ApiUpload::class.java).uploadImage(image)
}