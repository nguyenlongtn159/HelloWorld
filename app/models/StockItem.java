package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by nguyenlongtn159 on 3/10/2015.
 */
@Entity
public class StockItem extends Model {
    @Id
    public Long id;

    @ManyToOne
    public Warehouse warehouse;
            // trường quan hệ nối với Warehouse
    @ManyToOne
    public Product product;               // trường quan hệ nối với Product
    public Long quantity;

    public static Finder<Long, StockItem> find =
            new Finder<>(Long.class, StockItem.class);
    public static StockItem findById(Long id) {
        return find.byId(id);
    }


    public String toString() {
        return String.format("StockItem %d - %d x product %s",
                id, quantity, product == null ? null : product.id);
    }
    }
