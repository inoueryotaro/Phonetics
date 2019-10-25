package com.example.phoneticstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First_screenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button TestButton = findViewById(R.id.button);
        Button PractideButton = findViewById(R.id.button2);
        Button EditButton = findViewById(R.id.button7);

        TestButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), CategoryActivity.class);
                startActivity(intent1);
            }
        });
        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function2();
            }
            private void function2() {
                Intent intent2 = new Intent(getApplication(), EditActivity.class);
                startActivity(intent2);
            }
        });
    }

}
