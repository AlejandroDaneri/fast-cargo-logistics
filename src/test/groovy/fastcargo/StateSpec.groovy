package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class StateSpec extends Specification implements DomainUnitTest<State> {

    void "state must be in a country"() {
        when: "trying to create a state without a name"
        Country country = new Country()
        State state = [name: "", country: country]
        then: 'validation must fail'
        !state.validate()
        state.errors.hasFieldErrors('name')
    }
}
