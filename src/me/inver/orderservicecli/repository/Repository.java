package me.inver.orderservicecli.repository;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.model.Model;

public interface Repository<T extends Model> {
    public void saveOne(T model);
    public boolean exists(ObjectId id);
    public T[] findAll();
    public T findOneById(ObjectId id);
    public void removeOneById(ObjectId id);
}
