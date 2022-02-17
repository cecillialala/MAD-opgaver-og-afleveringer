package com.example.l2clickerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 /* READ_ME:
    OnCreate() is our lifecyle method
    SO! The reason it resets when rotating is because of the lifecycle
    so onCreate() gets called again when rotating
    so the private int count = 0; is cleared.
    The goal is now to save that state, and we use that through
    savedInstanceState and write an if statement.
    For this statement we getInt with a key. Right click the key
    Refactor -> Introduce constant and enter.
    This results in the public static final string at the top
        public static final String KEY_COUNT = "KEY_COUNT";
    After this we just need to save the state. For this we use
        onSaveInstanceState

    NOTE: We are tied to the bundle instance so for larger scale stuff we need
    a viewModel.

    Logd is so we can watch the lifecycle.
    */

public class MainActivity extends AppCompatActivity {

    //android studio has added this constant
    public static final String KEY_COUNT = "KEY_COUNT";
    private static final String TAG = "MainActivity"; //Logt
    //UI Widgets
  private TextView txtCount;
   private Button btnCountUp;

    //app state (of the activity)
   private int count = 0;

   //Life cycle methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: I LIVE!"); //logd

        if(savedInstanceState!= null){
        count = savedInstanceState.getInt(KEY_COUNT);
        }

        txtCount = findViewById(R.id.txtCount);
        btnCountUp = findViewById(R.id.btnCountUp);
        btnCountUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                updateUI();
            }
        });
        //If we don't call updateUI() here it will still show default text
        updateUI();
    }
    /*
   We saved KEY_COUNT as a const and so we can find it here
   for outState.putInt we need a String key and an int value.
   We have both.
   This will now be called in the process of the activity being shut down and will
   save the count (instance state) in the outState bundle.
   Then when the activity gets restarted after rotation it will be
   parsed into the
         protected void onCreate(Bundle savedInstanceState)
   savedInstanceState and so we retrive the count value.
    */

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_COUNT, count);
        super.onSaveInstanceState(outState);
    }
    /*
    Instead of setting to a string like this
     txtCount.setText(Integer.toString(counter));
    By setting "" + count it does it itself instead of casting the integer
    */

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: I START!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: I RESUME!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: I PAUSED!");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: I STOPPED!");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: I DED!");
        super.onDestroy();
    }

    private void updateUI(){
        txtCount.setText("" + count);
    }
}

/*
2022-02-17 15:00:21.952 6578-6578/com.example.l2clickerapp D/MainActivity: onCreate: I LIVE!
2022-02-17 15:00:21.956 6578-6578/com.example.l2clickerapp D/MainActivity: onStart: I START!
2022-02-17 15:00:21.957 6578-6578/com.example.l2clickerapp D/MainActivity: onResume: I RESUME!
(Rotate)
2022-02-17 15:01:34.549 6578-6578/com.example.l2clickerapp D/MainActivity: onPause: I PAUSED!
2022-02-17 15:01:34.555 6578-6578/com.example.l2clickerapp D/MainActivity: onStop: I STOPPED!
2022-02-17 15:01:34.561 6578-6578/com.example.l2clickerapp D/MainActivity: onDestroy: I DED!
2022-02-17 15:01:34.683 6578-6578/com.example.l2clickerapp D/MainActivity: onCreate: I LIVE!
2022-02-17 15:01:34.693 6578-6578/com.example.l2clickerapp D/MainActivity: onStart: I START!
2022-02-17 15:01:34.695 6578-6578/com.example.l2clickerapp D/MainActivity: onResume: I RESUME!
*/