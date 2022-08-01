package ir.MrMohamadHosein.easierWorkingWithRetrofit.apiManager

import ir.MrMohamadHosein.easierWorkingWithRetrofit.apiManager.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class ApiManager {
    private val apiService :ApiService
    init {

        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)

    }

    fun getUsers(callback :ApiCallback<List<User>> ) {

        apiService.getUsers().enqueue(object :Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val body = response.body()!!
                callback.onSuccess(body)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                val message = t.message!!
                callback.onError(message)
            }

        } )

    }


    interface ApiCallback<T> {

        fun onSuccess( data :T )
        fun onError(errorMessage :String)

    }
}