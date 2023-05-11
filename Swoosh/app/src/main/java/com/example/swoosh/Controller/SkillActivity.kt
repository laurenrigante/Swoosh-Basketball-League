package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.EXTRA_PLAYER
import com.example.swoosh.Model.Player
import com.example.swoosh.R

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player= intent.getParcelableExtra(EXTRA_PLAYER)!!
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState!=null)
        {
            player= savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }
    fun onBallerClick(view:View){
        findViewById<ToggleButton>(R.id.beginnerSkillBtn).isChecked=false
        player.skill="baller"
    }

    fun onBeginnerClick(view:View){
        findViewById<ToggleButton>(R.id.ballerSkillBtn).isChecked=false
        player.skill="beginner"

    }

   fun onSkillFinishClicked(view:View){
       findViewById<Button>(R.id.skillFinishBtn).setOnClickListener() {
           if (player.skill != "") {
               val finishActivity = Intent(this, FinishActivity::class.java)
               finishActivity.putExtra(EXTRA_PLAYER,player)
               startActivity(finishActivity)
           } else {
               Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
           }
       }
    }
}