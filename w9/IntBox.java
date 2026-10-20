public class IntBox {
    public int value;

    public IntBox(int v) {
        value = v;
    }

    // this implements a deep comparison with another IntBox
    // note that technically this isn't the right way to override the equals
    // method we inherit from Object, but you can look that up later if you're
    // curious
    public boolean equals(IntBox other) {
        return this.value == other.value;
    }

    // we can add a method for a deep copy
    public IntBox clone() {
        return new IntBox(this.value);
    }
}
