package com.example.madlab201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//Import log
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle","onCreate( ) is called ");
    }
    @Override
    protected void onStart(){
      super.onStart();
        Log.d("Lifecycle","onStart( ) is called ");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Lifecycle","onPause( ) is called ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume () called ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop( ) called ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart( ) called ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy( ) called ");

    }
}