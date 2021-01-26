package me.inver.orderservicecli.model;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.common.ObjectIdGenerator;

public class Client implements Model {
    private final ObjectId id;
    private final String name;
    private final String surname;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public ObjectId getId() {
        return id;
    }

    public Client(String name, String surname) {
        this.id = ObjectIdGenerator.generate();
        this.name = name;
        this.surname = surname;
    }
}