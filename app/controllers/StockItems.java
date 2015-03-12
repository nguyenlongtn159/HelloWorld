package controllers;
import com.avaje.ebean.Ebean;
import play.mvc.*;
import play.data.*;
import views.html.*;
import java.util.ArrayList;
import java.util.List;
import models.*;
import views.html.products.*;
/**
 * Created by nguyenlongtn159 on 3/13/2015.
 */


     //   import models.StockItem;
        import models.Tag;
        import play.mvc.*;

        import java.util.List;

public class StockItems extends Controller {
    public static Result index() {
        List<StockItem> items = StockItem.find
                .where()
                .ge("quantity", 300)
                .orderBy("quantity")  //bạn dùng orderBy("quantity desc") cho giảm dần, hoặc .orderBy("quantity asc") để xếp tăng dần.
                .setMaxRows(5)
                .setFirstRow(4)      // qdinh diem bát đầu
                        .findList();
        return ok(items.toString());
    }
}