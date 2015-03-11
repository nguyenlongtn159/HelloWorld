package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by nguyenlongtn159 on 3/10/2015.
 */
@Entity
public class Warehouse extends Model{
    @Id
    public Long id;

    public String name;

    @OneToOne
    public Address address;

    @OneToMany(mappedBy = "warehouse")


    public static Finder<Long, Tag> find =
            new Finder<>(Long.class, Tag.class);
    public static Tag findById(Long id) {
        return find.byId(id);
    }
    public List<StockItem> stock = new ArrayList();  // trường quan hệ

    public String toString() {
        return name;
    }
}
