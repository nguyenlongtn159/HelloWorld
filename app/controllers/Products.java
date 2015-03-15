package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Page;

import java.util.ArrayList;
import java.util.List;

import models.Product;
import models.StockItem;
import models.Tag;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Security;
import views.html.products.list;
import views.html.products.details;
import play.mvc.Result;
// kiem tra loi ko dien


//import javax.xml.transform.Result;

// import thư mục liên quan
// import play.mvc.*;
//import views.html.*;
 //import java.util.ArrayList;
//import java.util.List;
//import models.Product;
//  import views.html.products.list;
@Security.Authenticated(Secured.class) //kiem tra thuoc tinh email cua nguoi dung hien tai
public class Products extends Controller {
public static final Form<Product> productForm = Form.form(Product.class);
    //tren la pravate


    public static Result list(Integer page) {
        Page<Product> products = Product.find(page);
        return ok(views.html.catalog.render(products));
    }
// productForm = productForm.fill(product);
	
	public static Result newProduct(){
  return ok(details.render(productForm));
}
	 public static Result details(Product product) {
 //  final Product product = Product.findByEan(product.ean);
    if (product == null) {
      return notFound(String.format("Product %s does not exist.", product.ean));
    }
    Form<Product> filledForm = productForm.fill(product);
    return ok(details.render(filledForm));
  }
  public static Result delete(Product product) {
 // final Product product = Product.findByEan(product);
  if(product == null) {
    return notFound(String.format("Product %s does not exists.", product.ean));
  }
      for (StockItem stockItem : product.stockItems) {
          stockItem.delete();
      }
      product.delete();
      return redirect(routes.Products.list(0));
}
	// kiem tra xem co loi hay khong
	public static Result save() {
        Form<Product> boundForm = productForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            flash("error", "Please correct the form below.");
            return badRequest(details.render(boundForm));
        }
        Product product = boundForm.get();
  //  Ebean.save(product);
    List<Tag> tags = new ArrayList<Tag>();
    for (Tag tag : product.tags) {
      if (tag.id != null) {
        tags.add(Tag.findById(tag.id));
      }
    }
        StockItem stockItem = new StockItem();
        stockItem.product = product;
        stockItem.quantity = 0L;

    product.tags = tags;
        if (product.id == null) {
        product.save();
        } else {
            product.update();
        }
        stockItem.save();
  

  flash("success", String.format("Successfully added product %s", product));
  return redirect(routes.Products.list(0));
}
 
 
		
	}
