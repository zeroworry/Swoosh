package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER_CLASS
import com.example.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var player = Player("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER_CLASS)
        println(player.league)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER_CLASS, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER_CLASS)!!
    }

    // Move to the next Activity
    fun onClickFinish(view: View){
        if (player.skill != ""){
            // My intent goes to Finish Activity, is of type java class
            val finishActivity = Intent(this, FinishActivity::class.java)
            // I can hang variables to the going activity using the putExtra method
            finishActivity.putExtra(EXTRA_PLAYER_CLASS, player)
            // I start the next activity
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickAdvanced(view: View){
        beginnerSkillBtn.isChecked = false
        player.skill = "beginner"
        if (!advancedSkillBtn.isChecked){
            player.skill = ""
        }
    }

    fun onClickBeginner(view: View){
        advancedSkillBtn.isChecked = false
        player.skill = "advanced"
        if (!beginnerSkillBtn.isChecked){
            player.skill = ""
        }
    }

}
