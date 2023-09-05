package com.dicoding.spotzone

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View



import com.dicoding.spotzone.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dataContent = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_content", Content::class.java)

        } else {
            @Suppress("Deprecation")
            intent.getParcelableExtra("key_content")
        }

        if (dataContent!= null){
            binding.imgDetailPhoto.setImageResource(dataContent.photo)
            binding.tvDetailName.text = dataContent.name
            binding.tvDetailDescription.text = dataContent.description
        }

        binding.btnAbout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
            when(v?.id){
                R.id.btn_about -> {
                    val moveToAbout = Intent(this@DetailActivity, AboutActivity::class.java)
                    startActivity(moveToAbout)
                }
            }
    }

}