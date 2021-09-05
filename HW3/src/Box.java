public class Box<T extends Fruit> {
    private T object;
    private int count;

    public Box(T object) {
        this.object = object;
    }

    public T getObject() {
        return this.object;
    }

    public void addObject(int n) {
        count += n;
    }

    public void removeObject(int n) {
        count -= n;
    }
    @Override
    public String toString() {
        return "Box: type " + this.object.getClass().getSimpleName() + ", count " + this.count + ", weight "
                + this.getWeight();
    }

    public double getWeight() {
        return (object.weightFruit * count);
    }

    public boolean compare(Box<?> b) {
        if (b.getWeight() == getWeight()) {
            return true;
        }
        return false;
    }

    public String putToAnother(Box<?> b) {
        String t1 = this.object.getClass().getSimpleName();
        String t2 = b.object.getClass().getSimpleName();
        if (t1 != t2) {
            return "Box " + t1 + " is not " + t2 + " Box, can't put to " + t2 + " Box";
        }
        int tmpCount = count;
        b.addObject(tmpCount);
        count = 0;
        return "All " + t1 + " has been putted to another box, another box after weighting " + b.getWeight();
    }
}