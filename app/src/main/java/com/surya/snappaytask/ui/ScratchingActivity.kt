package com.surya.snappaytask.ui

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.anupkumarpanwar.scratchview.ScratchView
import com.anupkumarpanwar.scratchview.ScratchView.IRevealListener
import com.surya.snappaytask.R
import com.surya.snappaytask.databinding.ActivityScratchingBinding


class ScratchingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScratchingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScratchingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
            val color = ContextCompat.getColor(this@ScratchingActivity, R.color.black)
            val drawable =
                ContextCompat.getDrawable(this@ScratchingActivity, R.drawable.ic_arrow_back)
            if (drawable != null) {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                setHomeAsUpIndicator(drawable)
            }
        }

        binding.scratchView.setRevealListener(object : IRevealListener {
            override fun onRevealed(scratchView: ScratchView) {
                binding.beforeScratchTop.visibility = View.GONE
                binding.afterScratchTop.visibility = View.VISIBLE
                binding.beforeScratchBottom.visibility = View.GONE
                binding.afterScratchBottom.visibility = View.VISIBLE
            }

            override fun onRevealPercentChangedListener(scratchView: ScratchView, percent: Float) {

            }
        })

        binding.btn0.setOnClickListener {
            val intent = Intent(this, ReferEarnActivity::class.java)
            startActivity(intent)
        }
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
}