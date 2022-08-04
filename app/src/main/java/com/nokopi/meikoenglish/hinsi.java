package com.nokopi.meikoenglish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class hinsi extends AppCompatActivity {

    TextView mondai1, mondai2;
    Button back_button, question1, question2, question3, question4;
    ArrayList<ArrayList<String>> questionArray = new ArrayList<>();
    String rightAnswer;
    private int rightAnswerCount;
    int quizCount = 1;
    final int QUIZ_COUNT = 10;

    String[][] questiondata = {
            //{"問題","正解","選択肢1","選択肢2","選択肢3"}
            {"名詞とは", "人や物の名前", "同じ名詞を2回以上繰り返すときに使う詞", "動詞に別の意味を付け加える詞", "動きを表す詞"},
            {"動詞とは", "動きを表す詞", "文と文、単語と単語をつなぐ詞", "同じ名詞を2回以上繰り返すときに使う詞", "知りたい疑問があるときに使う詞"},
            {"形容詞とは", "名詞を詳しくする詞", "名詞の前に置く詞", "文と文、単語と単語をつなぐ詞", "知りたい疑問があるときに使う詞"},
            {"助動詞とは", "動詞に別の意味を付け加える詞", "動詞、形容詞、仲間の副詞を詳しくする詞", "人や物の名前", "知りたい疑問があるときに使う詞"},
            {"冠詞とは", "「1つの」を表す。特定・不特定", "人や物の名前", "動詞、形容詞、仲間の副詞を詳しくする詞", "名詞を詳しくする詞"},
            {"副詞とは", "動詞、形容詞、仲間の副詞を詳しくする詞", "名詞を詳しくする詞", "人や物の名前", "同じ名詞を2回以上繰り返すときに使う詞"},
            {"前置詞とは", "名詞の前に置く詞", "動詞、形容詞、仲間の副詞を詳しくする詞", "動詞に別の意味を付け加える詞", "文と文、単語と単語をつなぐ詞"},
            {"代名詞とは", "同じ名詞を2回以上繰り返すときに使う詞", "動詞に別の意味を付け加える詞", "人や物の名前", "文と文、単語と単語をつなぐ詞"},
            {"接続詞とは", "文と文、単語と単語をつなぐ詞", "動詞、形容詞、仲間の副詞を詳しくする詞", "名詞を詳しくする詞", "同じ名詞を2回以上繰り返すときに使う詞"},
            {"疑問詞とは", "知りたい疑問があるときに使う詞", "動詞、形容詞、仲間の副詞を詳しくする詞", "名詞の前に置く詞", "名詞を詳しくする詞"},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinsi);

        int i;

        /*sentakusi.put(0, "人や物の名前"); //名詞
        sentakusi.put(1,"動きを表す詞"); //動詞
        sentakusi.put(2,"名詞を詳しくする詞"); //形容詞
        sentakusi.put(3,"動詞に別の意味を付け加える詞"); //助動詞
        sentakusi.put(4,"「1つの」を表す。特定・不特定"); //冠詞
        sentakusi.put(5,"動詞、形容詞、仲間の副詞を詳しくする詞"); //副詞
        sentakusi.put(6,"名詞の前に置く詞"); //前置詞
        sentakusi.put(7,"同じ名詞を2回以上繰り返すときに使う詞"); //代名詞
        sentakusi.put(8,"文と文、単語と単語をつなぐ詞"); //接続詞
        sentakusi.put(9,"知りたい疑問があるときに使う詞"); //疑問詞*/

        mondai1 = findViewById(R.id.mondai1);
        mondai2 = findViewById(R.id.mondai2);
        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        back_button = findViewById(R.id.backbutton);

        for (i = 0; i < questiondata.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(questiondata[i][0]); //問題
            tmpArray.add(questiondata[i][1]); //正解
            tmpArray.add(questiondata[i][2]); //選択肢1
            tmpArray.add(questiondata[i][3]); //選択肢2
            tmpArray.add(questiondata[i][4]); //選択肢3
            questionArray.add(tmpArray);
        }

        showNextQuiz();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void showNextQuiz() {
        mondai2.setText(getString(R.string.quiz_number, quizCount));
        Random random = new Random();
        int randomNum = random.nextInt(questionArray.size());
        ArrayList<String> quiz = questionArray.get(randomNum);
        mondai1.setText(quiz.get(0));
        rightAnswer = quiz.get(1);
        quiz.remove(0);
        Collections.shuffle(quiz);

        question1.setText(quiz.get(0));
        question2.setText(quiz.get(1));
        question3.setText(quiz.get(2));
        question4.setText(quiz.get(3));

        questionArray.remove(randomNum);
    }

    public void judge(View view){
        Button answerButton = findViewById(view.getId());
        String ButtonText = answerButton.getText().toString();

        String alertTitle;
        if (ButtonText.equals(rightAnswer)){
            alertTitle = "正解!";
            rightAnswerCount++;
        } else {
            alertTitle = "不正解";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("答え：" + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (quizCount == QUIZ_COUNT){
                    //結果
                    Intent Result = new Intent(hinsi.this, result.class);
                    Result.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(Result);
                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}