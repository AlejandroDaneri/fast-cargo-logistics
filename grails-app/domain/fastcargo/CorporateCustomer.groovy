package fastcargo

class CorporateCustomer extends Customer {

    static constraints = {
        importFrom Customer
    }
}
