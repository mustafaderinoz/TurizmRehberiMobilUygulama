package com.mustafaderinoz.asistan.model

data class Message(
    val text: String,
    val isUser: Boolean // true = kullanıcı, false = bot
)
