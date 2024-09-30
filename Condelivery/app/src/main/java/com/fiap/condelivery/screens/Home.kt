package com.fiap.condelivery.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fiap.esgapp.R
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
    fun UserProfileScreen(navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top Bar with icons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logotipo",
                    Modifier.size(30.dp)
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.home), // Replace with appropriate icons
                        contentDescription = "Home",
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "Profile",
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = "Settings",
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.config),
                        contentDescription = "Settings",
                        modifier = Modifier.size(25.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // User profile with picture, name and edit button
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar2), // User profile picture
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Lucas Vidal", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Usuário", fontSize = 16.sp, color = Color.Gray)
                    }
                }

                Button(onClick = { /* Edit Profile Action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1677FF))) {
                    Icon(painter = painterResource(id = R.drawable.editar), contentDescription = "Edit Icon", Modifier.size(15.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Editar perfil")

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize() // Preenche a tela toda
                    .padding(16.dp), // Adiciona padding ao redor da coluna
                verticalArrangement = Arrangement.spacedBy(16.dp) // Adiciona espaçamento entre os itens
            ) {
                OrderSummaryCard(title = "Pedidos realizados nos últimos 7 dias", count = 3, isPositive = true)
                OrderSummaryCard(title = "Pedidos realizados nos últimos 30 dias", count = 4, isPositive = false)
                OrderSummaryCard(title = "Total de pedidos realizados", count = 23 , isPositive = true)

                OrderInProgressCard()
            }

        }
    }

    @Composable
    fun OrderSummaryCard(title: String, count: Int, isPositive: Boolean?) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, 35.dp)
                .padding(vertical = 8.dp),

            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = title, fontSize = 16.sp)
                    Row(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isPositive != null) {
                            Icon(
                                painter = painterResource(
                                    id = if (isPositive) android.R.drawable.arrow_up_float else android.R.drawable.arrow_down_float
                                ),
                                contentDescription = if (isPositive) "Crescente" else "Decrescente",
                                tint = if (isPositive) Color(0xFF52C41A) else Color.Red,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "$count",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isPositive == true) Color(0xFF52C41A) else Color.Red
                        )
                    }
                }

            }
        }
    }

    @Composable
    fun OrderInProgressCard() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, 40.dp)
                .padding(vertical = 16.dp)
                .background(color = Color(0xFFFFFFFF)),

            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Pedido em andamento", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Image(
                        painter = painterResource(id = R.drawable.ifood), // Replace with Ifood logo
                        contentDescription = "Ifood Logo",
                        modifier = Modifier.size(65.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1677FF)),
                    onClick = { /* Authorize action */ },
                    modifier = Modifier.fillMaxWidth(),

                ) {
                    Text(text = "Autorizar pedido", color = Color.White)
                }
            }
        }
    }