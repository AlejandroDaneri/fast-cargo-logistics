package fastcargo

class RegularCustomer extends Customer {

    static constraints = {
        importFrom Customer
    }
}
