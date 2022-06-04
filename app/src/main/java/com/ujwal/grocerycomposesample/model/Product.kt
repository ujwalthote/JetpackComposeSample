package com.ujwal.grocerycomposesample.model

data class Product(
    var id: Int? = null,
    var title: String? = null,
    var price: Double? = null,
    var description: String? = null,
    var category: String? = null,
    var image: String? = null,
    var rating: Rating? = null
)