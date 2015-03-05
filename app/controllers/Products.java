package controllers;
import play.mvc.*;
import views.html.*;
 import java.util.ArrayList;
import java.util.List;
import models.Product;
import views.html.products.list;
// import thư mục liên quan
// import play.mvc.*;
//import views.html.*;
 //import java.util.ArrayList;
//import java.util.List;
//import models.Product;
//  import views.html.products.list;
public class Products extends Controller {

	 public static Result list() {
    List<Product> products = Product.findAll();
    return ok(list.render(products));
  }
	
		public static Result newProduct() {
		return ok();
	}
		public static Result details( String ean) {
		return ok();
	}
		public static Result save() {
		return ok();
	}
	
		
	}
