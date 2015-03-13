import com.avaje.ebean.Ebean;
import play.*;
import models.*;
import play.libs.Yaml;
import java.util.List;
import java.util.Map;
import play.api.mvc.EssentialFilter;
import play.filters.csrf.CSRFFilter;
public class Global extends GlobalSettings {

    public <T extends EssentialFilter> Class<T>[] filters() {
        return new Class[]{CSRFFilter.class};
    }

    public void onStart(Application app) {
        Logger.info("Application has started");
        InitialData.insert(app);
    }
 
    static class InitialData {
        public static void insert(Application app) {
            if (Ebean.find(Tag.class).findRowCount() == 0) {
                Map<String, List<Object>> all =
                   (Map<String, List <Object>>)Yaml.load("initial-data.yml");
                Ebean.save(all.get("tags"));
            }
        }
    }
   
    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }
}