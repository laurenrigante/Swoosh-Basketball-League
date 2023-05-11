package com.example.swoosh.Controller

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.swoosh.EXTRA_PLAYER
import com.example.swoosh.Model.Player
import com.example.swoosh.R

class FinishActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player=intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        findViewById<TextView>(R.id.searchLeaguesText).text="looking for ${player?.league} ${player?.skill} leagues near you ..."

    }
}