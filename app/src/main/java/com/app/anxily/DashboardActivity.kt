package com.app.anxily

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.anxily.databinding.ActivityDashboardBinding
import com.app.anxily.databinding.ItemCardDashboardBinding
import com.app.anxily.inspire.InspireActivity
import com.app.anxily.quiz.QuizActivity
import com.app.base.ui.activity.BindingBaseActivity

class DashboardActivity : BindingBaseActivity<ActivityDashboardBinding>() {

    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityDashboardBinding) {
        val items = mutableListOf<DashboardItem>()
        items.add(
            DashboardItem(
                title = "Feeling Anxious",
                description = "How do you feel when you are anxious?",
                image = R.drawable.ic_1,
                color = "#FCA82F"
            )
        )

        items.add(
            DashboardItem(
                title = "Let's meditate",
                description = "Take some time to meditate and relax",
                image = R.drawable.ic_2,
                color = "#DCAFE3"
            )
        )

        items.add(
            DashboardItem(
                title = "Relax right away",
                description = "Listen to nature music and deep dive in peace",
                image = R.drawable.ic_3,
                color = "#378FF3"
            )
        )

        items.add(
            DashboardItem(
                title = "Focus on your breath",
                description = "Feel better quickly y following a session",
                image = R.drawable.ic_4,
                color = "#FF5678"
            )
        )
        items.add(
            DashboardItem(
                title = "Let's get Inspired",
                description = "Listen to nature music and deep dive in peace",
                image = R.drawable.ic_3,
                color = "#48EBFD"
            )
        )

        binding.rvList.layoutManager = GridLayoutManager(this, 2)
        binding.rvList.adapter = DashBoardAdapter(items)
    }

    override fun getViewBinding(): ActivityDashboardBinding {
        return ActivityDashboardBinding.inflate(layoutInflater)
    }

    inner class DashBoardAdapter(private val items: List<DashboardItem>) :
        RecyclerView.Adapter<DashBoardViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
            return DashBoardViewHolder(
                ItemCardDashboardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
            holder.item.apply {
                ivMain.setImageResource(items[position].image)
                tvHeader.text = items[position].title
                tvSubheader.text = items[position].description
                cardDashboard.setCardBackgroundColor(
                    android.graphics.Color.parseColor(
                        items[position].color
                    )
                )

                cardDashboard.setOnClickListener {
                    when (position) {
                        0 -> {
                            startActivity(Intent(this@DashboardActivity, QuizActivity::class.java))
                        }
                        1 -> {
                            startActivity(Intent(this@DashboardActivity, MeditationActivity::class.java))

                        }
                        2 -> {
                            startActivity(Intent(this@DashboardActivity, RelaxActivity::class.java))

                        }
                        3 -> {
                            startActivity(Intent(this@DashboardActivity, BreatheActivity::class.java))

                        }
                        4 -> {
                           startActivity(Intent(this@DashboardActivity, InspireActivity::class.java))
                        }

                    }
                }

            }
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

}


class DashBoardViewHolder(val item: ItemCardDashboardBinding) :
    RecyclerView.ViewHolder(item.root)

data class DashboardItem(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
    val color: String
)
