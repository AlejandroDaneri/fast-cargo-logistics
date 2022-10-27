package fastcargo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class NormalPackageSpec extends Specification implements DomainUnitTest<NormalPackage> {

    void "validation of NormalPackage with invalid width must fail"() {
        when: "width is invalid"
        NormalPackage pack = [width: 0, length: 10, height: 10, weight: 100]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('width')
        pack.errors.allErrors.size() == 1
    }

    void "validation of NormalPackage with invalid length must fail"() {
        when: "length is invalid"
        NormalPackage pack = [width: 10, length: 0, height: 10, weight: 100]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('length')
        pack.errors.allErrors.size() == 1
    }

    void "validation of NormalPackage with invalid height must fail"() {
        when: "height is invalid"
        NormalPackage pack = [width: 10, length: 10, height: 0, weight: 100]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('height')
        pack.errors.allErrors.size() == 1
    }

    void "validation of NormalPackage with invalid weight must fail"() {
        when: "weight is invalid"
        NormalPackage pack = [width: 10, length: 10, height: 20, weight: -10]
        then: 'validation must fail'
        !pack.validate()
        pack.errors.hasFieldErrors('weight')
    }
}
