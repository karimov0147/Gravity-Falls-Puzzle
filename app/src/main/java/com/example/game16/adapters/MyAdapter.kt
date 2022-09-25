package com.example.game16.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.game16.R
import com.example.game16.databinding.ItemViewBinding
import com.example.game16.models.Score

class MyAdapter(var list : ArrayList<Score>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var binding = ItemViewBinding.bind(view)
        fun onBind(score : Score){
            binding.apply {
                textView.text = score.name
                time.text = score.time
                step.text  = score.step.toString()
                textView5.text = score.type
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.item_view , parent , false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}