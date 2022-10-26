package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ClientSpec extends Specification implements DomainUnitTest<Client> {

    void "creation of client with blank name must fail"() {
        when: "trying to create a client without name"
        Client client = [name: "", email: "aa.com"]
        then: 'validation must fail'
        !client.validate()
        client.errors.hasFieldErrors('name')
    }

    void "creation of client without a name must fail"() {
        when: "trying to create a client without name"
        Client client = [email: "aa.com"]
        then: 'validation must fail'
        !client.validate()
        client.errors.hasFieldErrors('name')
    }

    void "creation of client without email must fail"() {
        when: "trying to create a client with blank email"
        Client client = [name: "Pepe Perez", email: ""]
        then: 'validation must fail'
        !client.validate()
        client.errors.hasFieldErrors('email')
    }


    void "creation of client with invalid email must fail"() {
        when: "trying to create a client with an invalid email"
        Client client = [name: "Pepe Perez", email: "aa.com"]
        then: 'validation must fail'
        !client.validate()
        client.errors.hasFieldErrors('email')
    }

}
