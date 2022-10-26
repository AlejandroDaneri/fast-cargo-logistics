package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ItemSpec extends Specification implements DomainUnitTest<Item> {

    def setup() {
    }

    def cleanup() {
    }

    void "normal package"() {
        Package pack = new Item()
        expect: 'fix me'
        pack.item != 0
    }

}
