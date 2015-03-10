package models;
 import java.util.ArrayList;
import java.util.List;
import play.data.validation.Constraints;
import controllers.Products;
import java.util.LinkedList; // can de dung linkedlist
import play.mvc.PathBindable;
//import dung ebean
import play.db.ebean.Model;
 import javax.persistence.Entity;
 import javax.persistence.Id;

@Entity
public class Product extends Model  implements PathBindable<Product> {

    @Id
    public Long id; // la khoa

	public List<Tag> tags = new LinkedList<Tag>();
    public static Finder<Long,Product> find =
            new Finder<Long,Product>(Long.class, Product.class);
	 private static List<Product> products;
  static {
    products = new ArrayList<Product>();
    products.add(new Product("1111111111111", "Paperclips 1",
        "Paperclips description 1"));
    products.add(new Product("2222222222222", "Paperclips 2",
        "Paperclips description 2"));
    products.add(new Product("3333333333333", "Paperclips 3",
        "Paperclips description 3"));
    products.add(new Product("4444444444444", "Paperclips 4",
        "Paperclips description 4"));
    products.add(new Product("5555555555555", "Paperclips 5",
        "Paperclips description 5"));
  }
  
   @Override
    public Product bind(String key, String value) {
        return findByEan(value);
    }
 
    @Override
    public String unbind(String key) {
        return ean;
    }
 
    @Override
    public String javascriptUnbind() {
        return ean;
    }
  
 @Constraints.Required
  public String ean;
  
  @Constraints.Required
  public String name;
  
  public String description;

    public byte[] picture;
  //  public List<Tag> tags;    // trường quan hệ nối với Tag
  public Product() {}
  public Product(String ean, String name, String description) {
    this.ean = ean;
    this.name = name;
    this.description = description;
  }
  public String toString() {
    return String.format("%s - %s", ean, name);
  }

    public static List<Product> findAll() {
        return find.all();
    }
 
  public static Product findByEan(String ean) {
    for (Product candidate : products) {
      if (candidate.ean.equals(ean)) {       
        return candidate;
      }
    }
    return null;
  }
 
  public static List<Product> findByName(String term) {
    final List<Product> results = new ArrayList<Product>();
    for (Product candidate : products) {
      if (candidate.name.toLowerCase().contains(term.toLowerCase())) {
        results.add(candidate);
      }
    }
    return results;
  }
  
 
  public static boolean remove(Product product) {
    return products.remove(product);
  }
 

}