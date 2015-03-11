package models;
 
import play.data.validation.Constraints;
import play.db.ebean.Model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;
import views.html.products.*;
@Entity
public class Tag extends Model{


	@Id
    public Long id;

    @Constraints.Required
    public String name;

    @ManyToMany(mappedBy="tags")
    public List<Product> products;


    public static Finder<Long, Tag> find =
            new Finder<>(Long.class, Tag.class);
    public static Tag findById(Long id) {
        return find.byId(id);
    }
    public Tag(){
        // Left empty
    }
    public Tag(Long id, String name, Collection<Product> products) {
        this.id = id;
        this.name = name;
        this.products = new LinkedList<Product>(products);
        for (Product product : products) {
            product.tags.add(this);
        }
    }
}