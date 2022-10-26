package fastcargo

class Order {

    static constraints = {
    }
    Client owner
    Package pack
    Place destination
    Place origin
    Warehouse warehouse
}
