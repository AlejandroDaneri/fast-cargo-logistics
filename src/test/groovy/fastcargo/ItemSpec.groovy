package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ItemSpec extends Specification implements DomainUnitTest<Item> {

    void "creation of items with negative weight should not be allowed"() {
        when: "trying to create an item with negative weight"
        Item item = [weigth: -1]
        then: 'validation must fail'
        !item.validate()
        item.errors.hasFieldErrors("weight")
    }

    void "creation of items with weight equal to 0 should not be allowed"() {
        when: "trying to create an item with weight equal to 0"
        Item item = [weigth: 0]
        then: 'validation must fail'
        !item.validate()
        item.errors.hasFieldErrors("weight")
    }

    void "creation of items without weight must fail"() {
        when: "trying to create an item with weight equal to 0"
        Item item = []
        then: 'validation must fail'
        !item.validate()
        item.errors.hasFieldErrors("weight")
    }

}
