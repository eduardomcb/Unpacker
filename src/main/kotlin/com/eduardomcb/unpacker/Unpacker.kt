package com.eduardomcb.unpacker

import java.util.regex.Pattern

class Unpacker {
    private lateinit var unbaser: Unbaser
    private lateinit var payload: String
    private lateinit var symtab: List<String>
    private var radix: Int = 0
    private var count: Int = 0

    /**
     * Detects the presence of obfuscated JavaScript code in the given source.
     *
     * This function uses a regular expression to search for the pattern commonly used
     * to obfuscate JavaScript code.
     *
     * @param source The source code to be checked for obfuscated JavaScript.
     * @return `true` if obfuscated JavaScript code is detected, `false` otherwise.
     */
    fun detect(source: String): Boolean {
        val trimmedSource = source.replace(" ", "")
        val regex = Pattern.compile("eval\\(function\\(p,a,c,k,e,[r|d]?")
        val matcher = regex.matcher(trimmedSource)

        return matcher.find()
    }

    /**
     * Unpacks the obfuscated JavaScript code.
     *
     * It also early detects the presence of obfuscated JavaScript code in the specified font.
     *
     * @param source The obfuscated JavaScript source code.
     * @return The unpacked JavaScript code.
     */
    fun unpack(source: String): String {
        if (detect(source)) {
            val regex = Regex("}\\s*\\('(.*)',\\s*(.*?),\\s*(\\d+),\\s*'(.*?)'\\.split\\('\\|'\\)")
            val matchResult = regex.find(source)
            val (payloadValue, radixValue, countValue, symtabValue) = matchResult!!.destructured

            payload = payloadValue
            symtab = symtabValue.split("|")
            radix = radixValue.toInt()
            count = countValue.toInt()

            if (count != symtab.size) return ""

            unbaser = Unbaser(radix)

            val result = payload.replace("\\b\\w+\\b".toRegex()) { lookup(it.value) }
            return result.replace("\\", "")
        } else {
            return ""
        }
    }

    private fun lookup(matches: String): String {
        val ub = symtab.getOrNull(unbaser.unbase(matches)) ?: ""
        return ub.ifEmpty { matches }
    }
}


