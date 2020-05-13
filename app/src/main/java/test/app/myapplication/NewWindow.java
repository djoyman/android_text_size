package test.app.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class NewWindow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_window);


        TextView textwithhtml = (TextView) findViewById(R.id.textView2);
        textwithhtml.setText(Html.fromHtml("текст с штмл тегами<br>" +
                "<b>bold</b><br>" +
                "<i>italy</i><br>" +
                "1<sup><small><small>sup small small</small></small></sup><br>" +
                "2<sub><small><small>sub small small</small></small></sub><br>"));

    }
}
