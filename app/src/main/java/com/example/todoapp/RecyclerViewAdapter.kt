package com.example.todoapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*


class RecyclerViewAdapter (private val items:ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
   var countOFcheck = 0
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item= items[position]


        holder.itemView.apply {
           taskTextView.text = item
            checkBox.setOnCheckedChangeListener{_, isChecked ->
                if(isChecked){
                    taskTextView.setTextColor(Color.GRAY)
                    countOFcheck  ++
               //   var index=   items.indexOf(items[position])
                 //   removeItem(index, countOFcheck )

                }else{
                    taskTextView.setTextColor(Color.BLACK)
                }

            }
            }



        }


    override fun getItemCount() = items.size

fun removeItem(index:Int,countOFch:Int){
    items.removeAt(index)
    var count = countOFch
}


}

