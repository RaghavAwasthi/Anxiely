package com.app.anxily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.anxily.databinding.ActivityDashboardBinding
import com.app.base.ui.activity.BindingBaseActivity

class DashboardActivity : BindingBaseActivity<ActivityDashboardBinding>() {

    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityDashboardBinding) {

        binding.btnQuiz.root.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }

        binding.btnMeditation.root.setOnClickListener {
            startActivity(Intent(this, MeditationActivity::class.java))
        }
        binding.btnBlogs.root.setOnClickListener {
            startActivity(Intent(this, BlogsActivity::class.java))
        }
    }

    override fun getViewBinding(): ActivityDashboardBinding {
      return ActivityDashboardBinding.inflate(layoutInflater)
    }

}