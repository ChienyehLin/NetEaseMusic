package com.example.neteasemusic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.neteasemusic.design.theme.NetEaseMusicTheme
import com.example.neteasemusic.ui.MyApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT))//显示到状态栏
        setContent {
            val navController = rememberNavController()
            NetEaseMusicTheme {
                MyApp(navController)
            }
        }
    }
}

@Composable
fun MyButton(titleRes: Int, modifier: Modifier = Modifier) {
  Button(
      onClick = {
          Log.d("MyButton", "点击了")
      },
      colors = ButtonDefaults.buttonColors(
          containerColor = MaterialTheme.colorScheme.primary
      ),
      modifier = Modifier.fillMaxWidth()
  ) {
      Text(text = stringResource(id = titleRes))
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetEaseMusicTheme {
        MyButton(R.string.agree)
    }
}