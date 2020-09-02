fun main(args: Array<String>) {
    val s = "String"
    println(s as? Int)    // null
    println(s as Int?)    // exception
}