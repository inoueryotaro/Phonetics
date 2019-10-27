package com.example.phoneticstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;

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
        Intent intent3 = getIntent();
        String category_name = intent3.getStringExtra(FinishscreenActivity.EXTRA_MESSAGE);//ex "category1.csv"

        if( zenhan_count < 4 && kohan_count < 4){
            resultingtext.setText(R.string.weak_message);
        }
        if( zenhan_count >= 4 || kohan_count >= 4){
            if( zenhan_count >= 4){
                if( category_name.equals("category1.csv")) {
                    resultingtext.setText(R.string.weak_message2);
                }
                if( category_name.equals("category2.csv")) {
                    resultingtext.setText("[ɑ]です.");
                }
                if( category_name.equals("category3.csv")) {
                    resultingtext.setText("[i]です.");
                } if( category_name.equals("category4.csv")) {
                    resultingtext.setText("[ʊ]です.");
                } if( category_name.equals("category5.csv")) {
                    resultingtext.setText("[e]です.");
                }
            }
            else if( kohan_count >=  4 ){
                if( category_name.equals("category1.csv")) {
                    resultingtext.setText(R.string.weak_message3);
                }
                if( category_name.equals("category2.csv")) {
                    resultingtext.setText("[æ]です.");
                }
                if( category_name.equals("category3.csv")) {
                    resultingtext.setText("[ɪ]です.");
                }
                if( category_name.equals("category4.csv")) {
                    resultingtext.setText("[u]です.");
                }
                if( category_name.equals("category5.csv")) {
                    resultingtext.setText("[ɪ]です.");
                }

            }
            else{
                if( category_name.equals("category1.csv")) {
                    resultingtext.setText(R.string.weak_message4);
                }
                if( category_name.equals("category2.csv")) {
                    resultingtext.setText("[ɑ][æ]の両方です.");
                }
                if( category_name.equals("category3.csv")) {
                    resultingtext.setText("[i][ɪ]の両方です.");
                }
                if( category_name.equals("category4.csv")) {
                    resultingtext.setText("[ʊ][u]の両方です.");
                }
                if( category_name.equals("category5.csv")) {
                    resultingtext.setText("[e][ɪ]の両方です.");
                }
            }

        }

    }
}
