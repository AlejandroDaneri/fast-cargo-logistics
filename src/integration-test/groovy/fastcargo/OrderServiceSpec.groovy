package fastcargo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrderServiceSpec extends Specification {

    OrderService orderService
    SessionFactory sessionFactory

    private Long setupData() {
        Country country = [name:"Argentina"]
        State state = [name:"Buenos Aires", country: country]
        City city = [name:"Una ciudad", state:state]
        Customer customer = [name: "Pepe Perez", email: "a@a.com"]
        Package pack = [width: 10, length: 10, height: 10, weight: 20]
        Location destination = [address: "Andres Baranda 100", city: city, zipCode: "B1579"]
        Location origin = [address: "Cabildo 215", city: city, zipCode: "B1679"]
        Warehouse warehouse = [name: "Zona Sur 3", location: [address: "Cabildo 215", city: city, zipCode: "B1679"] as Location]
        Order order = [sender: customer, pack: pack, origin: origin, destination: destination, warehouse: warehouse, label: new byte[]{(byte) 0xe0, 0x4f, 0x20}]
        order.save(flush: true, failOnError: true)
        Order order2 = [sender: customer, pack: pack, origin: origin, destination: destination, warehouse: warehouse, label: new byte[]{(byte) 0xe0, 0x4f, 0x20}]
        order2.save(flush: true, failOnError: true)
        Order order3 = [sender: customer, pack: pack, origin: origin, destination: destination, warehouse: warehouse, label: new byte[]{(byte) 0xe0, 0x4f, 0x20}]
        order3.save(flush: true, failOnError: true)
        Order order4 = [sender: customer, pack: pack, origin: origin, destination: destination, warehouse: warehouse, label: new byte[]{(byte) 0xe0, 0x4f, 0x20}]
        order4.save(flush: true, failOnError: true)
        Order order5 = [sender: customer, pack: pack, origin: origin, destination: destination, warehouse: warehouse, label: new byte[]{(byte) 0xe0, 0x4f, 0x20}]
        order5.save(flush: true, failOnError: true)

        order5.id
    }

    void "test get"() {
        setupData()

        expect:
        orderService.get(1) != null
    }

   void "test list"() {
        setupData()

        when:
        List<Order> orderList = orderService.list(max: 2, offset: 2)

        then:
        orderList.size() == 2
    }

    void "test count"() {
        setupData()

        expect:
        orderService.count() == 5
    }

    void "test delete"() {
        Long orderId = setupData()

        expect:
        orderService.count() == 5

        when:
        orderService.delete(orderId)
        sessionFactory.currentSession.flush()

        then:
        orderService.count() == 4
    }

    void "test save"() {
        when:
        Country country = [name:"Argentina"]
        State state = [name:"Buenos Aires", country: country]
        City city = [name:"Una ciudad", state:state]
        Customer customer = [name: "Pepe Perez", email: "a@a.com"]
        Package pack = [width: 10, length: 10, height: 10, weight: 20]
        Location destination = [address: "Andres Baranda 100", city: city, zipCode: "B1579"]
        Location origin = [address: "Cabildo 215", city: city, zipCode: "B1679"]
        Warehouse warehouse = [name: "Zona Sur 3", location: [address: "Cabildo 215", city: city, zipCode: "B1679"] as Location]
        Order order = [sender: customer, pack: pack, origin: origin, destination: destination, warehouse: warehouse, label: new byte[]{(byte) 0xe0, 0x4f, 0x20}]

        orderService.save(order)

        then:
        order.id != null
    }
}
