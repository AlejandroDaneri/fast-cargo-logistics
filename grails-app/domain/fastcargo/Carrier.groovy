package fastcargo

class Carrier {
    String name

    static constraints = {
        name blank: false
    }
}
