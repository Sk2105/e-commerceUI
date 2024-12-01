package com.composeapp.ecommerceapp.data.navigation


import kotlinx.serialization.Serializable

sealed interface AppGraph {

    @Serializable
    data class Detail(val id: Int) : AppGraph

    @Serializable
    data object Home : AppGraph

    @Serializable
    data object Cart : AppGraph

}