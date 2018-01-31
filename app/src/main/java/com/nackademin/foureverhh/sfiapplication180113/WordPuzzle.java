package com.nackademin.foureverhh.sfiapplication180113;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class WordPuzzle extends AppCompatActivity  {

    TextView txv_en,txv_sv,txv_result;
    Button   btn1,btn2,btn3;
    WordMatching wordMatching = new WordMatching();
    ImageButton imageButton;
     String[] en= {"Hi", "Bye"};
     String[] sv= {"Hej","Hej då"};
     String[] svEmpty= {"H_j","Hej d_"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_puzzle);
        txv_sv = findViewById(R.id.txv_wordSV);
        txv_en = findViewById(R.id.txv_wordEN);
        txv_result = findViewById(R.id.txt_quizResult);
        imageButton = findViewById(R.id.imageButton);

        btn1 = findViewById(R.id.btn_choice1);
        btn2 = findViewById(R.id.btn_choice2);
        btn3 = findViewById(R.id.btn_choice3);

        txv_en.setText(wordMatching.en[wordMatching.getCounter()]);
        txv_sv.setText(wordMatching.svEmpty[wordMatching.getCounter()]);
    }

    public void button1Click(View view)
    {
       switch (wordMatching.getCounter())
       {
           case 0:
               result(btn1,wordMatching.match(wordMatching.svEmpty[wordMatching.getCounter()],wordMatching.getCounter()));
               break;
           case 1:
               result(btn1,wordMatching.match(wordMatching.sv[wordMatching.getCounter()],wordMatching.getCounter()));
               imageButton.setVisibility(View.VISIBLE);
               break;

       }
    }

    public void button2Click(View view)
    {
        switch (wordMatching.getCounter())
        {
            case 0:
                result(btn2,wordMatching.match(wordMatching.svEmpty[wordMatching.getCounter()],wordMatching.getCounter()));
                break;
            case 1:
                result(btn2,wordMatching.match(wordMatching.svEmpty[wordMatching.getCounter()],wordMatching.getCounter()));
                break;

        }
    }

    public void button3Click(View view)
    {
        switch (wordMatching.getCounter())
        {
            case 0:
                result(btn3,wordMatching.match(wordMatching.sv[wordMatching.getCounter()],wordMatching.getCounter()));
                imageButton.setVisibility(View.VISIBLE);
                break;
            case 1:
                result(btn3,wordMatching.match(wordMatching.svEmpty[wordMatching.getCounter()],wordMatching.getCounter()));
                break;

        }
    }



    public void result(Button btn,boolean bool)
    {
        if(bool)
        {
            txv_result.setText("It is wrong, try again!");
            btn.setBackgroundColor(Color.RED);
        }else
        {
            txv_result.setText("You are right, congratulation!");
            btn.setBackgroundColor(Color.GREEN);
        }
    }

    public void counterRise(View view)
    {
        wordMatching.nextWord();
    }

/*
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


    }*/
}
