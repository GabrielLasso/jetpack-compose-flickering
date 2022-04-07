package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val composeView = findViewById<ComposeView>(R.id.compose)

        composeView.setContent {
            Test()
        }
    }
}

@Composable
fun Test() {
    var expanded: Boolean by remember { mutableStateOf(false) }
    Surface(
        shape = RoundedCornerShape(6.dp, 6.dp, 0.dp, 0.dp),
        color = Color.LightGray,
        modifier = Modifier
            .shadow(16.dp, RoundedCornerShape(6.dp, 6.dp, 0.dp, 0.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                expanded = !expanded
            }
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Row {
                Text(text = "Title")
                Icon(
                    Icons.Outlined.ArrowDropUp,
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer(
                            rotationZ = animateFloatAsState(if (expanded) 180f else 0f).value
                        ),
                    tint = Color.Black
                )
            }
            AnimatedVisibility(expanded) {
                Column {
                    Text(text = "Info 1")
                    Text(text = "Info 2")
                    Text(text = "Info 3")
                    Text(text = "Info 4")
                }
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(0.dp, 8.dp)
                    .height(40.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = "ACTION",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}