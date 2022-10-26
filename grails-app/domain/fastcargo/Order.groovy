package fastcargo

class Order {
    Client sender
    Package pack
    Location destination
    Location origin
    Warehouse warehouse

    static mapping = {
        table 'shipping_order'
    }
}
