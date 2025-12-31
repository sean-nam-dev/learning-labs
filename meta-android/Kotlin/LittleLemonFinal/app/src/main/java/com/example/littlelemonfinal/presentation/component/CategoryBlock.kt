package com.example.littlelemonfinal.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonfinal.util.FilterType

@Composable
fun CategoryBlock(
    filterList: List<FilterType>,
    onClick: (FilterType) -> Unit
) {
    val filterTagList = listOf(
        FilterType.Starters,
        FilterType.Mains,
        FilterType.Desserts,
        FilterType.Drinks,
        FilterType.Soups
    )

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 25.dp
            ),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = "ORDER FOR DELIVERY!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(filterTagList) { tag ->
                val border = if (filterList.contains(tag)) {
                    BorderStroke(
                        width = 1.dp,
                        color = Color.Black
                    )
                } else {
                    BorderStroke(
                        width = 0.dp,
                        color = Color(0xFFedefee)
                    )
                }

                SuggestionChip(
                    onClick = {
                        onClick(tag)
                    },
                    label = {
                        Text(tag.value, fontWeight = FontWeight.Bold)
                    },
                    colors = SuggestionChipDefaults.suggestionChipColors(
                        containerColor = Color(0xFFedefee),
                        labelColor = Color(0xFF4d625b)
                    ),
                    border = border
                )
            }
        }
    }
}