package fastcargo

class NormalPackage extends Package {

    static constraints = {
        importFrom Package
    }
}
