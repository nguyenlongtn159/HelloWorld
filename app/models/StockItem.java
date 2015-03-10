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

    public String toString() {
        return String.format("$d %s", quantity, product);
    }
}
