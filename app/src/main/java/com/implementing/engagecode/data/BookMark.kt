package com.implementing.engagecode.data

import androidx.annotation.DrawableRes
import com.implementing.engagecode.R

data class BookMark(
    val title: String,
    @DrawableRes val image: Int
)