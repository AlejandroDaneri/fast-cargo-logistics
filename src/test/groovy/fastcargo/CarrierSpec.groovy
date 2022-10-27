package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CarrierSpec extends Specification implements DomainUnitTest<Carrier> {

    void "validation of hub without a name must fail"() {
        when: "name is invalid"
        Carrier carrier = [name: ""]
        then: 'validation must fail'
        !carrier.validate()
        carrier.errors.hasFieldErrors('name')
    }
}
