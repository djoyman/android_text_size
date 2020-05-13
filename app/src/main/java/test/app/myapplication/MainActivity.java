package test.app.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1_Click(View V) {
        Intent intent = new Intent(MainActivity.this, NewWindow.class);
        startActivity(intent);
    }

    public void btn2_Click(View V) {
        Intent intent = new Intent(MainActivity.this, SettingsWindow.class);
        startActivity(intent);
    }
}
