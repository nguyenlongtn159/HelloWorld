package models;

/**
 * Created by nguyenlongtn159 on 3/14/2015.
 */


        import play.data.validation.Constraints;
        import play.db.ebean.Model;

        import javax.persistence.Entity;
        import javax.persistence.Id;

@Entity
public class UserAccount extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String password;


    public UserAccount() { }
    public UserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

  /*  public static Finder<Long, UserAccount> finder =
            new Finder<Long, UserAccount>(Long.class, UserAccount.class);
*/
  public static Finder<Long, UserAccount> finder =
          new Finder<Long, UserAccount>(Long.class, UserAccount.class);

    public static UserAccount authenticate(String email, String password) {
        return finder.where().eq("email", email)
                .eq("password", password).findUnique();
    }
    }
   /*     //should be
        //return finder.where().eq("email", email)
        //        .eq("password", password).findUnique();
        if ("alice@example.com".equals(email) && "alice".equals(password))
            return new UserAccount("alice@example.com", "alice");
        else
            return null; */





