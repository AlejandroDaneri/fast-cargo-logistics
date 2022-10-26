package fastcargo

class Client {
    String name
    String email

    static constraints = {
        email blank: false, email: true
        name blank: false
    }
}
