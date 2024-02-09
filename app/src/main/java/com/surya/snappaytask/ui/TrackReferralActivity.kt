package com.surya.snappaytask.ui

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TextAppearanceSpan
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import com.surya.snappaytask.R
import com.surya.snappaytask.databinding.ActivityReferEarnBinding
import com.surya.snappaytask.databinding.ActivityTrackReferralBinding

class TrackReferralActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrackReferralBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackReferralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
            val color = ContextCompat.getColor(this@TrackReferralActivity, R.color.black)
            val drawable =
                ContextCompat.getDrawable(this@TrackReferralActivity, R.drawable.ic_arrow_back)
            if (drawable != null) {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                setHomeAsUpIndicator(drawable)
            }
        }

        binding.btnComplete.setOnClickListener {
            val intent = Intent(this, ScratchCardsActivity::class.java)
            startActivity(intent)
        }

        binding.ll0.setOnClickListener {
            val intent = Intent(this, ScratchCardsActivity::class.java)
            startActivity(intent)
        }

        binding.ll1.setOnClickListener {
            val intent = Intent(this, ScratchCardsActivity::class.java)
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