package com.example.jeomjamoon;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Emainn extends AppCompatActivity {

    private ListView listViewMain;
    private String[] sampleItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emainn);

        // 리소스에서 데이터 배열 가져오기
        sampleItems = getResources().getStringArray(R.array.econtent);

        listViewMain = findViewById(R.id.listViewMain);

        // ArrayAdapter를 사용하여 데이터와 ListView 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sampleItems);
        listViewMain.setAdapter(adapter);
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(getApplicationContext(), aa.class);
                    startActivity(intent);}
                if(position == 1){
                    Intent intent = new Intent(getApplicationContext(), b.class);
                    startActivity(intent);}
                if(position == 2){
                    Intent intent = new Intent(getApplicationContext(), c.class);
                    startActivity(intent);}
                if(position == 3){
                    Intent intent = new Intent(getApplicationContext(), d.class);
                    startActivity(intent);}
                if(position == 4){
                    Intent intent = new Intent(getApplicationContext(), e.class);
                    startActivity(intent);}
                if(position == 5){
                    Intent intent = new Intent(getApplicationContext(), f.class);
                    startActivity(intent);}
                if(position == 6){
                    Intent intent = new Intent(getApplicationContext(), g.class);
                    startActivity(intent);}
                if(position == 7){
                    Intent intent = new Intent(getApplicationContext(), h.class);
                    startActivity(intent);}
                if(position == 8){
                    Intent intent = new Intent(getApplicationContext(), i.class);
                    startActivity(intent);}
                if(position == 9){
                    Intent intent = new Intent(getApplicationContext(), j.class);
                    startActivity(intent);}
                if(position == 10){
                    Intent intent = new Intent(getApplicationContext(), k.class);
                    startActivity(intent);}
                if(position == 11){
                    Intent intent = new Intent(getApplicationContext(), l.class);
                    startActivity(intent);}
                if(position == 12){
                    Intent intent = new Intent(getApplicationContext(), m.class);
                    startActivity(intent);}
                if(position == 13){
                    Intent intent = new Intent(getApplicationContext(), n.class);
                    startActivity(intent);}
                if(position == 14){
                    Intent intent = new Intent(getApplicationContext(), o.class);
                    startActivity(intent);}
                if(position == 15){
                    Intent intent = new Intent(getApplicationContext(), p.class);
                    startActivity(intent);}
                if(position == 16){
                    Intent intent = new Intent(getApplicationContext(), q.class);
                    startActivity(intent);}
                if(position == 17){
                    Intent intent = new Intent(getApplicationContext(), r.class);
                    startActivity(intent);}
                if(position == 18){
                    Intent intent = new Intent(getApplicationContext(), s.class);
                    startActivity(intent);}
                if(position == 19){
                    Intent intent = new Intent(getApplicationContext(), t.class);
                    startActivity(intent);}
                if(position == 20){
                    Intent intent = new Intent(getApplicationContext(), u.class);
                    startActivity(intent);}
                if(position == 21){
                    Intent intent = new Intent(getApplicationContext(), vv.class);
                    startActivity(intent);}
                if(position == 22){
                    Intent intent = new Intent(getApplicationContext(), w.class);
                    startActivity(intent);}
                if(position == 23){
                    Intent intent = new Intent(getApplicationContext(), x.class);
                    startActivity(intent);}
                if(position == 24){
                    Intent intent = new Intent(getApplicationContext(), y.class);
                    startActivity(intent);}
                if(position == 25){
                    Intent intent = new Intent(getApplicationContext(), z.class);
                    startActivity(intent);}


            }
        });
    }
}

