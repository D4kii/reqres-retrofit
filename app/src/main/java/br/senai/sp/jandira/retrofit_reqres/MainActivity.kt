package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService  = RetrofitHelper.getInstance().create(ApiService::class.java)

        //BOTÃO DE GET
        findViewById<Button>(R.id.btnGET).setOnClickListener(){
            //Log.e("GETTING-DATA", "TESTE DE BOTÃO GET")
            getUserById()
        }

        //BOTÃO DE PUT
        findViewById<Button>(R.id.btnPUT).setOnClickListener(){
            //Log.e("PUTTING-DATA", "TESTE DE BOTÃO PUT")
            getUserById()
        }

        //BOTÃO DE DELETE
        findViewById<Button>(R.id.btnDELETE).setOnClickListener(){
            //Log.e("DELETING-DATA", "TESTE DE BOTÃO DELETE")
            getUserById()
        }

        //BOTÃO DE POST
        findViewById<Button>(R.id.btnPOST).setOnClickListener(){
            //Log.e("POSTING-DATA", "TESTE DE BOTÃO POST")
            getUserById()
        }

    }

    private fun getUserById() {
        lifecycleScope.launch {
            val result = apiService.getUserByID("2")

            if (result.isSuccessful){
                Log.e("GETTING-DATA", "${result.body()?.data}}")
            }else{
                Log.e("GETTING-DATA", "${result.message()}")
            }
        }
    }
}