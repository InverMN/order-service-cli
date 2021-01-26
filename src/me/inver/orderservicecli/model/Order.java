package me.inver.orderservicecli.model;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.common.ObjectIdGenerator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Model {
    private final ObjectId id;
    private final String date;
    private final ObjectId purchaser;
    private final BigDecimal cost;
    private final String[] items;

    public BigDecimal getCost() {
        return cost;
    }

    public String[] getItems() {
        return items;
    }

    @Override
    public ObjectId getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public ObjectId getPurchaser() {
        return purchaser;
    }

    public Order(ObjectId purchaser, BigDecimal cost, String[] items) {
        this.id = ObjectIdGenerator.generate();
        this.purchaser = purchaser;
        this.date = new SimpleDateFormat().format(new Date());
        this.cost = cost;
        this.items = items;
    }
}
