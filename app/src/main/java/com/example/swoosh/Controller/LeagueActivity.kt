package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER_CLASS
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER_CLASS, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        // This is another way of recovering the state besides the onRestoreInstanceState() done inside the onCreate()
        // player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER_CLASS)!!

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER_CLASS)!!
    }

    fun leagueNextClicked(view: View){
        if (player.league != "" ){
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER_CLASS, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league",Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickMensLeague(view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        player.league = "mens"
        if (!mensLeagueBtn.isChecked){
            player.league = ""
        }
    }

    fun onClickWomensLeague(view: View){
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        player.league = "womens"
        if (!womensLeagueBtn.isChecked){
            player.league = ""
        }
    }

    fun onClickCoedLeague(view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
        player.league = "coed"
        if (!coedLeagueBtn.isChecked){
            player.league = ""
        }
    }


}
