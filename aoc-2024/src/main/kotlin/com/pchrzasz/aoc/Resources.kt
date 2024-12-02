package com.pchrzasz.aoc

import java.io.File
import java.net.URI

internal object Resources {

    fun resourceAsText(fileName: String): String =
        File(fileName.toURI()).readText()

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find Resource: $this")
}