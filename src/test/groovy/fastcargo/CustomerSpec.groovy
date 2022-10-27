package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CustomerSpec extends Specification implements DomainUnitTest<Customer> {

    void "creation of customer with blank name must fail"() {
        when: "trying to create a customer without name"
        Customer customer = [name: "", email: "aa.com"]
        then: 'validation must fail'
        !customer.validate()
        customer.errors.hasFieldErrors('name')
    }

    void "creation of customer without a name must fail"() {
        when: "trying to create a customer without name"
        Customer customer = [email: "aa.com"]
        then: 'validation must fail'
        !customer.validate()
        customer.errors.hasFieldErrors('name')
    }

    void "creation of customer without email must fail"() {
        when: "trying to create a customer with blank email"
        Customer customer = [name: "Pepe Perez", email: ""]
        then: 'validation must fail'
        !customer.validate()
        customer.errors.hasFieldErrors('email')
    }


    void "creation of customer with invalid email must fail"() {
        when: "trying to create a customer with an invalid email"
        Customer customer = [name: "Pepe Perez", email: "aa.com"]
        then: 'validation must fail'
        !customer.validate()
        customer.errors.hasFieldErrors('email')
    }

}
