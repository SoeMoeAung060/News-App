package com.example.shoppingapp.presentations.onboarding

//this class will have the event that will be sent from the UI to the viewModel
sealed class OnBoardingEvent {

    data object SaveAppEntry : OnBoardingEvent()
}