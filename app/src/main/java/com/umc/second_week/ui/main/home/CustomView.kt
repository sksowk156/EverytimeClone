package com.umc.second_week.ui.main.home

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.umc.second_week.R

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var text: String

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            0, 0).apply {

            try {
                text = getString(R.styleable.CustomView_cus_text) ?: ""
            } finally {
                recycle()
            }
        }

        inflate(context, R.layout.customlayout, this)

        val titleTextView = findViewById<TextView>(R.id.customId)

        titleTextView.setText(text)
    }
}