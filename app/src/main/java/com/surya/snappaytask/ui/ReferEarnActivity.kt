package com.surya.snappaytask.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.surya.snappaytask.R
import com.surya.snappaytask.databinding.ActivityReferEarnBinding

class ReferEarnActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReferEarnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReferEarnBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
            val color = ContextCompat.getColor(this@ReferEarnActivity, R.color.black)
            val drawable =
                ContextCompat.getDrawable(this@ReferEarnActivity, R.drawable.ic_arrow_back)
            if (drawable != null) {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                setHomeAsUpIndicator(drawable)
            }
        }

        binding.imgLeftArrow.setOnClickListener {
            val intent = Intent(this, TrackReferralActivity::class.java)
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

    override fun onBackPressed() {
        finishAffinity()
    }
}