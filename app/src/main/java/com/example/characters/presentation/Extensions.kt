package com.example.characters.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imageAddress: String) {
    Glide.with(this)
        .load(imageAddress)
        .into(this)
}