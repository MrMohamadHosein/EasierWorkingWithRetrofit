package ir.MrMohamadHosein.easierWorkingWithRetrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import ir.MrMohamadHosein.easierWorkingWithRetrofit.apiManager.ApiManager
import ir.MrMohamadHosein.easierWorkingWithRetrofit.apiManager.ApiService
import ir.MrMohamadHosein.easierWorkingWithRetrofit.databinding.ActivityMainBinding
import ir.MrMohamadHosein.easierWorkingWithRetrofit.apiManager.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val apiManager = ApiManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetData.setOnClickListener {
            apiManager.getUsers(object : ApiManager.ApiCallback<List<User>> {
                override fun onSuccess(data: List<User>) {
                    Log.v("testApi", data.toString())
                }

                override fun onError(errorMessage: String) {
                    Log.v("testApi", errorMessage)
                }
            })
        }
    }


}