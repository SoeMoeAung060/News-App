package com.example.shoppingapp.presentations.onboarding

import androidx.annotation.DrawableRes
import com.example.shoppingapp.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)


val pages = listOf(
    Page(
        title = "Explore The Unexplored Places",
        description = "Explore the whole world with just a single click. Know availability immediately on call or emails.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Get Tickets Easily At Your Convenience",
        description = "Explore the whole world with just a single click. Know availability immediately on call or emails.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Avail New Offers Everytime",
        description = "Specify your date and ticket, we’ll get you at the best valueExplore the whole world with just a single click. ",
        image = R.drawable.onboarding3
    )
)
