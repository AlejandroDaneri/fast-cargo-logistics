package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CountrySpec extends Specification implements DomainUnitTest<Country> {

    void "country must have a name"() {
        when: "trying to create a country without a name"
        Country country = [name: ""]
        then: 'validation must fail'
        !country.validate()
        country.errors.hasFieldErrors('name')
    }
}
