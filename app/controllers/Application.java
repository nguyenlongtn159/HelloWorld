package controllers;

<<<<<<< HEAD
import models.UserAccount;

import play.data.Form;
import play.mvc.*;
import static play.data.Form.form;
=======
import play.*;
import play.mvc.*;

>>>>>>> 2a403f63898d878a31c4c6c6d6f8e06463ccd5ed
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

<<<<<<< HEAD


    public static class Login {
        public String email;
        public String password;
    }

    public static Result login() {
        return ok(
                login.render(form(Login.class))
        );
    }

    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        String email = loginForm.get().email;
        String password = loginForm.get().password;
        session().clear();  // dọn dẹp session để chuẩn bị cho các thông tin đăng nhập mớ
        if (UserAccount.authenticate(email, password) == null) {
            flash("error", "Invalid email and/or password");
            return redirect(routes.Application.login());
        }
        session("email", email);

        return redirect(routes.Products.list(0));
    }
=======
>>>>>>> 2a403f63898d878a31c4c6c6d6f8e06463ccd5ed
}
