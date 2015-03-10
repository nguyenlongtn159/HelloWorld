package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "warehouse")
    public List<StockItem> stock = new ArrayList();  // trường quan hệ

    public String toString() {
        return name;
    }
}
