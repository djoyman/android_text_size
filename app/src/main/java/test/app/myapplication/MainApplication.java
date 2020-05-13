package test.app.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

public class MainApplication extends Application {
    private static final String APP_PREFERENCES = "settings";
    private static final String APP_PREFERENCES_FONT_SCALE = "settings_font_scale";

    private static final float DefaultFontScale = 1;

    private float currentFontScale;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sharedPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        currentFontScale = sharedPref.getFloat(APP_PREFERENCES_FONT_SCALE, DefaultFontScale);
        updateFontScale();
    }
    private void updateFontScale() {
        Resources res = getResources();
        Configuration configuration = new Configuration(res.getConfiguration());
        configuration.fontScale = currentFontScale;
        res.updateConfiguration(configuration, res.getDisplayMetrics());
    }
    public float getCurrentFontScale() {
        return currentFontScale;
    }
    public void setCurrentFontScale(float value) {
        if (currentFontScale != value) {
            currentFontScale = value;
            SharedPreferences sharedPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putFloat(APP_PREFERENCES_FONT_SCALE, value);
            editor.apply();

            updateFontScale();
        }
    }
}
