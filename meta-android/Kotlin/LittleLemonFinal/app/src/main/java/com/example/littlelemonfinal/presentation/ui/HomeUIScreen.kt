package com.example.littlelemonfinal.presentation.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.littlelemonfinal.R
import com.example.littlelemonfinal.domain.model.Menu
import com.example.littlelemonfinal.presentation.component.CategoryBlock
import com.example.littlelemonfinal.presentation.component.Header
import com.example.littlelemonfinal.presentation.component.InfoBody
import com.example.littlelemonfinal.presentation.component.LemonLogo
import com.example.littlelemonfinal.presentation.component.ProfileButton
import com.example.littlelemonfinal.ui.theme.LittleLemonFinalTheme
import com.example.littlelemonfinal.util.FilterType
import com.example.littlelemonfinal.util.Temp

@Composable
fun HomeUIScreen(
    menuList: List<Menu>,
    searchQuery: String,
    filterList: List<FilterType>,
    onProfileClick: () -> Unit,
    onSearchQuery: (String) -> Unit,
    onFilter: (FilterType) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Header(onProfileClick)
        }
        item {
            InfoBody(
                searchText = searchQuery,
                onSearchText = onSearchQuery
            )
        }
        item {
            CategoryBlock(
                filterList =  filterList,
                onClick = onFilter
            )
        }
        item {
            Divider(modifier = Modifier.padding(horizontal = 10.dp))
        }
        items(menuList) { i ->
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = i.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(0.7f),
                        text = i.description,
                        fontSize = 12.sp,
                        color = Color(0xFF697b74),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 14.sp
                    )
                    AsyncImage(
                        modifier = Modifier.weight(0.3f),
                        model = i.image,
                        contentDescription = null
                    )
                }
                Text(
                    text = "$${i.price}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF60736d)
                )
                Divider(modifier = Modifier.padding(vertical = 10.dp))
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun HomeUIScreenPreview() {
//    LittleLemonFinalTheme {
//        HomeUIScreen(
//            emptyList(),
//            onProfileClick = {}
//        )
//    }
//}