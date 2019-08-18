package com.example.swoosh.Controller

import android.os.Bundle
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R

class SkillActivity : BaseActivity() {

    var league = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }


}
