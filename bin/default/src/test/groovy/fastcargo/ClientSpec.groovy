package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ClientSpec extends Specification implements DomainUnitTest<Client> {

    def setup() {
    }

    def cleanup() {
    }
    void "test something"() {
        Client client = new Client(name:"Pepe Perez")
        expect:"fix me"
            client.name == "Pepe Perez"
    }
}
