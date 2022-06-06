package com.app.anxily.quiz

import android.content.Intent
import android.os.Bundle
import com.app.anxily.FeelingGratefullActivity
import com.app.anxily.R
import com.app.anxily.databinding.ActivityOnboardingQuizBinding
import com.app.base.ui.activity.BindingBaseActivity

class OnboardingQuizActivity : BindingBaseActivity<ActivityOnboardingQuizBinding>() {
    var yes = false
    var no = false
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityOnboardingQuizBinding) {
        binding.btnYes.setOnClickListener {
            if (!yes) {
                no = false
                binding.btnNo.setBackgroundColor(resources.getColor(R.color.white))

                binding.btnYes.setBackgroundColor(resources.getColor(R.color.appYellow))
            } else {
                binding.btnYes.setBackgroundColor(resources.getColor(R.color.white))
            }
            yes = !yes

        }
        binding.btnNo.setOnClickListener {
            if (!no) {
                yes = false
                binding.btnNo.setBackgroundColor(resources.getColor(R.color.appYellow))
                binding.btnYes.setBackgroundColor(resources.getColor(R.color.white))

            } else {
                binding.btnYes.setBackgroundColor(resources.getColor(R.color.white))
            }
            no = !no
        }
        binding.buttonNext.setOnClickListener {
            if (yes) {
                startActivity(Intent(this, FeelingGratefullActivity::class.java))
                finish()
            }
        else
        {  startActivity(Intent(this, QuizActivity::class.java))
            finish()

        }
    }
}

override fun getViewBinding(): ActivityOnboardingQuizBinding {
    return ActivityOnboardingQuizBinding.inflate(layoutInflater)
}

}