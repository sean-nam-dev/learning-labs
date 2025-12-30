package com.example.littlelemonfinal.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemonfinal.presentation.component.LemonButton
import com.example.littlelemonfinal.presentation.component.LemonLogo
import com.example.littlelemonfinal.presentation.component.TextInput
import com.example.littlelemonfinal.presentation.component.Title
import com.example.littlelemonfinal.ui.theme.LittleLemonFinalTheme

@Composable
fun LogoutUIScreen(
    data: Triple<String, String, String>,
    onLogoutAction: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LemonLogo(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 30.dp)
        )
        Title(
            modifier = Modifier.padding(
                start = 10.dp,
                top = 80.dp,
                end = 10.dp,
                bottom = 40.dp
            )
        )
        TextInput(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
            value = "",
            onValueChange = {},
            label = data.first,
            enabled = false
        )
        TextInput(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
            value = "",
            onValueChange = {},
            label = data.second,
            enabled = false
        )
        TextInput(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
            value = "",
            onValueChange = {},
            label = data.third,
            enabled = false
        )
        Spacer(modifier = Modifier.weight(1f))
        LemonButton(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 30.dp
                ),
            text = "Log out",
            onClick = { onLogoutAction() }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LogoutUIScreenPreview() {
    LittleLemonFinalTheme {
        LogoutUIScreen(
            data = Triple(
                "John",
                "Johnson",
                "example@gmail.com"
            ),
            onLogoutAction = {}
        )
    }
}