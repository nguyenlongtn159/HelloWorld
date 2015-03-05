package controllers;
import play.mvc.*;
import play.data.*;
import views.html.*;
 import java.util.ArrayList;
import java.util.List;
import models.Product;
import views.html.products.*;
// import thư mục liên quan
// import play.mvc.*;
//import views.html.*;
 //import java.util.ArrayList;
//import java.util.List;
//import models.Product;
//  import views.html.products.list;
public class Products extends Controller {
private static final Form<Product> productForm = Form.form(Product.class);
	 public static Result list() {
    List<Product> products = Product.findAll();
    return ok(list.render(products));
  }
	
	public static Result newProduct(){
  return ok(details.render(productForm));
}
		public static Result details( String ean) {
		return ok();
	}
	public static Result save() {
    Form<Product> boundForm = productForm.bindFromRequest();
    Product product = boundForm.get();
    product.save();
    return ok(String.format("Saved product %s", product));
  }
	
		
	}
