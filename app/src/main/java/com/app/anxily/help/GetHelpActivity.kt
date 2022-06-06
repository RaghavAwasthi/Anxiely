package com.app.anxily.help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.anxily.R
import com.app.anxily.databinding.ActivityGetHelpBinding
import com.app.anxily.databinding.ItemGetHelpBinding
import com.app.base.ui.activity.BindingBaseActivity


class GetHelpActivity : BindingBaseActivity<ActivityGetHelpBinding>() {
    override fun onCreate(savedInstanceState: Bundle?, binding: ActivityGetHelpBinding) {
        val items = mutableListOf<GetHelpItem>()
        items.add(
            GetHelpItem(
                header = "Sangath",
                subHeader = "Sangath is a not-for-profit organisation working in Goa",
                image = R.drawable.ic_ins1,
                phone = "9888888888",
            )
        )
        items.add(
            GetHelpItem(
                header = "Mitram Foundation",
                subHeader = "Mitram Foundation is a suicide prevention helpline that aims",
                image = R.drawable.ic_ins2,
                phone = "98888888848",
            )
        )
        items.add(
            GetHelpItem(
                header = "Vandrevala Foundation",
                subHeader = "Cyrus & Priya Vandrevala Foundation is a non-profit ",
                image = R.drawable.ic_ins3,
                phone = "98888888858",
            )
        )
        items.add(
            GetHelpItem(
                header = "Parivarthan",
                subHeader = "Parivarthan Counselling, Training and Research Centre is a registered",
                image = R.drawable.ic_ins4,
                phone = "98888888838",
            )
        )

        items.add(
            GetHelpItem(
                header = "iCALL",
                subHeader = "iCALL is a psychosocial helpline for individuals in emotional",
                image = R.drawable.ic_ins5,
                phone = "98888888438",
            )
        )

        items.add(
            GetHelpItem(
                header = "Lifeline",
                subHeader = "Lifeline offers a free tele-helpline providing emotional support",
                image = R.drawable.ic_ins6,
                phone = "98848888438",
            )
        )



        binding.rvList.layoutManager= GridLayoutManager(this,2)
        binding.rvList.adapter= GetHelpAdapter(items)
    }

    override fun getViewBinding(): ActivityGetHelpBinding {
        return ActivityGetHelpBinding.inflate(layoutInflater)
    }

    inner class GetHelpAdapter(val items: List<GetHelpItem>) :
        RecyclerView.Adapter<GetHelpViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetHelpViewHolder {
            return GetHelpViewHolder(ItemGetHelpBinding.inflate(layoutInflater, parent, false))
        }

        override fun onBindViewHolder(holder: GetHelpViewHolder, position: Int) {
            holder.bind.apply {
                btnCall.setOnClickListener {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:${items[position].phone}")
                    startActivity(intent)
                }
                tvHeader.text = items[position].header
                tvSubheader.text = items[position].subHeader
                ivMain.setImageResource(items[position].image)
            }
        }

        override fun getItemCount(): Int {
            return items.size
        }

    }


    inner class GetHelpViewHolder(val bind: ItemGetHelpBinding) : RecyclerView.ViewHolder(bind.root)

}


data class GetHelpItem(
    val header: String,
    val subHeader: String,
    @DrawableRes
    val image: Int,
    val phone: String,
)
