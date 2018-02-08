package com.nackademin.foureverhh.sfiapplication180113;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class WordPuzzle extends AppCompatActivity implements View.OnClickListener{

    TextView txv_en, txv_sv, txv_result;
    Button btn1, btn2, btn3;
    WordMatching wordMatching = new WordMatching();
    ImageButton nextPage;
    String[] buttonLetters;
    char rightLetter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_puzzle);
        txv_sv = findViewById(R.id.txv_wordSV);
        txv_en = findViewById(R.id.txv_wordEN);
        txv_result = findViewById(R.id.txt_quizResult);
        nextPage = findViewById(R.id.imageButton);

        btn1 = findViewById(R.id.btn_choice1);
        btn2 = findViewById(R.id.btn_choice2);
        btn3 = findViewById(R.id.btn_choice3);

       while(wordMatching.getCounter()<wordMatching.sv.length)
       {
           rightLetter = wordMatching.takeRightLetter(wordMatching.svWord);
           Log.d("The right letter is ", String.valueOf(rightLetter));

           //To show the English word
           txv_en.setText(wordMatching.enWord);

           //To show the Swedish word with an empty blank
           txv_sv.setText(wordMatching.makeEmptyPlace(rightLetter, wordMatching.svWord));
           Log.d("Empty sv word", wordMatching.makeEmptyPlace(rightLetter, wordMatching.svWord));



           //Get three letters for the 3 buttons
           String[] threeLetters
                   = wordMatching.getAllThreeLetters(rightLetter, wordMatching.alphabet);
           for (String str : threeLetters)
               Log.d("The three letters are: ", str);
           //Get random letters for the 3 buttons
           buttonLetters = wordMatching.getRandomSequence3Letters(threeLetters);
           for (String str : buttonLetters)
               Log.d("The three letters", str);

           btn1.setText(buttonLetters[0]);
           btn2.setText(buttonLetters[1]);
           btn3.setText(buttonLetters[2]);

           btn1.setOnClickListener(this);
           btn2.setOnClickListener(this);
           btn3.setOnClickListener(this);
           nextPage.setOnClickListener(this);
          /* if(nextPage.getVisibility()==View.VISIBLE)
           {
                wordMatching.counterPlus();
           }
*/          wordMatching.counterPlus();

       }
    }

    /*public void button1Click(View view)
    {
        String btnChoice = btn1.getText().toString().toLowerCase();
        Log.d("Button 1 letter is :",btnChoice);
        getRightAnswer(btnChoice,String.valueOf(rightLetter),btn1,btn2,btn3);

    }

    public void button2Click(View view)
    {
        String btnChoice = btn2.getText().toString().toLowerCase();
        Log.d("Button 2 letter is :",btnChoice);
        getRightAnswer(btnChoice,String.valueOf(rightLetter),btn2,btn1,btn3);
    }

    public void button3Click(View view)
    {
        String btnChoice = btn3.getText().toString().toLowerCase();
        Log.d("Button 3 letter is :",btnChoice);
        getRightAnswer(btnChoice,String.valueOf(rightLetter),btn3,btn1,btn2);
    }*/

   /* public void nextWord(View view)
    {
        wordMatching.counterPlus();
    }

    public void result(Button btn, boolean bool) {
        if (bool) {
            txv_result.setText("It is wrong, try again!");
            btn.setBackgroundColor(Color.RED);
        } else {
            txv_result.setText("You are right, congratulation!");
            btn.setBackgroundColor(Color.GREEN);
        }
    }*/

   /* public void counterRise(View view) {
        wordMatching.counterPlus();
        nextPage.setVisibility(View.INVISIBLE);
    }*/

    public void getRightAnswer(String buttonLetter,String rLetter,Button btnChosen,Button btnWrong1,Button btnWrong2)
    {

        if(buttonLetter.equals(rLetter))
        {
            btnChosen.setBackgroundColor(Color.GREEN);
            btnWrong1.setBackgroundColor(Color.GRAY);
            btnWrong2.setBackgroundColor(Color.GRAY);
            nextPage.setVisibility(View.VISIBLE);
          /*  //To show the English word
            txv_en.setText(wordMatching.enWord);

            //To show the Swedish word with an empty blank

            txv_sv.setText(wordMatching.makeEmptyPlace(rightLetter,wordMatching.svWord));*/

        }else
        {
            btnChosen.setBackgroundColor(Color.RED);
            btnWrong1.setBackgroundColor(Color.GRAY);
            btnWrong2.setBackgroundColor(Color.GRAY);
            nextPage.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public void onClick(View v) {
        String btnChoice;
        switch (v.getId())
        {
            case R.id.btn_choice1:
                btnChoice = btn1.getText().toString().toLowerCase();
                Log.d("Button 1 letter is :",btnChoice);
                getRightAnswer(btnChoice,String.valueOf(rightLetter),btn1,btn2,btn3);
                break;

            case R.id.btn_choice2:
                btnChoice = btn2.getText().toString().toLowerCase();
                Log.d("Button 2 letter is :",btnChoice);
                getRightAnswer(btnChoice,String.valueOf(rightLetter),btn2,btn1,btn3);
                break;

            case R.id.btn_choice3:
                btnChoice = btn3.getText().toString().toLowerCase();
                Log.d("Button 3 letter is :",btnChoice);
                getRightAnswer(btnChoice,String.valueOf(rightLetter),btn3,btn1,btn2);
                break;

            case R.id.imageButton:
                wordMatching.counterPlus();
                nextPage.setVisibility(View.INVISIBLE);
                break;

        }
    }
}

