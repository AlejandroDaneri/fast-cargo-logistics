package fastcargo

class Package {
    float width
    float length
    float height
    float weight

    static constraints = {
        weight validator: {
            if (it <= 0) return ['invalidWeight']
        }
        width validator: {
            if (it <= 0) return ['invalidWidth']
        }
        height validator: {
            if (it <= 0) return ['invalidHeight']
        }
        length validator: {
            if (it <= 0) return ['invalidLength']
        }
    }

}
