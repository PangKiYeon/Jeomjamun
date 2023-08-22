package com.example.jeomjamoon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Nmain extends AppCompatActivity {

    private ListView listViewMain;
    private String[] sampleItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nmain);

        // 리소스에서 데이터 배열 가져오기
        sampleItems = getResources().getStringArray(R.array.ncontent);

        listViewMain = findViewById(R.id.listViewMain);

        // ArrayAdapter를 사용하여 데이터와 ListView 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sampleItems);
        listViewMain.setAdapter(adapter);
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), n0.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), n1.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), n2.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), n3.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), n4.class);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), n5.class);
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), n6.class);
                    startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), n7.class);
                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(getApplicationContext(), n8.class);
                    startActivity(intent);
                }
                if (position == 9) {
                    Intent intent = new Intent(getApplicationContext(), n9.class);
                    startActivity(intent);
                }
                if (position == 10) {
                    Intent intent = new Intent(getApplicationContext(), numbersign.class);
                    startActivity(intent);
                }
            }
        });
    }
}