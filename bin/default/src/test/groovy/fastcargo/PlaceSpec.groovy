package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PlaceSpec extends Specification implements DomainUnitTest<Place> {

    def setup() {
    }

    def cleanup() {
    }

    // zipcode must exists
    void "test something"() {
        Place place = new Place(city: "Monte Chingolo", state: "Buenos Aires", country: "Argentina")
        expect: "fix me"
        place.city == "Monte Chingolo"
        place.state == "Buenos Aires"
        place.country == "Argentina"
    }
}
