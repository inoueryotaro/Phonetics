package com.example.phoneticstest;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.util.HashMap;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] word_omoji = {""};
        final EditText textvi = findViewById(R.id.editText);
        final TextView textvi2 = findViewById(R.id.main_textview);
        final int[] testfile = {-1};
        Button henkan = findViewById(R.id.button3);
        Button next_button = findViewById(R.id.button4);
        henkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableStringBuilder sb = (SpannableStringBuilder) textvi.getText();
                String word = sb.toString();
                word_omoji[0] += word.toUpperCase();
                int testnumber = 0;
                String a = "";
                String b = "";
                if (word_omoji[0].compareTo("ALMENDAREZ") <= 0) {
                    testnumber = 1;
                } else if (word_omoji[0].compareTo("AZZOPARDI") <= 0) {
                    testnumber = 2;
                } else if (word_omoji[0].compareTo("BENDLER") <= 0) {
                    testnumber = 3;
                }
                else if (word_omoji[0].compareTo("BONN") <= 0) {
                    testnumber = 4;
                }
                else if (word_omoji[0].compareTo("BYZANTIUM") <= 0) {
                    testnumber = 5;
                }
                else if (word_omoji[0].compareTo("CHANCELLORS") <= 0) {
                    testnumber = 6;
                }
                else if (word_omoji[0].compareTo("COLLISTER") <= 0) {
                    testnumber = 7;
                }
                else if (word_omoji[0].compareTo("COVELLO") <= 0) {
                    testnumber = 8;
                }
                else if (word_omoji[0].compareTo("CZYZEWSKI") <= 0) {
                    testnumber = 9;
                }
                else if (word_omoji[0].compareTo("DESCENDED") <= 0) {
                    testnumber = 10;
                }
                else if (word_omoji[0].compareTo("DONNELLY'S") <= 0) {
                    testnumber = 11;
                }
                else if (word_omoji[0].compareTo("D_C") <= 0) {
                    testnumber = 12;
                }
                else if (word_omoji[0].compareTo("ERAS") <= 0) {
                    testnumber = 13;
                }
                else if (word_omoji[0].compareTo("EZZO") <= 0) {
                    testnumber = 14;
                }
                else if (word_omoji[0].compareTo("FLUORESCENCE") <= 0) {
                    testnumber = 15;
                }
                else if (word_omoji[0].compareTo("FYODOROV'S") <= 0) {
                    testnumber = 16;
                }
                else if (word_omoji[0].compareTo("GODOT'S") <= 0) {
                    testnumber = 17;
                }
                else if (word_omoji[0].compareTo("GYUHAMA") <= 0) {
                    testnumber = 18;
                }
                else if (word_omoji[0].compareTo("HERBIG") <= 0) {
                    testnumber = 19;
                }
                else if (word_omoji[0].compareTo("HZ") <= 0) {
                    testnumber = 20;
                }
                else if (word_omoji[0].compareTo("IRRAWADDY") <= 0) {
                    testnumber = 21;
                }
                else if (word_omoji[0].compareTo("I_R_A") <= 0) {
                    testnumber = 22;
                }
                else if (word_omoji[0].compareTo("JYNX") <= 0) {
                    testnumber = 23;
                }
                else if (word_omoji[0].compareTo("KONZ") <= 0) {
                    testnumber = 24;
                }
                else if (word_omoji[0].compareTo("KYZER") <= 0) {
                    testnumber = 25;
                }
                else if (word_omoji[0].compareTo("LIDEN") <= 0) {
                    testnumber = 26;
                }
                else if (word_omoji[0].compareTo("LYVERS") <= 0) {
                    testnumber = 27;
                }
                else if (word_omoji[0].compareTo("MAYBELLINE") <= 0) {
                    testnumber = 28;
                }
                else if (word_omoji[0].compareTo("MILAN'S") <= 0) {
                    testnumber = 29;
                }
                else if (word_omoji[0].compareTo("MYUNG") <= 0) {
                    testnumber = 30;
                }
                else if (word_omoji[0].compareTo("N_WORDS") <= 0) {
                    testnumber = 31;
                }
                else if (word_omoji[0].compareTo("OZZY") <= 0) {
                    testnumber = 32;
                }
                else if (word_omoji[0].compareTo("PETZINGER") <= 0) {
                    testnumber = 33;
                }
                else if (word_omoji[0].compareTo("PRECIADO") <= 0) {
                    testnumber = 34;
                }
                else if (word_omoji[0].compareTo("PYXIS") <= 0) {
                    testnumber = 35;
                }
                else if (word_omoji[0].compareTo("QURESHI ") <= 0) {
                    testnumber = 36;
                }
                else if (word_omoji[0].compareTo("REMEDIATE") <= 0) {
                    testnumber = 37;
                }
                else if (word_omoji[0].compareTo("ROMPING") <= 0) {
                    testnumber = 38;
                }
                else if (word_omoji[0].compareTo("RZEPKA") <= 0) {
                    testnumber = 39;
                }
                else if (word_omoji[0].compareTo("SCUTTLING(1)") <= 0) {
                    testnumber = 40;
                }
                else if (word_omoji[0].compareTo("SIEFERT'S") <= 0) {
                    testnumber = 41;
                }
                else if (word_omoji[0].compareTo("SPECTACLES") <= 0) {
                    testnumber = 42;
                }
                else if (word_omoji[0].compareTo("STUFFING") <= 0) {
                    testnumber = 43;
                }
                else if (word_omoji[0].compareTo("SZYMCZAK") <= 0) {
                    testnumber = 44;
                }
                else if (word_omoji[0].compareTo("TOBACK") <= 0) {
                    testnumber = 45;
                }
                else if (word_omoji[0].compareTo("T_A_C(1)") <= 0) {
                    testnumber = 46;
                }
                else if (word_omoji[0].compareTo("U_S_M_C") <= 0) {
                    testnumber = 47;
                }
                else if (word_omoji[0].compareTo("V_S") <= 0) {
                    testnumber = 48;
                }
                else if (word_omoji[0].compareTo("WILLIAMSBURG") <= 0) {
                    testnumber = 49;
                }
                else if (word_omoji[0].compareTo("WYTHE") <= 0) {
                    testnumber = 50;
                }else if (word_omoji[0].compareTo("ZYWICKI") <= 0) {
                    testnumber = 51;
                }else {
                }
                testfile[0] = testnumber;
                InputStream is = null;
                BufferedReader br = null;
                String text = "";
                //textvi2.setText(String.valueOf(testfile[0]));
                //textvi2.setText(String.valueOf(testfile[0]));
                //成功した
                AssetManager as = getResources().getAssets();
                try {
                    try {
                        // assetsフォルダ内の sample.txt をオープンする
                        if (testfile[0] == 1) {
                            is = as.open("dic1.txt");
                          //  textvi2.setText("dic1あけた");

                        } else if (testfile[0] == 2) {
                            is = as.open("dic2.txt");
                          //  textvi2.setText("dic2あけた");
                        } else if (testfile[0] == 3) {
                            is = as.open("dic3.txt");
                          //  textvi2.setText("dic3あけた");
                        } else if (testfile[0] == 4) {
                            is = as.open("dic4.txt");
                        }
                        else if (testfile[0] == 5) {
                            is = as.open("dic5.txt");
                        }
                        else if (testfile[0] == 6) {
                            is = as.open("dic6.txt");
                        }
                        else if (testfile[0] == 7) {
                            is = as.open("dic7.txt");
                        }
                        else if (testfile[0] == 8) {
                            is = as.open("dic8.txt");
                        }
                        else if (testfile[0] == 9) {
                            is = as.open("dic9.txt");
                        }
                        else if (testfile[0] == 10) {
                            is = as.open("dic10.txt");
                        }
                        else if (testfile[0] == 11) {
                            is = as.open("dic11.txt");
                        }
                        else if (testfile[0] == 12) {
                            is = as.open("dic12.txt");
                        }
                        else if (testfile[0] == 13) {
                            is = as.open("dic13.txt");
                        }
                        else if (testfile[0] == 14) {
                            is = as.open("dic14.txt");
                        }
                        else if (testfile[0] == 15) {
                            is = as.open("dic15.txt");
                        }
                        else if (testfile[0] == 16) {
                            is = as.open("dic16.txt");
                        }
                        else if (testfile[0] == 17) {
                            is = as.open("dic17.txt");
                        }
                        else if (testfile[0] == 18) {
                            is = as.open("dic18.txt");
                        }else if (testfile[0] == 19) {
                            is = as.open("dic19.txt");
                        }else if (testfile[0] == 20) {
                            is = as.open("dic20.txt");
                        }
                        else if (testfile[0] == 21) {
                            is = as.open("dic21.txt");
                        }
                        else if (testfile[0] == 22) {
                            is = as.open("dic22.txt");
                        }
                        else if (testfile[0] == 23) {
                            is = as.open("dic23.txt");
                        }
                        else if (testfile[0] == 24) {
                            is = as.open("dic24.txt");
                        }else if (testfile[0] == 25) {
                            is = as.open("dic25.txt");
                        }else if (testfile[0] == 26) {
                            is = as.open("dic26.txt");
                        }else if (testfile[0] == 27) {
                            is = as.open("dic27.txt");
                        }else if (testfile[0] == 28) {
                            is = as.open("dic28.txt");
                        }else if (testfile[0] == 29) {
                            is = as.open("dic29.txt");
                        }else if (testfile[0] == 30) {
                            is = as.open("dic30.txt");
                        }else if (testfile[0] == 31) {
                            is = as.open("dic31.txt");
                        }
                        else if (testfile[0] == 32) {
                            is = as.open("dic32.txt");
                        }
                        else if (testfile[0] == 33) {
                            is = as.open("dic33.txt");
                        }
                        else if (testfile[0] == 34) {
                            is = as.open("dic34.txt");
                        }
                        else if (testfile[0] == 35) {
                            is = as.open("dic35.txt");
                        }
                        else if (testfile[0] == 36) {
                            is = as.open("dic36.txt");
                        }else if (testfile[0] == 37) {
                            is = as.open("dic37.txt");
                        }else if (testfile[0] == 38) {
                            is = as.open("dic38.txt");
                        }else if (testfile[0] == 39) {
                            is = as.open("dic39.txt");
                        }else if (testfile[0] == 40) {
                            is = as.open("dic40.txt");
                        }else if (testfile[0] == 41) {
                            is = as.open("dic41.txt");
                        }else if (testfile[0] == 42) {
                            is = as.open("dic42.txt");
                        }else if (testfile[0] == 43) {
                            is = as.open("dic43.txt");
                        }else if (testfile[0] == 44) {
                            is = as.open("dic44.txt");
                        }else if (testfile[0] == 45) {
                            is = as.open("dic45.txt");
                        }else if (testfile[0] == 46) {
                            is = as.open("dic46.txt");
                        }else if (testfile[0] == 47) {
                            is = as.open("dic47.txt");
                        }else if (testfile[0] == 48) {
                            is = as.open("dic48.txt");
                        }else if (testfile[0] == 49) {
                            is = as.open("dic49.txt");
                        }else if (testfile[0] == 50) {
                            is = as.open("dic50.txt");
                        }
                        else if (testfile[0] == 51) {
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
                            if (str_tango[0].equals(word_omoji[0])) {
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
                //textvi2.setText(text);
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
                            b += map2.get(alphabet[i]);
                        } else {
                        }
                    }
                //b = b.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                //成功
                  textvi2.setText(b);
                  //  if( b.equals("dìɔr")){
                  //      textvi2.setText("正解");
                  //  }
                  //  else{
                  //      textvi2.setText("発音が違います");
                  //  }
                    if( text == ""){
                        textvi2.setText("該当なし");
                    }
                    word_omoji[0] = "";
                }

        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), TestActivity.class);
                    startActivity(intent);


            }
        });
    }
}

