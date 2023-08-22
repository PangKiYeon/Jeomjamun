package com.example.jeomjamoon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    TextView quiz;
    TextView question;
    Button ansA, ansB, ansC, ansD, prev, next;

    int score = 0;
    String selectedAnswer = "";
    int totalQuestion = QuestionAnswer.question.length; // 전체 문제 수
    int currentQuestionIndex = 0; // 현재 문제 index

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        quiz = findViewById(R.id.quiz);
        question = findViewById(R.id.question);
        ansA = findViewById(R.id.Ans_A);
        ansB = findViewById(R.id.Ans_B);
        ansC = findViewById(R.id.Ans_C);
        ansD = findViewById(R.id.Ans_D);
        prev = findViewById(R.id.prev_btn);
        next = findViewById(R.id.next_btn);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        //ansA.setBackgroundColor(Color.WHITE);
        //ansB.setBackgroundColor(Color.WHITE);
        //ansC.setBackgroundColor(Color.WHITE);
        //ansD .setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.next_btn) {
            if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }
        if (clickedButton.getId() == R.id.prev_btn) {
            currentQuestionIndex--;
            loadNewQuestion();
        }
        else {
            selectedAnswer = clickedButton.getText().toString();
            //clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    void loadNewQuestion(){
        if (currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        question.setText(QuestionAnswer.question[currentQuestionIndex]);
        //quesImg.setImageResource(QuestionAnswer.question[currentQuestionIndex]);
        //quesImg.setImageResource(R.drawable.);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if (score > totalQuestion * 0.60){
            passStatus = "합격!";
        }
        else {
            passStatus = "불합격";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + "out of " + totalQuestion)
                .setMessage(totalQuestion + "점 중에 " + score + "점")
                .setPositiveButton("다시 시작", (dialogInterface, i) -> restartQuiz())
                .setNegativeButton("나가기", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) { // 홈으로 감
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }

    void  restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

}