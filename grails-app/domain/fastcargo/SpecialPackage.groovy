package fastcargo

class SpecialPackage extends Package {
    List<Item> items

    static constraints = {
        importFrom Package
        items minSize: 1, validator: { items, pack -> items.weight.sum() < pack.weight }
    }
}
