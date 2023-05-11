package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.swoosh.R

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.getStartedBtn).setOnClickListener{
            val leagueIntent= Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
        }

    }
}