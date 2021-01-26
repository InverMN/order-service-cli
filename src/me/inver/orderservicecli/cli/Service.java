package me.inver.orderservicecli.cli;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.model.Model;

public interface Service<T extends Model> {
    public void printOne(T object, boolean isListItem);
    public void printOneById(ObjectId id);
    public void printAll();
    public void create(T model);
    public void remove(ObjectId id);
}
