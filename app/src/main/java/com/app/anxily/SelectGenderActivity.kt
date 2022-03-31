package com.app.anxily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.anxily.databinding.ActivitySelectGenderBinding
import com.app.base.ui.activity.BaseActivity
import com.app.base.ui.activity.BindingBaseActivity

class SelectGenderActivity : BindingBaseActivity<ActivitySelectGenderBinding>()  {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivitySelectGenderBinding) {
      binding.imageView2.setOnClickListener {  launchNextActivity()}
        binding.imageView3.setOnClickListener {
            launchNextActivity()
        }
    }

    fun launchNextActivity() {
        startActivity(Intent(this,SelectHobbiesActivity::class.java))
    }

    override fun getViewBinding(): ActivitySelectGenderBinding {
   return ActivitySelectGenderBinding.inflate(layoutInflater)
    }


}