package com.kmp.scaffold

actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = NativeBase64Encoder
}

object NativeBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray {
        return byteArrayOf(0x01, 0x02, 0x03)
    }
}