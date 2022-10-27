package fastcargo

class CarrierHub {
    String name
    Location location

    static constraints = {
        name blank: false
    }
}
