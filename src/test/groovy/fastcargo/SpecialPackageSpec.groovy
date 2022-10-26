package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class SpecialPackageSpec extends Specification implements DomainUnitTest<SpecialPackage> {

    def createValidItem() {
        [weight: 25] as Item
    }

    void "successful validation of special package"() {
        when: "package with correct dimensions and a list of items is created"
        List<Item> items = [createValidItem(), createValidItem()]
        SpecialPackage pack = [width: 10, length: 10, height: 10, weight: 100, items: items]
        then: 'validation must success'
        pack.validate()
    }

    void "validation of package with incorrect weight (one item) must fail"() {
        when: "items have more weight than the package"
        List<Item> items = [createValidItem()]
        SpecialPackage pack = [width: 10, length: 10, height: 10, weight: 1, items: items]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('items')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with incorrect weight (more than one item)  must fail "() {
        when: "items have more weight than the package"
        List<Item> items = [createValidItem(), createValidItem(), createValidItem(), createValidItem(), createValidItem()]
        SpecialPackage pack = [width: 10, length: 10, height: 10, weight: 10, items: items]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('items')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with empty items list must fail"() {
        when: "when the items list is empty"
        List<Item> items = []
        SpecialPackage pack = [width: 10, length: 10, height: 10, weight: 10, items: items]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('items')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with invalid width must fail"() {
        when: "width is invalid"
        List<Item> items = [createValidItem()]
        SpecialPackage pack = [width: 0, length: 10, height: 10, weight: 100, items: items]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('width')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with invalid length must fail"() {
        when: "length is invalid"
        List<Item> items = [createValidItem()]
        SpecialPackage pack = [width: 10, length: 0, height: 10, weight: 100, items: items]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('length')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with invalid height must fail"() {
        when: "height is invalid"
        List<Item> items = [createValidItem()]
        SpecialPackage pack = [width: 10, length: 10, height: 0, weight: 100, items: items]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('height')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with invalid weight must fail"() {
        when: "weight is invalid"
        List<Item> items = [createValidItem()]
        SpecialPackage pack = [width: 10, length: 10, height: 20, weight: -10, items: items]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('weight')
    }
}
