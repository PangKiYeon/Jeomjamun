package com.example.jeomjamoon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Hmain extends AppCompatActivity {

    private ListView listViewMain;
    private String[] sampleItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hmain);

        // 리소스에서 데이터 배열 가져오기
        sampleItems = getResources().getStringArray(R.array.jamo);

        listViewMain = findViewById(R.id.listViewMain);

        // ArrayAdapter를 사용하여 데이터와 ListView 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sampleItems);
        listViewMain.setAdapter(adapter);
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(getApplicationContext(), Jamain.class);
                    startActivity(intent);}
                if(position == 1){
                    Intent intent = new Intent(getApplicationContext(),
                            Momain.class);
                    startActivity(intent);}


            }
        });
    }
}