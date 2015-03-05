package controllers;
import play.mvc.*;
import play.data.*;
import views.html.*;
 import java.util.ArrayList;
import java.util.List;
import models.Product;
import views.html.products.*;
import play.data.validation.Constraints; // kiem tra loi ko dien
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
	
	// kiem tra xem co loi hay khong
	public static Result save() {
  Form<Product> boundForm = productForm.bindFromRequest();
  if (boundForm.hasErrors()) {
    flash("error", "Please correct the form below.");
    return badRequest(details.render(boundForm));
  }
  Product product = boundForm.get();
  product.save();
  flash("success", String.format("Successfully added product %s", product));
  return redirect(routes.Products.list());
}
 
		
	}
