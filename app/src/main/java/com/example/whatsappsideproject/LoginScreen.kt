package com.example.whatsappsideproject

import android.content.res.Resources
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappsideproject.ui.theme.textColor
import com.example.whatsappsideproject.ui.theme.whatsApp
import com.example.whatsappsideproject.ui.theme.whatsAppGray
import kotlin.math.min


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
                TopImg(Modifier.fillMaxHeight(0.25f))
                BottomForm(Modifier.fillMaxHeight(1f))
        }
    }
}

@Composable
fun TopImg(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth(),

        ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.whatsapp),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

/*@Preview
@Composable
fun TopImgPreview() {
    TopImg()
}*/

@Composable
fun BottomForm(
    modifier: Modifier = Modifier
) {
    val (phoneNum, onPhoneNumChange) = remember { mutableStateOf("") }
    val (email, onEmailChange) = remember { mutableStateOf("") }
    val (password, onPasswordChange) = remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }


    Box(
        modifier = modifier
            .background(Color.White)
            .padding(horizontal = 16.dp)
            .fillMaxHeight()

    ) {

        Column(
            modifier = modifier
                .background(Color.White)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
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
                fontSize = 14.sp,
                color = if (phoneNum.length != 10 && phoneNum.isNotEmpty()) Color.Red else textColor
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .fillMaxHeight(0.15f),
                value = phoneNum,
                onValueChange = onPhoneNumChange,
                textStyle = TextStyle.Default.copy(
                    color = textColor,
                    fontSize = 16.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                prefix = {
                    Text(
                        text = "+1 ",
                        color = textColor,
                        fontSize = 16.sp,
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
                ),
                maxLines = 1
            )


            Spacer(modifier = Modifier.height(5.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Email Address",
                fontSize = 14.sp,
                color = if (email.isNotEmpty() && (!email.contains("@") || !email.contains("."))) Color.Red else textColor

            )


            TextField(
                value = email,
                onValueChange = onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle.Default.copy(
                    color = textColor,
                    fontSize = 16.sp,
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
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Password",
                fontSize = 14.sp,
                color = if (password.isNotEmpty() && password.length < 8) Color.Red else textColor
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = onPasswordChange,
                textStyle = LocalTextStyle.current.copy(
                    color = textColor,
                    fontSize = 16.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.SemiBold
                ),

                visualTransformation = if (!isVisible) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    val image =
                        if (isVisible) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff
                    IconButton(onClick = { isVisible = !isVisible }) {

                        Icon(
                            imageVector = image,
                            contentDescription = "",
                            tint = if (password.isNotEmpty() && password.length < 8) Color.Red else whatsApp
                        )
                    }
                },
                supportingText = {
                    if (password.isNotEmpty() && password.length < 8)
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            color = Color.Red,
                            text = "Password must be minimum 8 characters"
                        )
                    else
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            text = "* Required",
                            color = Color.Gray
                        )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedIndicatorColor = whatsApp,
                    unfocusedIndicatorColor = whatsApp
                ),
                isError = password.isNotEmpty() && password.length < 8,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                maxLines = 1

            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.small,
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(whatsApp),
                enabled = password.isNotEmpty() && password.length >= 8,
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Sign Up",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(0.5.dp)
                        .background(whatsAppGray),
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "or signup with",
                        color = whatsAppGray,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(0.5.dp)
                        .background(whatsAppGray)
                )
            }



            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .border(0.1.dp, whatsAppGray, CircleShape)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painterResource(id = R.drawable.fb_ic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp),
                        tint = Color.Unspecified
                    )
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .border(0.1.dp, whatsAppGray, CircleShape)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painterResource(id = R.drawable.ig_ic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp),
                        tint = Color.Unspecified
                    )
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .border(0.1.dp, whatsAppGray, CircleShape)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painterResource(id = R.drawable.g_ic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp),
                        tint = Color.Unspecified
                    )
                }

            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = "Already have an account?",
                    textAlign = TextAlign.Center,
                    color = textColor,
                    fontSize = 12.sp
                )
                Text(
                    modifier = Modifier,
                    text = "Login Here",
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    fontSize = 12.sp
                )

            }


        }
    }

}


//@Preview()
//@Composable
//fun BottomFormPreview() {
//    BottomForm()
//}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(modifier = Modifier)
}