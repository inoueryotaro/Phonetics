package com.example.phoneticstest;
//AndroidX

//import android.support.v7.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;

public class WeakActivity extends AppCompatActivity {
    public static final String CATEGORY_MESSAGE =  "com.example.phoneticstest.WeakActivity.MESSAGE";//カテゴリー名を渡す;
    public static final String NIGATE_MESSAGE = "com.example.phoneticstest.WeakActivity.MESSAGE2";
    private int zenhan_count;
    private int kohan_count;
    private TextView resultingtext;
    private int exist_nigate;
    private int type_of_mistake;
    private EditText editTextKey, editTextValue;
    private TestOpenHelper2 helper2;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak);
        type_of_mistake = 0;
        resultingtext = findViewById(R.id.textView14);
        Button ShosaiButton = findViewById(R.id.button8);
        Button BackCategory = findViewById(R.id.button9);
        Intent intent = getIntent();
        zenhan_count = intent.getIntExtra("miss_zenhan", 0);
        Intent intent2 = getIntent();
        kohan_count = intent2.getIntExtra("miss_kohan",0);
        Intent intent3 = getIntent();
        final String category_name = intent3.getStringExtra(FinishscreenActivity.EXTRA_MESSAGE);//ex "category1.csv"

        BackCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(helper2 == null){
                    helper2 = new TestOpenHelper2(getApplicationContext());
                }
                if(db == null){
                    db = helper2.getWritableDatabase();
                }
                function();
            }

            private void function() {
                Intent intent4 = new Intent(getApplication(), CategoryActivity.class);
                String key = resultingtext.getText().toString();
                //String value = String.valueOf(id_number);
                insertData(db, key,category_name);
                if( category_name.equals("category1.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword",1);
                    }
                    else{
                        intent4.putExtra("keyword",2);
                    }
                }
                if( category_name.equals("category2.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword2",1);
                    }
                    else{
                        intent4.putExtra("keyword2",2);
                    }
                }
                if( category_name.equals("category3.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword3",1);
                    }
                    else{
                        intent4.putExtra("keyword3",2);
                    }
                }
                if( category_name.equals("category4.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword4",1);
                    }
                    else{
                        intent4.putExtra("keyword4",2);
                    }
                }
                if( category_name.equals("category5.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword5",1);
                    }
                    else{
                        intent4.putExtra("keyword5",2);
                    }
                }
                if( category_name.equals("category6.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword6",1);
                    }
                    else{
                        intent4.putExtra("keyword6",2);
                    }
                }
                if( category_name.equals("category7.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword7",1);
                    }
                    else{
                        intent4.putExtra("keyword7",2);
                    }
                }
                if( category_name.equals("category8.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword8",1);
                    }
                    else{
                        intent4.putExtra("keyword8",2);
                    }
                }
                if( category_name.equals("category9.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword9",1);
                    }
                    else{
                        intent4.putExtra("keyword9",2);
                    }
                }if( category_name.equals("category10.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword10",1);
                    }
                    else{
                        intent4.putExtra("keyword10",2);
                    }
                }
                if( category_name.equals("category11.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword11",1);
                    }
                    else{
                        intent4.putExtra("keyword11",2);
                    }
                }
                if( category_name.equals("category12.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword12",1);
                    }
                    else{
                        intent4.putExtra("keyword12",2);
                    }
                }
                if( category_name.equals("category13.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword13",1);
                    }
                    else{
                        intent4.putExtra("keyword13",2);
                    }
                }
                if( category_name.equals("category14.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword14",1);
                    }
                    else{
                        intent4.putExtra("keyword14",2);
                    }
                }
                if( category_name.equals("category15.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword15",1);
                    }
                    else{
                        intent4.putExtra("keyword15",2);
                    }
                }
                if( category_name.equals("category16.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword16",1);
                    }
                    else{
                        intent4.putExtra("keyword16",2);
                    }
                }
                if( category_name.equals("category17.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword17",1);
                    }
                    else{
                        intent4.putExtra("keyword17",2);
                    }
                }
                if( category_name.equals("category18.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword18",1);
                    }
                    else{
                        intent4.putExtra("keyword18",2);
                    }
                }if( category_name.equals("category19.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword19",1);
                    }
                    else{
                        intent4.putExtra("keyword19",2);
                    }
                }
                if( category_name.equals("category20.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword20",1);
                    }
                    else{
                        intent4.putExtra("keyword20",2);
                    }
                }
                if( category_name.equals("category21.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword21",1);
                    }
                    else{
                        intent4.putExtra("keyword21",2);
                    }
                }
                if( category_name.equals("category22.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword22",1);
                    }
                    else{
                        intent4.putExtra("keyword22",2);
                    }
                }
                if( category_name.equals("category23.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword23",1);
                    }
                    else{
                        intent4.putExtra("keyword23",2);
                    }
                }
                if( category_name.equals("category24.csv")){
                    if(zenhan_count < 4 && kohan_count < 4 ){
                        intent4.putExtra("keyword24",1);
                    }
                    else{
                        intent4.putExtra("keyword24",2);
                    }
                }
                startActivity(intent4);
            }
        });

        if( zenhan_count < 4 && kohan_count < 4){
            type_of_mistake = 0;
            resultingtext.setText("今回のテストで特に苦手な発音と思われるものはありません!!");
        }
        if( zenhan_count >= 4 || kohan_count >= 4){
            if( zenhan_count >= 4 && kohan_count < 4){
                type_of_mistake = 1;
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
                if( category_name.equals("category6.csv")) {
                    resultingtext.setText("[ɔ]です.");
                }
                if( category_name.equals("category7.csv")) {
                    resultingtext.setText("[s]です.");
                }
                if( category_name.equals("category8.csv")) {
                    resultingtext.setText("[ʃ]です.");
                }
                if( category_name.equals("category9.csv")) {
                    resultingtext.setText("[θ]です.");
                }
                if( category_name.equals("category10.csv")) {
                    resultingtext.setText("[f]です.");
                }
                if( category_name.equals("category11.csv")) {
                    resultingtext.setText("[l]です.");
                }
                if( category_name.equals("category12.csv")) {
                    resultingtext.setText("[t]です.");
                }
                if( category_name.equals("category13.csv")) {
                    resultingtext.setText("[p]です.");
                }
                if( category_name.equals("category14.csv")) {
                    resultingtext.setText("[k]です.");
                }
                if( category_name.equals("category15.csv")) {
                    resultingtext.setText("[tʃ]です.");
                }
                if( category_name.equals("category16.csv")) {
                    resultingtext.setText("[m]です.");
                }
                if( category_name.equals("category17.csv")) {
                    resultingtext.setText("[f]です.");
                }
                if( category_name.equals("category18.csv")) {
                    resultingtext.setText("[w]です.");
                }
                if( category_name.equals("category19.csv")) {
                    resultingtext.setText("[ŋ]です.");
                }
                if( category_name.equals("category20.csv")) {
                    resultingtext.setText("[ɪ]です.");
                }
                if( category_name.equals("category21.csv")) {
                    resultingtext.setText("[aɪ]です.");
                }
                if( category_name.equals("category22.csv")) {
                    resultingtext.setText("[aɪ]です.");
                }
                if( category_name.equals("category23.csv")) {
                    resultingtext.setText("[aʊ]です.");
                }
                if( category_name.equals("category24.csv")) {
                    resultingtext.setText("[ɜr]です.");
                }

            }
            else if( kohan_count >= 4 && zenhan_count < 4 ){
                type_of_mistake = 2;
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
                if( category_name.equals("category6.csv")) {
                    resultingtext.setText("[oʊ]です.");
                }
                if( category_name.equals("category7.csv")) {
                    resultingtext.setText("[z]です.");
                }
                if( category_name.equals("category8.csv")) {
                    resultingtext.setText("[ʒ]です.");
                }
                if( category_name.equals("category9.csv")) {
                    resultingtext.setText("[ð]です.");
                }
                if( category_name.equals("category10.csv")) {
                    resultingtext.setText("[v]です.");
                }
                if( category_name.equals("category11.csv")) {
                    resultingtext.setText("[r]です.");
                }
                if( category_name.equals("category12.csv")) {
                    resultingtext.setText("[d]です.");
                }
                if( category_name.equals("category13.csv")) {
                    resultingtext.setText("[b]です.");
                }
                if( category_name.equals("category14.csv")) {
                    resultingtext.setText("[g]です.");
                }
                if( category_name.equals("category15.csv")) {
                    resultingtext.setText("[dʒ]です.");
                }
                if( category_name.equals("category16.csv")) {
                    resultingtext.setText("[n]です.");
                }
                if( category_name.equals("category17.csv")) {
                    resultingtext.setText("[h]です.");
                }
                if( category_name.equals("category18.csv")) {
                    resultingtext.setText("[v]です.");
                }
                if( category_name.equals("category19.csv")) {
                    resultingtext.setText("[n]です.");
                }
                if( category_name.equals("category20.csv")) {
                    resultingtext.setText("[j]です.");
                }
                if( category_name.equals("category21.csv")) {
                    resultingtext.setText("[eɪ]です.");
                }
                if( category_name.equals("category22.csv")) {
                    resultingtext.setText("[ɔɪ]です.");
                }
                if( category_name.equals("category23.csv")) {
                    resultingtext.setText("[oʊ]です.");
                } if( category_name.equals("category24.csv")) {
                    resultingtext.setText("[r]です.");
                }

            }
            else{
                type_of_mistake = 3;
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
                if( category_name.equals("category6.csv")) {
                    resultingtext.setText("[ɔ][oʊ]の両方です.");
                }
                if( category_name.equals("category7.csv")) {
                    resultingtext.setText("[s][z]の両方です.");
                }
                if( category_name.equals("category8.csv")) {
                    resultingtext.setText("[ʃ][ʒ]の両方です.");
                }
                if( category_name.equals("category9.csv")) {
                    resultingtext.setText("[θ][ð]の両方です.");
                }
                if( category_name.equals("category10.csv")) {
                    resultingtext.setText("[f][v]の両方です.");
                }
                if( category_name.equals("category11.csv")) {
                    resultingtext.setText("[l][r]の両方です.");
                }
                if( category_name.equals("category12.csv")) {
                    resultingtext.setText("[t][d]の両方です.");
                }
                if( category_name.equals("category13.csv")) {
                    resultingtext.setText("[p][b]の両方です.");
                }
                if( category_name.equals("category14.csv")) {
                    resultingtext.setText("[k][g]の両方です.");
                }
                if( category_name.equals("category15.csv")) {
                    resultingtext.setText("[tʃ][dʒ]の両方です.");
                }
                if( category_name.equals("category16.csv")) {
                    resultingtext.setText("[m][n]の両方です.");
                } if( category_name.equals("category17.csv")) {
                    resultingtext.setText("[f][h]の両方です.");
                }
                if( category_name.equals("category18.csv")) {
                    resultingtext.setText("[w][v]の両方です.");
                }
                if( category_name.equals("category19.csv")) {
                    resultingtext.setText("[ŋ][n]の両方です.");
                }
                if( category_name.equals("category20.csv")) {
                    resultingtext.setText("[ɪ][j]の両方です.");
                }
                if( category_name.equals("category21.csv")) {
                    resultingtext.setText("[aɪ][eɪ]の両方です.");
                }
                if( category_name.equals("category22.csv")) {
                    resultingtext.setText("[aɪ][ɔɪ]の両方です.");
                }
                if( category_name.equals("category23.csv")) {
                    resultingtext.setText("[aʊ][oʊ]の両方です.");
                }
                if( category_name.equals("category24.csv")) {
                    resultingtext.setText("[ɜr][r]の両方です.");
                }


            }

        }
            ShosaiButton.setVisibility(View.VISIBLE);
            ShosaiButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(helper2 == null){
                        helper2 = new TestOpenHelper2(getApplicationContext());
                    }
                    if(db == null){
                        db = helper2.getWritableDatabase();
                    }
                    Intent intent3 = new Intent(getApplication(), PracticeActivity.class);
                    String key = resultingtext.getText().toString();
                    //String value = String.valueOf(id_number);
                    insertData(db, key,category_name);
                    intent3.putExtra("miss_zenhan", zenhan_count);
                    intent3.putExtra("miss_kohan", kohan_count);
                    intent3.putExtra("type_mistake", type_of_mistake);
                    intent3.putExtra(CATEGORY_MESSAGE, category_name);
                    startActivity(intent3);
                }
            });

    }
    private void insertData(SQLiteDatabase db, String com,String name){
        int symbols = 0;
        if(com.equals("今回のテストで特に苦手な発音と思われるものはありません!!"))
        {
         symbols = 0;
        }
        else {
            if( name.equals("category.csv")){
                if( type_of_mistake == 1){
                    symbols = 1;
                }
                if (type_of_mistake == 2){
                    symbols = 2;
                }
                if( type_of_mistake == 3){
                    symbols = 3;
                }

            }
            if( name.equals("category2.csv")){
                if( type_of_mistake == 1){
                    symbols = 4;
                }
                if (type_of_mistake == 2){
                    symbols = 5;
                }
                if( type_of_mistake == 3){
                    symbols = 6;
                }

            }
            if( name.equals("category3.csv")){
                if( type_of_mistake == 1){
                    symbols = 7;
                }
                if (type_of_mistake == 2){
                    symbols = 8;
                }
                if( type_of_mistake == 3){
                    symbols = 9;
                }

            }
            if( name.equals("category4.csv")){
                if( type_of_mistake == 1){
                    symbols = 10;
                }
                if (type_of_mistake == 2){
                    symbols = 11;
                }
                if( type_of_mistake == 3){
                    symbols = 12;
                }

            }
            if( name.equals("category5.csv")){
                if( type_of_mistake == 1){
                    symbols = 13;
                }
                if (type_of_mistake == 2){
                    symbols = 14;
                }
                if( type_of_mistake == 3){
                    symbols = 15;
                }

            }
            if( name.equals("category6.csv")){
                if( type_of_mistake == 1){
                    symbols = 16;
                }
                if (type_of_mistake == 2){
                    symbols = 17;
                }
                if( type_of_mistake == 3){
                    symbols = 18;
                }

            }
            if( name.equals("category7.csv")){
                if( type_of_mistake == 1){
                    symbols = 19;
                }
                if (type_of_mistake == 2){
                    symbols = 20;
                }
                if( type_of_mistake == 3){
                    symbols = 21;
                }

            }
            if( name.equals("category8.csv")){
                if( type_of_mistake == 1){
                    symbols = 22;
                }
                if (type_of_mistake == 2){
                    symbols = 23;
                }
                if( type_of_mistake == 3){
                    symbols = 24;
                }

            }
            if( name.equals("category9.csv")){
                if( type_of_mistake == 1){
                    symbols = 25;
                }
                if (type_of_mistake == 2){
                    symbols = 26;
                }
                if( type_of_mistake == 3){
                    symbols = 27;
                }

            }
            if( name.equals("category10.csv")){
                if( type_of_mistake == 1){
                    symbols = 28;
                }
                if (type_of_mistake == 2){
                    symbols = 29;
                }
                if( type_of_mistake == 3){
                    symbols = 30;
                }

            }if( name.equals("category11.csv")){
                if( type_of_mistake == 1){
                    symbols = 31;
                }
                if (type_of_mistake == 2){
                    symbols = 32;
                }
                if( type_of_mistake == 3){
                    symbols = 33;
                }

            }
            if( name.equals("category12.csv")){
                if( type_of_mistake == 1){
                    symbols = 34;
                }
                if (type_of_mistake == 2){
                    symbols = 35;
                }
                if( type_of_mistake == 3){
                    symbols = 36;
                }

            }
            if( name.equals("category13.csv")){
                if( type_of_mistake == 1){
                    symbols = 37;
                }
                if (type_of_mistake == 2){
                    symbols = 38;
                }
                if( type_of_mistake == 3){
                    symbols = 39;
                }

            }
            if( name.equals("category14.csv")){
                if( type_of_mistake == 1){
                    symbols = 40;
                }
                if (type_of_mistake == 2){
                    symbols = 41;
                }
                if( type_of_mistake == 3){
                    symbols = 42;
                }

            }
            if( name.equals("category15.csv")){
                if( type_of_mistake == 1){
                    symbols = 43;
                }
                if (type_of_mistake == 2){
                    symbols = 44;
                }
                if( type_of_mistake == 3){
                    symbols = 45;
                }

            }if( name.equals("category16.csv")){
                if( type_of_mistake == 1){
                    symbols = 46;
                }
                if (type_of_mistake == 2){
                    symbols = 47;
                }
                if( type_of_mistake == 3){
                    symbols = 48;
                }

            }
            if( name.equals("category17.csv")){
                if( type_of_mistake == 1){
                    symbols = 49;
                }
                if (type_of_mistake == 2){
                    symbols = 50;
                }
                if( type_of_mistake == 3){
                    symbols = 51;
                }

            }
            if( name.equals("category18.csv")){
                if( type_of_mistake == 1){
                    symbols = 52;
                }
                if (type_of_mistake == 2){
                    symbols = 53;
                }
                if( type_of_mistake == 3){
                    symbols = 54;
                }

            }
            if( name.equals("category19.csv")){
                if( type_of_mistake == 1){
                    symbols = 55;
                }
                if (type_of_mistake == 2){
                    symbols = 56;
                }
                if( type_of_mistake == 3){
                    symbols = 57;
                }

            }

            if( name.equals("category20.csv")){
                if( type_of_mistake == 1){
                    symbols = 58;
                }
                if (type_of_mistake == 2){
                    symbols = 59;
                }
                if( type_of_mistake == 3){
                    symbols = 60;
                }

            }
            if( name.equals("category21.csv")){
                if( type_of_mistake == 1){
                    symbols = 61;
                }
                if (type_of_mistake == 2){
                    symbols = 62;
                }
                if( type_of_mistake == 3){
                    symbols = 63;
                }

            }
            if( name.equals("category22.csv")){
                if( type_of_mistake == 1){
                    symbols = 64;
                }
                if (type_of_mistake == 2){
                    symbols = 65;
                }
                if( type_of_mistake == 3){
                    symbols = 66;
                }

            }
            if( name.equals("category23.csv")){
                if( type_of_mistake == 1){
                    symbols = 67;
                }
                if (type_of_mistake == 2){
                    symbols = 68;
                }
                if( type_of_mistake == 3){
                    symbols = 69;
                }

            }
            if( name.equals("category24.csv")){
                if( type_of_mistake == 1){
                    symbols = 70;
                }
                if (type_of_mistake == 2){
                    symbols = 71;
                }
                if( type_of_mistake == 3){
                    symbols = 72;
                }

            }
        }
        Cursor cursor = db.query(
                "testdb2",
                new String[] { "company2", "stockprice2" },
                null,
                null,
                null,
                null,
                null
        );
        Cursor cursor2 = db.query(
                "testdb2",
                new String[] { "company2", "stockprice2" },
                null,
                null,
                null,
                null,
                null
        );
        Cursor cursor3 = db.query(
                "testdb2",
                new String[] { "company2", "stockprice2" },
                null,
                null,
                null,
                null,
                null
        );
        if( cursor.getCount() == 0) {
            ContentValues values = new ContentValues();
            ContentValues values2 = new ContentValues();
            ContentValues values3 = new ContentValues();
            ContentValues values4 = new ContentValues();
            ContentValues values5 = new ContentValues();
            ContentValues values6 = new ContentValues();
            ContentValues values7 = new ContentValues();
            ContentValues values8 = new ContentValues();
            ContentValues values9 = new ContentValues();
            ContentValues values10 = new ContentValues();
            ContentValues values11 = new ContentValues();
            ContentValues values12 = new ContentValues();
            ContentValues values13 = new ContentValues();
            ContentValues values14 = new ContentValues();
            ContentValues values15 = new ContentValues();
            ContentValues values16 = new ContentValues();
            ContentValues values17 = new ContentValues();
            ContentValues values18 = new ContentValues();
            ContentValues values19 = new ContentValues();
            ContentValues values20= new ContentValues();
            ContentValues values21 = new ContentValues();
            ContentValues values22 = new ContentValues();
            ContentValues values23 = new ContentValues();
            ContentValues values24 = new ContentValues();
            ContentValues values25 = new ContentValues();
            ContentValues values26 = new ContentValues();
            ContentValues values27 = new ContentValues();
            ContentValues values28 = new ContentValues();
            ContentValues values29 = new ContentValues();
            ContentValues values30 = new ContentValues();
            ContentValues values31 = new ContentValues();
            ContentValues values32 = new ContentValues();
            ContentValues values33 = new ContentValues();
            ContentValues values34 = new ContentValues();
            ContentValues values35 = new ContentValues();
            ContentValues values36 = new ContentValues();
            ContentValues values37 = new ContentValues();
            ContentValues values38 = new ContentValues();
            ContentValues values39 = new ContentValues();
            ContentValues values40 = new ContentValues();
            ContentValues values41 = new ContentValues();
            ContentValues values42 = new ContentValues();
            ContentValues values43 = new ContentValues();
            ContentValues values44 = new ContentValues();
            ContentValues values45 = new ContentValues();
            ContentValues values46 = new ContentValues();
            ContentValues values47 = new ContentValues();
            ContentValues values48 = new ContentValues();

                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                    values3.put("company2","ɑ");
                    values3.put("stockprice2","0");
                    values4.put("company2","æ");
                    values4.put("stockprice2","0");
                    values5.put("company2","i");
                    values5.put("stockprice2","0");
                    values6.put("company2","ɪ");
                    values6.put("stockprice2","0");
                    values7.put("company2","ʊ");
                    values7.put("stockprice2","0");
                    values8.put("company2","u");
                    values8.put("stockprice2","0");
                    values9.put("company2","e");
                    values9.put("stockprice2","0");
                    //values10.put("company2","ɪ");
                    //values10.put("stockprice2","0");
                    values11.put("company2","ɔ");
                    values11.put("stockprice2","0");
                    values12.put("company2","oʊ");
                    values12.put("stockprice2","0");
                    values13.put("company2","s");
                    values13.put("stockprice2","0");
                    values14.put("company2","z");
                    values14.put("stockprice2","0");
                    values15.put("company2","ʃ");
                    values15.put("stockprice2","0");
                    values16.put("company2","ʒ");
                    values16.put("stockprice2","0");
                    values17.put("company2","θ");
                    values17.put("stockprice2","0");
                    values18.put("company2","ð");
                    values18.put("stockprice2","0");
                    values19.put("company2","f");
                    values19.put("stockprice2","0");
                    values20.put("company2","v");
                    values20.put("stockprice2","0");
                    values21.put("company2","l");
                    values21.put("stockprice2","0");
                    values22.put("company2","r");
                    values22.put("stockprice2","0");
                    values23.put("company2","t");
                    values23.put("stockprice2","0");
                    values24.put("company2","d");
                    values24.put("stockprice2","0");
                    values25.put("company2","p");
                    values25.put("stockprice2","0");
                    values26.put("company2","b");
                    values26.put("stockprice2","0");
                    values27.put("company2","k");
                    values27.put("stockprice2","0");
                    values28.put("company2","g");
                    values28.put("stockprice2","0");
                    values29.put("company2","tʃ");
                    values29.put("stockprice2","0");
                    values30.put("company2","dʒ");
                    values30.put("stockprice2","0");
                    values31.put("company2","m");
                    values31.put("stockprice2","0");
                    values32.put("company2","n");
                    values32.put("stockprice2","0");
                    //values33.put("company2","f");
                    //values33.put("stockprice2","0");
                    values34.put("company2","h");
                    values34.put("stockprice2","0");
                    values35.put("company2","w");
                    values35.put("stockprice2","0");
                    //values36.put("company2","v");
                    //values36.put("stockprice2","0");
                    values37.put("company2","ŋ");
                    values37.put("stockprice2","0");
                    //values38.put("company2","n");
                    //values38.put("stockprice2","0");
                   // values39.put("company2","ɪ");
                   // values39.put("stockprice2","0");
                    values40.put("company2","j");
                    values40.put("stockprice2","0");
                    values41.put("company2","aɪ");
                    values41.put("stockprice2","0");
                    values42.put("company2","eɪ");
                    values42.put("stockprice2","0");
                   // values43.put("company2","aɪ");
                   // values43.put("stockprice2","0");
                    values44.put("company2","ɔɪ");
                    values44.put("stockprice2","0");
                    values45.put("company2","aʊ");
                    values45.put("stockprice2","0");
                   // values46.put("company2","oʊ");
                   // values46.put("stockprice2","0");
                    values47.put("company2","ɜr");
                    values47.put("stockprice2","0");
                    //values48.put("company2","r");
                    //values48.put("stockprice2","0");
            db.insert("testdb2", null, values);
            db.insert("testdb2",null,values2);
            db.insert("testdb2",null,values3);
            db.insert("testdb2",null,values4);
            db.insert("testdb2",null,values5);
            db.insert("testdb2",null,values6);
            db.insert("testdb2",null,values7);
            db.insert("testdb2",null,values8);
            db.insert("testdb2",null,values9);
            db.insert("testdb2",null,values10);
            db.insert("testdb2",null,values11);
            db.insert("testdb2",null,values12);
            db.insert("testdb2",null,values13);
            db.insert("testdb2",null,values14);
            db.insert("testdb2",null,values15);
            db.insert("testdb2",null,values16);
            db.insert("testdb2",null,values17);
            db.insert("testdb2",null,values18);
            db.insert("testdb2",null,values19);
            db.insert("testdb2",null,values20);
            db.insert("testdb2",null,values21);
            db.insert("testdb2",null,values22);
            db.insert("testdb2",null,values23);
            db.insert("testdb2",null,values24);
            db.insert("testdb2",null,values25);
            db.insert("testdb2",null,values26);
            db.insert("testdb2",null,values27);
            db.insert("testdb2",null,values28);
            db.insert("testdb2",null,values29);
            db.insert("testdb2",null,values30);
            db.insert("testdb2",null,values31);
            db.insert("testdb2",null,values32);
            db.insert("testdb2",null,values33);
            db.insert("testdb2",null,values34);
            db.insert("testdb2",null,values35);
            db.insert("testdb2",null,values36);
            db.insert("testdb2",null,values37);
            db.insert("testdb2",null,values38);
            db.insert("testdb2",null,values39);
            db.insert("testdb2",null,values40);
            db.insert("testdb2",null,values41);
            db.insert("testdb2",null,values42);
            db.insert("testdb2",null,values43);
            db.insert("testdb2",null,values44);
            db.insert("testdb2",null,values45);
            db.insert("testdb2",null,values46);
            db.insert("testdb2",null,values47);
            db.insert("testdb2",null,values48);
        }
        cursor.close();
        if( symbols >= 1 ){
            if( symbols == 1){
                ContentValues val = new ContentValues();
                val.put("stockprice2","1");
                db.update("testdb2",val,"id=1",null);
            }
            if( symbols == 2){

            }
            if( symbols == 3){

            }
            if( symbols == 4){

            }
            if( symbols == 5){

            }
            if( symbols == 6){

            }
            if( symbols == 7){

            }
            if( symbols == 8){

            }
            if( symbols == 9){

            }
            if( symbols == 10){

            }
            if( symbols == 11){

            }
            if( symbols == 12){

            }
            if( symbols == 13){

            }
            if( symbols == 14){

            } if( symbols == 15){

            }
            if( symbols == 16){

            }
            if( symbols == 17){

            }
            if( symbols == 18){

            }
            if( symbols == 19){

            }
            if( symbols == 20){

            } if( symbols == 21){

            }
            if( symbols == 22){

            }
            if( symbols == 23){

            }
            if( symbols == 24){

            }
            if( symbols == 25){

            }
            if( symbols == 26){

            }
            if( symbols == 27){

            }
            if( symbols == 28){

            } if( symbols == 29){

            } if( symbols == 30){

            } if( symbols == 31){

            } if( symbols == 32){

            } if( symbols == 33){

            } if( symbols == 34){

            } if( symbols == 35){

            } if( symbols == 36){

            } if( symbols == 37){

            } if( symbols == 38){

            }
            if( symbols == 39){

            } if( symbols == 40){

            }
            if( symbols == 41){

            } if( symbols == 42){

            }
            if( symbols == 43){

            }
            if( symbols == 44){

            }
            if( symbols == 45){

            }
            if( symbols == 46){

            }
            if( symbols == 47){

            }
            if( symbols == 48){

            }
            if( symbols == 49){

            }
            if( symbols == 50){

            }
            if( symbols == 51){

            }
            if( symbols == 52){

            }
            if( symbols == 53){

            }
            if( symbols == 54){

            }if( symbols == 55){

            }if( symbols == 56){

            }if( symbols == 57){

            }if( symbols == 58){

            }if( symbols == 59){

            }if( symbols == 60){

            }if( symbols == 61){

            }if( symbols == 62){

            }if( symbols == 63){

            }if( symbols == 64){

            }if( symbols == 65){

            }if( symbols == 66){

            }if( symbols == 67){

            }if( symbols == 68){

            }
            if( symbols == 69){

            }
            if( symbols == 70){

            }
            if( symbols == 71){

            }
            if( symbols == 72){

            }
        }
     }

}




