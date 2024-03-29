package com.example.phoneticstest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.os.Build;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public  class TestActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

   // private TextView textView;
   // private EditText editTextKey, editTextValue;
    private TestOpenHelper helper;
    private SQLiteDatabase db;
    private SpeechRecognizer sr;
    private static final int REQUEST_CODE = 1000;
    private TextView resulttext;//音声認識の受け取り皿
    private TextView textView2;//出題単語の発音記号text
    private TextToSpeech tts;
    private TextView textView;//出題単語のtext
    private TextView mondaikaisutext;//現在が何問目なのかのtext
    private static final String TAG = "TestTTS";

    public static final String EXTRA_MESSAGE
            = "com.example.phoneticstest.TestActivity.MESSAGE";//認識結果の単語
    public static final String EXTRA_MESSAGE2
            = "com.example.phoneticstest.TestActivity.MESSAGE2";//出題単語
    public static final String EXTRA_MESSAGE3
            ="com.example.phoneticstest.TestActivity.MESSAGE3";//出題単語の発音記号
    public static final String EXTRA_MESSAGE4
            ="com.example.phoneticstest.TestActivity.MESSAGE4";//カテゴリー
    private int mTransitionCount;//出題回数カウント
    //private int msumnumber=0;//合計点数
    //private int msumnumber2=0;
    //private int tensu=0;//点数
    private int mmiss_phonetics_symbols;//前半ブロック
    private int mmiss_phonetics_symbols2;//後半ブロック
    private String categoryname;//カテゴリー名
    private int id_number; //idの番号
    private int[] id_shuffle_array = new int[10];
    private int[] id_shuffle_array2= new int[10];
    private  int skip = 0;//skipボタンを押したかの判定に使用する変数
    private int speakingbutton_tap_count = 0;//[話す]ボタンのタップされた回数
    // リストの並びをシャッフルします。

    // シャッフルされたリストの先頭を取得します。


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //音声認識の結果の受け取り皿
        resulttext = findViewById(R.id.textView3);
        //出題単語のtext
        textView = findViewById(R.id.textView);
        //出題単語の発音記号text
        textView2 = findViewById(R.id.textView8);
        mondaikaisutext = findViewById(R.id.textView11);
        Intent intent0 = getIntent();
        skip = intent0.getIntExtra("skip_id",0);
        Intent intent_tensu = getIntent();//点数
      //  tensu = intent_tensu.getIntExtra("tensu",0);
        Intent intent_sumtensu = getIntent();//合計点数
      //  msumnumber = intent_sumtensu.getIntExtra("sumtensu",0);
      //  msumnumber2 = msumnumber + tensu;
        Intent intent1 = getIntent(); //遷移回数データを受け取る
        mTransitionCount = intent1.getIntExtra("TransitionCount", 0);
        mTransitionCount++;
        Intent intent2 = getIntent();//前半ミスの回数
        mmiss_phonetics_symbols = intent2.getIntExtra("miss_phonetics_symbols", 0);
        Intent intent3 = getIntent();//後半ミスの回数
        mmiss_phonetics_symbols2 = intent3.getIntExtra("miss_phonetics_symbols2", 0);
       if( mTransitionCount == 1) {
           Intent intent4 = getIntent();//カテゴリーの番号
           categoryname = intent4.getStringExtra(CategoryActivity.EXTRA_MESSAGE);
       }
       else{
           if( skip == 0) {
               Intent intent5 = getIntent();
               categoryname = intent5.getStringExtra(ResultActivity.EXTRA_MESSAGE);
           }
           else if( skip == 1){
               Intent intent5 = getIntent();
               categoryname = intent5.getStringExtra(TestActivity.EXTRA_MESSAGE4);
           }
       }
       if( mTransitionCount != 1) {
           Intent intent6 = getIntent();
           id_shuffle_array = intent6.getIntArrayExtra("id_shuffle_message");
       }
       if( mTransitionCount != 1 && mTransitionCount != 2) {
           Intent intent7 = getIntent();
           id_shuffle_array2 = intent7.getIntArrayExtra("id_shuffle_message2");
       }
        String number = String.valueOf(mTransitionCount);
       String text="nofile";
       if( mTransitionCount % 2 != 0) {
            text = readFile(categoryname, number, id_shuffle_array);
       }
       if( mTransitionCount % 2 == 0){
            text = readFile(categoryname,number,id_shuffle_array2);
       }

           mondaikaisutext.setText("第"+ String.valueOf(mTransitionCount)+ "問");
            //Toast toast = Toast.makeText(this, String.format("第%d問", mTransitionCount), Toast.LENGTH_LONG);
            //toast.setGravity(Gravity.TOP, 0, 150);
            //toast.show();
            tts = new TextToSpeech(this, this);
            //ファイルがあれば，問題を出題する
            if (!(text.equals("nofile"))) {
                String[] question = text.split(",", 0);
                textView.setText(question[1]);
                textView2.setText(question[2]);
            }
            else {
                textView.setText("問題が作成されていません.");
            }

            //   Random rand = new Random();
            //    questionnumber_variable = rand.nextInt(20) + 1;

        Button speakingbutton = (Button) findViewById(R.id.speakingbutton);
        speakingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(helper == null){
                    helper = new TestOpenHelper(getApplicationContext());
                }
                if(db == null){
                    db = helper.getWritableDatabase();
                }
                speakingbutton_tap_count++;
                mondaikaisutext.setText("第"+ String.valueOf(mTransitionCount)+ "問"+"\n"+"([話す]ボタンタップ回数:"+String.valueOf(speakingbutton_tap_count)+")");
                speech();
            }
        });

        Button ttsButton = findViewById(R.id.readbutton);
        ttsButton.setOnClickListener(this);

        Button skipbutton = findViewById(R.id.skipbutton);
        skipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(helper == null){
                    helper = new TestOpenHelper(getApplicationContext());
                }
                if(db == null){
                    db = helper.getWritableDatabase();
                }
                String key = textView.getText().toString();
                String value = String.valueOf(id_number);
                insertData(db, key,Integer.valueOf(value));
                skip();
            }
        });
    }
    private void insertData(SQLiteDatabase db, String com, int price){

        ContentValues values = new ContentValues();
        values.put("company", com);
        values.put("stockprice", price);

        db.insert("testdb", null, values);
    }
    public String readFile(String file, String count,int[] array){
        String text = "nofile";
        int countnumber;
        countnumber = Integer.parseInt(count);
         if( countnumber == 1) {
            id_shuffle_array = init(countnumber);
         }
         else if( countnumber == 2){
             id_shuffle_array2 = init(countnumber);
         }
         else{
             if( countnumber == 3){
                 id_number =  array[1];
             }
             if( countnumber == 5){
                 id_number =  array[2];
             }
             if( countnumber == 7){
                 id_number =  array[3];
             }
             if( countnumber == 9){
                 id_number =  array[4];
             }
             if( countnumber == 11){
                 id_number =  array[5];
             }
             if( countnumber == 13){
                 id_number =  array[6];
             }
             if( countnumber == 15){
                 id_number =  array[7];
             }
             if( countnumber == 17){
                 id_number =  array[8];
             }
             if( countnumber == 19){
                 id_number =  array[9];
             }
             if( countnumber == 4){
                 id_number =  array[1];
             }
             if( countnumber == 6){
                 id_number =  array[2];
             }
             if( countnumber == 8){
                 id_number =  array[3];
             }
             if( countnumber == 10){
                 id_number =  array[4];
             }
             if( countnumber == 12){
                 id_number =  array[5];
             }
             if( countnumber == 14){
                 id_number =  array[6];
             }
             if( countnumber == 16){
                 id_number =  array[7];
             }
             if( countnumber == 18){
                 id_number =  array[8];
             }
             if( countnumber == 20){
                 id_number =  array[9];
             }
         }
            if( countnumber == 1) {
                id_number = id_shuffle_array[0];
            }
            if( countnumber == 2) {
                id_number = id_shuffle_array2[0];
                //textView2.setText(String.valueOf(id_number));
            }

        boolean isExists = false;
        File filecheck = this.getFileStreamPath(file);
        isExists = filecheck.exists();
        if (isExists) {
            try (FileInputStream fileInputStream = openFileInput(file);
                 BufferedReader reader = new BufferedReader(
                         new InputStreamReader(fileInputStream, StandardCharsets.UTF_8))) {
                String lineBuffer;
                while ((lineBuffer = reader.readLine()) != null) {
                    String[] search = lineBuffer.split(",", 0);
                    if (search[0].equals(String.valueOf(id_number))) {
                        text = lineBuffer;
                     //   break;
                    } //else {
                      //  text = "nofile";
                   // }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            text = "nofile";
        }
        return text;
    }
    private static int[] init(int countnumber){
        int[] ary = new int[ 10 ];
        if( countnumber == 1){
            // 配列に1からの連番を格納
            for ( int i = 0; i < ary.length; i++ )
            {
                ary[ i ] = i + 1;
            }

            // シャフル
            for ( int i = 0; i < ary.length; ++i ) {
                // 0～(配列aryの個数-1)の乱数を発生
                int rnd = (int)(Math.random() * 10);
                // ary[ i ]とary[ rnd ]を入れ替える
                int w = ary[ i ];
                ary[ i ] = ary[ rnd ];
                ary[ rnd ] = w;
            }
        }
        else if (countnumber == 2)
        {
            for ( int i = 0; i < ary.length; i++ )
            {
                ary[ i ] = i + 11;
            }
            // シャフル
            for ( int i = 0; i < ary.length; ++i ) {
                // 0～(配列aryの個数-1)の乱数を発生
                int rnd = (int)(Math.random() * 10);
                // ary[ i ]とary[ rnd ]を入れ替える
                int w = ary[ i ];
                ary[ i ] = ary[ rnd ];
                ary[ rnd ] = w;
            }

        }
        else{

        }
        return ary;
    }
    public void onInit(int status) {
        // TTS初期化
        if (TextToSpeech.SUCCESS == status) {
            Log.d(TAG, "initialized");
        } else {
            Log.e(TAG, "failed to initialize");
        }
    }

    @Override
    public void onClick(View v) {
        speechText();
    }
    private void shutDown() {
        if (null != tts) {
            // to release the resource of TextToSpeech
            tts.shutdown();
        }
    }
    private void speechText() {
        TextView editor = (TextView)findViewById(R.id.textView);

        // EditTextからテキストを取得
        String string = editor.getText().toString();

        if (0 < string.length()) {
            if (tts.isSpeaking()) {
                tts.stop();
                return;
            }
            setSpeechRate(0.5f);
            setSpeechPitch(1.0f);
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            if (Build.VERSION.SDK_INT >= 21) {
                // SDK 21 以上
                tts.speak(string, TextToSpeech.QUEUE_FLUSH, null, "messageID");
            } else {
                // tts.speak(text, TextToSpeech.QUEUE_FLUSH, null) に
                // KEY_PARAM_UTTERANCE_ID を HasMap で設定
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "messageID");
                tts.speak(string, TextToSpeech.QUEUE_FLUSH, map);
            }

            setTtsListener();
        }
    }
    private void setSpeechRate(float rate) {
        if (null != tts) {
            tts.setSpeechRate(rate);
        }
    }
    // 読み上げのピッチ
    private void setSpeechPitch(float pitch) {
        if (null != tts) {
            tts.setPitch(pitch);
        }
    }
    // 読み上げの始まりと終わりを取得
    private void setTtsListener() {
        // android version more than 15th
        if (Build.VERSION.SDK_INT >= 15) {
            int listenerResult =
                    tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onDone(String utteranceId) {
                            Log.d(TAG, "progress on Done " + utteranceId);
                        }

                        @Override
                        public void onError(String utteranceId) {
                            Log.d(TAG, "progress on Error " + utteranceId);
                        }

                        @Override
                        public void onStart(String utteranceId) {
                            Log.d(TAG, "progress on Start " + utteranceId);
                        }
                    });

            if (listenerResult != TextToSpeech.SUCCESS) {
                Log.e(TAG, "failed to add utterance progress listener");
            }
        } else {
            Log.e(TAG, "Build VERSION is less than API 15");
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        shutDown();
    }

    private void skip(){
        if( mTransitionCount < 20) {
            Intent skipintent = new Intent(getApplication(), TestActivity.class);
            String str4 = categoryname;
            skip = 1;
            skipintent.putExtra("TransitionCount", mTransitionCount);
            if (mTransitionCount % 2 != 0) {
                mmiss_phonetics_symbols++;
            }
            if (mTransitionCount % 2 == 0) {
                mmiss_phonetics_symbols2++;
            }
        //    tensu = 0;
            skipintent.putExtra("miss_phonetics_symbols", mmiss_phonetics_symbols);
            skipintent.putExtra("miss_phonetics_symbols2", mmiss_phonetics_symbols2);
            skipintent.putExtra("skip_id", skip);
            skipintent.putExtra(EXTRA_MESSAGE4, str4);
        //    skipintent.putExtra("tensu",tensu);
         //   skipintent.putExtra("sumtensu",msumnumber2);
            skipintent.putExtra("id_shuffle_message", id_shuffle_array);
            if (mTransitionCount != 1) {
                skipintent.putExtra("id_shuffle_message2", id_shuffle_array2);
            }
            startActivity(skipintent);
            resulttext.setText("");
        }
        else{
            Intent skipintent2 = new Intent(getApplication(),FinishscreenActivity.class);
            String str4 = categoryname;
            skip = 1;
            if (mTransitionCount % 2 != 0) {
                mmiss_phonetics_symbols++;
            }
            if (mTransitionCount % 2 == 0) {
                mmiss_phonetics_symbols2++;
            }
            skipintent2.putExtra("miss_phonetics_symbols",mmiss_phonetics_symbols);
            skipintent2.putExtra("miss_phonetics_symbols2",mmiss_phonetics_symbols2);
            skipintent2.putExtra(EXTRA_MESSAGE4,str4);
           // skipintent2.putExtra("sumtensu",msumnumber2);
            skipintent2.putExtra("skip_id", skip);
            startActivity(skipintent2);
        }
    }
    private void speech() {
        try{
            if (sr == null){
                sr = SpeechRecognizer.createSpeechRecognizer(this);
                if (!SpeechRecognizer.isRecognitionAvailable(getApplicationContext())) {
                    Toast.makeText(getApplicationContext(), "音声認識が使えません",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
                sr.setRecognitionListener(new listener());
            }
            Intent intent4 = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent4.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
            intent4.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH.toString());
            intent4.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
            intent4.putExtra(RecognizerIntent.EXTRA_PROMPT,"音声認識中です");
            sr.startListening(intent4);
            //インテント発行
            // startActivityForResult(intent, REQUEST_CODE);

        }catch (Exception ex){
            //エラー表示
            Toast.makeText(getApplicationContext(), "startListening()でエラーが起こりました",
                    Toast.LENGTH_LONG).show();
        }        //finish();
        //e.printStackTrace();
        //textView.setText(R.string.error);
    }
    protected void stopListening() {
        if (sr != null) sr.destroy();
        sr = null;
    }



    private class listener implements RecognitionListener {
        public void onBeginningOfSpeech() {
            resulttext.setText("音声認識中です!");
            //Toast.makeText(getApplicationContext(), "音声認識を開始しました",
            //        Toast.LENGTH_LONG).show();
        }
        public void onBufferReceived(byte[] buffer) {
        }
        public void onEndOfSpeech() {
            resulttext.setText("音声認識が終了しました!");
            //Toast.makeText(getApplicationContext(), "音声認識を終了しました",
            //        Toast.LENGTH_LONG).show();
        }
        public void onError(int error) {
            String reason = "";
            switch (error) {
                // Audio recording error
                case SpeechRecognizer.ERROR_AUDIO:
                    //reason = "ERROR_AUDIO";
                    reason = "音声データの保存に失敗しました.";
                    break;
                // Other client side errors
                case SpeechRecognizer.ERROR_CLIENT:
                    //reason = "ERROR_CLIENT";
                    reason = "Android端末内のエラーです.確認してください!";
                    break;
                // Insufficient permissions
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    reason = "権限があたえられていません．設定してください!";
                    break;
                // 	Other network related errors
                case SpeechRecognizer.ERROR_NETWORK:
                    reason = "ネットワークのエラーです.ネットワークを確認してください!";
                    /* ネットワーク接続をチェックする処理をここに入れる */
                    break;
                // Network operation timed out
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    //reason = "ERROR_NETWORK_TIMEOUT";
                    reason = "時間切れです.再度,[話す]ボタンをタップしてください!";
                    break;
                // No recognition result matched
                case SpeechRecognizer.ERROR_NO_MATCH:
                    //reason = "ERROR_NO_MATCH";
                    reason = "該当する音声認識結果がありません.再度,[話す]ボタンをタップしてください!";
                    break;
                // RecognitionService busy
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    //reason = "ERROR_RECOGNIZER_BUSY";
                    reason = "少し時間をおいて再度,[話す]ボタンをタップしてください!";
                    break;
                // Server sends error status
                case SpeechRecognizer.ERROR_SERVER:
                    //reason = "ERROR_SERVER";
                    reason = "サーバーからのエラーを受け取りました";
                    /* ネットワーク接続をチェックをする処理をここに入れる */
                    break;
                // No speech input
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    reason = "音声入力がありません.再度,[話す]ボタンをタップしてください!";
                    break;
            }
            if( speakingbutton_tap_count >= 3){
                if( mTransitionCount < 20) {
                    Intent skipintent = new Intent(getApplication(), TestActivity.class);
                    String str4 = categoryname;
                    skip = 1;
                    skipintent.putExtra("TransitionCount", mTransitionCount);
                    if (mTransitionCount % 2 != 0) {
                        mmiss_phonetics_symbols++;
                    }
                    if (mTransitionCount % 2 == 0) {
                        mmiss_phonetics_symbols2++;
                    }
            //        tensu = 0;
                    String key = textView.getText().toString();
                    String value = String.valueOf(id_number);
                    skipintent.putExtra("miss_phonetics_symbols", mmiss_phonetics_symbols);
                    skipintent.putExtra("miss_phonetics_symbols2", mmiss_phonetics_symbols2);
                    skipintent.putExtra("skip_id", skip);
                    skipintent.putExtra(EXTRA_MESSAGE4, str4);
            //        skipintent.putExtra("tensu",tensu);
            //        skipintent.putExtra("sumtensu",msumnumber2);
                    skipintent.putExtra("id_shuffle_message", id_shuffle_array);
                    if (mTransitionCount != 1) {
                        skipintent.putExtra("id_shuffle_message2", id_shuffle_array2);
                    }
                    insertData(db, key,Integer.valueOf(value));
                    startActivity(skipintent);
                    resulttext.setText("");
                }
                else{
                    Intent skipintent2 = new Intent(getApplication(),FinishscreenActivity.class);
                    String str4 = categoryname;
                    skip = 1;
                    if (mTransitionCount % 2 != 0) {
                        mmiss_phonetics_symbols++;
                    }
                    if (mTransitionCount % 2 == 0) {
                        mmiss_phonetics_symbols2++;
                    }
              //      tensu = 0;
                    skipintent2.putExtra("miss_phonetics_symbols",mmiss_phonetics_symbols);
                    skipintent2.putExtra("miss_phonetics_symbols2",mmiss_phonetics_symbols2);
                    skipintent2.putExtra(EXTRA_MESSAGE4,str4);
                    skipintent2.putExtra("skip_id", skip);
                    String key = textView.getText().toString();
                    String value = String.valueOf(id_number);
                    insertData(db, key,Integer.valueOf(value));
             //       skipintent2.putExtra("tensu",tensu);
             //       skipintent2.putExtra("sumtensu",msumnumber2);
                    startActivity(skipintent2);
                }
            }
            //Toast.makeText(getApplicationContext(), reason, Toast.LENGTH_SHORT).show();
            resulttext.setText(reason);
            //      restartListeningService();
        }
        public void onEvent(int eventType, Bundle params) {
        }

        // 部分的な認識結果が利用出来るときに呼ばれる
        // 利用するにはインテントでEXTRA_PARTIAL_RESULTSを指定する必要がある
        public void onPartialResults(Bundle partialResults) {
        }
        public void onReadyForSpeech(Bundle params) {
            resulttext.setText("準備ができています.発声を開始してください!");
            //Toast.makeText(getApplicationContext(), "Let's talk!",
            //        Toast.LENGTH_LONG).show();
        }
        public void onResults(Bundle results) {
            // 結果をArrayListとして取得
            //ArrayList<String> candidates =
            //            data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            //  if(candidates.size() > 0) {
            // 認識結果候補で一番有力なものを表示
            //  textView.setText( candidates.get(0));
            ArrayList<String> results_array = results.getStringArrayList(
                    SpeechRecognizer.RESULTS_RECOGNITION);
            // 取得した文字列を結合
            String resultsString = "";
            for (int i = 0; i < results.size(); i++) {
                resultsString += results_array.get(0) + ";";
            }
            // トーストを使って結果表示
            if (results_array.size() > 0){
                resulttext.setText(results_array.get(0));}
            //Toast.makeText(getApplicationContext(), resultsString, Toast.LENGTH_LONG).show();
            Intent intent5 = new Intent(getApplication(), ResultActivity.class);

            if (resulttext.getText() != null) {
                String str = resulttext.getText().toString();
                intent5.putExtra(EXTRA_MESSAGE, str); //認識結果の単語
            }

            if(textView.getText() != null ){
                String str2 = textView.getText().toString();
                intent5.putExtra(EXTRA_MESSAGE2, str2);//出題単語
                String str3 = textView2.getText().toString();
                intent5.putExtra(EXTRA_MESSAGE3,str3);//出題単語の発音記号
                String str4 = categoryname;
                intent5.putExtra("TransitionCount", mTransitionCount);
                intent5.putExtra("miss_phonetics_symbols",mmiss_phonetics_symbols);
                intent5.putExtra("miss_phonetics_symbols2",mmiss_phonetics_symbols2);
                intent5.putExtra(EXTRA_MESSAGE4,str4);
               // intent5.putExtra("sumtensu",msumnumber2);
                intent5.putExtra("id_bango",id_number);
                intent5.putExtra("id_shuffle_message",id_shuffle_array);
                if( mTransitionCount != 1) {
                    intent5.putExtra("id_shuffle_message2", id_shuffle_array2);
                }
            }

            startActivity(intent5);
            resulttext.setText("");
            //    restartListeningService();
        }
        public void onRmsChanged(float rmsdB) {
        }

    }



}
