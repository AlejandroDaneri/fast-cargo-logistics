package fastcargo

class State {
    String name
    Country country

    static constraints = {
        name blank:false
    }

}
