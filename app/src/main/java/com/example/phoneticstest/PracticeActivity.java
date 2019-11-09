package com.example.phoneticstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PracticeActivity extends AppCompatActivity {

    private int zenhan_count;
    private int kohan_count;
    private int type_of_mistake;
    private String category_name;
    private TextView nigate_phonetics_text;
    private TextView seiko_count_text;
    private TextView concrete_tango_text;
    private TextView nigate_phonetics_text2;
    private TextView seiko_count_text2;
    private TextView concrete_tango_text2;
    private TextView gutairei_text;
    private TextView gutairei_text2;
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

        nigate_phonetics_text = findViewById(R.id.nigate_phonetic_text);
        seiko_count_text = findViewById(R.id.seiko_count_text);
        concrete_tango_text = findViewById(R.id.concrete_tango_text);
        nigate_phonetics_text2 = findViewById(R.id.nigate_phonetic_text2);
        seiko_count_text2 = findViewById(R.id.seiko_count_text2);
        concrete_tango_text2 = findViewById(R.id.concrete_tango_text2);
        gutairei_text = findViewById(R.id.gutairei_text);
        gutairei_text2 = findViewById(R.id.gutairei_text2);


        if( type_of_mistake == 1) {
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
        }
            if( type_of_mistake == 2){
                if (category_name.equals("category1.csv")) {
                    nigate_phonetics_text.setText("[ə]");
                    gutairei_text.setText("ex)about[əbaʊt]"+"\n"+"     away[əweɪ]");
                } else if (category_name.equals("category2.csv")) {
                    nigate_phonetics_text.setText("[æ]");
                    gutairei_text.setText("ex)bag[bæg]"+"\n"+"     cat[kæt]");
                } else if (category_name.equals("category3.csv")) {
                    nigate_phonetics_text.setText("[ɪ]");
                    gutairei_text.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category4.csv")) {
                    nigate_phonetics_text.setText("[u]");
                    gutairei_text.setText("ex)do[du]"+"\n"+"     soon[sun]");
                } else if (category_name.equals("category5.csv")) {
                    nigate_phonetics_text.setText("[ɪ]");
                    gutairei_text.setText("ex)in[ɪn]"+"\n"+"     sit[sɪt]");
                } else if (category_name.equals("category6.csv")) {
                    nigate_phonetics_text.setText("[oʊ]");
                    gutairei_text.setText("ex)go[goʊ]"+"\n"+"     know[noʊ]");
                } else if (category_name.equals("category7.csv")) {
                    nigate_phonetics_text.setText("[z]");
                    gutairei_text.setText("ex)eazy[izi]"+"\n"+"     size[saɪz]");
                } else if (category_name.equals("category8.csv")) {
                    nigate_phonetics_text.setText("[ʒ]");
                    gutairei_text.setText("ex)vision[vɪʒʌn]"+"\n"+"     measure[meʒɜr]");
                } else if (category_name.equals("category9.csv")) {
                    nigate_phonetics_text.setText("[ð]");
                    gutairei_text.setText("ex)the[ðʌ]"+"\n"+"     there[ðæt]");
                } else if (category_name.equals("category10.csv")) {
                    nigate_phonetics_text.setText("[v]");
                    gutairei_text.setText("ex)very[veri]"+"\n"+"     have[hæv]");
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
            }
            if( type_of_mistake == 3){
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
                    gutairei_text2.setText("ex)the[ðʌ]"+"\n"+"     there[ðæt]");
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

    }

