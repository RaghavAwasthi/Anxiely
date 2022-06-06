package com.app.anxily.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.app.anxily.QuizEndActivity
import com.app.anxily.R
import com.app.anxily.databinding.ActivityQuizBinding
import com.app.base.ui.activity.BindingBaseActivity

class QuizActivity : BindingBaseActivity<ActivityQuizBinding>() {
    val questions = mutableListOf<Quiz>()
    var count = 0;
    var yes = false
    var no = false
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityQuizBinding) {

        questions.add(Quiz("Do you have Stage Fear?", 40))
        questions.add(Quiz("Do you think you have insomnia?", 70))
        questions.add(Quiz("Feeling uncomfortable at parties?", 100))

        binding.tvQuestion.text = "Question 1/5"
        binding.tvQuestionInner.text = questions[count].question
        binding.linearProgressIndicator.setProgress(questions[count].progress, true)
        binding.btnYes.setOnClickListener {
            if (!yes) {
                no=false
                binding.btnNo.setBackgroundColor(resources.getColor(R.color.white))

                binding.btnYes.setBackgroundColor(resources.getColor(R.color.appYellow))
            }   else {
                binding.btnYes.setBackgroundColor(resources.getColor(R.color.white))
            }
            yes = !yes

        }
        binding.btnNo.setOnClickListener {
            if (!no) {
                yes=false
                binding.btnNo.setBackgroundColor(resources.getColor(R.color.appYellow))
                binding.btnYes.setBackgroundColor(resources.getColor(R.color.white))

            }   else {
                binding.btnYes.setBackgroundColor(resources.getColor(R.color.white))
            }
            no = !no
        }
        binding.buttonNext.setOnClickListener {
            yes=false
            no=false
            binding.btnNo.setBackgroundColor(resources.getColor(R.color.white))
            binding.btnYes.setBackgroundColor(resources.getColor(R.color.white))

            if (count < questions.size - 1) {
                count++
                binding.tvQuestion.text = "Question ${count + 1}/${questions.size}"
                binding.tvQuestionInner.text = questions[count].question
                binding.linearProgressIndicator.setProgress(questions[count].progress, true)
            } else {

                startActivity(Intent(this, SpecialQuizActivity::class.java))
                finish()
            }
        }
    }



    override fun getViewBinding(): ActivityQuizBinding {
        return ActivityQuizBinding.inflate(layoutInflater)
    }

}

data class Quiz(
    val question: String, val progress: Int = 10
)