package com.example.jeomjamoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button mainservice;
Button trainservice;
Button quizservice;
Button searchservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainservice=findViewById(R.id.mainservice);
        mainservice.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

        trainservice = findViewById(R.id.trainservice);
        trainservice.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

        quizservice = findViewById(R.id.quizservice);
        quizservice.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });

        searchservice = findViewById(R.id.searchservice);
        searchservice.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(intent);
            }
        });
    }

}