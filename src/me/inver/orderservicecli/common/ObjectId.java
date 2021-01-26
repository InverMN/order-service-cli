package me.inver.orderservicecli.common;

public class ObjectId {
    private final String id;

    public ObjectId(String hexNumber) {
        id = hexNumber;
    }

    public boolean equals(ObjectId obj) {
        return id.equals(obj.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
