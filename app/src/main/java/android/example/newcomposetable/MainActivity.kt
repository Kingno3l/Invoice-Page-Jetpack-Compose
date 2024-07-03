package android.example.newcomposetable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.example.newcomposetable.ui.theme.NewComposeTableTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.breens.beetablescompose.BeeTablesCompose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val users = listOf(
                User(name =  "John", age  =  25, email =  "helloemail@example.com"),
                User(name =  "Sim", age  =  15, email =  "simmers@example.com"),
                User(name =  "Sam", age  =  12, email =  "samore@example.com"),
                User(name =  "Ade", age  =  56, email =  "adele@example.com"),
            )
            val tableHeaders = listOf("Name", "Age", "Email")
            NewComposeTableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        BeeTablesCompose(data = users, headerTableTitles = tableHeaders)
                    }
                }
            }
        }
    }
}

data class User(
    val name: String,
    val age: Int,
    val email: String
)

