package com.composeapp.ecommerceapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeapp.ecommerceapp.data.models.Category


@Composable
fun CategorySection() {
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
                text = "Categories",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
            )

            Text(
                text = "See All",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(end = 16.dp)
            )

        }

        CategoryList(categoryList)


    }
}

val categoryList = listOf(
    Category(
        creationAt = "2023-01-01T00:00:00Z",
        id = 1,
        name = "Clothing",
        updatedAt = "2023-01-01T00:00:00Z",
        image = "https://example.com/clothing.jpg"
    ),
    Category(
        creationAt = "2023-01-01T00:00:00Z",
        id = 2,
        name = "Electronics",
        updatedAt = "2023-01-01T00:00:00Z",
        image = "https://example.com/electronics.jpg"
    ),
    Category(
        creationAt = "2023-01-01T00:00:00Z",
        id = 3,
        name = "Furniture",
        updatedAt = "2023-01-01T00:00:00Z",
        image = "https://example.com/furniture.jpg"
    ),
    Category(
        creationAt = "2023-01-01T00:00:00Z",
        id = 4,
        name = "Jewelry",
        updatedAt = "2023-01-01T00:00:00Z",
        image = "https://example.com/jewelry.jpg"
    ),
    Category(
        creationAt = "2023-01-01T00:00:00Z",
        id = 5,
        name = "Shoes",
        updatedAt = "2023-01-01T00:00:00Z",
        image = "https://example.com/shoes.jpg"
    ),
    Category(
        creationAt = "2023-01-01T00:00:00Z",
        id = 6,
        name = "Sports",
        updatedAt = "2023-01-01T00:00:00Z",
        image = "https://example.com/sports.jpg"
    )
)

@Composable
fun CategoryList(categoryList: List<Category>) {

    LazyRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
        categoryList.forEach { category ->
            item {
                CategoryItem(category)
            }
        }
    }


}

@Composable
fun CategoryItem(category: Category) {
    SuggestionChip(onClick = {

    }, label = {
        Text(text = category.name, fontWeight = FontWeight.Bold)
    }, modifier = Modifier.padding(horizontal = 8.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = MaterialTheme.colorScheme.surface,
            labelColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            disabledLabelColor = MaterialTheme.colorScheme.primary
        )
    )
}