package com.samarthgupta.firstandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Handler;

public class FirstActivity extends AppCompatActivity {

    EditText et1;
    Button b1;
    TextView tv1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        b1 = (Button) findViewById(R.id.button2);
        et1 = (EditText) findViewById(R.id.editText1);
        tv1 = (TextView) findViewById(R.id.textView);
        tv1.setText("Decide for me");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rotate();
                tv1.setText("Using complex algorithms...");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Random random = new Random();
                        int i = random.nextInt(4 - 0);
                        Log.i("Teg", " " + i);
                        switch (i) {
                            case 0:
                                tv1.setText("Do it!");
                                break;
                            case 1:
                                tv1.setText("Not at all");
                                break;
                            case 2:
                                tv1.setText("Maybe later");
                                break;
                            case 3:
                                tv1.setText("Can be done");
                                break;
                        }

                    }
                },5000);



            }
        });



       /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotate();
            }
        }); */
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void rotate() {
        ImageView iv1 = (ImageView) findViewById(R.id.imageView2);
        Animation rotAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
        iv1.startAnimation(rotAnim);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("First Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
