package fastcargo

class Order {
    Customer sender
    Package pack
    Location destination
    Location origin
    Warehouse warehouse

    static mapping = {
        table 'shipping_order'
    }
}
