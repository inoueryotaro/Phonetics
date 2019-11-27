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
        if( cursor.getCount() == 0) {
            if( com.equals("今回のテストで特に苦手な発音と思われるものはありません!!")) {
                if( name.equals("category.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category2.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ɑ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","æ");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category3.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","i");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ɪ");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category4.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʊ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","u");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category5.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","e");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ɪ");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category6.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ɔ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","oʊ");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category7.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","s");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","z");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category8.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category9.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category10.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category11.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category12.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category13.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category14.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category15.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category16.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category17.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category18.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category19.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category20.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category21.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category22.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category23.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else if(name.equals("category24.csv")){
                    ContentValues values = new ContentValues();
                    values.put("company2","ʌ");
                    values.put("stockprice2","0");
                    ContentValues values2 = new ContentValues();
                    values2.put("company2","ə");
                    values2.put("stockprice2","0");
                }
                else{

                }
            ContentValues values = new ContentValues();
            values.put("company2","ə");

            }
            //String price = "";
            ContentValues values = new ContentValues();
            values.put("company2", com);
            //values.put("stockprice2", price);
            db.insert("testdb2", null, values);
        }

        cursor.moveToFirst();
        StringBuilder sbuilder = new StringBuilder();
        StringBuilder sbuilder2 = new StringBuilder();

        if( type_of_mistake == 3 || type_of_mistake == 1 || type_of_mistake == 2 || type_of_mistake == 0){
            for (int i = 0; i < cursor.getCount(); i++) {
                if(  (cursor.getString(0)).equals("")) {
                    sbuilder.append(cursor.getString(0));
                    sbuilder.append(",");
                    sbuilder.append("0");
                    sbuilder.append("\n");
                }
                cursor.moveToNext();
            }
            cursor.close();
         /*   cursor2.moveToFirst();
            for (int i = 0; i < cursor2.getCount(); i++) {
                if ( a < cursor2.getInt(1)) {
                    sbuilder2.append(cursor2.getString(0));
                    //   sbuilder2.append(",");
                    //   sbuilder2.append(cursor.getInt(1));
                    sbuilder2.append("\n");
                }
                cursor2.moveToNext();
            }
            // 忘れずに！
            cursor2.close();*/
            //concrete_tango_text.setText("あなたが発音ミスした単語"+"\n"+sbuilder.toString());
            //concrete_tango_text2.setText("あなたが発音ミスした単語"+"\n"+sbuilder2.toString());
        }

    }

}
