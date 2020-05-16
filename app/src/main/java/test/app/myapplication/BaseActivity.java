package test.app.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private float currentFontScale;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentFontScale = SettingsState.getInstance().getCurrentFontScale(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (SettingsState.getInstance().getCurrentFontScale(this) != currentFontScale)
            recreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        float currentScale = SettingsState.getInstance().getCurrentFontScale(base);
        super.attachBaseContext(FontUtils.updateFontScaleInContext(base, currentScale));
    }
}
