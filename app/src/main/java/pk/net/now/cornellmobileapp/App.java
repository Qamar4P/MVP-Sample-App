package pk.net.now.cornellmobileapp;

import android.app.Application;

import pk.net.now.cornellmobileapp.data.PrefsHelper;

/**
 * Created by Qamar on 9/4/2017.
 */

public class App extends Application {
    public static App instance;
    private PrefsHelper prefs;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        prefs = new PrefsHelper(instance);

    }

    public static PrefsHelper prefs(){
        return instance.prefs;
    }
}
