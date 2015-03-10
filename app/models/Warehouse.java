package models;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by nguyenlongtn159 on 3/10/2015.
 */
public class Warehouse {
    public String name;
    public List<StockItem> stock = new ArrayList();  // trường quan hệ

    public String toString() {
        return name;
    }
}
