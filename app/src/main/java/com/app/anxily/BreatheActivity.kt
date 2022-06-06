package com.app.anxily

import android.os.Bundle
import com.app.anxily.databinding.ActivityBreatheBinding
import com.app.base.ui.activity.BindingBaseActivity

class BreatheActivity : BindingBaseActivity<ActivityBreatheBinding>() {


    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityBreatheBinding) {
        binding.btnContinue.setOnClickListener { finish() }

    }

    override fun getViewBinding(): ActivityBreatheBinding {
        return ActivityBreatheBinding.inflate(layoutInflater)
    }
}