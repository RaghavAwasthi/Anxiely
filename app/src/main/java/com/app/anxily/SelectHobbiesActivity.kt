package com.app.anxily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.anxily.databinding.ActivitySelectHobbiesBinding
import com.app.anxily.databinding.ItemCardBinding
import com.app.base.ui.activity.BindingBaseActivity

class SelectHobbiesActivity : BindingBaseActivity<ActivitySelectHobbiesBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivitySelectHobbiesBinding) {

        val hobbies=listOf("Singing", "Lawda", "Lassan")
        hobbies.forEach {

            val bind=ItemCardBinding.inflate(layoutInflater)
            bind.text.setText(it)
            bind.rootElem.setOnClickListener {
                bind.rootElem.setCardBackgroundColor(resources.getColor(R.color.appPrimaryVariant))
            }
            binding.linearLayout.addView(bind.root)
        }
    }

    override fun getViewBinding(): ActivitySelectHobbiesBinding {
    return ActivitySelectHobbiesBinding.inflate(layoutInflater)
    }

}