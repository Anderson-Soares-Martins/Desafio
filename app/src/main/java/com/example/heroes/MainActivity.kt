package com.example.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroes.data.response.CharacterResponse
import com.example.heroes.data.service.api.Endpoint
import com.example.heroes.data.service.MarvelRequestGenerator
import com.example.heroes.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var characters: List<CharacterResponse> = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            GlobalScope.launch(Dispatchers.IO) {
                val callResponse = MarvelRequestGenerator().createService(Endpoint::class.java).getCharacters()
                val response = callResponse.execute()
                val responseBody = response.body()
                if (responseBody != null) {
                    characters = responseBody.data.characters
                }
            }
        }catch (e: Exception){
            println(e)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateBooks()

    }


}