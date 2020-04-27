package com.zanyzephyr.workmanagertest

class Dependencies {

    val libraries = ArrayList<String>()

    fun implementation(lib: String) {
        libraries.add(lib)
    }
}

fun dependencies(block: Dependencies.() -> Unit): ArrayList<String> {
    val dependencies = Dependencies()
    dependencies.block()
    return dependencies.libraries
}

fun main() {
    val libraries = dependencies {
        implementation("com.foo:foo:2.1")
        implementation("com.bar:bar:3.5")
    }
    for (lib in libraries) {
        println(lib)
    }
}