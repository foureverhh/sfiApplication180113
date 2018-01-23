package com.nackademin.foureverhh.sfiapplication180113;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WordPuzzle extends AppCompatActivity implements View.OnClickListener {

    TextView txv_word,txv_result;
    Button   btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_puzzle);
        txv_word = findViewById(R.id.txv_wordSV);
        txv_result = findViewById(R.id.txt_quizResult);

        btn1 = findViewById(R.id.btn_choice1);
        btn2 = findViewById(R.id.btn_choice2);
        btn3 = findViewById(R.id.btn_choice3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.btn_choice1)
        {
            txv_word.setText("Hej dä");
            txv_result.setText("It is wrong, try again!");
            btn1.setBackgroundColor(Color.RED);
        } else if (v.getId()==R.id.btn_choice2)
        {
            txv_word.setText("Hej dö");
            txv_result.setText("It is wrong, try again!");
            btn2.setBackgroundColor(Color.RED);
        } else if(v.getId()==R.id.btn_choice3)
        {
            txv_word.setText("Hej då");
            txv_result.setText("Congratulation, you are right");
            btn3.setBackgroundColor(Color.GREEN);
        }


    }
}
