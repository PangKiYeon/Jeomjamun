package com.example.jeomjamoon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Momain extends AppCompatActivity {

    private ListView listViewMain;
    private String[] sampleItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jamain);

        // 리소스에서 데이터 배열 가져오기
        sampleItems = getResources().getStringArray(R.array.mocontent);

        listViewMain = findViewById(R.id.listViewMain);

        // ArrayAdapter를 사용하여 데이터와 ListView 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sampleItems);
        listViewMain.setAdapter(adapter);
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), mo1.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), mo2.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), mo3.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), mo4.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), mo5.class);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), mo6.class);
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), mo7.class);
                    startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), mo8.class);
                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(getApplicationContext(), mo9.class);
                    startActivity(intent);
                }
                if (position == 9) {
                    Intent intent = new Intent(getApplicationContext(), mo10.class);
                    startActivity(intent);
                }
                if (position == 10) {
                    Intent intent = new Intent(getApplicationContext(), mo11.class);
                    startActivity(intent);
                }
                if (position == 11) {
                    Intent intent = new Intent(getApplicationContext(), mo12.class);
                    startActivity(intent);
                }
                if (position == 12) {
                    Intent intent = new Intent(getApplicationContext(), mo13.class);
                    startActivity(intent);
                }
                if (position == 13) {
                    Intent intent = new Intent(getApplicationContext(), mo14.class);
                    startActivity(intent);
                }
                if (position == 14) {
                    Intent intent = new Intent(getApplicationContext(), mo15.class);
                    startActivity(intent);
                }
                if (position == 15) {
                    Intent intent = new Intent(getApplicationContext(), mo16.class);
                    startActivity(intent);
                }
                if (position == 16) {
                    Intent intent = new Intent(getApplicationContext(), mo17.class);
                    startActivity(intent);
                }
                if (position == 17) {
                    Intent intent = new Intent(getApplicationContext(), mo18.class);
                    startActivity(intent);
                }
                if (position == 18) {
                    Intent intent = new Intent(getApplicationContext(), mo19.class);
                    startActivity(intent);
                }
                if (position == 19) {
                    Intent intent = new Intent(getApplicationContext(), mo20.class);
                    startActivity(intent);
                }
                if (position == 20) {
                    Intent intent = new Intent(getApplicationContext(), mo21.class);
                    startActivity(intent);
                }

                if (position == 21) {
                    Intent intent = new Intent(getApplicationContext(), tips.class);
                    startActivity(intent);
                }
            }
        });
    }
}