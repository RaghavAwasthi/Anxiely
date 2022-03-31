package com.app.anxily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.anxily.databinding.ActivityHomeBinding
import com.app.base.ui.activity.BindingBaseActivity

class HomeActivity : BindingBaseActivity<ActivityHomeBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityHomeBinding) {


    }

    override fun getViewBinding(): ActivityHomeBinding {
     return ActivityHomeBinding.inflate(layoutInflater)
    }

}