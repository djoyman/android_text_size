package test.app.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private float currentFontScale;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentFontScale = ((MainApplication)getApplication()).getCurrentFontScale();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (((MainApplication)getApplication()).getCurrentFontScale() != currentFontScale)
            recreate();
    }
}
