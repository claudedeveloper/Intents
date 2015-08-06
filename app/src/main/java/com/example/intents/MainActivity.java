package com.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;


public class MainActivity extends ActionBarActivity {

    String LOGTAG = "Intents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/test.pdf");
        File file2 = new File(Environment.getExternalStorageDirectory().getPath()+"test");
        File file3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/test.pdf");
        File file4 = new File(Environment.getExternalStorageDirectory().getParentFile() +"/test.pdf");

//        displayText(this, R.id.textView, String.valueOf(file));
        displayText(this, R.id.textView2, String.valueOf(file2));
        displayText(this, R.id.textView3, String.valueOf(file3));
        displayText(this, R.id.textView4, String.valueOf(file4));

    }

    public void openPDF(View view) {

        File file = new File("/storage/sdcard1/test.pdf");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),"application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        Log.i(LOGTAG, String.valueOf(file));
        displayText(this, R.id.textView, String.valueOf(file));
    }

    public static void displayText(Activity activity, int id, String text) {
        TextView tv = (TextView) activity.findViewById(id);
        tv.setText(text);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
