package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class OrderSpec extends Specification implements DomainUnitTest<Order> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        Client client = new Client(name: "Pepe Perez")
        Package pack = new Package(width: 10, length: 10, height: 10, weight: 20)
        Place destination = new Place(country: "Canada", state: "Ontario", city: "Toronto", zipCode: 123456)
        Place origin = new Place(country: "Canada", state: "Ontario", city: "Toronto", zipCode: 123456)
        Warehouse warehouse = new Warehouse(city: "papa")
        Order order = new Order(owner: client, pack: pack, origin: origin, destination: destination, warehouse: warehouse)
        expect: "fix me"
        order.owner == client
        order.pack == pack
        order.destination == destination
        order.origin == origin
        order.warehouse == warehouse
    }
}
