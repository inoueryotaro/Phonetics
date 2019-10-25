package com.example.phoneticstest;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public  class TestActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    private SpeechRecognizer sr;
    private static final int REQUEST_CODE = 1000;
    private TextView resulttext;
    private TextView textView2;
    private TextToSpeech tts;
    private TextView textView;
    private static final String TAG = "TestTTS";

    public static final String EXTRA_MESSAGE
            = "com.example.phoneticstest.TestActivity.MESSAGE";//認識結果の単語
    public static final String EXTRA_MESSAGE2
            = "com.example.phoneticstest.TestActivity.MESSAGE2";//出題単語
    public static final String EXTRA_MESSAGE3
            ="com.example.phoneticstest.TestActivity.MESSAGE3";//出題単語の発音記号
    private int mTransitionCount;
    private int mmiss_phonetics_symbols;//前半ブロック
    private int mmiss_phonetics_symbols2;//後半ブロック

    // リストの並びをシャッフルします。

    // シャッフルされたリストの先頭を取得します。


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent1 = getIntent(); //遷移回数データ
        mTransitionCount = intent1.getIntExtra("TransitionCount", 0);
        mTransitionCount++;
        Intent intent2 = getIntent();//ミスの回数
        mmiss_phonetics_symbols = intent2.getIntExtra("miss_phonetics_symbols",0);
        Intent intent3 = getIntent();
        mmiss_phonetics_symbols2 = intent3.getIntExtra("miss_phonetics_symbols2",0);
       // List<Integer> list = new ArrayList<Integer>();
       // List<Integer> list2 = new ArrayList<Integer>();
       // if( mTransitionCount == 1) {
       //     list.add(1);
       //     list.add(2);
       //     list.add(3);
       //     list.add(4);
       //     list.add(5);
       //     list.add(6);
       //     list.add(7);
       //     list.add(8);
       //     list.add(9);
        //    list.add(10);
        //    list2.add(11);
        //    list2.add(12);
        //    list2.add(13);
        //    list2.add(14);
        //    list2.add(15);
        //    list2.add(16);
        //    list2.add(17);
        //    list2.add(18);
        //    list2.add(19);
        //    list2.add(20);
        //    Collections.shuffle(list);
        //    Collections.shuffle(list2);
       // }


            Toast toast = Toast.makeText(this, String.format("遷移した回数：%d", mTransitionCount), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 150);
            toast.show();
            tts = new TextToSpeech(this, this);
            resulttext = findViewById(R.id.textView3);
            textView = findViewById(R.id.textView);
            textView2 = findViewById(R.id.textView8);

            int questionnumber_variable = mTransitionCount;
            if (mTransitionCount <= 10) {
                questionnumber_variable = mTransitionCount;
                //randomメソッドで1以上10未満の整数を生成
            } else {
                questionnumber_variable = mTransitionCount;
            }

            //   Random rand = new Random();
            //    questionnumber_variable = rand.nextInt(20) + 1;
            if (questionnumber_variable == 1) {
                textView.setText(R.string.question_number1);
                textView2.setText(R.string.phonetics_symbols1);
            }
            if (questionnumber_variable == 2) {
                textView.setText(R.string.question_number2);
                textView2.setText(R.string.phonetics_symbols2);
            }
            if (questionnumber_variable == 3) {
                textView.setText(R.string.question_number3);
                textView2.setText(R.string.phonetics_symbols3);
            }
            if (questionnumber_variable == 4) {
                textView.setText(R.string.question_number4);
                textView2.setText(R.string.phonetics_symbols4);
            }
            if (questionnumber_variable == 5) {
                textView.setText(R.string.question_number5);
                textView2.setText(R.string.phonetics_symbols5);
            }
            if (questionnumber_variable == 6
            ) {
                textView.setText(R.string.question_number6);
                textView2.setText(R.string.phonetics_symbols6);
            }
            if (questionnumber_variable == 7) {
                textView.setText(R.string.question_number7);
                textView2.setText(R.string.phonetics_symbols7);
            }
            if (questionnumber_variable == 8) {
                textView.setText(R.string.question_number8);
                textView2.setText(R.string.phonetics_symbols8);
            }
            if (questionnumber_variable == 9) {
                textView.setText(R.string.question_number9);
                textView2.setText(R.string.phonetics_symbols9);
            }
            if (questionnumber_variable == 10) {
                textView.setText(R.string.question_number10);
                textView2.setText(R.string.phonetics_symbols10);
            }
            if (questionnumber_variable == 11) {
                textView.setText(R.string.question_number11);
                textView2.setText(R.string.phonetics_symbols11);
            }
            if (questionnumber_variable == 12) {
                textView.setText(R.string.question_number12);
                textView2.setText(R.string.phonetics_symbols12);
            }
            if (questionnumber_variable == 13) {
                textView.setText(R.string.question_number13);
                textView2.setText(R.string.phonetics_symbols13);
            }
            if (questionnumber_variable == 14) {
                textView.setText(R.string.question_number14);
                textView2.setText(R.string.phonetics_symbols14);
            }
            if (questionnumber_variable == 15) {
                textView.setText(R.string.question_number15);
                textView2.setText(R.string.phonetics_symbols15);
            }
            if (questionnumber_variable == 16) {
                textView.setText(R.string.question_number16);
                textView2.setText(R.string.phonetics_symbols16);
            }
            if (questionnumber_variable == 17) {
                textView.setText(R.string.question_number17);
                textView2.setText(R.string.phonetics_symbols17);
            }
            if (questionnumber_variable == 18) {
                textView.setText(R.string.question_number18);
                textView2.setText(R.string.phonetics_symbols18);
            }
            if (questionnumber_variable == 19) {
                textView.setText(R.string.question_number19);
                textView2.setText(R.string.phonetics_symbols19);
            }
            if (questionnumber_variable == 20) {
                textView.setText(R.string.question_number20);
                textView2.setText(R.string.phonetics_symbols20);
            }

        Button speakingbutton = (Button) findViewById(R.id.speakingbutton);
        speakingbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                speech();
            }
        });

        Button ttsButton = findViewById(R.id.readbutton);
        ttsButton.setOnClickListener(this);

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
            setSpeechRate(0.7f);
            setSpeechPitch(0.7f);

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
            /*Toast.makeText(getApplicationContext(), "onBeginningofSpeech",
                    Toast.LENGTH_SHORT).show();*/
        }
        public void onBufferReceived(byte[] buffer) {
        }
        public void onEndOfSpeech() {
            /*Toast.makeText(getApplicationContext(), "onEndofSpeech",
                    Toast.LENGTH_SHORT).show();*/
        }
        public void onError(int error) {
            String reason = "";
            switch (error) {
                // Audio recording error
                case SpeechRecognizer.ERROR_AUDIO:
                    reason = "ERROR_AUDIO";
                    break;
                // Other client side errors
                case SpeechRecognizer.ERROR_CLIENT:
                    reason = "ERROR_CLIENT";
                    break;
                // Insufficient permissions
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    reason = "ERROR_INSUFFICIENT_PERMISSIONS";
                    break;
                // 	Other network related errors
                case SpeechRecognizer.ERROR_NETWORK:
                    reason = "ERROR_NETWORK";
                    /* ネットワーク接続をチェックする処理をここに入れる */
                    break;
                // Network operation timed out
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    reason = "ERROR_NETWORK_TIMEOUT";
                    break;
                // No recognition result matched
                case SpeechRecognizer.ERROR_NO_MATCH:
                    reason = "ERROR_NO_MATCH";
                    break;
                // RecognitionService busy
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    reason = "ERROR_RECOGNIZER_BUSY";
                    break;
                // Server sends error status
                case SpeechRecognizer.ERROR_SERVER:
                    reason = "ERROR_SERVER";
                    /* ネットワーク接続をチェックをする処理をここに入れる */
                    break;
                // No speech input
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    reason = "ERROR_SPEECH_TIMEOUT";
                    break;
            }
            Toast.makeText(getApplicationContext(), reason, Toast.LENGTH_SHORT).show();
            //      restartListeningService();
        }
        public void onEvent(int eventType, Bundle params) {
        }

        // 部分的な認識結果が利用出来るときに呼ばれる
        // 利用するにはインテントでEXTRA_PARTIAL_RESULTSを指定する必要がある
        public void onPartialResults(Bundle partialResults) {
        }
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getApplicationContext(), "話してください",
                    Toast.LENGTH_SHORT).show();
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
                resultsString += results_array.get(i) + ";";
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
                intent5.putExtra("TransitionCount", mTransitionCount);
                intent5.putExtra("miss_phonetics_symbols",mmiss_phonetics_symbols);
                intent5.putExtra("miss_phonetics_symbols2",mmiss_phonetics_symbols2);
            }
            startActivity(intent5);
            resulttext.setText("");
            //    restartListeningService();
        }
        public void onRmsChanged(float rmsdB) {
        }

    }



}
