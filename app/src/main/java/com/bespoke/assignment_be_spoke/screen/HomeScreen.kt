package com.bespoke.assignment_be_spoke.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bespoke.assignment_be_spoke.R
import androidx.compose.ui.layout.ContentScale
import com.bespoke.assignment_be_spoke.models.Category
import com.bespoke.assignment_be_spoke.models.Shop
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
       Header()

        // Banner
        BannerSection()

        // Limited Time Offers
        val limitedTimeOffers = listOf(
            Shop("Cafe Aroma", "123 Main St", R.drawable.cofee_1),
            Shop("Burger Hub", "456 Food Lane", R.drawable.ic_chips)
        )
        OffersSection(title = "Limited Time Offers", shops = limitedTimeOffers)

        // Categories
        CategoriesSection()



        // Visit Again
        val visitAgain = listOf(
            Shop("Steak House", "789 Grill Rd", R.drawable.visit_1),
            Shop("Coffee Time", "101 Espresso St", R.drawable.visit_2)
        )
        OffersSection(title = "Visit Again", shops = visitAgain)

        // Upcoming Offers (dummy data same as above for demo)
        val upcomingOffers = listOf(
            Shop("Starbucks Coffee", "1st Floor, City Center Mall", R.drawable.cold_cofee),
            Shop("Domino's Pizza", "Food Court, High Street", R.drawable.ic_pizza)
        )
        OffersSection(title = "Upcoming Offers", shops = upcomingOffers)


        PromotionsSlider(
            images = listOf(
                R.drawable.ic_offer_1,
                R.drawable.ic_offer_2,
                R.drawable.ic_offer_3
            ))


    }
}

@Composable
fun BannerSection() {
    val bannerImages = listOf(
        R.drawable.slider_image_1,
        R.drawable.slider_image_2,
        R.drawable.slider_image_3,
        R.drawable.slider_image_4
    )

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(bannerImages) { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(300.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }
}

@Composable
fun CategoriesSection() {
    val categories = listOf(
        Category("New", R.drawable.ic_new_1),
        Category("Hot", R.drawable.ic_hot),
        Category("Grocery", R.drawable.ic_grocery),
        Category("Fruits", R.drawable.ic_fruits),
        Category("Vegetable", R.drawable.ic_vegetable),
        Category("Meat", R.drawable.ic_meat),
        Category("Sea Food", R.drawable.ic_seafood),
        Category("Dairy", R.drawable.ic_dairy)
    )

    var selectedCategory by remember { mutableStateOf("New") }

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Categories", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("View all categories", color = Color.Gray, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Grid layout (2 per row)
            val chunked = categories.chunked(2)
            chunked.forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowItems.forEach { category ->
                        val isSelected = category.name == selectedCategory
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isSelected) Color(0xFFFFEBEE) else Color.White
                            ),
                            border = BorderStroke(1.dp, if (isSelected) Color.Red else Color.LightGray),
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .clickable { selectedCategory = category.name }
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 12.dp),
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.align(Alignment.CenterStart)
                                ) {
                                    Image(
                                        painter = painterResource(id = category.iconRes),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(category.name, fontSize = 16.sp)
                                }

                                if (isSelected) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_selected),
                                        contentDescription = null,
                                        tint = Color.Red,
                                        modifier = Modifier
                                            .size(20.dp)
                                            .align(Alignment.CenterEnd)
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}

@Composable
fun OffersSection(title: String, shops: List<Shop>) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("View all offers", color = Color.Gray, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(shops) { shop ->
                    ShopCard(shop)
                }
            }
        }
    }
}

@Composable
fun PromotionsSlider(images: List<Int>) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Promotions",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )
            }
        }
    }
}





@Composable
fun ShopCard(shop: Shop) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(200.dp)
            .clickable { /* TODO */ }
    ) {
        Column {
            Image(
                painter = painterResource(id = shop.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(shop.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(shop.address, fontSize = 14.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB71C1C)),
                shape = RoundedCornerShape(8.dp), // Added this line for curved corners
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text("LOCATE", color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
