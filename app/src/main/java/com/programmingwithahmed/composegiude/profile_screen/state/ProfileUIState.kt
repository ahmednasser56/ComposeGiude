package com.programmingwithahmed.composegiude.profile_screen.state

data class ProfileUIState(
    val firstName: String = "",
    val lastName: String = "",
    val location: String = "",
    val email: String = "",
    val phone: String = "",
    val profileImage: String = "https://via.placeholder.com/600/f66b97"
)