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
//[テストを始める]ボタンをタップしたときの処理
        TestButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                //CategoryActivityへ画面推移
                Intent intent1 = new Intent(getApplication(), CategoryActivity.class);
                startActivity(intent1);
            }
        });
       //[編集する]ボタンをタップしたときの処理
        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function2();
            }
            private void function2() {
                //EditActivityへ画面推移
                Intent intent2 = new Intent(getApplication(), EditActivity.class);
                startActivity(intent2);
            }
        });
        //[苦手発音の学習]ボタンをタップしたときの処理(11/22までに実装完了予定)
        PractideButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){function3();}
            private  void function3(){
                //(仮)PracticeActivityへ画面推移
                Intent intent3 = new Intent(getApplication(),EditActivity.class );
                startActivity(intent3);
            }
        });
    }

}
