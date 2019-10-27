package com.example.phoneticstest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE
            = "com.example.phoneticstest.CategoryActivity.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
      //  ImageView category_iv = (ImageView)this.findViewById(R.id.category_1_checkView);
      //  ImageView category_iv2 = (ImageView)this.findViewById(R.id.category_1_checkView2);
      //  ImageView category2_iv = (ImageView)this.findViewById(R.id.category_2_checkView);
      //  ImageView category2_iv2 = (ImageView)this.findViewById(R.id.category_2_checkView2);
      //  ImageView category3_iv = (ImageView)this.findViewById(R.id.category_3_checkView);
      //  ImageView category3_iv2 = (ImageView)this.findViewById(R.id.category_3_checkView2);
      //  ImageView category4_iv = (ImageView)this.findViewById(R.id.category_4_checkView);
      //  ImageView category4_iv2 = (ImageView)this.findViewById(R.id.category_4_checkView2);
      //  ImageView category5_iv = (ImageView)this.findViewById(R.id.category_5_checkView);
      //  ImageView category5_iv2 = (ImageView)this.findViewById(R.id.category_5_checkView2);
      //  ImageView category6_iv = (ImageView)this.findViewById(R.id.category_6_checkView);
      //  ImageView category6_iv2 = (ImageView)this.findViewById(R.id.category_6_checkView2);
      //  ImageView category7_iv = (ImageView)this.findViewById(R.id.category_7_checkView);
      //  ImageView category7_iv2 = (ImageView)this.findViewById(R.id.category_7_checkView2);
      //  ImageView category8_iv = (ImageView)this.findViewById(R.id.category_8_checkView);
      //  ImageView category8_iv2 = (ImageView)this.findViewById(R.id.category_8_checkView2);
      //  ImageView category9_iv = (ImageView)this.findViewById(R.id.category_9_checkView);
      //  ImageView category9_iv2 = (ImageView)this.findViewById(R.id.category_9_checkView2);
      //  ImageView category10_iv = (ImageView)this.findViewById(R.id.category_10_checkView);
      //  ImageView category10_iv2 = (ImageView)this.findViewById(R.id.category_10_checkView2);
      //  ImageView category11_iv = (ImageView)this.findViewById(R.id.category_11_checkView);
       // ImageView category11_iv2 = (ImageView)this.findViewById(R.id.category_11_checkView2);
       // ImageView category12_iv = (ImageView)this.findViewById(R.id.category_12_checkView);
      //  ImageView category12_iv2 = (ImageView)this.findViewById(R.id.category_12_checkView2);
      //  ImageView category13_iv = (ImageView)this.findViewById(R.id.category_13_checkView);
      //  ImageView category13_iv2 = (ImageView)this.findViewById(R.id.category_13_checkView2);
       // ImageView category14_iv = (ImageView)this.findViewById(R.id.category_14_checkView);
       // ImageView category14_iv2 = (ImageView)this.findViewById(R.id.category_14_checkView2);
       // ImageView category15_iv = (ImageView)this.findViewById(R.id.category_15_checkView);
       // ImageView category15_iv2 = (ImageView)this.findViewById(R.id.category_15_checkView2);
       // ImageView category16_iv = (ImageView)this.findViewById(R.id.category_16_checkView);
       // ImageView category16_iv2 = (ImageView)this.findViewById(R.id.category_16_checkView2);
        //ImageView category17_iv = (ImageView)this.findViewById(R.id.category_17_checkView);
       // ImageView category17_iv2 = (ImageView)this.findViewById(R.id.category_17_checkView2);
       // ImageView category18_iv = (ImageView)this.findViewById(R.id.category_18_checkView);
       // ImageView category18_iv2 = (ImageView)this.findViewById(R.id.category_18_checkView2);
        //ImageView category19_iv = (ImageView)this.findViewById(R.id.category_19_checkView);
       // ImageView category19_iv2 = (ImageView)this.findViewById(R.id.category_19_checkView2);
       // ImageView category20_iv = (ImageView)this.findViewById(R.id.category_20_checkView);
       // ImageView category20_iv2 = (ImageView)this.findViewById(R.id.category_20_checkView2);
       // ImageView category21_iv = (ImageView)this.findViewById(R.id.category_21_checkView);
       // ImageView category21_iv2 = (ImageView)this.findViewById(R.id.category_21_checkView2);
       // ImageView category22_iv = (ImageView)this.findViewById(R.id.category_22_checkView);
       // ImageView category22_iv2 = (ImageView)this.findViewById(R.id.category_22_checkView2);
       // ImageView category23_iv = (ImageView)this.findViewById(R.id.category_23_checkView);
       // ImageView category23_iv2 = (ImageView)this.findViewById(R.id.category_23_checkView2);



        Button Category_1Button = findViewById(R.id.category_1);
        Button Category_2Button = findViewById(R.id.category_2);
        Button Category_3Button = findViewById(R.id.category_3);
        Button Category_4Button = findViewById(R.id.category_4);
        Button Category_5Button = findViewById(R.id.category_5);
        Button Category_6Button = findViewById(R.id.category_6);
        Button Category_7Button = findViewById(R.id.category_7);
        Button Category_8Button = findViewById(R.id.category_8);
        Button Category_9Button = findViewById(R.id.category_9);
        Button Category_10Button = findViewById(R.id.category_10);
        Button Category_11Button = findViewById(R.id.category_11);
        Button Category_12Button = findViewById(R.id.category_12);
        Button Category_13Button = findViewById(R.id.category_13);
        Button Category_14Button = findViewById(R.id.category_14);
        Button Category_15Button = findViewById(R.id.category_15);
        Button Category_16Button = findViewById(R.id.category_16);
        Button Category_17Button = findViewById(R.id.category_17);
        Button Category_18Button = findViewById(R.id.category_18);
        Button Category_19Button = findViewById(R.id.category_19);
        Button Category_20Button = findViewById(R.id.category_20);
        Button Category_21Button = findViewById(R.id.category_21);
        Button Category_22Button = findViewById(R.id.category_22);
        Button Category_23Button = findViewById(R.id.category_23);
        Button backButton = findViewById(R.id.button10);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent = new Intent(getApplication(), First_screenActivity.class);
                startActivity(intent);
            }
        });
        Category_1Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category1.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        });
        Category_2Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category2.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        });
        Category_3Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category3.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_4Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category4.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_5Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category5.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_6Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category6.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_7Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category7.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_8Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category8.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_9Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category9.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_10Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category10.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_11Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category11.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_12Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category12.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_13Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category13.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_14Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category14.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_15Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category15.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_16Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category16.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_17Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category17.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_18Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category18.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_19Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category19.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_20Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category20.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_21Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category21.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_22Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category22.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        }); Category_23Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                function();
            }

            private void function() {
                Intent intent1 = new Intent(getApplication(), TestActivity.class);
                String str = "category23.csv";
                intent1.putExtra(EXTRA_MESSAGE,str);
                startActivity(intent1);
            }
        });
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs3 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs4 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs5 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs6 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs7 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs8 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs9 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs10 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs11 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs12 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs13 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs14 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs15 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs16 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs17 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs18 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs19 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs20 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs21 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs22 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs23 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Intent intent1 = getIntent();
        int data = intent1.getIntExtra("keyword",0);
        if(data == 1){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("int", 1);
            editor.apply();
        }
        if(data == 2){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("int", 2);
            editor.apply();
        }
        Intent intent2 = getIntent();
        int data2 = intent2.getIntExtra("keyword2",0);
        if(data2 == 1){
            SharedPreferences.Editor editor = prefs2.edit();
            editor.putInt("int2", 1);
            editor.apply();
        }
        if(data2 == 2){
            SharedPreferences.Editor editor = prefs2.edit();
            editor.putInt("int2", 2);
            editor.apply();
        }
        Intent intent3 = getIntent();
        int data3 = intent3.getIntExtra("keyword3",0);
        if(data3 == 1){
            SharedPreferences.Editor editor = prefs3.edit();
            editor.putInt("int3", 1);
            editor.apply();
        }
        if(data3 == 2){
            SharedPreferences.Editor editor = prefs3.edit();
            editor.putInt("int3", 2);
            editor.apply();
        }
        Intent intent4 = getIntent();
        int data4 = intent4.getIntExtra("keyword4",0);
        if(data4 == 1){
            SharedPreferences.Editor editor = prefs4.edit();
            editor.putInt("int4", 1);
            editor.apply();
        }
        if(data4 == 2){
            SharedPreferences.Editor editor = prefs4.edit();
            editor.putInt("int4", 2);
            editor.apply();
        }
        Intent intent5 = getIntent();
        int data5 = intent5.getIntExtra("keyword5",0);
        if(data5 == 1){
            SharedPreferences.Editor editor = prefs5.edit();
            editor.putInt("int5", 1);
            editor.apply();
        }
        if(data5 == 2){
            SharedPreferences.Editor editor = prefs5.edit();
            editor.putInt("int5", 2);
            editor.apply();
        }
        Intent intent6 = getIntent();
        int data6 = intent6.getIntExtra("keyword6",0);
        if(data6 == 1){
            SharedPreferences.Editor editor = prefs6.edit();
            editor.putInt("int6", 1);
            editor.apply();
        }
        if(data6 == 2){
            SharedPreferences.Editor editor = prefs6.edit();
            editor.putInt("int6", 2);
            editor.apply();
        }
        Intent intent7 = getIntent();
        int data7 = intent7.getIntExtra("keyword7",0);
        if(data7 == 1){
            SharedPreferences.Editor editor = prefs7.edit();
            editor.putInt("int7", 1);
            editor.apply();
        }
        if(data7 == 2){
            SharedPreferences.Editor editor = prefs7.edit();
            editor.putInt("int7", 2);
            editor.apply();
        }
        Intent intent8 = getIntent();
        int data8 = intent8.getIntExtra("keyword8",0);
        if(data8 == 1){
            SharedPreferences.Editor editor = prefs8.edit();
            editor.putInt("int8", 1);
            editor.apply();
        }
        if(data8 == 2){
            SharedPreferences.Editor editor = prefs8.edit();
            editor.putInt("int", 2);
            editor.apply();
        }
        Intent intent9 = getIntent();
        int data9 = intent9.getIntExtra("keyword9",0);
        if(data9 == 1){
            SharedPreferences.Editor editor9 = prefs9.edit();
            editor9.putInt("int9", 1);
            editor9.apply();
        }
        if(data9 == 2){
            SharedPreferences.Editor editor9 = prefs9.edit();
            editor9.putInt("int9", 2);
            editor9.apply();
        }
        Intent intent10 = getIntent();
        int data10 = intent10.getIntExtra("keyword10",0);
        if(data10 == 1){
            SharedPreferences.Editor editor10 = prefs10.edit();
            editor10.putInt("int10", 1);
            editor10.apply();
        }
        if(data10 == 2){
            SharedPreferences.Editor editor10 = prefs10.edit();
            editor10.putInt("int10", 2);
            editor10.apply();
        }
        Intent intent11 = getIntent();
        int data11 = intent11.getIntExtra("keyword11",0);
        if(data11 == 1){
            SharedPreferences.Editor editor11 = prefs11.edit();
            editor11.putInt("int11", 1);
            editor11.apply();
        }
        if(data11 == 2){
            SharedPreferences.Editor editor11 = prefs11.edit();
            editor11.putInt("int11", 2);
            editor11.apply();
        }
        Intent intent12 = getIntent();
        int data12 = intent12.getIntExtra("keyword12",0);
        if(data12 == 1){
            SharedPreferences.Editor editor12 = prefs12.edit();
            editor12.putInt("int12", 1);
            editor12.apply();
        }
        if(data12 == 2){
            SharedPreferences.Editor editor12 = prefs12.edit();
            editor12.putInt("int12", 2);
            editor12.apply();
        }
        Intent intent13 = getIntent();
        int data13 = intent13.getIntExtra("keyword13",0);
        if(data13 == 1){
            SharedPreferences.Editor editor13 = prefs13.edit();
            editor13.putInt("int13", 1);
            editor13.apply();
        }
        if(data13 == 2){
            SharedPreferences.Editor editor13 = prefs13.edit();
            editor13.putInt("int13", 2);
            editor13.apply();
        }
        Intent intent14 = getIntent();
        int data14 = intent14.getIntExtra("keyword14",0);
        if(data14 == 1){
            SharedPreferences.Editor editor14 = prefs14.edit();
            editor14.putInt("int14", 1);
            editor14.apply();
        }
        if(data14 == 2){
            SharedPreferences.Editor editor14 = prefs14.edit();
            editor14.putInt("int14", 2);
            editor14.apply();
        }
        Intent intent15 = getIntent();
        int data15 = intent15.getIntExtra("keyword15",0);
        if(data15 == 1){
            SharedPreferences.Editor editor15 = prefs15.edit();
            editor15.putInt("int15", 1);
            editor15.apply();
        }
        if(data15 == 2){
            SharedPreferences.Editor editor15 = prefs15.edit();
            editor15.putInt("int15", 2);
            editor15.apply();
        }
        Intent intent16 = getIntent();
        int data16 = intent16.getIntExtra("keyword16",0);
        if(data16 == 1){
            SharedPreferences.Editor editor16 = prefs16.edit();
            editor16.putInt("int16", 1);
            editor16.apply();
        }
        if(data16 == 2){
            SharedPreferences.Editor editor16 = prefs16.edit();
            editor16.putInt("int16", 2);
            editor16.apply();
        }
        Intent intent17 = getIntent();
        int data17 = intent17.getIntExtra("keyword17",0);
        if(data17 == 1){
            SharedPreferences.Editor editor17 = prefs17.edit();
            editor17.putInt("int17", 1);
            editor17.apply();
        }
        if(data17 == 2){
            SharedPreferences.Editor editor17 = prefs17.edit();
            editor17.putInt("int17", 2);
            editor17.apply();
        }
        Intent intent18 = getIntent();
        int data18 = intent18.getIntExtra("keyword18",0);
        if(data18 == 1){
            SharedPreferences.Editor editor18 = prefs18.edit();
            editor18.putInt("int18", 1);
            editor18.apply();
        }
        if(data18 == 2){
            SharedPreferences.Editor editor18 = prefs18.edit();
            editor18.putInt("int", 2);
            editor18.apply();
        }
        Intent intent19 = getIntent();
        int data19 = intent19.getIntExtra("keyword19",0);
        if(data19 == 1){
            SharedPreferences.Editor editor19 = prefs19.edit();
            editor19.putInt("int19", 1);
            editor19.apply();
        }
        if(data19 == 2){
            SharedPreferences.Editor editor19 = prefs19.edit();
            editor19.putInt("int19", 2);
            editor19.apply();
        }
        Intent intent20 = getIntent();
        int data20 = intent20.getIntExtra("keyword20",0);
        if(data20 == 1){
            SharedPreferences.Editor editor20 = prefs20.edit();
            editor20.putInt("int20", 1);
            editor20.apply();
        }
        if(data20 == 2){
            SharedPreferences.Editor editor20 = prefs20.edit();
            editor20.putInt("int", 2);
            editor20.apply();
        }
        Intent intent21 = getIntent();
        int data21 = intent21.getIntExtra("keyword21",0);
        if(data21 == 1){
            SharedPreferences.Editor editor21 = prefs21.edit();
            editor21.putInt("int21", 1);
            editor21.apply();
        }
        if(data21 == 2){
            SharedPreferences.Editor editor21 = prefs21.edit();
            editor21.putInt("int21", 2);
            editor21.apply();
        }
        Intent intent22 = getIntent();
        int data22 = intent22.getIntExtra("keyword22",0);
        if(data22 == 1){
            SharedPreferences.Editor editor22 = prefs22.edit();
            editor22.putInt("int22", 1);
            editor22.apply();
        }
        if(data22 == 2){
            SharedPreferences.Editor editor22 = prefs22.edit();
            editor22.putInt("int22", 2);
            editor22.apply();
        }
        Intent intent23 = getIntent();
        int data23 = intent23.getIntExtra("keyword23",0);
        if(data23 == 1){
            SharedPreferences.Editor editor23 = prefs23.edit();
            editor23.putInt("int23", 1);
            editor23.apply();
        }
        if(data23 == 2){
            SharedPreferences.Editor editor23 = prefs23.edit();
            editor23.putInt("int23", 2);
            editor23.apply();
        }







        int intNum = prefs.getInt("int",0);
        if( intNum == 1){
  //          category_iv.setImageResource(R.drawable.check_picture);
        }
        if( intNum == 2){
  //          category_iv2.setImageResource(R.drawable.check_picture2);
        }
        int intNum2 = prefs2.getInt("int2",0);
        if( intNum2 == 1){
  //          category2_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum2 == 2){
  //          category2_iv2.setImageResource(R.drawable.check_picture2);
        }


        int intNum3 = prefs3.getInt("int3",0);
        if( intNum3 == 1){
    //        category3_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum3 == 2){
     //       category3_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum4 = prefs4.getInt("int4",0);
        if( intNum4 == 1){
      //      category4_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum4 == 2){
        //    category4_iv2.setImageResource(R.drawable.check_picture2);
        }


        int intNum5 = prefs5.getInt("int5",0);
        if( intNum5 == 1){
          //  category5_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum5 == 2){
            //category5_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum6 = prefs6.getInt("int6",0);
        if( intNum6 == 1){
           // category6_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum6 == 2){
           // category6_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum7 = prefs7.getInt("int7",0);
        if( intNum7 == 1){
            //category7_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum7 == 2){
            //category7_iv2.setImageResource(R.drawable.check_picture2);
        }


        int intNum8 = prefs8.getInt("int8",0);
        if( intNum8 == 1){
            //category8_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum8 == 2){
            //category8_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum9 = prefs9.getInt("int9",0);
        if( intNum9 == 1){
            //category9_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum9 == 2){
            //category9_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum10 = prefs10.getInt("int10",0);
        if( intNum10 == 1){
            //category10_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum10 == 2){
            //category10_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum11 = prefs11.getInt("int11",0);
        if( intNum11 == 1){
            //category11_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum11 == 2){
            //category11_iv2.setImageResource(R.drawable.check_picture2);
        }


        int intNum12 = prefs12.getInt("int12",0);
        if( intNum12 == 1){
            //category12_iv2.setImageResource(R.drawable.check_picture);
        }

        if( intNum12 == 2){
            //category12_iv.setImageResource(R.drawable.check_picture2);
        }

        int intNum13 = prefs13.getInt("int13",0);
        if( intNum13 == 1){
            //category13_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum13 == 2){
            //category13_iv2.setImageResource(R.drawable.check_picture2);
        }


        int intNum14 = prefs14.getInt("int14",0);
        if( intNum14 == 1){
            //category14_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum14 == 2){
       //     category14_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum15 = prefs15.getInt("int15",0);
        if( intNum15 == 1){
         //   category15_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum15 == 2){
           // category15_iv2.setImageResource(R.drawable.check_picture2);
        }


        int intNum16 = prefs16.getInt("int16",0);
        if( intNum16 == 1){
            //category16_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum16 == 2){
            //category16_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum17 = prefs17.getInt("int17",0);
        if( intNum17 == 1){
            //category17_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum == 2){
            //category17_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum18 = prefs18.getInt("int18",0);
        if( intNum18 == 1){
            //category18_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum18 == 2){
            //category18_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum19 = prefs19.getInt("int19",0);
        if( intNum19 == 1){
            //category19_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum19 == 2){
            //category19_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum20 = prefs20.getInt("int20",0);
        if( intNum20 == 1){
            //category20_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum20 == 2){
            //category20_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum21 = prefs21.getInt("int21",0);
        if( intNum21 == 1){
            //category21_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum21 == 2){
            //category21_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum22 = prefs22.getInt("int22",0);
        if( intNum22 == 1){
            //category22_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum22 == 2){
            //category22_iv2.setImageResource(R.drawable.check_picture2);
        }

        int intNum23 = prefs23.getInt("int23",0);
        if( intNum23 == 1){
            //category23_iv.setImageResource(R.drawable.check_picture);
        }

        if( intNum23 == 2){
            //category23_iv2.setImageResource(R.drawable.check_picture2);
        }
    }
}
