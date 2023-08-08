package com.eduardomcb.unpacker

import kotlin.math.pow

class Unbaser(private val base: Int) {
    private val selector: Int
    private val ALPHABET = mapOf(
        52 to "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOP",
        54 to "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQR",
        62 to "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
        95 to " !\"#\$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"
    )
    private val dict: Map<Char, Int>?

    init {
        selector = when {
            base > 62 -> 95
            base > 54 -> 62
            base > 52 -> 54
            else -> 52
        }
        dict = ALPHABET[selector]?.mapIndexed { index, char -> char to index }?.toMap()
    }

    /**
     * Unbases the given value using the specified radix.
     *
     * @param value The value to unbase.
     * @return The unbased integer value.
     */
    fun unbase(value: String): Int {
        return if (base in 2..36) {
            value.toIntOrNull(base) ?: 0
        } else {
            var result = 0
            val valueArray = value.reversed()

            for ((index, cipher) in valueArray.withIndex()) {
                result += base.toDouble().pow(index.toDouble()).toInt() * (dict?.get(cipher) ?: 0)
            }
            result
        }
    }
}