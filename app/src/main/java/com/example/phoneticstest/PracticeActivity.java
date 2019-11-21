package com.example.phoneticstest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class PracticeActivity extends AppCompatActivity {

    private int zenhan_count;
    private int kohan_count;
    private int type_of_mistake;
    private String category_name;
    private String nigate_word;
    private TextView nigate_phonetics_text;
    private TextView seiko_count_text;
    private TextView concrete_tango_text;
    private TextView nigate_phonetics_text2;
    private TextView seiko_count_text2;
    private TextView concrete_tango_text2;
    private TextView gutairei_text;
    private TextView gutairei_text2;
    private MediaPlayer mediaPlayer=null;
    private TextView textView;
    private TestOpenHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Intent intent = getIntent();
        zenhan_count =intent.getIntExtra("miss_zenhan",0);
        Intent intent2 = getIntent();
        kohan_count = intent2.getIntExtra("miss_kohan",0);
        Intent intent3 = getIntent();
        type_of_mistake = intent3.getIntExtra("type_mistake",0);
        Intent intent4 = getIntent();
        category_name = intent4.getStringExtra(WeakActivity.CATEGORY_MESSAGE);
      //  Intent intent5 = getIntent();
      //  nigate_word = intent5.getStringExtra(WeakActivity.NIGATE_MESSAGE);
        nigate_phonetics_text = findViewById(R.id.nigate_phonetic_text);
        seiko_count_text = findViewById(R.id.seiko_count_text);
        concrete_tango_text = findViewById(R.id.concrete_tango_text);
        nigate_phonetics_text2 = findViewById(R.id.nigate_phonetic_text2);
        seiko_count_text2 = findViewById(R.id.seiko_count_text2);
        concrete_tango_text2 = findViewById(R.id.concrete_tango_text2);
        gutairei_text = findViewById(R.id.gutairei_text);
        gutairei_text2 = findViewById(R.id.gutairei_text2);
        Button RegenerationStart = findViewById(R.id.saisei_button);
        Button RegenerationStart2 = findViewById(R.id.saisei_button2);
        Button RegenerationStart3 = findViewById(R.id.saisei_button3);
        Button RegenerationStart4 = findViewById(R.id.saisei_button4);

        readData(type_of_mistake);
        if( type_of_mistake == 3 || type_of_mistake == 1 || type_of_mistake == 2) {
            if (category_name.equals("category1.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("come.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("cup.mp3");
                    }
                });

                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("about.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("away.mp3");
                    }
                });
            } else if (category_name.equals("category2.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("hot.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("stop.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("bag.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("cat.mp3");
                    }
                });
            } else if (category_name.equals("category3.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("eat.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("key.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("in.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("sit.mp3");
                    }
                });
            } else if (category_name.equals("category4.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("look.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("good.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("do.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("soon.mp3");
                    }
                });
            } else if (category_name.equals("category5.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("any.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("test.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("in.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("sit.mp3");
                    }
                });
            } else if (category_name.equals("category6.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("dog.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("small.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("go.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("know.mp3");
                    }
                });
            } else if (category_name.equals("category7.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("city.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("see.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("easy.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("size.mp3");
                    }
                });
            } else if (category_name.equals("category8.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("she.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sure.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("vision.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("measure.mp3");
                    }
                });
            } else if (category_name.equals("category9.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("think.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("mouth.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("the.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("there.mp3");
                    }
                });
            } else if (category_name.equals("category10.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("for.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("safe.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("very.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("have.mp3");
                    }
                });
            } else if (category_name.equals("category11.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("like.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("listen.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("right.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("carry.mp3");
                    }
                });
            } else if (category_name.equals("category12.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("tea.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("take.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("day.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("dinner.mp3");
                    }
                });
            } else if (category_name.equals("category14.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("kind.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("like.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("big.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("gift.mp3");
                    }
                });
            } else if (category_name.equals("category15.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("teach.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("chair.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("age.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("join.mp3");
                    }
                });
            } else if (category_name.equals("category16.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("many.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("mind.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("new.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("name.mp3");
                    }
                });
            } else if (category_name.equals("category17.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("for.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("safe.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("he.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("high.mp3");
                    }
                });
            } else if (category_name.equals("category18.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("we.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("way.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("very.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("have.mp3");
                    }
                });
            } else if (category_name.equals("category19.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("thing.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sing.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("new.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("name.mp3");
                    }
                });
            } else if (category_name.equals("category20.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("in.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sit.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("you.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("yet.mp3");
                    }
                });
            } else if (category_name.equals("category21.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("mine.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("by.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("say.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("wait.mp3");
                    }
                });
            } else if (category_name.equals("category22.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("mine.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("by.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("boy.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("point.mp3");
                    }
                });
            } else if (category_name.equals("category23.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("out.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("down.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("go.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("know.mp3");
                    }
                });
            } else if (category_name.equals("category24.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("after.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("better.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("right.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("carry.mp3");
                    }
                });
            } else if (category_name.equals("category13.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("put.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("paper.mp3");
                    }
                });
                RegenerationStart3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("but.mp3");
                    }
                });
                RegenerationStart4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("baby.mp3");
                    }
                });
            } else {

            }
        }
 /*        if( type_of_mistake == 1) {
            if (category_name.equals("category1.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("come.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("cup.mp3");
                    }
                });
            }
            else if (category_name.equals("category2.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("hot.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("stop.mp3");
                    }
                });

            }
            else if (category_name.equals("category3.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("eat.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("key.mp3");
                    }
                });

            }
            else if (category_name.equals("category4.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("look.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("good.mp3");
                    }
                });

            }
            else if (category_name.equals("category5.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("any.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("test.mp3");
                    }
                });

            }
            else if (category_name.equals("category6.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("dog.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("small.mp3");
                    }
                });

            }
            else if (category_name.equals("category7.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("city.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("see.mp3");
                    }
                });

            }
            else if (category_name.equals("category8.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("she.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sure.mp3");
                    }
                });

            }
            else if (category_name.equals("category9.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("think.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("mouth.mp3");
                    }
                });

            }
            else if (category_name.equals("category10.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("for.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("safe.mp3");
                    }
                });

            }
            else if (category_name.equals("category11.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("like.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("listen.mp3");
                    }
                });

            }
            else if (category_name.equals("category12.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("tea.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("take.mp3");
                    }
                });

            }
            else if (category_name.equals("category13.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("put.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("paper.mp3");
                    }
                });

            }
            else if (category_name.equals("category14.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("kind.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("like.mp3");
                    }
                });

            }
            else if (category_name.equals("category15.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("teach.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("chair.mp3");
                    }
                });

            } else if (category_name.equals("category16.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("many.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("mind.mp3");
                    }
                });

            }
            else if (category_name.equals("category17.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("for.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("safe.mp3");
                    }
                });

            }
            else if (category_name.equals("category18.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("we.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("way.mp3");
                    }
                });

            }
            else if (category_name.equals("category19.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("thing.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sing.mp3");
                    }
                });

            }
            else if (category_name.equals("category20.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("in.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sit.mp3");
                    }
                });

            }
            else if (category_name.equals("category21.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("mine.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("by.mp3");
                    }
                });

            }
            else if (category_name.equals("category22.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("mine.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("by.mp3");
                    }
                });

            }
            else if (category_name.equals("category23.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("out.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("down.mp3");
                    }
                });

            } else if (category_name.equals("category24.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("after.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("better.mp3");
                    }
                });

            }
            else{

            }

        }
         if ( type_of_mistake == 2){
            if( category_name.equals("category.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("about.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("away.mp3");
                    }
                });
            }
             else if( category_name.equals("category2.csv")) {
                 RegenerationStart.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         // 音楽再生
                         audioPlay("bag.mp3");
                     }
                 });
                 RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         audioPlay("cat.mp3");
                     }
                 });
             }
            else if( category_name.equals("category3.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("in.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sit.mp3");
                    }
                });
            }
            else if( category_name.equals("category4.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("do.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("soon.mp3");
                    }
                });
            }
            else if( category_name.equals("category5.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("in.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("sit.mp3");
                    }
                });
            }
            else if( category_name.equals("category6.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("go.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("know.mp3");
                    }
                });
            }
            else if( category_name.equals("category7.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("easy.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("size.mp3");
                    }
                });
            }
            else if( category_name.equals("category8.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("vision.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("measure.mp3");
                    }
                });
            }
            else if( category_name.equals("category9.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("the.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("there.mp3");
                    }
                });
            }
            else if( category_name.equals("category10.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("very.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("have.mp3");
                    }
                });
            }
            else if( category_name.equals("category11.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("right.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("carry.mp3");
                    }
                });
            }
            else if( category_name.equals("category12.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("day.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("dinner.mp3");
                    }
                });
            }
            else if( category_name.equals("category13.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("but.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("baby.mp3");
                    }
                });
            }
            else if( category_name.equals("category14.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("big.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("gift.mp3");
                    }
                });
            }
            else if( category_name.equals("category15.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("age.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("join.mp3");
                    }
                });
            }
            else if( category_name.equals("category16.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("new.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("name.mp3");
                    }
                });
            }
            else if( category_name.equals("category17.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("he.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("high.mp3");
                    }
                });
            }
            else if( category_name.equals("category18.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("very.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("have.mp3");
                    }
                });
            }
            else if( category_name.equals("category19.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("new.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("name.mp3");
                    }
                });
            }
            else if( category_name.equals("category20.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("you.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("yet.mp3");
                    }
                });
            }
            else if( category_name.equals("category21.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("say.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("wait.mp3");
                    }
                });
            }
            else if( category_name.equals("category22.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("boy.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("point.mp3");
                    }
                });
            }
            else if( category_name.equals("category23.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("go.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("know.mp3");
                    }
                });
            }
            else if( category_name.equals("category24.csv")) {
                RegenerationStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 音楽再生
                        audioPlay("right.mp3");
                    }
                });
                RegenerationStart2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioPlay("carry.mp3");
                    }
                });
            }
            else{

            }
         }
        if(type_of_mistake !=  3) {
            RegenerationStart3.setVisibility(View.GONE);
        }
        if( type_of_mistake != 3) {
            RegenerationStart4.setVisibility(View.GONE);
        }
*/
     /*   if( type_of_mistake == 1) {
            if (category_name.equals("category1.csv")) {
                nigate_phonetics_text.setText("[ʌ]");
                gutairei_text.setText("ex)come[kʌm]"+"\n"+"     cup[kʌp]");
            } else if (category_name.equals("category2.csv")) {
                nigate_phonetics_text.setText("[ɑ]");
                gutairei_text.setText("ex)hot[hɑt]"+"\n"+"     stop[stɑp]");
            } else if (category_name.equals("category3.csv")) {
                nigate_phonetics_text.setText("[i]");
                gutairei_text.setText("ex)eat[it]"+"\n"+"     key[ki]");
            } else if (category_name.equals("category4.csv")) {
                nigate_phonetics_text.setText("[ʊ]");
                gutairei_text.setText("ex)look[lʊk]"+"\n"+"     good[gʊd]");
            } else if (category_name.equals("category5.csv")) {
                nigate_phonetics_text.setText("[e]");
                gutairei_text.setText("ex)any[eni]"+"\n"+"     test[test]");
            } else if (category_name.equals("category6.csv")) {
                nigate_phonetics_text.setText("[ɔ]");
                gutairei_text.setText("ex)dog[dɔg]"+"\n"+"     small[smɔl]");
            } else if (category_name.equals("category7.csv")) {
                nigate_phonetics_text.setText("[s]");
                gutairei_text.setText("ex)city[sɪti]"+"\n"+"     see[si]");
            } else if (category_name.equals("category8.csv")) {
                nigate_phonetics_text.setText("[ʃ]");
                gutairei_text.setText("ex)she[ʃi]"+"\n"+"     sure[ʃʊr]");
            } else if (category_name.equals("category9.csv")) {
                nigate_phonetics_text.setText("[θ]");
                gutairei_text.setText("ex)think[θɪŋk]"+"\n"+"     mouth[maʊθ]");
            } else if (category_name.equals("category10.csv")) {
                nigate_phonetics_text.setText("[f]");
                gutairei_text.setText("ex)for[fɔr]"+"\n"+"     safe[seɪf]");
            } else if (category_name.equals("category11.csv")) {
                nigate_phonetics_text.setText("[l]");
                gutairei_text.setText("ex)like[laɪk]"+"\n"+"     listen[lɪsʌn]");
            } else if (category_name.equals("category12.csv")) {
                nigate_phonetics_text.setText("[t]");
                gutairei_text.setText("ex)tea[ti]"+"\n"+"     take[teɪk]");
            } else if (category_name.equals("category13.csv")) {
                nigate_phonetics_text.setText("[p]");
                gutairei_text.setText("ex)put[pʊt]"+"\n"+"     paper[peɪpɜr]");
            } else if (category_name.equals("category14.csv")) {
                nigate_phonetics_text.setText("[k]");
                gutairei_text.setText("ex)kind[kaɪnd]"+"\n"+"     like[laɪk]");
            } else if (category_name.equals("category15.csv")) {
                nigate_phonetics_text.setText("[tʃ]");
                gutairei_text.setText("ex)teach[titʃ]"+"\n"+"     chair[tʃer]");
            } else if (category_name.equals("category16.csv")) {
                nigate_phonetics_text.setText("[m]");
                gutairei_text.setText("ex)many[meni]"+"\n"+"     mind[maɪnd]");
            } else if (category_name.equals("category17.csv")) {
                nigate_phonetics_text.setText("[f]");
                gutairei_text.setText("ex)for[fɔr]"+"\n"+"     safe[seɪf]");
            } else if (category_name.equals("category18.csv")) {
                nigate_phonetics_text.setText("[w]");
                gutairei_text.setText("ex)we[wi]"+"\n"+"     way[weɪ]");
            } else if (category_name.equals("category19.csv")) {
                nigate_phonetics_text.setText("[ŋ]");
                gutairei_text.setText("ex)thing[θɪŋ]"+"\n"+"     sing[sɪŋ]");
            } else if (category_name.equals("category20.csv")) {
                nigate_phonetics_text.setText("[ɪ]");
                gutairei_text.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
            } else if (category_name.equals("category21.csv")) {
                nigate_phonetics_text.setText("[aɪ]");
                gutairei_text.setText("ex)mine[maɪn]"+"\n"+"     by[baɪ]");
            } else if (category_name.equals("category22.csv")) {
                nigate_phonetics_text.setText("[aɪ]");
                gutairei_text.setText("ex)mine[maɪn]"+"\n"+"     by[baɪ]");
            } else if (category_name.equals("category23.csv")) {
                nigate_phonetics_text.setText("[aʊ]");
                gutairei_text.setText("ex)out[aʊt]"+"\n"+"     down[daʊn]");
            } else if (category_name.equals("category24.csv")) {
                nigate_phonetics_text.setText("[ɜr]");
                gutairei_text.setText("ex)after[æftɜr]"+"\n"+"     better[betɜr]");
            } else {

            }
            if (category_name.equals("category1.csv")) {
                nigate_phonetics_text2.setText("[ə]");
                gutairei_text.setText("ex)about[əbaʊt]"+"\n"+"     away[əweɪ]");
            } else if (category_name.equals("category2.csv")) {
                nigate_phonetics_text2.setText("[æ]");
                gutairei_text.setText("ex)bag[bæg]"+"\n"+"     cat[kæt]");
            } else if (category_name.equals("category3.csv")) {
                nigate_phonetics_text2.setText("[ɪ]");
                gutairei_text.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
            } else if (category_name.equals("category4.csv")) {
                nigate_phonetics_text2.setText("[u]");
                gutairei_text.setText("ex)do[du]"+"\n"+"     soon[sun]");
            } else if (category_name.equals("category5.csv")) {
                nigate_phonetics_text2.setText("[ɪ]");
                gutairei_text.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
            } else if (category_name.equals("category6.csv")) {
                nigate_phonetics_text2.setText("[oʊ]");
                gutairei_text.setText("ex)go[goʊ]"+"\n"+"     know[noʊ]");
            } else if (category_name.equals("category7.csv")) {
                nigate_phonetics_text2.setText("[z]");
                gutairei_text.setText("ex)eazy[izi]"+"\n"+"     size[saɪz]");
            } else if (category_name.equals("category8.csv")) {
                nigate_phonetics_text2.setText("[ʒ]");
                gutairei_text.setText("ex)vision[vɪʒʌn]"+"\n"+"     measure[meʒɜr]");
            } else if (category_name.equals("category9.csv")) {
                nigate_phonetics_text2.setText("[ð]");
                gutairei_text.setText("ex)the[ðʌ]"+"\n"+"     there[ðer]");
            } else if (category_name.equals("category10.csv")) {
                nigate_phonetics_text2.setText("[v]");
                gutairei_text.setText("ex)very[veri]"+"\n"+"     have[hæv]");
            } else if (category_name.equals("category11.csv")) {
                nigate_phonetics_text2.setText("[r]");
                gutairei_text.setText("ex)right[raɪt]"+"\n"+"     carry[kæri]");
            } else if (category_name.equals("category12.csv")) {
                nigate_phonetics_text2.setText("[d]");
                gutairei_text.setText("ex)day[deɪ]"+"\n"+"     dinner[dɪnɜr]");
            } else if (category_name.equals("category13.csv")) {
                nigate_phonetics_text2.setText("[b]");
                gutairei_text.setText("ex)but[bʌt]"+"\n"+"     baby[beɪbi]");
            } else if (category_name.equals("category14.csv")) {
                nigate_phonetics_text2.setText("[g]");
                gutairei_text.setText("ex)big[bɪg]"+"\n"+"     gift[gɪft]");
            } else if (category_name.equals("category15.csv")) {
                nigate_phonetics_text2.setText("[dʒ]");
                gutairei_text.setText("ex)age[eɪdʒ]"+"\n"+"     join[dʒɪn]");
            } else if (category_name.equals("category16.csv")) {
                nigate_phonetics_text2.setText("[n]");
                gutairei_text.setText("ex)new[nu]"+"\n"+"     name[neɪm]");
            } else if (category_name.equals("category17.csv")) {
                nigate_phonetics_text2.setText("[h]");
                gutairei_text.setText("ex)he[hi]"+"\n"+"     high[haɪ]");
            } else if (category_name.equals("category18.csv")) {
                nigate_phonetics_text2.setText("[v]");
                gutairei_text.setText("ex)very[veri]"+"\n"+"     have[hæv]");
            } else if (category_name.equals("category19.csv")) {
                nigate_phonetics_text2.setText("[n]");
                gutairei_text.setText("ex)new[nu]"+"\n"+"     name[neɪm]");
            } else if (category_name.equals("category20.csv")) {
                nigate_phonetics_text2.setText("[j]");
                gutairei_text.setText("ex)you[ju]"+"\n"+"     yet[jet]");
            } else if (category_name.equals("category21.csv")) {
                nigate_phonetics_text2.setText("[eɪ]");
                gutairei_text.setText("ex)say[seɪ]"+"\n"+"     wait[weɪt]");
            } else if (category_name.equals("category22.csv")) {
                nigate_phonetics_text2.setText("[ɔɪ]");
                gutairei_text.setText("ex)boy[bɔɪ]"+"\n"+"     point[pɔɪnt]");
            } else if (category_name.equals("category23.csv")) {
                nigate_phonetics_text2.setText("[oʊ]");
                gutairei_text.setText("ex)go[goʊ]"+"\n"+"     know[noʊ]");
            } else if (category_name.equals("category24.csv")) {
                nigate_phonetics_text2.setText("[r]");
                gutairei_text.setText("ex)right[raɪt]"+"\n"+"     carry[kæri]");
            } else {

            }
            if( zenhan_count == 0){
                seiko_count_text.setText("10回中10回発音成功");
            }
            else if( zenhan_count == 1){
                seiko_count_text.setText("10回中9回発音成功");
            } else if( zenhan_count == 2){
                seiko_count_text.setText("10回中8回発音成功");
            } else if( zenhan_count == 3){
                seiko_count_text.setText("10回中7回発音成功");
            } else if( zenhan_count == 4){
                seiko_count_text.setText("10回中6回発音成功");
            } else if( zenhan_count == 5){
                seiko_count_text.setText("10回中5回発音成功");
            } else if( zenhan_count == 6){
                seiko_count_text.setText("10回中4回発音成功");
            } else if( zenhan_count == 7){
                seiko_count_text.setText("10回中3回発音成功");
            } else if( zenhan_count == 8){
                seiko_count_text.setText("10回中2回発音成功");
            } else if( zenhan_count == 9){
                seiko_count_text.setText("10回中1回発音成功");
            }
            else{
                seiko_count_text.setText("10回中すべて発音失敗");
            }
            if( kohan_count == 0){
                seiko_count_text2.setText("10回中10回発音成功");
            }
            else if( kohan_count == 1){
                seiko_count_text2.setText("10回中9回発音成功");
            } else if( kohan_count == 2){
                seiko_count_text2.setText("10回中8回発音成功");
            } else if( kohan_count == 3){
                seiko_count_text2.setText("10回中7回発音成功");
            } else if(kohan_count == 4){
                seiko_count_text2.setText("10回中6回発音成功");
            } else if( kohan_count== 5){
                seiko_count_text2.setText("10回中5回発音成功");
            } else if( kohan_count == 6){
                seiko_count_text2.setText("10回中4回発音成功");
            } else if( kohan_count == 7){
                seiko_count_text2.setText("10回中3回発音成功");
            } else if( kohan_count == 8){
                seiko_count_text2.setText("10回中2回発音成功");
            } else if( kohan_count == 9){
                seiko_count_text2.setText("10回中1回発音成功");
            }
            else{
                seiko_count_text2.setText("10回中すべて発音失敗");
            }



        }
        //concrete_tango_text.setText(nigate_word);
            if( type_of_mistake == 2){
                if (category_name.equals("category1.csv")) {
                    nigate_phonetics_text.setText("[ʌ]");
                    gutairei_text.setText("ex)come[kʌm]"+"\n"+"     cup[kʌp]");
                } else if (category_name.equals("category2.csv")) {
                    nigate_phonetics_text.setText("[ɑ]");
                    gutairei_text.setText("ex)hot[hɑt]"+"\n"+"     stop[stɑp]");
                } else if (category_name.equals("category3.csv")) {
                    nigate_phonetics_text.setText("[i]");
                    gutairei_text.setText("ex)eat[it]"+"\n"+"     key[ki]");
                } else if (category_name.equals("category4.csv")) {
                    nigate_phonetics_text.setText("[ʊ]");
                    gutairei_text.setText("ex)look[lʊk]"+"\n"+"     good[gʊd]");
                } else if (category_name.equals("category5.csv")) {
                    nigate_phonetics_text.setText("[e]");
                    gutairei_text.setText("ex)any[eni]"+"\n"+"     test[test]");
                } else if (category_name.equals("category6.csv")) {
                    nigate_phonetics_text.setText("[ɔ]");
                    gutairei_text.setText("ex)dog[dɔg]"+"\n"+"     small[smɔl]");
                } else if (category_name.equals("category7.csv")) {
                    nigate_phonetics_text.setText("[s]");
                    gutairei_text.setText("ex)city[sɪti]"+"\n"+"     see[si]");
                } else if (category_name.equals("category8.csv")) {
                    nigate_phonetics_text.setText("[ʃ]");
                    gutairei_text.setText("ex)she[ʃi]"+"\n"+"     sure[ʃʊr]");
                } else if (category_name.equals("category9.csv")) {
                    nigate_phonetics_text.setText("[θ]");
                    gutairei_text.setText("ex)think[θɪŋk]"+"\n"+"     mouth[maʊθ]");
                } else if (category_name.equals("category10.csv")) {
                    nigate_phonetics_text.setText("[f]");
                    gutairei_text.setText("ex)for[fɔr]"+"\n"+"     safe[seɪf]");
                } else if (category_name.equals("category11.csv")) {
                    nigate_phonetics_text.setText("[l]");
                    gutairei_text.setText("ex)like[laɪk]"+"\n"+"     listen[lɪsʌn]");
                } else if (category_name.equals("category12.csv")) {
                    nigate_phonetics_text.setText("[t]");
                    gutairei_text.setText("ex)tea[ti]"+"\n"+"     take[teɪk]");
                } else if (category_name.equals("category13.csv")) {
                    nigate_phonetics_text.setText("[p]");
                    gutairei_text.setText("ex)put[pʊt]"+"\n"+"     paper[peɪpɜr]");
                } else if (category_name.equals("category14.csv")) {
                    nigate_phonetics_text.setText("[k]");
                    gutairei_text.setText("ex)kind[kaɪnd]"+"\n"+"     like[laɪk]");
                } else if (category_name.equals("category15.csv")) {
                    nigate_phonetics_text.setText("[tʃ]");
                    gutairei_text.setText("ex)teach[titʃ]"+"\n"+"     chair[tʃer]");
                } else if (category_name.equals("category16.csv")) {
                    nigate_phonetics_text.setText("[m]");
                    gutairei_text.setText("ex)many[meni]"+"\n"+"     mind[maɪnd]");
                } else if (category_name.equals("category17.csv")) {
                    nigate_phonetics_text.setText("[f]");
                    gutairei_text.setText("ex)for[fɔr]"+"\n"+"     safe[seɪf]");
                } else if (category_name.equals("category18.csv")) {
                    nigate_phonetics_text.setText("[w]");
                    gutairei_text.setText("ex)we[wi]"+"\n"+"     way[weɪ]");
                } else if (category_name.equals("category19.csv")) {
                    nigate_phonetics_text.setText("[ŋ]");
                    gutairei_text.setText("ex)thing[θɪŋ]"+"\n"+"     sing[sɪŋ]");
                } else if (category_name.equals("category20.csv")) {
                    nigate_phonetics_text.setText("[ɪ]");
                    gutairei_text.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category21.csv")) {
                    nigate_phonetics_text.setText("[aɪ]");
                    gutairei_text.setText("ex)mine[maɪn]"+"\n"+"     by[baɪ]");
                } else if (category_name.equals("category22.csv")) {
                    nigate_phonetics_text.setText("[aɪ]");
                    gutairei_text.setText("ex)mine[maɪn]"+"\n"+"     by[baɪ]");
                } else if (category_name.equals("category23.csv")) {
                    nigate_phonetics_text.setText("[aʊ]");
                    gutairei_text.setText("ex)out[aʊt]"+"\n"+"     down[daʊn]");
                } else if (category_name.equals("category24.csv")) {
                    nigate_phonetics_text.setText("[ɜr]");
                    gutairei_text.setText("ex)after[æftɜr]"+"\n"+"     better[betɜr]");
                } else {

                }
                if (category_name.equals("category1.csv")) {
                    nigate_phonetics_text2.setText("[ə]");
                    gutairei_text2.setText("ex)about[əbaʊt]"+"\n"+"     away[əweɪ]");
                } else if (category_name.equals("category2.csv")) {
                    nigate_phonetics_text2.setText("[æ]");
                    gutairei_text2.setText("ex)bag[bæg]"+"\n"+"     cat[kæt]");
                } else if (category_name.equals("category3.csv")) {
                    nigate_phonetics_text2.setText("[ɪ]");
                    gutairei_text2.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category4.csv")) {
                    nigate_phonetics_text2.setText("[u]");
                    gutairei_text2.setText("ex)do[du]"+"\n"+"     soon[sun]");
                } else if (category_name.equals("category5.csv")) {
                    nigate_phonetics_text2.setText("[ɪ]");
                    gutairei_text2.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category6.csv")) {
                    nigate_phonetics_text2.setText("[oʊ]");
                    gutairei_text2.setText("ex)go[goʊ]"+"\n"+"     know[noʊ]");
                } else if (category_name.equals("category7.csv")) {
                    nigate_phonetics_text2.setText("[z]");
                    gutairei_text2.setText("ex)eazy[izi]"+"\n"+"     size[saɪz]");
                } else if (category_name.equals("category8.csv")) {
                    nigate_phonetics_text2.setText("[ʒ]");
                    gutairei_text2.setText("ex)vision[vɪʒʌn]"+"\n"+"     measure[meʒɜr]");
                } else if (category_name.equals("category9.csv")) {
                    nigate_phonetics_text2.setText("[ð]");
                    gutairei_text2.setText("ex)the[ðʌ]"+"\n"+"     there[ðer]");
                } else if (category_name.equals("category10.csv")) {
                    nigate_phonetics_text2.setText("[v]");
                    gutairei_text2.setText("ex)very[veri]"+"\n"+"     have[hæv]");
                } else if (category_name.equals("category11.csv")) {
                    nigate_phonetics_text.setText("[r]");
                    gutairei_text.setText("ex)right[raɪt]"+"\n"+"     carry[kæri]");
                } else if (category_name.equals("category12.csv")) {
                    nigate_phonetics_text.setText("[d]");
                    gutairei_text.setText("ex)day[deɪ]"+"\n"+"     dinner[dɪnɜr]");
                } else if (category_name.equals("category13.csv")) {
                    nigate_phonetics_text.setText("[b]");
                    gutairei_text.setText("ex)but[bʌt]"+"\n"+"     baby[beɪbi]");
                } else if (category_name.equals("category14.csv")) {
                    nigate_phonetics_text.setText("[g]");
                    gutairei_text.setText("ex)big[bɪg]"+"\n"+"     gift[gɪft]");
                } else if (category_name.equals("category15.csv")) {
                    nigate_phonetics_text.setText("[dʒ]");
                    gutairei_text.setText("ex)age[eɪdʒ]"+"\n"+"     join[dʒɪn]");
                } else if (category_name.equals("category16.csv")) {
                    nigate_phonetics_text.setText("[n]");
                    gutairei_text.setText("ex)new[nu]"+"\n"+"     name[neɪm]");
                } else if (category_name.equals("category17.csv")) {
                    nigate_phonetics_text.setText("[h]");
                    gutairei_text.setText("ex)he[hi]"+"\n"+"     high[haɪ]");
                } else if (category_name.equals("category18.csv")) {
                    nigate_phonetics_text.setText("[v]");
                    gutairei_text.setText("ex)very[veri]"+"\n"+"     have[hæv]");
                } else if (category_name.equals("category19.csv")) {
                    nigate_phonetics_text.setText("[n]");
                    gutairei_text.setText("ex)new[nu]"+"\n"+"     name[neɪm]");
                } else if (category_name.equals("category20.csv")) {
                    nigate_phonetics_text.setText("[j]");
                    gutairei_text.setText("ex)you[ju]"+"\n"+"     yet[jet]");
                } else if (category_name.equals("category21.csv")) {
                    nigate_phonetics_text.setText("[eɪ]");
                    gutairei_text.setText("ex)say[seɪ]"+"\n"+"     wait[weɪt]");
                } else if (category_name.equals("category22.csv")) {
                    nigate_phonetics_text.setText("[ɔɪ]");
                    gutairei_text.setText("ex)boy[bɔɪ]"+"\n"+"     point[pɔɪnt]");
                } else if (category_name.equals("category23.csv")) {
                    nigate_phonetics_text.setText("[oʊ]");
                    gutairei_text.setText("ex)go[goʊ]"+"\n"+"     know[noʊ]");
                } else if (category_name.equals("category24.csv")) {
                    nigate_phonetics_text.setText("[r]");
                    gutairei_text.setText("ex)right[raɪt]"+"\n"+"     carry[kæri]");
                } else {

                }
                if( kohan_count == 0){
                    seiko_count_text.setText("10回中10回発音成功");
                }
                else if( kohan_count == 1){
                    seiko_count_text.setText("10回中9回発音成功");
                } else if( kohan_count == 2){
                    seiko_count_text.setText("10回中8回発音成功");
                } else if( kohan_count == 3){
                    seiko_count_text.setText("10回中7回発音成功");
                } else if(kohan_count == 4){
                    seiko_count_text.setText("10回中6回発音成功");
                } else if( kohan_count== 5){
                    seiko_count_text.setText("10回中5回発音成功");
                } else if( kohan_count == 6){
                    seiko_count_text.setText("10回中4回発音成功");
                } else if( kohan_count == 7){
                    seiko_count_text.setText("10回中3回発音成功");
                } else if( kohan_count == 8){
                    seiko_count_text.setText("10回中2回発音成功");
                } else if( kohan_count == 9){
                    seiko_count_text.setText("10回中1回発音成功");
                }
                else{
                    seiko_count_text.setText("10回中すべて発音失敗");
                }
            }*/
            if( type_of_mistake == 0){
                nigate_phonetics_text.setTextColor(Color.BLACK);
                nigate_phonetics_text2.setTextColor(Color.BLACK);
            }
            if( type_of_mistake == 3 || type_of_mistake == 1 || type_of_mistake == 2 ){
                if( type_of_mistake == 1 || type_of_mistake == 3) {
                    nigate_phonetics_text.setTextColor(Color.RED);
                }
                if( type_of_mistake == 2 || type_of_mistake == 3){
                    nigate_phonetics_text2.setTextColor(Color.RED);
                }
                if (category_name.equals("category1.csv")) {

                    nigate_phonetics_text.setText("[ʌ]");
                    gutairei_text.setText("ex)come[kʌm]"+"\n"+"     cup[kʌp]");
                } else if (category_name.equals("category2.csv")) {
                    nigate_phonetics_text.setText("[ɑ]");
                    gutairei_text.setText("ex)hot[hɑt]"+"\n"+"     stop[stɑp]");
                } else if (category_name.equals("category3.csv")) {
                    nigate_phonetics_text.setText("[i]");
                    gutairei_text.setText("ex)eat[it]"+"\n"+"     key[ki]");
                } else if (category_name.equals("category4.csv")) {
                    nigate_phonetics_text.setText("[ʊ]");
                    gutairei_text.setText("ex)look[lʊk]"+"\n"+"     good[gʊd]");
                } else if (category_name.equals("category5.csv")) {
                    nigate_phonetics_text.setText("[e]");
                    gutairei_text.setText("ex)any[eni]"+"\n"+"     test[test]");
                } else if (category_name.equals("category6.csv")) {
                    nigate_phonetics_text.setText("[ɔ]");
                    gutairei_text.setText("ex)dog[dɔg]"+"\n"+"     small[smɔl]");
                } else if (category_name.equals("category7.csv")) {
                    nigate_phonetics_text.setText("[s]");
                    gutairei_text.setText("ex)city[sɪti]"+"\n"+"     see[si]");
                } else if (category_name.equals("category8.csv")) {
                    nigate_phonetics_text.setText("[ʃ]");
                    gutairei_text.setText("ex)she[ʃi]"+"\n"+"     sure[ʃʊr]");
                } else if (category_name.equals("category9.csv")) {
                    nigate_phonetics_text.setText("[θ]");
                    gutairei_text.setText("ex)think[θɪŋk]"+"\n"+"     mouth[maʊθ]");
                } else if (category_name.equals("category10.csv")) {
                    nigate_phonetics_text.setText("[f]");
                    gutairei_text.setText("ex)for[fɔr]"+"\n"+"     safe[seɪf]");
                } else if (category_name.equals("category11.csv")) {
                    nigate_phonetics_text.setText("[l]");
                    gutairei_text.setText("ex)like[laɪk]"+"\n"+"     listen[lɪsʌn]");
                } else if (category_name.equals("category12.csv")) {
                    nigate_phonetics_text.setText("[t]");
                    gutairei_text.setText("ex)tea[ti]"+"\n"+"     take[teɪk]");
                } else if (category_name.equals("category13.csv")) {
                    nigate_phonetics_text.setText("[p]");
                    gutairei_text.setText("ex)put[pʊt]"+"\n"+"     paper[peɪpɜr]");
                } else if (category_name.equals("category14.csv")) {
                    nigate_phonetics_text.setText("[k]");
                    gutairei_text.setText("ex)kind[kaɪnd]"+"\n"+"     like[laɪk]");
                } else if (category_name.equals("category15.csv")) {
                    nigate_phonetics_text.setText("[tʃ]");
                    gutairei_text.setText("ex)teach[titʃ]"+"\n"+"     chair[tʃer]");
                } else if (category_name.equals("category16.csv")) {
                    nigate_phonetics_text.setText("[m]");
                    gutairei_text.setText("ex)many[meni]"+"\n"+"     mind[maɪnd]");
                } else if (category_name.equals("category17.csv")) {
                    nigate_phonetics_text.setText("[f]");
                    gutairei_text.setText("ex)for[fɔr]"+"\n"+"     safe[seɪf]");
                } else if (category_name.equals("category18.csv")) {
                    nigate_phonetics_text.setText("[w]");
                    gutairei_text.setText("ex)we[wi]"+"\n"+"     way[weɪ]");
                } else if (category_name.equals("category19.csv")) {
                    nigate_phonetics_text.setText("[ŋ]");
                    gutairei_text.setText("ex)thing[θɪŋ]"+"\n"+"     sing[sɪŋ]");
                } else if (category_name.equals("category20.csv")) {
                    nigate_phonetics_text.setText("[ɪ]");
                    gutairei_text.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category21.csv")) {
                    nigate_phonetics_text.setText("[aɪ]");
                    gutairei_text.setText("ex)mine[maɪn]"+"\n"+"     by[baɪ]");
                } else if (category_name.equals("category22.csv")) {
                    nigate_phonetics_text.setText("[aɪ]");
                    gutairei_text.setText("ex)mine[maɪn]"+"\n"+"     by[baɪ]");
                } else if (category_name.equals("category23.csv")) {
                    nigate_phonetics_text.setText("[aʊ]");
                    gutairei_text.setText("ex)out[aʊt]"+"\n"+"     down[daʊn]");
                } else if (category_name.equals("category24.csv")) {
                    nigate_phonetics_text.setText("[ɜr]");
                    gutairei_text.setText("ex)after[æftɜr]"+"\n"+"     better[betɜr]");
                } else {

                }
                if( zenhan_count == 0){
                    seiko_count_text.setText("10回中10回発音成功");
                }
                else if( zenhan_count == 1){
                    seiko_count_text.setText("10回中9回発音成功");
                } else if( zenhan_count == 2){
                    seiko_count_text.setText("10回中8回発音成功");
                } else if( zenhan_count == 3){
                    seiko_count_text.setText("10回中7回発音成功");
                } else if( zenhan_count == 4){
                    seiko_count_text.setText("10回中6回発音成功");
                } else if( zenhan_count == 5){
                    seiko_count_text.setText("10回中5回発音成功");
                } else if( zenhan_count == 6){
                    seiko_count_text.setText("10回中4回発音成功");
                } else if( zenhan_count == 7){
                    seiko_count_text.setText("10回中3回発音成功");
                } else if( zenhan_count == 8){
                    seiko_count_text.setText("10回中2回発音成功");
                } else if( zenhan_count == 9){
                    seiko_count_text.setText("10回中1回発音成功");
                }
                else{
                    seiko_count_text.setText("10回中すべて発音失敗");
                }

                if (category_name.equals("category1.csv")) {
                    nigate_phonetics_text2.setText("[ə]");
                    gutairei_text2.setText("ex)about[əbaʊt]"+"\n"+"     away[əweɪ]");
                } else if (category_name.equals("category2.csv")) {
                    nigate_phonetics_text2.setText("[æ]");
                    gutairei_text2.setText("ex)bag[bæg]"+"\n"+"     cat[kæt]");
                } else if (category_name.equals("category3.csv")) {
                    nigate_phonetics_text2.setText("[ɪ]");
                    gutairei_text2.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category4.csv")) {
                    nigate_phonetics_text2.setText("[u]");
                    gutairei_text2.setText("ex)do[du]"+"\n"+"     soon[sun]");
                } else if (category_name.equals("category5.csv")) {
                    nigate_phonetics_text2.setText("[ɪ]");
                    gutairei_text2.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category6.csv")) {
                    nigate_phonetics_text2.setText("[oʊ]");
                    gutairei_text2.setText("ex)go[goʊ]"+"\n"+"     know[noʊ]");
                } else if (category_name.equals("category7.csv")) {
                    nigate_phonetics_text2.setText("[z]");
                    gutairei_text2.setText("ex)eazy[izi]"+"\n"+"     size[saɪz]");
                } else if (category_name.equals("category8.csv")) {
                    nigate_phonetics_text2.setText("[ʒ]");
                    gutairei_text2.setText("ex)vision[vɪʒʌn]"+"\n"+"     measure[meʒɜr]");
                } else if (category_name.equals("category9.csv")) {
                    nigate_phonetics_text2.setText("[ð]");
                    gutairei_text2.setText("ex)the[ðʌ]"+"\n"+"     there[ðer]");
                } else if (category_name.equals("category10.csv")) {
                    nigate_phonetics_text2.setText("[v]");
                    gutairei_text2.setText("ex)very[veri]"+"\n"+"     have[hæv]");
                } else if (category_name.equals("category11.csv")) {
                    nigate_phonetics_text2.setText("[r]");
                    gutairei_text2.setText("ex)right[raɪt]"+"\n"+"     carry[kæri]");
                } else if (category_name.equals("category12.csv")) {
                    nigate_phonetics_text2.setText("[d]");
                    gutairei_text2.setText("ex)day[deɪ]"+"\n"+"     dinner[dɪnɜr]");
                } else if (category_name.equals("category13.csv")) {
                    nigate_phonetics_text2.setText("[b]");
                    gutairei_text2.setText("ex)but[bʌt]"+"\n"+"     baby[beɪbi]");
                } else if (category_name.equals("category14.csv")) {
                    nigate_phonetics_text2.setText("[g]");
                    gutairei_text2.setText("ex)big[bɪg]"+"\n"+"     gift[gɪft]");
                } else if (category_name.equals("category15.csv")) {
                    nigate_phonetics_text2.setText("[dʒ]");
                    gutairei_text2.setText("ex)age[eɪdʒ]"+"\n"+"     join[dʒɪn]");
                } else if (category_name.equals("category16.csv")) {
                    nigate_phonetics_text2.setText("[n]");
                    gutairei_text2.setText("ex)new[nu]"+"\n"+"     name[neɪm]");
                } else if (category_name.equals("category17.csv")) {
                    nigate_phonetics_text2.setText("[h]");
                    gutairei_text2.setText("ex)he[hi]"+"\n"+"     high[haɪ]");
                } else if (category_name.equals("category18.csv")) {
                    nigate_phonetics_text2.setText("[v]");
                    gutairei_text2.setText("ex)very[veri]"+"\n"+"     have[hæv]");
                } else if (category_name.equals("category19.csv")) {
                    nigate_phonetics_text2.setText("[n]");
                    gutairei_text2.setText("ex)new[nu]"+"\n"+"     name[neɪm]");
                } else if (category_name.equals("category20.csv")) {
                    nigate_phonetics_text2.setText("[j]");
                    gutairei_text2.setText("ex)you[ju]"+"\n"+"     yet[jet]");
                } else if (category_name.equals("category21.csv")) {
                    nigate_phonetics_text2.setText("[eɪ]");
                    gutairei_text2.setText("ex)say[seɪ]"+"\n"+"     wait[weɪt]");
                } else if (category_name.equals("category22.csv")) {
                    nigate_phonetics_text2.setText("[ɔɪ]");
                    gutairei_text2.setText("ex)boy[bɔɪ]"+"\n"+"     point[pɔɪnt]");
                } else if (category_name.equals("category23.csv")) {
                    nigate_phonetics_text2.setText("[oʊ]");
                    gutairei_text2.setText("ex)go[goʊ]"+"\n"+"     know[noʊ]");
                } else if (category_name.equals("category24.csv")) {
                    nigate_phonetics_text2.setText("[r]");
                    gutairei_text2.setText("ex)right[raɪt]"+"\n"+"     carry[kæri]");
                } else {

                }

                if( kohan_count == 0){
                    seiko_count_text2.setText("10回中10回発音成功");
                }
                else if( kohan_count == 1){
                    seiko_count_text2.setText("10回中9回発音成功");
                } else if( kohan_count == 2){
                    seiko_count_text2.setText("10回中8回発音成功");
                } else if( kohan_count == 3){
                    seiko_count_text2.setText("10回中7回発音成功");
                } else if( kohan_count == 4){
                    seiko_count_text2.setText("10回中6回発音成功");
                } else if( kohan_count == 5){
                    seiko_count_text2.setText("10回中5回発音成功");
                } else if( kohan_count == 6){
                    seiko_count_text2.setText("10回中4回発音成功");
                } else if( kohan_count == 7){
                    seiko_count_text2.setText("10回中3回発音成功");
                } else if( kohan_count == 8){
                    seiko_count_text2.setText("10回中2回発音成功");
                } else if( kohan_count == 9){
                    seiko_count_text2.setText("10回中1回発音成功");
                }
                else{
                    seiko_count_text2.setText("10回中すべて発音失敗");
                }
            }

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

    private void readData(int type_of_mistake){
        if(helper == null){
            helper = new TestOpenHelper(getApplicationContext());
        }
        if(db == null){
            db = helper.getReadableDatabase();
        }
        Log.d("debug","**********Cursor");
        Cursor cursor = db.query(
                "testdb",
                new String[] { "company", "stockprice" },
                null,
                null,
                null,
                null,
                null
        );
        Cursor cursor2 = db.query(
                "testdb",
                new String[] { "company", "stockprice" },
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        StringBuilder sbuilder = new StringBuilder();
        StringBuilder sbuilder2 = new StringBuilder();
        int a = 10;
       /* if( type_of_mistake == 1) {
            for (int i = 0; i < cursor.getCount(); i++) {
                if( a >= cursor.getInt(1)){
                sbuilder.append(cursor.getString(0));
                //sbuilder.append(",");
                //sbuilder.append(cursor.getInt(1));
                sbuilder.append("\n");
                }
                cursor.moveToNext();
            }
            // 忘れずに！
            cursor.close();
            concrete_tango_text.setText("あなたが発音ミスした単語"+"\n"+sbuilder.toString());
        }
        else if( type_of_mistake == 2) {
            for (int i = 0; i < cursor.getCount(); i++) {
                if( a < cursor.getInt(1)) {
                    sbuilder.append(cursor.getString(0));
                  //  sbuilder.append(",");
                  //  sbuilder.append(cursor.getInt(1));
                    sbuilder.append("\n");
                }
                cursor.moveToNext();
            }
            // 忘れずに！
            cursor.close();
            concrete_tango_text.setText("あなたが発音ミスした単語"+"\n"+sbuilder.toString());
        }*/
        if( type_of_mistake == 3 || type_of_mistake == 1 || type_of_mistake == 2){
            for (int i = 0; i < cursor.getCount(); i++) {
                if( a >= cursor.getInt(1)) {
                    sbuilder.append(cursor.getString(0));
                    //sbuilder.append(",");
                    //sbuilder.append(cursor.getInt(1));
                    sbuilder.append("\n");
                }
                cursor.moveToNext();
            }
            cursor.close();
            cursor2.moveToFirst();
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
            cursor2.close();
            concrete_tango_text.setText("あなたが発音ミスした単語"+"\n"+sbuilder.toString());
            concrete_tango_text2.setText("あなたが発音ミスした単語"+"\n"+sbuilder2.toString());
        }
      //  Log.d("debug","**********"+sbuilder.toString());
      //  nigate_word_text.setText(sbuilder.toString());
    }

}

