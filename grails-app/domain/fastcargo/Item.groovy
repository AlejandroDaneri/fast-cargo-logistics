package fastcargo

class Item {
    Float weight
    String name

    static constraints = {
        weight validator: {
            if (weight <= 0) return ['invalidWeight']
        }
        name blank: false
    }


}
