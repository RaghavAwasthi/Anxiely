package com.app.anxily

import android.content.Intent
import android.os.Bundle
import com.app.anxily.databinding.ActivityFeelingGratefullBinding
import com.app.base.ui.activity.BindingBaseActivity

class FeelingGratefullActivity : BindingBaseActivity<ActivityFeelingGratefullBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityFeelingGratefullBinding) {
        binding.btnContinue.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun getViewBinding(): ActivityFeelingGratefullBinding {
        return ActivityFeelingGratefullBinding.inflate(layoutInflater)
    }

}