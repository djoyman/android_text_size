package test.app.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

class SettingsState {
    public static SettingsState getInstance() {
        if (instance == null)
            instance = new SettingsState();
        return instance;
    }
    private static SettingsState instance;

    private static final String APP_PREFERENCES = "settings";
    private static final String APP_PREFERENCES_FONT_SCALE = "settings_font_scale";
    private static final float DefaultFontScale = 1;

    private boolean ready;
    private float currentFontScale;

    private SettingsState() {
    }
    private void Read(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        currentFontScale = sharedPref.getFloat(APP_PREFERENCES_FONT_SCALE, DefaultFontScale);
        ready = true;
    }
    public float getCurrentFontScale(Context context) {
        if (!ready)
            Read(context);
        return currentFontScale;
    }
    public void setCurrentFontScale(Context context, float value) {
        if (!ready)
            Read(context);
        if (currentFontScale != value) {
            currentFontScale = value;
            SharedPreferences sharedPref = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putFloat(APP_PREFERENCES_FONT_SCALE, value);
            editor.apply();
        }
    }
}

class FontUtils {
    public static Context updateFontScaleInContext(Context context, float scale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.fontScale = scale;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            return context.createConfigurationContext(configuration);

        //noinspection deprecation
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
    public static int convertSpToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}
