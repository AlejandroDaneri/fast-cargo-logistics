package fastcargo



class Order {
    Customer sender
    Package pack
    Location destination
    Location origin
    Warehouse warehouse
    OrderStatus status = OrderStatus.PROCESSING

    enum OrderStatus {
        PROCESSING,
        PROCESSED
    }

    static mapping = {
        table 'shipping_order'
    }


}


