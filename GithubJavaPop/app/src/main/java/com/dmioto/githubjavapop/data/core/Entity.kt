package com.dmioto.githubjavapop.data.core

import com.google.gson.GsonBuilder

internal interface Entity {

    fun toJson(): String {
        val gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()
        return gson.toJson(this)
    }

}