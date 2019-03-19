package com.felixsoares.animatedbottombar.model

class Item {
    var message: String = ""
    var iconBg: Int = 0
    var icon: Int = 0

    constructor(message: String, icon: Int) {
        this.message = message
        this.icon = icon
    }

    constructor(iconBg: Int, icon: Int) {
        this.iconBg = iconBg
        this.icon = icon;
    }
}