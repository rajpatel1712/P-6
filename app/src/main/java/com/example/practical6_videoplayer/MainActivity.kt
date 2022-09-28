package com.example.practical6_videoplayer

import android.content.Intent
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.practical6_videoplayer.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        videoplayer()

        binding.btnSwitch.setOnClickListener {
            Intent(this, youtubeactivity::class.java).also {
                startActivity(it)
            }
        }
    }
    private fun videoplayer(){
        val mediaController=MediaController(this)
        val uri : Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.thestoryoflight)
        binding.myVideoview.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myVideoview)
        binding.myVideoview.setVideoURI(uri)
        binding.myVideoview.requestFocus()
        binding.myVideoview.start()
    }
}