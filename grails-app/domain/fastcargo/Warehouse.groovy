package fastcargo

class Warehouse {
    String name
    Location location

    static constraints = {
        name blank: false
    }
}
