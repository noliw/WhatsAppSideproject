package com.example.whatsappsideproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappsideproject.ui.theme.textColor
import com.example.whatsappsideproject.ui.theme.whatsApp
import kotlin.math.min

@Composable
fun LoginScreen() {

}

@Composable
fun BottomForm(
    modifier: Modifier = Modifier
) {
    val (phoneNum, onPhoneNumChange) = remember { mutableStateOf("") }
    val (email, onEmailChange) = remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)

    ) {

        Column(
            modifier = Modifier
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Create a New Account",
                color = textColor,
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleSmall,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Phone Number",
                color = if (phoneNum.length != 10 && phoneNum.isNotEmpty()) Color.Red else textColor
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = phoneNum,
                onValueChange = onPhoneNumChange,
                textStyle = TextStyle.Default.copy(
                    color = textColor,
                    fontSize = 18.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                prefix = {
                    Text(
                        text = "+1 ",
                        color = textColor,
                        fontSize = 18.sp,
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = "",
                        tint = if (phoneNum.length != 10 && phoneNum.isNotEmpty()) Color.Red else whatsApp
                    )
                },
                isError = phoneNum.isNotEmpty() && phoneNum.length != 10,
                supportingText = {
                    if (phoneNum.length != 10 && phoneNum.isNotEmpty())
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Phone number must be 10 digits long",
                            color = Color.Red,
                            textAlign = TextAlign.End
                        )
                    else
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "* Required",
                            color = Color.Gray,
                            textAlign = TextAlign.End
                        )
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedIndicatorColor = whatsApp,
                    unfocusedIndicatorColor = whatsApp
                )
            )


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Email Address",
                color = if (email.isNotEmpty() && (!email.contains("@") || !email.contains("."))) Color.Red else textColor

                )


            TextField(
                value = email,
                onValueChange = onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle.Default.copy(
                    color = textColor,
                    fontSize = 18.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "",
                        tint = if (email.isNotEmpty() && (!email.contains("@") || !email.contains("."))) Color.Red else whatsApp
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next

                ),
                isError = email.isNotEmpty() && (!email.contains("@") || !email.contains(".")),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedIndicatorColor = whatsApp,
                    unfocusedIndicatorColor = whatsApp
                ),
                supportingText = {
                    if (email.isNotEmpty() && (!email.contains("@") || !email.contains(".")))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Enter A Valid Email Address",
                            color = Color.Red,
                            textAlign = TextAlign.End
                        )
                    else
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "* Required",
                        color = Color.Gray,
                        textAlign = TextAlign.End
                    )
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Password",
                color = textColor
            )
            TextField(
                value = phoneNum,
                onValueChange = onPhoneNumChange
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Login",
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "or signup with")

            Spacer(modifier = Modifier.height(64.dp))

            Row {
                Box() {}
                Box() {}
                Box() {}
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row {
                Text(text = "Already have an account")
                Text(text = "Login Here")

            }


        }
    }

}


@Preview()
@Composable
fun BottomFormPreview() {
    BottomForm()
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}