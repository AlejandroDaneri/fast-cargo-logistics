package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CarrierHubSpec extends Specification implements DomainUnitTest<CarrierHub> {

    void "validation of hub without a name must fail"() {
        when: "name is invalid"
        CarrierHub hub = [name: "", location: [address: "NC suite 3", city: new City(), zipCode: "1234-2241"] as Location]
        then: 'validation must fail'
        !hub.validate()
        hub.errors.hasFieldErrors('name')
    }

}
