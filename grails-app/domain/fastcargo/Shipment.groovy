package fastcargo

class Shipment {
    byte[] label
    BigDecimal price
    CarrierHub hub
    ShipmentStatus status = ShipmentStatus.SCHEDULED
    String trackingCode
    Order order

    enum ShipmentStatus {
        SCHEDULED,
        MOVING,
        DELIVERED
    }

    static constraints = {
    }
}
