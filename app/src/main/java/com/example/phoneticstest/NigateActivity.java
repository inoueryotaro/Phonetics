package com.example.phoneticstest;

import android.app.MediaRouteButton;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NigateActivity extends AppCompatActivity {
    private TestOpenHelper2 helper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nigate);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setVisibility(View.GONE);
        int a = readData();
        if( a == 1){
            btn1.setVisibility(View.VISIBLE);
        }
    }
    private int readData(){
        if(helper == null){
            helper = new TestOpenHelper2(getApplicationContext());
        }
        if(db == null){
            db = helper.getReadableDatabase();
        }
        Log.d("debug","**********Cursor");
        Cursor cursor = db.query(
                "testdb2",
                new String[] { "company2", "stockprice2" },
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
                   for (int i = 0; i < cursor.getCount(); i++) {
                if( (cursor.getString(0)).equals("ʌ")) {
                    return 1;
                }
                cursor.moveToNext();
            }
            cursor.close();
                   return 0;
    }
}
