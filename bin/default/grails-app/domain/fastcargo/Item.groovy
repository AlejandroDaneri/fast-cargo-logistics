package fastcargo

class Item {

    static constraints = {
        weight min: 0.0F, notEqual: 0F, nullable: false //check how to force
    }

    public final float weight

    Item(float weight) {
        this.weight = weight
    }

    // Item(){ //fix this
    //     throw new Exception()
    // }

}
