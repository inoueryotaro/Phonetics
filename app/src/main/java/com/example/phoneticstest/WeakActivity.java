package com.example.phoneticstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeakActivity extends AppCompatActivity {
    private int zenhan_count;
    private int kohan_count;
    private TextView resultingtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak);
        resultingtext = findViewById(R.id.textView14);
        Intent intent = getIntent();
        zenhan_count = intent.getIntExtra("miss_zenhan", 0);
        Intent intent2 = getIntent();
        kohan_count = intent2.getIntExtra("miss_kohan",0);

        if( zenhan_count < 4 && kohan_count < 4){
            resultingtext.setText(R.string.weak_message);
        }
        if( zenhan_count >= 4 || kohan_count >= 4){
            if( kohan_count < 4){
                resultingtext.setText(R.string.weak_message2);
            }
            else if( zenhan_count < 4 ){
                resultingtext.setText(R.string.weak_message3);
            }
            else{
                resultingtext.setText(R.string.weak_message4);
            }

        }

    }
}
