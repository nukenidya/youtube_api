package com.example.tugasapi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {

    companion object {
        val VIDEO_ID : String = "IdssuxDdqKk";
        val YOUTUBE_API : String = "AIzaSyDMoZ2LRhLmYWnh9D5JDrPrN8FM6rE05c8";
    }

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }
    private fun initUI() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, p2: Boolean) {
                youTubePlayer?.loadVideo(VIDEO_ID)
            }
            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext, "Something Went Wrong !!", Toast.LENGTH_SHORT).show()
            }
        }
        button.setOnClickListener(View.OnClickListener { v ->
        youtube_view.initialize(YOUTUBE_API, youtubePlayerInit)
        })
    }
}
