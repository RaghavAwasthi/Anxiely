package com.app.anxily

import android.content.Intent
import android.os.Bundle
import com.app.anxily.databinding.ActivityBlogsBinding
import com.app.base.ui.activity.BindingBaseActivity

class BlogsActivity : BindingBaseActivity<ActivityBlogsBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityBlogsBinding) {
        binding.hs.setOnClickListener {
            startActivity(Intent(this, BlogDetailActivity::class.java))
        }
    }

    override fun getViewBinding(): ActivityBlogsBinding {
        return ActivityBlogsBinding.inflate(layoutInflater)
    }

}