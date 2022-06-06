package com.app.anxily.quiz

import android.content.Intent
import android.os.Bundle
import com.app.anxily.BreatheActivity
import com.app.anxily.databinding.ActivitySpecialQuizBinding
import com.app.anxily.help.GetHelpActivity
import com.app.base.ui.activity.BindingBaseActivity

class SpecialQuizActivity : BindingBaseActivity<ActivitySpecialQuizBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivitySpecialQuizBinding) {

        binding.btnAlcohol.setOnClickListener {
            startActivity(Intent(this, GetHelpActivity::class.java))
            finish()
        }

        binding.btnNightOwl.setOnClickListener {
            startActivity(Intent(this, BreatheActivity::class.java))
            finish()
        }

        binding.btnWorkingAtStartup.setOnClickListener {

        }
        binding.linearProgressIndicator.setProgress(100)
    }

    override fun getViewBinding(): ActivitySpecialQuizBinding {
        return ActivitySpecialQuizBinding.inflate(layoutInflater)
    }

}