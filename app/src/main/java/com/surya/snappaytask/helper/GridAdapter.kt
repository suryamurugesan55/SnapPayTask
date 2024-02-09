package com.surya.snappaytask.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import com.surya.snappaytask.R

class GridAdapter(context: Context, gridModelArrayList: ArrayList<GridModel>, private var onItemClick: OnItemClick,) :
    ArrayAdapter<GridModel?>(context, 0, gridModelArrayList!! as List<GridModel?>) {

    interface OnItemClick {
        fun onItemClicked()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.lyt_grid, parent, false)
        }

        val gridModel: GridModel? = getItem(position)
        val imgView = listItemView!!.findViewById<AppCompatImageView>(R.id.imgView)
        val textView = listItemView.findViewById<AppCompatTextView>(R.id.textView)
        val cardView = listItemView.findViewById<CardView>(R.id.cardView)

        cardView.setOnClickListener {
            onItemClick.onItemClicked()
        }

        textView.text = gridModel!!.getDays()
        imgView.setImageResource(gridModel.getImgId())
        return listItemView
    }
}