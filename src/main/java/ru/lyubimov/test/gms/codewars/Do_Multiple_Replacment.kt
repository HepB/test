package ru.lyubimov.test.gms.codewars

fun f(s: String): String = Regex("""[{\[(>})<\]]""").replace(s){c->when(c.value[0]){'{','[','<'->(c.value[0] + 2).toString()'(' -> ")"')' -> "(" else -> (c.value[0] - 2).toString()}}
fun f1(s: String): String = s.map{when(it){'<','{','['->it+2 '>','}',']'->it-2 '('->')'')'->'(' else->it}}.joinToString("")
//fun f2(s: String): String = s.map{when(it){'<','{','['->it+2 '>','}',']'->it-2 '('->')'')'->'(' else->it}}

val c = """s.map{when(it){'<','{','['->it+2 '>','}',']'->it-2 '('->')'')'->'(' else->it}}.joinToString("")"""
fun main(args: Array<String>) {
    println(f("dfs}sdf]("))
    println(f1("dfs}sdf]("))
    //println(f2("dfs}sdf]("))
    println(c.length)
}
