package com.dicoding.spotzone

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.dicoding.spotzone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Content>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContents.setHasFixedSize(true)
        list.addAll(getListContents())
        showRecyclerList()

    }

    @SuppressLint("Recycle")
    private fun getListContents(): ArrayList<Content>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listContent =ArrayList<Content>()

            for (i in dataName.indices){
                val content = Content(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
                listContent.add(content)
            }
        return listContent
    }

    private fun showRecyclerList(){
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.rvContents.layoutManager = GridLayoutManager(this,2)
        }else {
            binding.rvContents.layoutManager = LinearLayoutManager(this)
        }

        val listContentAdapter = ListContentAdapter (list)
        binding.rvContents.adapter = listContentAdapter

        listContentAdapter.setOnItemClickCallback(object : ListContentAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Content) {
            }
        })
    }


}