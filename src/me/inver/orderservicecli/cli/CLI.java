package me.inver.orderservicecli.cli;

import me.inver.orderservicecli.common.ObjectId;
import me.inver.orderservicecli.model.Model;

public interface CLI {
    public void execute(String[] commandSegments);
    public void printHelp();
    public void printNotFound();
}
