package test.app.myapplication;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsWindow extends BaseActivity {
    private static final float MinScale = 0.5f;
    private static final float MaxScale = 3;
    private static final float ScaleStep = 0.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_window);

        final TextView exampleText = findViewById(R.id.text_font_scale_example);
        final float currentExampleTextSize = exampleText.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
        SeekBar seekBar = findViewById(R.id.seek_bar_font_scale);
        final MainApplication application = (MainApplication) getApplication();
        int max = (int)((MaxScale - MinScale) / ScaleStep) + 1;
        int progress = (int)((application.getCurrentFontScale() - MinScale) / ScaleStep);
        seekBar.setMax(max);
        seekBar.setProgress(progress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float newScale = progress * ScaleStep + MinScale;
                application.setCurrentFontScale(newScale);
                exampleText.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentExampleTextSize);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
