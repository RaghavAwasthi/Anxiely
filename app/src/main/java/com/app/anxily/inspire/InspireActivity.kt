package com.app.anxily.inspire

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.anxily.R
import com.app.anxily.databinding.ActivityInspireBinding
import com.app.anxily.databinding.ItemInspireBinding
import com.app.anxily.player.AudioPlayer
import com.app.base.ui.activity.BindingBaseActivity
import com.bumptech.glide.Glide

class InspireActivity : BindingBaseActivity<ActivityInspireBinding>() {


    val player: AudioPlayer = AudioPlayer()
    var prev = -1;

    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityInspireBinding) {
        player.initialise(this)

        val items = mutableListOf<InspireItem>()

        items.add(
            InspireItem(
                soundUrl = "https://storage.googleapis.com/anxily.appspot.com/The_King_And_The_Beggar_-_an_inspir_(getmp3.pro).mp3",
                title = "The King And The Beggar",
                description = "an inspirational story another short story about what is really important in life, and why riches are not everything!",
                image = "https://storage.googleapis.com/anxily.appspot.com/inspiring%20stories/inspiring%20stories/1/7wEWl0Kp-UM-SD.jpg"
            )
        )
        items.add(
            InspireItem(
                soundUrl = "https://storage.googleapis.com/anxily.appspot.com/inspiring%20stories/inspiring%20stories/2/The_Richest_Boy_In_The_World_-_an_i_(getmp3.pro).mp3",
                title = "The Richest Boy In The World",
                description = " Motivation story about being rich and being poor and about what reaL wealth means in life.",
                image = "https://storage.googleapis.com/anxily.appspot.com/inspiring%20stories/inspiring%20stories/2/3H9d7_fU3p4-SD.jpg"
            )
        )

        items.add(
            InspireItem(
                soundUrl = "https://storage.googleapis.com/anxily.appspot.com/The_King_And_The_Beggar_-_an_inspir_(getmp3.pro).mp3",
                title = "The Richest Boy In The World",
                description = " Motivation story about being rich and being poor and about what reaL wealth means in life.",
                image = "https://storage.googleapis.com/anxily.appspot.com/inspiring%20stories/inspiring%20stories/1/7wEWl0Kp-UM-SD.jpg"
            )
        )


        binding.rvList.layoutManager = GridLayoutManager(this, 2)
        binding.rvList.adapter = InspireAdapter(items)

    }

    override fun getViewBinding(): ActivityInspireBinding {
        return ActivityInspireBinding.inflate(layoutInflater)
    }


    inner class InspireAdapter(val items: List<InspireItem>) :
        RecyclerView.Adapter<InspireViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspireViewHolder {
            return InspireViewHolder(ItemInspireBinding.inflate(layoutInflater, parent, false))
        }

        override fun onBindViewHolder(holder: InspireViewHolder, position: Int) {
            holder.binding.apply {
                Glide.with(ivMain).load(items[position].image).into(ivMain)
                tvHeader.text = items[position].title
                tvSubHeader.text = items[position].description
                if (items[position].isplaying) {
                    btnPlay.setImageResource(R.drawable.ic_pause_orange)
                } else {
                    btnPlay.setImageResource(R.drawable.ic_play_orange)
                }
                btnPlay.setOnClickListener {
                    if (prev != position) {
                        if (prev != -1)
                            items[position].isplaying = false
                        items[position].isplaying = true
                        playMusic(items[position].soundUrl)
                        prev = position
                    } else {
                        items[position].isplaying = false
                        pauseMusic()
                    }

                }


            }
        }

        override fun getItemCount(): Int {
            return items.size
        }

    }

    private fun pauseMusic() {
        player.pause()
        binding.rvList.adapter?.notifyDataSetChanged()
    }

    private fun playMusic(soundUrl: String) {
        player.load(soundUrl)
        player.play()
        binding.rvList.adapter?.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    inner class InspireViewHolder(val binding: ItemInspireBinding) :
        RecyclerView.ViewHolder(binding.root)


}

data class InspireItem(
    val soundUrl: String,
    val title: String,
    val description: String,
    val image: String,
    var isplaying: Boolean = false
)
