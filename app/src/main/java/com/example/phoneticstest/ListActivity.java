package com.example.phoneticstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ListActivity extends AppCompatActivity {

    private TextView word_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        word_text = findViewById(R.id.textView15);

        Intent intent= getIntent();
        String filename = intent.getStringExtra(EditActivity.EXTRA_MESSAGE);
        String text= readFile(filename);
        word_text.setText(text);

    }
    public String readFile(String file){
        String text = "";
        //String text2 = null;
        try(FileInputStream fileInputStream = openFileInput(file);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)))
        {
            String lineBuffer;
            while((lineBuffer = reader.readLine()) != null){
                text += lineBuffer;
                text += "\n";
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
}
