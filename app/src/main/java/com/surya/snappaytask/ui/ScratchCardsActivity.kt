package com.surya.snappaytask.ui

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.surya.snappaytask.R
import com.surya.snappaytask.databinding.ActivityScratchCardsBinding
import com.surya.snappaytask.helper.GridAdapter
import com.surya.snappaytask.helper.GridModel

class ScratchCardsActivity : AppCompatActivity(), GridAdapter.OnItemClick {
    private lateinit var binding: ActivityScratchCardsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScratchCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
            val color = ContextCompat.getColor(this@ScratchCardsActivity, R.color.black)
            val drawable =
                ContextCompat.getDrawable(this@ScratchCardsActivity, R.drawable.ic_arrow_back)
            if (drawable != null) {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                setHomeAsUpIndicator(drawable)
            }
        }


        val modelArrayList: ArrayList<GridModel> = ArrayList<GridModel>()

        modelArrayList.add(GridModel("Expiring in 10 days", R.drawable.ic_scratch_1))
        modelArrayList.add(GridModel("Expiring in 10 days", R.drawable.ic_scratch_2))
        modelArrayList.add(GridModel("Expiring in 10 days", R.drawable.ic_scratch_3))
        modelArrayList.add(GridModel("Expiring in 10 days", R.drawable.ic_scratch_4))

        val adapter = GridAdapter(this, modelArrayList, this@ScratchCardsActivity)
        binding.gridView.adapter = adapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClicked() {
        val intent = Intent(this, ScratchingActivity::class.java)
        startActivity(intent)
    }
}