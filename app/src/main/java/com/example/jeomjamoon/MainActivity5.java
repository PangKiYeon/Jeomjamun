package com.example.jeomjamoon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    public static ArrayList<library> libraryList = new ArrayList<library>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        searchLibrary();
        setUpData();
        setUpList();
        setUpOnClickListner();
    }

    private void searchLibrary() {
        SearchView searchView = findViewById(R.id.library_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<library> filterLibrary = new ArrayList<>();

                for ( int i = 0; i<libraryList.size(); i++){
                    library library = libraryList.get(i);
                    if (library.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filterLibrary.add(library);
                    }
                }
                LibraryAdapter adapter = new LibraryAdapter(getApplicationContext(),0,filterLibrary);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }
    private void setUpData() {
        library gangseo = new library("0", "강서점자도서관",
                "서울특별시 강서구 공항대로 206 나인스퉤어 8층",
                "02-2661-2280", "평일: 9:00 ~ 18:00",
                37.559025, 126.830218);
        libraryList.add(gangseo);
        library mapo = new library("1", "마포점자도서관",
                "서울특별시 마포구 월드컵로 213",
                "02-338-0180", "평일: 9:00 ~ 18:00",
                37.565558, 126.900807);
        libraryList.add(mapo);
        library student = new library("2", "한국학생점자도서관",
                "서울특별시 종로구 청운동 40-3",
                "02-880-0610", "평일: 9:00 ~ 18:00",
                37.587444, 126.969148);
        libraryList.add(student);
        library yeonguang = new library("3", "영광시각장애인모바일점자도서관",
                "서울특별시 서대문구 세검정로 78-19 2층",
                "02-393-4568", "평일: 9:00 ~ 18:00",
                37.595153, 126.949034);
        libraryList.add(yeonguang);
        library bucheon = new library("4", "부천점자도서관",
                "경기도 부천시 원미구 심곡동 454-1",
                "031-652-9963", "평일: 9:00 ~ 17:30",
                37.488393, 126.778418);
        libraryList.add(bucheon);
        library gangbook = new library("5", "강북점자도서관",
                "서울특별시 강북구 수유동 484-21",
                "02-985-3664", "평일: 9:00 ~ 17:30",
                37.628024, 127.015658);
        libraryList.add(gangbook);
        library bukboo = new library("6", "경기북부시각장애인점자도서관",
                "경기도 의정부시 호원2동 432-7",
                "031-871-0435", "평일: 9:00 ~ 18:00",
                37.720751, 127.047859);
        libraryList.add(bukboo);
        library korea = new library("7", "한국점자도서관",
                "서울특별시 강동구 암사동 510-23",
                "02-3456-7411", "평일: 9:00 ~ 18:00",
                37.550675, 127.124736);
        libraryList.add(korea);
        library incheon = new library("8", "인천송암점자도서관",
                "인천광역시 미추홀구 학익동 709-1",
                "032-876-3504", "평일: 9:00 ~ 18:00",
                37.438126, 126.656033);
        libraryList.add(incheon);
    }
    private void setUpList() {
        listView = findViewById(R.id.library_listView);

        LibraryAdapter adapter = new LibraryAdapter(getApplicationContext(),0,libraryList);
        listView.setAdapter(adapter);
    }
    private void setUpOnClickListner() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                library selectLibrary = (library) listView.getItemAtPosition(position);
                Intent showDetail = new Intent(getApplicationContext(), MapsDetailActivity.class);
                showDetail.putExtra("id",selectLibrary.getId());
                startActivity(showDetail);
            }
        });
    }
}