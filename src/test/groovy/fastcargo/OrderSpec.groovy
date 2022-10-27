package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class OrderSpec extends Specification implements DomainUnitTest<Order> {

    void "creation of an order with all required property must success"() {
        when: "trying to create an order with all properties"
        Customer customer = [name: "Pepe Perez", email: "a@a.com"]
        Package pack = [width: 10, length: 10, height: 10, weight: 20]
        Location destination = [address: "Andres Baranda 100", city: new City(), zipCode: "B1579"]
        Location origin = [address: "Cabildo 215", city: new City(), zipCode: "B1679"]
        Warehouse warehouse = [name: "Zona Sur 3", location: [address: "Cabildo 215", city: new City(), zipCode: "B1679"] as Location]
        Order order = [sender: customer, pack: pack, origin: origin, destination: destination, warehouse: warehouse]
        then: "validation must succeed"
        order.validate()
    }
}
