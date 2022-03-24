import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    println("Input bilangan = ")
    val s = input.nextInt()
    var a = 0
    var b = 1

    while (b <= 5) {
        a += s
        if (a % 2 == 0 || a % 3 == 0) {
            print("$a ")
            b++
        }
    }


}
