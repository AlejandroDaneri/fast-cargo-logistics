package fastcargo

class City {
    String name
    State state

    static constraints = {
        name blank: false
    }
}
