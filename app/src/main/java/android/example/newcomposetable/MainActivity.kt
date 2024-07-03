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
import android.provider.Telephony.Mms.Rate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.breens.beetablescompose.BeeTablesCompose

data class User(
    val numb: Int,
    val item_desc: String,
    val Qty: Double,
    val Rate: Double,
    val Amount: Double
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val users = listOf(
                User(numb =  1, item_desc =  "Pepe Jeans", Qty =  1.00, Rate = 24.99, Amount = 24.99),
                User(numb =  2, item_desc =  "Boys Shirts", Qty =  4.00, Rate = 52.99, Amount = 52.99),
                User(numb =  3, item_desc =  "Girls Shirts", Qty =  3.00, Rate = 41.99, Amount = 41.99),
            )

            val tableHeaders = listOf("#", "Item & Description", "Qty", "Rate", "Amount")
            NewComposeTableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        MainContent(users = users, headers = tableHeaders)
                    }
                }
            }
        }
    }
}

@Composable
fun MainContent(users: List<User>, headers: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ItemTable(users = users, headers = headers)
        }
        item {
            ItemTable(users = users, headers = headers)
        }
    }
}

@Composable
fun ItemTable(users: List<User>, headers: List<String>) {
    BeeTablesCompose(data = users, headerTableTitles =headers, columnToIndexIncreaseWidth = 1)
}

