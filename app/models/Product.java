package models;
 import java.util.ArrayList;
import java.util.List;

 import com.avaje.ebean.Page;
 import play.data.validation.Constraints;
import controllers.Products;
import java.util.LinkedList; // can de dung linkedlist
import play.mvc.PathBindable;
//import dung ebean
import play.db.ebean.Model;
 import javax.persistence.Entity;
 import javax.persistence.Id;
 import javax.persistence.ManyToMany;
 import javax.persistence.OneToMany;

@Entity
public class Product extends Model  implements PathBindable<Product> {

    @Id
    public Long id; // la khoa

 //   @ManyToMany
	//public List<Tag> tags = new LinkedList<Tag>();

    public static Finder<Long,Product> find =
            new Finder<Long,Product>(Long.class, Product.class);
	// private static List<Product> products;

  
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

    @OneToMany(mappedBy="product")
    public List<StockItem> stockItems;

    public byte[] picture;

    @ManyToMany
    public List<Tag> tags;
       //trường quan hệ nối với Tag
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

    public static Page<Product> find(int page) {  // trả về trang thay vì List
        return find.where()
                .orderBy("id asc")     // sắp xếp tăng dần theo id
                .findPagingList(5)    // quy định kích thước của trang
                .setFetchAhead(false)  // có cần lấy tất cả dữ liệu một thể?
                .getPage(page);    // lấy trang hiện tại, bắt đầu từ trang 0
    }

    public static Product findByEan(String ean) {
        return find.where().eq("ean", ean).findUnique();
    }
 /* public static List<Product> findByName(String term) {
    final List<Product> results = new ArrayList<Product>();
    for (Product candidate : products) {
      if (candidate.name.toLowerCase().contains(term.toLowerCase())) {
        results.add(candidate);
      }
    }
    return results;
  }
  
*/

}