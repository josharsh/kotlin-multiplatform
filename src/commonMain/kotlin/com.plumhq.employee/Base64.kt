package com.kmp.scaffold

interface Base64Encoder {
    fun encode(src: ByteArray): ByteArray
}

expect object Base64Factory {
    fun createEncoder(): Base64Encoder
}