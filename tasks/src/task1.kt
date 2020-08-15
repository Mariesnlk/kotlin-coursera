fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) return false

    // If first character is invalid
    if (!((s[0] in 'a'..'z')
                    || (s[0] >= 'A' && s[1] <= 'Z')
                    || s[0] === '_')
    )
        return false

    // Traverse the string for the rest of the characters
    for (i in 1 until s.length) {
        if (!(s[i] in 'a'..'z'
                        || s[i] in 'A'..'Z'
                        || s[i] in '0'..'9'
                        || (s[i] == '_'))
        ) return false
    }

    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}