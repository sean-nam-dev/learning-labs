package dev.sn.littlelemonktor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.sn.littlelemonktor.ui.theme.LittleLemonKtorTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

    private val model: MainViewModel by viewModels()
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                },
                contentType = ContentType.Text.Plain
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var menuItemList by remember { mutableStateOf<List<String>>(emptyList()) }

            val menuItemListObserver = Observer<List<String>> { newMenuItemList ->
                menuItemList = newMenuItemList
            }
            model.menuItemsLiveData.observe(this, menuItemListObserver)

            LittleLemonKtorTheme {
                Scaffold { paddingValues ->
                    LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                        item {
                            Button(
                                onClick = {
                                    model.getMenu(
                                        httpClient = httpClient,
                                        category = "Salads"
                                    )
                                }
                            ) {
                                Text("Load Salads")
                            }
                        }
                        items(menuItemList) { menu ->
                            Text(menu)
                        }
                    }
                }
            }
        }
    }
}

class MainViewModel : ViewModel() {
    val menuItemsLiveData: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    fun getMenu(
        httpClient: HttpClient,
        category: String
    ) {
        viewModelScope.launch {
            val response: Map<String, MenuCategory> = httpClient.get(URL)
                .body<Map<String, MenuCategory>>()
            menuItemsLiveData.value = response[category]?.menu ?: emptyList()
        }
    }

    companion object {
        private const val URL = "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/littleLemonMenu.json"
    }
}

@Serializable
data class MenuCategory(
    val menu: List<String>
)