package com.dicoding.spotzone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.spotzone.databinding.ActivityAboutBinding


class AboutActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFacebook.setOnClickListener(this)
        binding.btnInstagram.setOnClickListener(this)
        binding.btnTiktok.setOnClickListener(this)
        binding.btnGithub.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_facebook -> {
                val urlSearch = Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/profile.php?id=100011613752601"))
                startActivity(urlSearch)
            }
            R.id.btn_github -> {
                val urlSearch = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Lamz16"))
                startActivity(urlSearch)
            }
            R.id.btn_instagram -> {
                val urlSearch = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/avada.kedaavra/"))
                startActivity(urlSearch)
            }
            R.id.btn_tiktok -> {
                val urlSearch = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tiktok.com/@spot_zone"))
                startActivity(urlSearch)
            }
        }
    }
}