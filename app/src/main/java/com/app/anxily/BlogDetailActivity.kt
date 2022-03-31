package com.app.anxily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.anxily.databinding.ActivityBlogDetailBinding
import com.app.anxily.databinding.ActivityBlogsBinding
import com.app.base.ui.activity.BindingBaseActivity

class BlogDetailActivity : BindingBaseActivity<ActivityBlogDetailBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityBlogDetailBinding) {

    }

    override fun getViewBinding(): ActivityBlogDetailBinding {
       return ActivityBlogDetailBinding.inflate(layoutInflater)
    }

}