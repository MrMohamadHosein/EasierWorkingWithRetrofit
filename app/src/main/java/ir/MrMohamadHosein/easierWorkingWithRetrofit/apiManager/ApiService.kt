package ir.MrMohamadHosein.easierWorkingWithRetrofit.apiManager

import ir.MrMohamadHosein.easierWorkingWithRetrofit.apiManager.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers() :Call<List<User>>

}