package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.EXTRA_PLAYER
import com.example.swoosh.Model.Player
import com.example.swoosh.R

class LeagueActivity : BaseActivity() {

    var player= Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState!=null){
            player= savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }
     fun onMensClicked(view:View){
         findViewById<ToggleButton>(R.id.womensLeagueBtn).isChecked= false
         findViewById<ToggleButton>(R.id.coedLeagueBtn).isChecked=false

         player.league="mens"
     }

    fun onWomensClicked(view:View){
        findViewById<ToggleButton>(R.id.mensLeagueBtn).isChecked= false
        findViewById<ToggleButton>(R.id.coedLeagueBtn).isChecked=false
        player.league="womens"
    }

    fun onCoedClicked(view:View){
        findViewById<ToggleButton>(R.id.mensLeagueBtn).isChecked= false
        findViewById<ToggleButton>(R.id.womensLeagueBtn).isChecked= false
        player.league="coed"
    }


    fun leagueNextClicked(view: View){
        if(player.league!="") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }else{
            Toast.makeText(this, "Please select a League", Toast.LENGTH_SHORT).show()
        }
    }


}