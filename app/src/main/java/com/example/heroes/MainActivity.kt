package com.example.heroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroes.data.adapter.RecyclerViewAdapter
import com.example.heroes.data.response.CharacterResponse
import com.example.heroes.data.service.MarvelRequestGenerator
import com.example.heroes.data.service.api.Endpoint
import com.example.heroes.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var characters: List<CharacterResponse> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityMain = this
        try {
            GlobalScope.launch(Dispatchers.IO) {
                val callResponse = MarvelRequestGenerator().createService(Endpoint::class.java).getCharacters()
                val response = callResponse.execute()
                val responseBody = response.body()
                if (responseBody != null) {
                    println(responseBody.data.characters.toString())
                    characters = responseBody.data.characters

                }

            }
        }catch (e: Exception){
            println(e)
        }

        val recyclerView = activityMain.findViewById<RecyclerView>(R.id.recyclerView)
        val ca = RecyclerViewAdapter(characters)
        recyclerView.setLayoutManager(LinearLayoutManager(activityMain))
        recyclerView.setAdapter(ca)


    }


}