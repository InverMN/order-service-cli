package me.inver.orderservicecli.common;

import me.inver.orderservicecli.common.ObjectId;

import java.util.Random;

public class ObjectIdGenerator {
    private static int currentId = new Random().nextInt(1777215) + 15000000;

    public static ObjectId generate() {
        return new ObjectId(Integer.toHexString(currentId++));
    }
}
