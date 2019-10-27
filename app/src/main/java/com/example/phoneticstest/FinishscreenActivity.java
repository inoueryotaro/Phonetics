package com.example.phoneticstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishscreenActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private Button resultbutton;
    public static final String EXTRA_MESSAGE
            = "com.example.phoneticstest.FinishscreenActivity.MESSAGE";//カテゴリー名
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishscreen);
      //  textView = findViewById(R.id.textView11);
     //   textView2 = findViewById(R.id.textView12);
        resultbutton = findViewById(R.id.button6);
        Intent intent1 = getIntent(); //前半ブロックの失敗回数
        final int miss_count = intent1.getIntExtra("miss_phonetics_symbols", 0);
        Intent intent2 = getIntent();
        final int miss_count2 = intent2.getIntExtra("miss_phonetics_symbols2",0);
        Intent intent3 = getIntent();
        final String category_name = intent3.getStringExtra(ResultActivity.EXTRA_MESSAGE);//ex "category1.csv"
        resultbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                speech();
            }

            private void speech() {
                Intent intent = new Intent(getApplication(), WeakActivity.class);
                intent.putExtra("miss_zenhan",miss_count);
                intent.putExtra("miss_kohan",miss_count2);
                intent.putExtra(EXTRA_MESSAGE,category_name);
                startActivity(intent);
            }
        });

      //  textView.setText(String.valueOf(miss_count));
      //  textView2.setText(String.valueOf(miss_count2));
    }
}
