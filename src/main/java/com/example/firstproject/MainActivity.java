package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int prevValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeText();
        exitButton();
    }
    private void  exitButton(){

        Button exitBtn = (Button) findViewById(R.id.button_exit);
        exitBtn.setOnClickListener(view -> {
            finish();
            System.exit(0);
        });
    }
    private void changeText(){
        TextView changeText = (TextView) findViewById(R.id.text_change);
        Button changeButton = (Button) findViewById(R.id.button_change_text);

        changeButton.setOnClickListener(view -> {
            if(changeText.getText().equals(getResources().getString(R.string.change_text))){
                changeText.setText(getResources().getString(R.string.text_to_change));
            }
            else{
                changeText.setText(getResources().getString(R.string.change_text));
            }
        });

    }
}