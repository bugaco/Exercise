package com.zanyzephyr.workmanagertest

import java.lang.StringBuilder

class Td {
    var content = ""
    fun html() = "\n\t\t<td>$content</td>"
}

class Tr {
    val tdList = ArrayList<Td>()

    fun td(block: Td.() -> String) {
        val td = Td()
        td.content = td.block()
        tdList.add(td)
    }

    fun html(): String {
        val builder = StringBuilder()
        builder.append("\n\t<tr>")
        for (td in tdList) {
            builder.append(td.html())
        }
        builder.append("\n\t</tr>")
        return builder.toString()
    }
}

fun table(block: Table.() -> Unit): String {
    val table = Table()
    table.block()
    return table.html()
}

class Table {
    val trList = ArrayList<Tr>()

    fun tr(block: Tr.() -> Unit) {
        val tr = Tr()
        tr.block()
        trList.add(tr)
    }

    fun html(): String {
        val builder = StringBuilder()
        builder.append("\n<table>")
        for (tr in trList) {
            builder.append(tr.html())
        }
        builder.append("\n</table>\n")
        return builder.toString()
    }
}

fun main() {
    val tr = Tr()
    tr.td { "Item 1" }
    tr.td { "Item 2" }
    tr.td { "Item 3" }

    val table = Table()
    table.tr {
        td { "A" }
        td { "B" }
        td { "C" }
    }
    table.tr {
        td { "1" }
        td { "2" }
        td { "3" }
    }

    val tableHtml = table {
        tr {
            td { "1⃣️" }
            td { "2⃣️️" }
            td { "三" }
        }
        tr {
            td { "五" }
            td { "6" }
            td { "7" }
        }
    }
    println(tableHtml)
}