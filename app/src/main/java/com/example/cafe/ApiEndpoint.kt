package com.example.cafe

import android.view.Menu
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    //fungsi getAllMenu yang ada pada file cafe.php
    @GET("myAPI.php?menu=getAllMenu")
    fun getMenu(): Call<MenuModel>
}