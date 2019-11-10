package com.example.phoneticstest;
//AndroidX

//import android.support.v7.app.AppCompatActivity;
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
    private TextView nigate_word_text;
    private EditText editTextKey, editTextValue;
    private TestOpenHelper helper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak);
        exist_nigate = 1;
        type_of_mistake = 0;
        resultingtext = findViewById(R.id.textView14);
        nigate_word_text = findViewById(R.id.textView12);
        Button ShosaiButton = findViewById(R.id.button8);
        Button BackCategory = findViewById(R.id.button9);
        Intent intent = getIntent();
        zenhan_count = intent.getIntExtra("miss_zenhan", 0);
        Intent intent2 = getIntent();
        kohan_count = intent2.getIntExtra("miss_kohan",0);
        Intent intent3 = getIntent();
        final String category_name = intent3.getStringExtra(FinishscreenActivity.EXTRA_MESSAGE);//ex "category1.csv"

        BackCategory.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent4 = new Intent(getApplication(), CategoryActivity.class);
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
            resultingtext.setText(R.string.weak_message);
            exist_nigate = 0;
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
        if( exist_nigate == 1) {
            ShosaiButton.setVisibility(View.VISIBLE);
            ShosaiButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    readData();
                    String text = nigate_word_text.getText().toString();
                    Intent intent3 = new Intent(getApplication(), PracticeActivity.class);
                    intent3.putExtra("miss_zenhan", zenhan_count);
                    intent3.putExtra("miss_kohan", kohan_count);
                    intent3.putExtra("type_mistake", type_of_mistake);
                    intent3.putExtra(CATEGORY_MESSAGE, category_name);
                    intent3.putExtra(NIGATE_MESSAGE,text);
                    startActivity(intent3);
                }
            });
        }

        else if( exist_nigate == 0){
            ShosaiButton.setVisibility(View.GONE);
        }
        else{

        }
    }
    private void readData(){
        if(helper == null){
            helper = new TestOpenHelper(getApplicationContext());
        }
        if(db == null){
            db = helper.getReadableDatabase();
        }
        Log.d("debug","**********Cursor");
        Cursor cursor = db.query(
                "testdb",
                new String[] { "company" },
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < cursor.getCount(); i++) {
            sbuilder.append(cursor.getString(0));
            sbuilder.append("\n");
            cursor.moveToNext();
        }
        // 忘れずに！
        cursor.close();
        Log.d("debug","**********"+sbuilder.toString());
        nigate_word_text.setText(sbuilder.toString());
    }

}
