package com.example.phoneticstest;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class EditActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private String spinnerItems[] = {"category1.csv", "category2.csv", "category3.csv", "category4.csv","category5.csv","category6.csv","category7.csv","category8.csv","category9.csv","category10.csv",
            "category11.csv","category12.csv","category13.csv","category14.csv","category15.csv","category16.csv","category17.csv","category18.csv","category19.csv",
            "category20.csv","category21.csv","category22.csv","category23.csv","category24.csv","category25.csv"
    ,"category26.csv","category27.csv","category28.csv","category29.csv","category30.csv"};
    private EditText editText;
    private EditText editText2;
    public static final String EXTRA_MESSAGE
            = "com.example.phoneticstest.EditActivity.MESSAGE";//認識結果の単語
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        textView = findViewById(R.id.kakunin_view);
        textView2 = findViewById(R.id.kakunin_view2);
        editText = findViewById(R.id.edit_text);//id
        editText2 = findViewById(R.id.edit_text2);//単語
        Spinner spinner = findViewById(R.id.spinner);
        // ArrayAdapter
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // リスナーを登録
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String)spinner.getSelectedItem();

                textView.setText(item);
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button savebutton = findViewById(R.id.save);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // エディットテキストのテキストを取得
                String textFile = textView.getText().toString();
                String  id = editText.getText().toString();
                String  mondai_tango = editText2.getText().toString();
                saveFile(textFile, id,mondai_tango);
                Toast.makeText(getApplicationContext(), "ファイルの新規作成or追記しました",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button buttoncreate = findViewById(R.id.create);
        buttoncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textFile = textView.getText().toString();
                String  id = editText.getText().toString();
                String  mondai_tango = editText2.getText().toString();
                String text = "";
                 createFile(textFile, id, mondai_tango);

            }


        });
        Button buttondisplay = findViewById(R.id.display);
        buttondisplay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), ListActivity.class);
                String textFile = textView.getText().toString();
                intent1.putExtra(  EXTRA_MESSAGE,textFile);
                startActivity(intent1);
            }
        });

        Button buttondelete = findViewById(R.id.delete);
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textFile = textView.getText().toString();
                deleteFile(textFile);
                Toast.makeText(getApplicationContext(), "ファイルを削除しました",
                        Toast.LENGTH_SHORT).show();
            }


        });
    }


    // ファイルを保存
    public void saveFile(String file, String id, String  str) {

        // try-with-resources
            String csv = "";
            String id_number;
            String mondai_tango;
            String phonetics_symobols;
            id_number = id;
            mondai_tango = str;
            phonetics_symobols = calculateBmi(mondai_tango);
            csv += id_number +"," + mondai_tango+"," + phonetics_symobols + "\n";

        try{
            FileOutputStream fileOutputStream = openFileOutput(file, MODE_APPEND);
            // String writeString = dIdo + "\n";
            fileOutputStream.write(csv.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createFile(String file, String id, String  str) {

        // try-with-resources
        String csv = "";
        String id_number;
        String mondai_tango;
        String phonetics_symobols;
        id_number = id;
        mondai_tango = str;
        phonetics_symobols = calculateBmi(mondai_tango);
        csv += id_number + "," + mondai_tango + "," + phonetics_symobols + "\n";
        String filePath = "/data/data/com.example.phoneticstest/files/"+file;
        try {
            File mediafile = new File(filePath);
            if (mediafile.exists()) {
                textView2.setText("存在");
            }
            else{
                textView2.setText("なし");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RandomAccessFile raf;
        try	{
            raf	=	new	RandomAccessFile(filePath,	"rw");
            String lineBuffer;
            while((lineBuffer = raf.readLine()) != null){
                //text += lineBuffer;

            }
            raf.seek(0);
            raf.write(csv.getBytes());
            raf.close();
        }	catch	(FileNotFoundException	e)	{
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    // ファイルを読み出し
    public String readFile(String file, String id,String str){
        String text = "";
        //String text2 = null;
        try(FileInputStream fileInputStream = openFileInput(file);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fileInputStream,StandardCharsets.UTF_8)))
        {
        String lineBuffer;
        while((lineBuffer = reader.readLine()) != null){
            text += lineBuffer;
            //String[] search = text.split(",", 0);
            //if( search[0].equals(id) || search[1].equals(str) ){
            //    text2 = lineBuffer;
            //    break;
            //}
            //else{
            //    text2 = "ありませんでした";
            //}
        }
        }catch (IOException e){
            e.printStackTrace();
        }
            return text;
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
                phonetics = phonetics.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");//ゴジラ";
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
}



