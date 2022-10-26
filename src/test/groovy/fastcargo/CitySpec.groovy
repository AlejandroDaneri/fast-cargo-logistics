package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CitySpec extends Specification implements DomainUnitTest<City> {

    void "city must have a name"() {
        when: "trying to create a city without a name"
        State state = new State()
        City city = [name: "", state: state]
        then: 'validation must fail'
        !city.validate()
        city.errors.hasFieldErrors('name')
    }

    void "city must have a state"() {
        when: "trying to create a city without a name"
        State state = new State()
        City city = [name: "Springfield"]
        then: 'validation must fail'
        !city.validate()
        city.errors.hasFieldErrors('state')
    }
}
