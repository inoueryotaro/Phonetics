package com.example.phoneticstest;

//AndroidX
//import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer=null;
    private TextView textView;
    private EditText editTextKey, editTextValue;
    private TestOpenHelper helper;
    private SQLiteDatabase db;
    private int mTransitionCount;
    private int mmiss_phonetics_symbols;
    private int mmiss_phonetics_symbols2;
    private int id_number;
  //  private int msumnumber=0;
  //  private int tensu=0;
    public static final String EXTRA_MESSAGE
            = "com.example.phoneticstest.ResultActivity.MESSAGE";//カテゴリー名
    private String category;
    private  int[] id_shuffle_array = new int[10];
    private  int[] id_shuffle_array2 = new int[10];
  /*

        textView = findViewById(R.id.text_view);
        Button readButton = findViewById(R.id.button_read);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
                //deleteDatabase("TestDB.db");
            }
        });
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
        textView.setText(sbuilder.toString());
    }
}*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //認識単語の発音記号text
        TextView textview2 = findViewById(R.id.textView2);
        //出題単語の発音記号text
        TextView textview4 = findViewById(R.id.textView4);
        //出題単語text
        final TextView textview5 = findViewById(R.id.textView5);
        //認識単語text
        TextView textview6 = findViewById(R.id.textView6);
        //合否判定のtext
        TextView textview7 = findViewById(R.id.textView7);
        //点数表示のtext
        TextView textview16 = findViewById(R.id.textView16);
        Button   nextbutton = findViewById(R.id.button5);
        Intent sum_intent = getIntent();
    //    msumnumber = sum_intent.getIntExtra("sumtensu",0);
        Intent intent4 = getIntent();
        mTransitionCount = intent4.getIntExtra("TransitionCount", 0);
        Intent intent5 = getIntent();
        mmiss_phonetics_symbols = intent5.getIntExtra("miss_phonetics_symbols",0);
        Intent intent6 = getIntent();
        mmiss_phonetics_symbols2 = intent6.getIntExtra("miss_phonetics_symbols2",0);
        Intent intent8 = getIntent();
        id_number = intent8.getIntExtra("id_bango",0);
        Intent intent9 = getIntent();
        id_shuffle_array = intent9.getIntArrayExtra("id_shuffle_message");
        if( mTransitionCount != 1) {
            Intent intent10 = getIntent();
            id_shuffle_array2 = intent10.getIntArrayExtra("id_shuffle_message2");
        }

        //データを受け取る
        Intent intent2= getIntent();
        String mondai = intent2.getStringExtra(TestActivity.EXTRA_MESSAGE2); //問題の受け取り
        textview5.setText(mondai);
        Intent intent3 = getIntent();
        String mondai_phonetics = intent3.getStringExtra(TestActivity.EXTRA_MESSAGE3); //問題発音の受け取り

        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(TestActivity.EXTRA_MESSAGE);//認識の受け取り
        Intent intent7 = getIntent();
        category = intent7.getStringExtra(TestActivity.EXTRA_MESSAGE4);//カテゴリー名の受け取り
        textview6.setText(message);
        String result_phonetics = "";
        String result_phonetics1 = "";
        String result_phonetics2 = "";
        String result_phonetics3 = "";

        int error = 0;
        String[] message_number = message.split(" ",0);
        if( message_number.length > 1) {
             result_phonetics1  =  calculateBmi(message_number[0]);
             result_phonetics2 =    calculateBmi(message_number[1]);
             result_phonetics3 = result_phonetics1 + " " + result_phonetics2;
             error = 1;
        }
        if( message_number.length == 1){
             result_phonetics = calculateBmi(message);
        }
        class Levenstein_distance {
            String LevensteinDistance(String array_left, String array_right) {

                String[] left = array_left.split("",0);
                String[] right = array_right.split("",0);
                int array_[][] = new int[left.length][right.length];
                int x = 0;
                int COST_DEL = 1;
                int COST_INS = 1;
                int COST_SUB = 1;
                int c_del = 0;
                int c_ins = 0;
                int c_sub = 0;
                int c_match = 0;
                int candidate = 0;
                int candidate2 = 0;
                int candidate3 = 0;
                for (int i = 0; i < left.length; i++) {
                    array_[i][0] = i;
                }
                for (int j = 0; j < right.length; j++) {
                    array_[0][j] = j;
                }
                for (int i = 1; i < left.length; i++) {
                    for (int j = 1; j < right.length; j++) {
                        c_del = array_[i - 1][j] + COST_DEL;
                        c_ins = array_[i][j - 1] + COST_INS;
                        c_sub = array_[i - 1][j - 1] + COST_SUB;
                        if (left[i].equals(right[j])) {
                            x = 0;
                        } else {
                            x = 1;
                        }
                        c_match = array_[i - 1][j - 1] + x;
                        candidate = Math.min(c_del, c_ins);
                        candidate2 = Math.min(c_match, c_sub);
                        candidate3 = Math.min(candidate, candidate2);
                        array_[i][j] = candidate3;


                    }
                }
                int score_left = 0;
                int score_up = 0;
                int score_naname = 0;
                int position_left = left.length-1;
                int position_right = right.length-1;
                int score = 0;
                String seikai = "";
                for (int i = 0; i < (left.length) * (right.length); i++) {
                    if (position_left == 0 && position_right == 0) {
                        break;
                    } else if (position_left == 0) {
                        score_naname = 10000;
                        score_up = 10000;
                        score_left = array_[position_left][position_right - 1];
                    } else if (position_right == 0) {
                        score_naname = 10000;
                        score_left = 10000;
                        score_up = array_[position_left - 1][position_right];
                    } else {
                        score_left = array_[position_left][position_right - 1];
                        score_up = array_[position_left - 1][position_right];
                        score_naname = array_[position_left - 1][position_right - 1];
                    }
                    score = array_[position_left][position_right];
                    if (score_naname <= score_left && score_naname <= score_up && score >= score_naname) {
                        position_left = position_left - 1;
                        position_right = position_right - 1;
                        if (score > score_naname) {
                            seikai += String.valueOf(position_left + 1);
                            seikai += " ";
                            // seikai += String.valueOf(position_right + 1);
                            // seikai += " ";
                        }
                        score = array_[position_left][position_right];
                    } else if (score_left <= score_naname && score_left <= score_up && score > score_left) {
                        position_left = position_left;
                        position_right = position_right - 1;
                        if (score > score_left) {


                            //seikai += "-1";
                            //seikai += " ";
                            //seikai += String.valueOf(position_right + 1);
                            //seikai += " ";
                        }
                        score = array_[position_left][position_right];
                    } else if (score_up <= score_naname && score_up <= score_left && score > score_up) {
                        position_left = position_left - 1;
                        position_right = position_right;
                        if (score > score_up) {
                            seikai += String.valueOf(position_left + 1);
                            seikai += " ";
                            //seikai += "-1";
                            //seikai += " ";
                        }
                    } else {

                    }

                }
                //textView.setText(String.valueOf(array_[4][6]));
                return  seikai;
            }
        }
        //b = b.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        String right = "";
        if( message_number.length == 1) {
             right = result_phonetics.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");//ゴジラ";
        }
        if( message_number.length > 1){
            right = result_phonetics3.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        }
        Levenstein_distance LD = new Levenstein_distance();
        String distance = LD.LevensteinDistance(mondai_phonetics, right);
        String distance2 = LD.LevensteinDistance(right,mondai_phonetics);
        String[] distance_index;
        distance_index = distance.split(" ",0);
        textview2.setText(right);
        textview4.setText(mondai_phonetics);
        int spanColor = Color.RED;
        if( distance.length() != 0) {
            SpannableStringBuilder ssb = new SpannableStringBuilder(mondai_phonetics);
            int place = 10000;
            for (int i = 0; i < distance_index.length; i++) {
                place = Integer.parseInt(distance_index[i]);
                ssb.setSpan(new ForegroundColorSpan(spanColor), place-1,place, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textview4.setText(ssb);
            }

        }

        if( mondai_phonetics.equals(right) ){
           textview7.setText("正解です!!");
        }
        else{
            textview7.setText("不正解です");
        }
        textview16.setText(String.valueOf(distance2.length()));
        if( distance2.length() != 0 ) {
           textview16.setText(String.valueOf(100 / right.length() * (right.length() - distance2.length() / 2)) + "点");

       }
       else{
            audioPlay("fanfare3.mp3");
           textview16.setText("100点");
        }
      //  tensu = 100 / right.length() * (right.length() - distance2.length() / 2);
        int Failure = 0;
        if( id_number <= 10 && !(mondai_phonetics.equals(right))){
            mmiss_phonetics_symbols++;
            Failure = 1;
        }
        else if( id_number > 10 && !(mondai_phonetics.equals(right))){
            mmiss_phonetics_symbols2++;
            Failure = 1;
        }
        else{

        }

/*        if( distance.length() != 0) {
            if (id_number <= 10) {
                for (int i = 0; i < distance_index.length; i++) {
                    int position = Integer.parseInt(distance_index[i]);
                    String phonetic = mondai_phonetics.substring(position - 1, position);
                    if (category.equals("category1.csv") && phonetic.equals("ʌ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category2.csv") && phonetic.equals("ɑ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category3.csv") && phonetic.equals("i")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category4.csv") && phonetic.equals("ʊ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category5.csv") && phonetic.equals("e")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category6.csv") && phonetic.equals("ɔ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category7.csv") && phonetic.equals("s")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category8.csv") && phonetic.equals("ʃ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category9.csv") && phonetic.equals("θ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category10.csv") && phonetic.equals("f")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category11.csv") && phonetic.equals("l")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category12.csv") && phonetic.equals("t")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category13.csv") && phonetic.equals("p")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category14.csv") && phonetic.equals("k")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category15.csv") && phonetic.equals("tʃ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category16.csv") && phonetic.equals("m")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category17.csv") && phonetic.equals("f")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category18.csv") && phonetic.equals("w")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category19.csv") && phonetic.equals("ŋ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category20.csv") && phonetic.equals("ɪ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category21.csv") && phonetic.equals("aɪ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category22.csv") && phonetic.equals("aɪ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category23.csv") && phonetic.equals("aʊ")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else if (category.equals("category24.csv") && phonetic.equals("ɜr")) {
                        mmiss_phonetics_symbols++;
                        Failure = 1;
                    } else {

                    }
                }

            }
            if (id_number > 10) {
                for (int i = 0; i < distance_index.length; i++) {
                    int position = Integer.parseInt(distance_index[i]);
                    String phonetic = mondai_phonetics.substring(position - 1, position);
                    if (category.equals("category1.csv") && phonetic.equals("ə")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category2.csv") && phonetic.equals("æ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category3.csv") && phonetic.equals("ɪ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category4.csv") && phonetic.equals("u")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category5.csv") && phonetic.equals("ɪ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category6.csv") && phonetic.equals("oʊ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category7.csv") && phonetic.equals("z")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category8.csv") && phonetic.equals("ʒ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category9.csv") && phonetic.equals("ð")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category10.csv") && phonetic.equals("v")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category11.csv") && phonetic.equals("r")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category12.csv") && phonetic.equals("d")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category13.csv") && phonetic.equals("b")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category14.csv") && phonetic.equals("g")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category15.csv") && phonetic.equals("dʒ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category16.csv") && phonetic.equals("n")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category17.csv") && phonetic.equals("h")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category18.csv") && phonetic.equals("v")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category19.csv") && phonetic.equals("n")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category20.csv") && phonetic.equals("j")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category21.csv") && phonetic.equals("eɪ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category22.csv") && phonetic.equals("ɔɪ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category23.csv") && phonetic.equals("oʊ")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else if (category.equals("category24.csv") && phonetic.equals("r")) {
                        mmiss_phonetics_symbols2++;
                        Failure = 1;
                    } else {

                    }
                }
            }
        }*/

        final int finalFailure = Failure;
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(helper == null){
                    helper = new TestOpenHelper(getApplicationContext());
                }
                if(db == null){
                    db = helper.getWritableDatabase();
                }
                String key = textview5.getText().toString();
                String value = String.valueOf(id_number);
                if(finalFailure == 1) {
                    insertData(db, key,Integer.valueOf(value));
                }
                speech();
            }
        });

    }
    private void insertData(SQLiteDatabase db, String com, int price){

        ContentValues values = new ContentValues();
        values.put("company", com);
        values.put("stockprice", price);

        db.insert("testdb", null, values);
    }
    private void speech(){
        if( mTransitionCount  >= 20){
        //    msumnumber = msumnumber + tensu;
            Intent intent6 = new Intent(getApplication(),FinishscreenActivity.class);
            intent6.putExtra("miss_phonetics_symbols",mmiss_phonetics_symbols);
            intent6.putExtra("miss_phonetics_symbols2",mmiss_phonetics_symbols2);
         //   intent6.putExtra("sumtensu",msumnumber);
            String str = category;
            intent6.putExtra(EXTRA_MESSAGE,str);
            startActivity(intent6);
        }
        else {
            Intent intent5 = new Intent(getApplication(), TestActivity.class);
         //   msumnumber = msumnumber + tensu;
            intent5.putExtra("TransitionCount", mTransitionCount);
            intent5.putExtra("miss_phonetics_symbols",mmiss_phonetics_symbols);
            intent5.putExtra("miss_phonetics_symbols2",mmiss_phonetics_symbols2);
            intent5.putExtra("id_shuffle_message",id_shuffle_array);
           // intent5.putExtra("sumtensu",msumnumber);
            if( mTransitionCount != 1) {
                intent5.putExtra("id_shuffle_message2", id_shuffle_array2);
            }
            String str = category;
            intent5.putExtra(EXTRA_MESSAGE,str);
            startActivity(intent5);
        }
    }
    private String  calculateBmi(String word) {

        String word_omoji = word.toUpperCase();
        int testnumber = 0;
        String phonetics = "";
        if (word_omoji.compareTo("ALMENDAREZ") <= 0) {
            testnumber = 1;
        } else if (word_omoji.compareTo("AZZOPARDI") <= 0) {
            testnumber = 2;
        } else if (word_omoji.compareTo("BENDLER") <= 0) {
            testnumber = 3;
        }
        else if (word_omoji.compareTo("BONN") <= 0) {
            testnumber = 4;
        }
        else if (word_omoji.compareTo("BYZANTIUM") <= 0) {
            testnumber = 5;
        }
        else if (word_omoji.compareTo("CHANCELLORS") <= 0) {
            testnumber = 6;
        }
        else if (word_omoji.compareTo("COLLISTER") <= 0) {
            testnumber = 7;
        }
        else if (word_omoji.compareTo("COVELLO") <= 0) {
            testnumber = 8;
        }
        else if (word_omoji.compareTo("CZYZEWSKI") <= 0) {
            testnumber = 9;
        }
        else if (word_omoji.compareTo("DESCENDED") <= 0) {
            testnumber = 10;
        }
        else if (word_omoji.compareTo("DONNELLY'S") <= 0) {
            testnumber = 11;
        }
        else if (word_omoji.compareTo("D_C") <= 0) {
            testnumber = 12;
        }
        else if (word_omoji.compareTo("ERAS") <= 0) {
            testnumber = 13;
        }
        else if (word_omoji.compareTo("EZZO") <= 0) {
            testnumber = 14;
        }
        else if (word_omoji.compareTo("FLUORESCENCE") <= 0) {
            testnumber = 15;
        }
        else if (word_omoji.compareTo("FYODOROV'S") <= 0) {
            testnumber = 16;
        }
        else if (word_omoji.compareTo("GODOT'S") <= 0) {
            testnumber = 17;
        }
        else if (word_omoji.compareTo("GYUHAMA") <= 0) {
            testnumber = 18;
        }
        else if (word_omoji.compareTo("HERBIG") <= 0) {
            testnumber = 19;
        }
        else if (word_omoji.compareTo("HZ") <= 0) {
            testnumber = 20;
        }
        else if (word_omoji.compareTo("IRRAWADDY") <= 0) {
            testnumber = 21;
        }
        else if (word_omoji.compareTo("I_R_A") <= 0) {
            testnumber = 22;
        }
        else if (word_omoji.compareTo("JYNX") <= 0) {
            testnumber = 23;
        }
        else if (word_omoji.compareTo("KONZ") <= 0) {
            testnumber = 24;
        }
        else if (word_omoji.compareTo("KYZER") <= 0) {
            testnumber = 25;
        }
        else if (word_omoji.compareTo("LIDEN") <= 0) {
            testnumber = 26;
        }
        else if (word_omoji.compareTo("LYVERS") <= 0) {
            testnumber = 27;
        }
        else if (word_omoji.compareTo("MAYBELLINE") <= 0) {
            testnumber = 28;
        }
        else if (word_omoji.compareTo("MILAN'S") <= 0) {
            testnumber = 29;
        }
        else if (word_omoji.compareTo("MYUNG") <= 0) {
            testnumber = 30;
        }
        else if (word_omoji.compareTo("N_WORDS") <= 0) {
            testnumber = 31;
        }
        else if (word_omoji.compareTo("OZZY") <= 0) {
            testnumber = 32;
        }
        else if (word_omoji.compareTo("PETZINGER") <= 0) {
            testnumber = 33;
        }
        else if (word_omoji.compareTo("PRECIADO") <= 0) {
            testnumber = 34;
        }
        else if (word_omoji.compareTo("PYXIS") <= 0) {
            testnumber = 35;
        }
        else if (word_omoji.compareTo("QURESHI ") <= 0) {
            testnumber = 36;
        }
        else if (word_omoji.compareTo("REMEDIATE") <= 0) {
            testnumber = 37;
        }
        else if (word_omoji.compareTo("ROMPING") <= 0) {
            testnumber = 38;
        }
        else if (word_omoji.compareTo("RZEPKA") <= 0) {
            testnumber = 39;
        }
        else if (word_omoji.compareTo("SCUTTLING(1)") <= 0) {
            testnumber = 40;
        }
        else if (word_omoji.compareTo("SIEFERT'S") <= 0) {
            testnumber = 41;
        }
        else if (word_omoji.compareTo("SPECTACLES") <= 0) {
            testnumber = 42;
        }
        else if (word_omoji.compareTo("STUFFING") <= 0) {
            testnumber = 43;
        }
        else if (word_omoji.compareTo("SZYMCZAK") <= 0) {
            testnumber = 44;
        }
        else if (word_omoji.compareTo("TOBACK") <= 0) {
            testnumber = 45;
        }
        else if (word_omoji.compareTo("T_A_C(1)") <= 0) {
            testnumber = 46;
        }
        else if (word_omoji.compareTo("U_S_M_C") <= 0) {
            testnumber = 47;
        }
        else if (word_omoji.compareTo("V_S") <= 0) {
            testnumber = 48;
        }
        else if (word_omoji.compareTo("WILLIAMSBURG") <= 0) {
            testnumber = 49;
        }
        else if (word_omoji.compareTo("WYTHE") <= 0) {
            testnumber = 50;
        }else if (word_omoji.compareTo("ZYWICKI") <= 0) {
            testnumber = 51;
        }else {
        }
        InputStream is = null;
        BufferedReader br = null;
        String text = "";
        AssetManager as = getResources().getAssets();
        try {
            try {
                // assetsフォルダ内の sample.txt をオープンする
                if (testnumber == 1) {
                    is = as.open("dic1.txt");
                    //  textvi2.setText("dic1あけた");

                } else if (testnumber == 2) {
                    is = as.open("dic2.txt");
                    //  textvi2.setText("dic2あけた");
                } else if (testnumber == 3) {
                    is = as.open("dic3.txt");
                    //  textvi2.setText("dic3あけた");
                } else if (testnumber == 4) {
                    is = as.open("dic4.txt");
                }
                else if (testnumber == 5) {
                    is = as.open("dic5.txt");
                }
                else if (testnumber == 6) {
                    is = as.open("dic6.txt");
                }
                else if (testnumber == 7) {
                    is = as.open("dic7.txt");
                }
                else if (testnumber == 8) {
                    is = as.open("dic8.txt");
                }
                else if (testnumber == 9) {
                    is = as.open("dic9.txt");
                }
                else if (testnumber == 10) {
                    is = as.open("dic10.txt");
                }
                else if (testnumber == 11) {
                    is = as.open("dic11.txt");
                }
                else if (testnumber == 12) {
                    is = as.open("dic12.txt");
                }
                else if (testnumber == 13) {
                    is = as.open("dic13.txt");
                }
                else if (testnumber == 14) {
                    is = as.open("dic14.txt");
                }
                else if (testnumber == 15) {
                    is = as.open("dic15.txt");
                }
                else if (testnumber == 16) {
                    is = as.open("dic16.txt");
                }
                else if (testnumber == 17) {
                    is = as.open("dic17.txt");
                }
                else if (testnumber == 18) {
                    is = as.open("dic18.txt");
                }else if (testnumber == 19) {
                    is = as.open("dic19.txt");
                }else if (testnumber == 20) {
                    is = as.open("dic20.txt");
                }
                else if (testnumber == 21) {
                    is = as.open("dic21.txt");
                }
                else if (testnumber == 22) {
                    is = as.open("dic22.txt");
                }
                else if (testnumber == 23) {
                    is = as.open("dic23.txt");
                }
                else if (testnumber == 24) {
                    is = as.open("dic24.txt");
                }else if (testnumber == 25) {
                    is = as.open("dic25.txt");
                }else if (testnumber == 26) {
                    is = as.open("dic26.txt");
                }else if (testnumber == 27) {
                    is = as.open("dic27.txt");
                }else if (testnumber == 28) {
                    is = as.open("dic28.txt");
                }else if (testnumber == 29) {
                    is = as.open("dic29.txt");
                }else if (testnumber == 30) {
                    is = as.open("dic30.txt");
                }else if (testnumber == 31) {
                    is = as.open("dic31.txt");
                }
                else if (testnumber == 32) {
                    is = as.open("dic32.txt");
                }
                else if (testnumber == 33) {
                    is = as.open("dic33.txt");
                }
                else if (testnumber== 34) {
                    is = as.open("dic34.txt");
                }
                else if (testnumber == 35) {
                    is = as.open("dic35.txt");
                }
                else if (testnumber == 36) {
                    is = as.open("dic36.txt");
                }else if (testnumber == 37) {
                    is = as.open("dic37.txt");
                }else if (testnumber == 38) {
                    is = as.open("dic38.txt");
                }else if (testnumber == 39) {
                    is = as.open("dic39.txt");
                }else if (testnumber == 40) {
                    is = as.open("dic40.txt");
                }else if (testnumber == 41) {
                    is = as.open("dic41.txt");
                }else if (testnumber == 42) {
                    is = as.open("dic42.txt");
                }else if (testnumber == 43) {
                    is = as.open("dic43.txt");
                }else if (testnumber == 44) {
                    is = as.open("dic44.txt");
                }else if (testnumber == 45) {
                    is = as.open("dic45.txt");
                }else if (testnumber == 46) {
                    is = as.open("dic46.txt");
                }else if (testnumber == 47) {
                    is = as.open("dic47.txt");
                }else if (testnumber == 48) {
                    is = as.open("dic48.txt");
                }else if (testnumber == 49) {
                    is = as.open("dic49.txt");
                }else if (testnumber == 50) {
                    is = as.open("dic50.txt");
                }
                else if (testnumber == 51) {
                    is = as.open("dic51.txt");
                }
                else {
                }
                br = new BufferedReader(new InputStreamReader(is));
                //textvi2.setText(word_omoji[0]);
                // １行ずつ読み込み、改行を付加する
                String str;
                while ((str = br.readLine()) != null) {
                    String[] str_tango = str.split(" ",0);
                    if (str_tango[0].equals(word_omoji)) {
                        String[] str2 = str.split(" ", 0);
                        for (int i = 1; i < str2.length; i++) {
                            text += str2[i];
                            text += " ";
                        }
                        //textvi2.setText(text);
                        break;
                    }
                }
                // textvi2.setText(text);
            } finally {
                if (is != null) is.close();
                if (br != null) br.close();
            }
        } catch (Exception e) {
        }
        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("AO", "ɔ");
        map2.put("AO0", "ɔ");
        map2.put("AO1", "ɔ́");
        map2.put("AO2", "ɔ̀");
        map2.put("AA", "ɑ");
        map2.put("AA0", "ɑ");
        map2.put("AA1", "ɑ́");
        map2.put("AA2", "ɑ̀");
        map2.put("IY", "i");
        map2.put("IY0", "i");
        map2.put("IY1", "í");
        map2.put("IY2", "ì");
        map2.put("UW", "u");
        map2.put("UW0", "u");
        map2.put("UW1", "ú");
        map2.put("UW2", "ù");
        map2.put("EH", "e");
        map2.put("EH0", "e");
        map2.put("EH1", "é");
        map2.put("EH2", "è");
        map2.put("IH", "ɪ");
        map2.put("IH0", "ɪ");
        map2.put("IH1", "ɪ́");
        map2.put("IH2", "ɪ̀");
        map2.put("UH", "ʊ");
        map2.put("UH0", "ʊ");
        map2.put("UH1", "ʊ́");
        map2.put("UH2", "ʊ̀");
        map2.put("AH", "ʌ");
        map2.put("AH0", "ə");
        map2.put("AH1", "ʌ́");
        map2.put("AH2", "ʌ̀");
        map2.put("AE", "æ");
        map2.put("AE0", "æ");
        map2.put("AE1", "ǽ");
        map2.put("AE2", "æ̀");
        map2.put("AX", "ə");
        map2.put("AX0", "ə");
        map2.put("AX1", "ə́");
        map2.put("AX2", "ə̀");
        map2.put("EY", "eɪ");
        map2.put("EY0", "eɪ");
        map2.put("EY1", "éɪ");
        map2.put("EY2", "èɪ");
        map2.put("AY", "aɪ");
        map2.put("AY0", "aɪ");
        map2.put("AY1", "áɪ");
        map2.put("AY2", "àɪ");
        map2.put("OW", "oʊ");
        map2.put("OW0", "oʊ");
        map2.put("OW1", "óʊ");
        map2.put("OW2", "òʊ");
        map2.put("AW", "aʊ");
        map2.put("AW0", "aʊ");
        map2.put("AW1", "áʊ");
        map2.put("AW2", "àʊ");
        map2.put("OY", "ɔɪ");
        map2.put("OY0", "ɔɪ");
        map2.put("OY1", "ɔ́ɪ");
        map2.put("OY2", "ɔ̀ɪ");
        map2.put("P", "p");
        map2.put("B", "b");
        map2.put("T", "t");
        map2.put("D", "d");
        map2.put("K", "k");
        map2.put("G", "g");
        map2.put("CH", "tʃ");
        map2.put("JH", "dʒ");
        map2.put("F", "f");
        map2.put("V", "v");
        map2.put("TH", "θ");
        map2.put("DH", "ð");
        map2.put("S", "s");
        map2.put("Z", "z");
        map2.put("SH", "ʃ");
        map2.put("ZH", "ʒ");
        map2.put("HH", "h");
        map2.put("M", "m");
        map2.put("N", "n");
        map2.put("NG", "ŋ");
        map2.put("L", "l");
        map2.put("R", "r");
        map2.put("ER", "ɜr");
        map2.put("ER0", "ɜr");
        map2.put("ER1", "ɜ́r");
        map2.put("ER2", "ɜ̀r");
        map2.put("AXR", "ər");
        map2.put("AXR0", "ər");
        map2.put("AXR1", "ə́r");
        map2.put("AXR2", "ə̀r");
        map2.put("W", "w");
        map2.put("Y", "j");

        String[] alphabet = text.split(" ", 0);
        for (int i = 0; i < alphabet.length; i++) {
            if (map2.containsKey(alphabet[i])) {
                phonetics += map2.get(alphabet[i]);
            } else {
            }
        }
        //b = b.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        //成功
        //  if( b.equals("dìɔr")){
        //      textvi2.setText("正解");
        //  }
        //  else{
        //      textvi2.setText("発音が違います");
        //  }
        if( text == ""){
            phonetics = "該当なし";
        }

        return phonetics;
    }
    private boolean audioSetup(String file){
        boolean fileCheck = false;

        // インタンスを生成
        mediaPlayer = new MediaPlayer();

        //音楽ファイル名, あるいはパス
        String filePath = file;

        // assetsから mp3 ファイルを読み込み
        try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath);)
        {
            // MediaPlayerに読み込んだ音楽ファイルを指定
            mediaPlayer.setDataSource(afdescripter.getFileDescriptor(),
                    afdescripter.getStartOffset(),
                    afdescripter.getLength());
            // 音量調整を端末のボタンに任せる
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();
            fileCheck = true;
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return fileCheck;
    }
    private void audioPlay(String file) {
        if (mediaPlayer == null) {
            // audio ファイルを読出し
            if (audioSetup(file)){
                //     Toast.makeText(getApplication(), "Rread audio file", Toast.LENGTH_SHORT).show();
            }
            else{
                //     Toast.makeText(getApplication(), "Error: read audio file", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else{
            // 繰り返し再生する場合
            mediaPlayer.stop();
            mediaPlayer.reset();
            // リソースの解放
            mediaPlayer.release();
            mediaPlayer = null;
        }

        // 再生する
        mediaPlayer.start();

        // 終了を検知するリスナー
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d("debug","end of audio");
                audioStop();
            }
        });
    }
    private void audioStop() {
        // 再生終了
        mediaPlayer.stop();
        // リセット
        mediaPlayer.reset();
        // リソースの解放
        mediaPlayer.release();

        mediaPlayer = null;
    }

}
