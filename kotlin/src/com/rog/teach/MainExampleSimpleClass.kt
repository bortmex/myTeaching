import com.rog.teach.entity.User

fun main() {
    val alex = User()

    alex.firstName = "Bob"
    println(alex)
    val djon = User("qwe", "asd")
    println("djon.login = " + djon.login)

    djon.login = "Codi"

    println(djon)
    println(djon.login)
}