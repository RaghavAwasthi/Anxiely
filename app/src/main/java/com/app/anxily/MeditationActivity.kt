package com.app.anxily

import android.os.Bundle
import com.app.anxily.databinding.ActivityMeditationBinding
import com.app.base.ui.activity.BindingBaseActivity

class MeditationActivity : BindingBaseActivity<ActivityMeditationBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityMeditationBinding) {
        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    override fun getViewBinding(): ActivityMeditationBinding {
        return ActivityMeditationBinding.inflate(layoutInflater)
    }
}