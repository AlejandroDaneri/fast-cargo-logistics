package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PackageSpec extends Specification implements DomainUnitTest<Package> {

    void "successful validation of special package"() {
        when: "package have correct dimensions"
        Package pack = [width: 10, length: 10, height: 10, weight: 100]
        then: 'validation must success'
        pack.validate()
    }

    void "validation of package with invalid width must fail"() {
        when: "width is invalid"
        Package pack = [width: 0, length: 10, height: 10, weight: 100]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('width')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with invalid length must fail"() {
        when: "length is invalid"
        Package pack = [width: 10, length: 0, height: 10, weight: 100]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('length')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with invalid height must fail"() {
        when: "height is invalid"
        Package pack = [width: 10, length: 10, height: 0, weight: 100]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('height')
        pack.errors.allErrors.size() == 1
    }

    void "validation of package with invalid weight must fail"() {
        when: "weight is invalid"
        Package pack = [width: 10, length: 10, height: 20, weight: -10]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('weight')
    }
}
