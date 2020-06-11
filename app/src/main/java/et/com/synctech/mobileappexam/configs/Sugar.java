package et.com.synctech.mobileappexam.configs;

import com.orm.SugarApp;
import com.orm.SugarContext;

/**
 * Created by Queen on 6/9/2020.
 */

public class Sugar extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
