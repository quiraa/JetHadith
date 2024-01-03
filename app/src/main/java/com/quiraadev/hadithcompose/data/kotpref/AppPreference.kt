package com.quiraadev.hadithcompose.data.kotpref

import com.chibatching.kotpref.KotprefModel

object AppPreference : KotprefModel() {
    var darkMode by booleanPref(false)
}