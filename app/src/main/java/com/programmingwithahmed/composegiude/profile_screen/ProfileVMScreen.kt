package com.programmingwithahmed.composegiude.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.programmingwithahmed.composegiude.R
import com.programmingwithahmed.composegiude.profile_screen.state.ProfileUIState
import com.programmingwithahmed.composegiude.ui.theme.Green
import com.programmingwithahmed.composegiude.ui.theme.Rubik

@Composable
fun ProfileVMScreen(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    val uiState by profileViewModel.profileUiState.collectAsState()

    ProfileVMContent(
        profileUIState = uiState,
        onFirstNameChanged = profileViewModel::onChangeFirstName,
        onLastNameChanged = profileViewModel::onChangeLastName,
        onLocationChanged = profileViewModel::onChangeLocation,
        onEmailChanged = profileViewModel::onChangeEmail,
        onPhoneChanged = profileViewModel::onChangePhone,
        onSaveClicked = profileViewModel::onSaveClicked
    )
}


@Composable
private fun ProfileVMContent(
    profileUIState: ProfileUIState,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onLocationChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onSaveClicked: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileHeader(title = "Account", subTitle = "Edit or manage your Account")
        Spacer(modifier = Modifier.height(32.dp))
        ProfileOnlineAvatar(imageUrl = profileUIState.profileImage)
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(text = "Change Profile Picture") {}
        Spacer(modifier = Modifier.height(32.dp))
        Row() {
            Box(modifier = Modifier.weight(1f))
            {
                ProfileEditableInfoCard(
                    title = stringResource(id = R.string.first_name),
                    body = profileUIState.firstName,
                    onValueChanged = onFirstNameChanged
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier.weight(1f))
            {
                ProfileEditableInfoCard(
                    title = stringResource(id = R.string.last_name),
                    body = profileUIState.lastName,
                    onValueChanged = onLastNameChanged
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ProfileEditableInfoCard(
            title = stringResource(id = R.string.location),
            body = profileUIState.location,
            onValueChanged = onLocationChanged
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProfileEditableInfoCard(
            title = stringResource(id = R.string.email),
            body = profileUIState.email,
            onValueChanged = onEmailChanged
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProfileEditableInfoCard(
            title = stringResource(id = R.string.phone),
            body = profileUIState.phone,
            onValueChanged = onPhoneChanged
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onSaveClicked,
            modifier = Modifier
                .fillMaxWidth(),
            shape = CutCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Green),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text(
                "Save",
                modifier = Modifier
                    .padding(8.dp),
                color = Color.White,
                fontFamily = Rubik,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }

}


@Preview
@Composable
fun ProfileVMScreenPreview() {
    ProfileVMContent(
        profileUIState = ProfileUIState(),
        onFirstNameChanged = {},
        onLastNameChanged = {},
        onLocationChanged = {},
        onEmailChanged = {},
        onPhoneChanged = {},
        onSaveClicked = {}
    )
}