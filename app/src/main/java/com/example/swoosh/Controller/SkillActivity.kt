package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    // Move to the next Activity
    fun onClickFinish(view: View){
        if (selectedSkill != ""){
            // My intent goes to Finish Activity, is of type java class
            val finishActivity = Intent(this, FinishActivity::class.java)
            // I can hang variables to the going activity using the putExtra method
            finishActivity.putExtra(EXTRA_SKILL, selectedSkill).putExtra(EXTRA_LEAGUE, league)
            // I start the next activity
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickAdvanced(view: View){
        beginnerSkillBtn.isChecked = false
        selectedSkill = "beginner"
        if (!advancedSkillBtn.isChecked){
            selectedSkill = ""
        }
    }

    fun onClickBeginner(view: View){
        advancedSkillBtn.isChecked = false
        selectedSkill = "advanced"
        if (!beginnerSkillBtn.isChecked){
            selectedSkill = ""
        }
    }

}
