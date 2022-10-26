package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PackageSpec extends Specification implements DomainUnitTest<Package> {

    def setup() {
    }

    def cleanup() {
    }
    void "todo ok"() {
        List<Item> items = [new Item(5),new Item(5)]
        Package pack = new Package(10, 10, 10, 20, items)
        expect: "fix me"
        pack.width == 10
        pack.length == 10
        pack.height == 10
        pack.weight == 20
        pack.items == items
    }
/*    void "cuando los items tienen mas peso que el paquete"() {
        List<Item> items = [new Item(50)]
        Package pack = new Package(10, 10, 10, 20, items)
        expect: "fix me"
        pack.width == 10
        pack.length == 10
        pack.height == 10
        pack.weight == 20
        pack.items == items
    }*/
/*    void "cuando los items tienen mas peso que el paquete"() {
        List<Item> items = [new Item(5),new Item(20)]
        Package pack = new Package(10, 10, 10, 20, items)
        expect: "fix me"
        pack.width == 10
        pack.length == 10
        pack.height == 10
        pack.weight == 20
        pack.items == items
    }*/

/*    void "items vacia"() {
        List<Item> items = []
        Package pack = new Package(10, 10, 10, 20, items)
        expect: "fix me"
        pack.width == 10
        pack.length == 10
        pack.height == 10
        pack.weight == 20
        pack.items == items
    }*/
    void "normal package"() {
        Package pack = new Package(10, 10, 10, 20)
        expect: "fix me"
        pack.width == 10
        pack.length == 10
        pack.height == 10
        pack.weight == 20
    }
}
