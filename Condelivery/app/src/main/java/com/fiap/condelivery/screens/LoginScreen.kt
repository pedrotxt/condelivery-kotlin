package com.fiap.condelivery.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import android.util.Log
import com.fiap.esgapp.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fiap.condelivery.model.Post
import com.fiap.condelivery.network.ApiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(10.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, 90.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logotipo",
                Modifier.size(100.dp)
            )
            Text(
                text = "Condelivery",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1677FF)
            )
            Text(
                text = "Entregas em sua porta!",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000)
            )
        }
        Column (
            modifier = Modifier.offset(0.dp, 150.dp),
        ){
            Text(
                modifier = Modifier.offset(0.dp, 15.dp),
                text = "Insira seu email e senha para continuar",
                fontSize = 15.sp,
                color = Color(0xFF1677FF)
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = "Email",
                        color = Color(0xFF667085)
                    )
                },
                modifier = Modifier
                    .border(
                        border = BorderStroke(1.dp, Color(0xFFD0D5DD)),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "E-mail Icon",
                        tint = Color.Unspecified
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = "Password",
                        color = Color(0xFF667085)
                    )
                },
                modifier = Modifier
                    .border(
                        border = BorderStroke(1.dp, Color(0xFFD0D5DD)),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = "Lock Icon",
                        tint = Color.Unspecified
                    )
                }
            )
            Text(
                text = "Esqueceu a senha ?",
                fontSize = 13.sp,
                color = Color(0xFF1677FF),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    // Navegar para a tela de login após a resposta
                    navController.navigate("home")

                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://backend-condelivery.onrender.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val service: ApiService = retrofit.create(ApiService::class.java)

                    val requestBody = Post("lucascadastrando@gmail.com", "lucas123")

                    service.postRequest(requestBody).enqueue(object : Callback<ResponseBody> {
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            // retornando token do usuario logado
                            Log.d("Response", "${response.body()?.string()}")


                        }
                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            Log.d("Hi", "error")
                        }
                    })
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1677FF)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Log in")
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                Divider(
                    color = Color(0xFFD0D5DD),
                    thickness = 2.dp,
                    modifier = Modifier.weight(0.5f)
                )
                Text (text = "OR",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFD0D5DD),
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 0.dp,
                        end = 8.dp,
                        bottom = 0.dp
                    )
                )
                Divider(
                    color = Color(0xFFD0D5DD),
                    thickness = 2.dp,
                    modifier = Modifier.weight(0.5f)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

