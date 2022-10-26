package fastcargo

import fastcargo.exceptions.ErrorInvalidPackageWeight


class Package {
    public int width
    public int length
    public int height
    public int weight
    public List<Item> items

    Package(width, length, height, weight, items) {
        if (items.isEmpty()) throw new ErrorPackageEmpty() //test
        if (items.weight.sum() > weight) throw new ErrorInvalidPackageWeight() //test
        this.width = width
        this.length = length
        this.height = height
        this.weight = weight
        this.items = items
    }

    Package(width, length, height, weight) {
        this.width = width
        this.length = length
        this.height = height
        this.weight = weight
    }
    static constraints = {
    }
    
}
