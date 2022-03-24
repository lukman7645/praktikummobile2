import javafx.beans.property.ReadOnlyListProperty
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock
fun main(){
    println("Waktu Sekarang: ")
    val waktu = readLine()
    println("Nama Anda: ")
    val nama = readLine()
    println("Umur Anda: ")
    val umur = readLine()
    println("Suhu Tubuh Anda")
    val suhu = readLine()

    val biografi = """
        Selamat $waktu, $nama. 
        Umur Anda $umur Tahun.
        Suhu Tubuh anda $suhu derajat 
        Celcius.
        """.trimIndent()
        print(biografi)

}