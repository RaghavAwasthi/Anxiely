package com.app.anxily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.anxily.databinding.ActivityRelaxBinding
import com.app.base.ui.activity.BindingBaseActivity

class RelaxActivity : BindingBaseActivity<ActivityRelaxBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityRelaxBinding) {

    }

    override fun getViewBinding(): ActivityRelaxBinding {
       return ActivityRelaxBinding.inflate(layoutInflater)
    }

}