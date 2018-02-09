package com.nackademin.foureverhh.sfiapplication180113;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class WordPuzzle extends AppCompatActivity {

    TextView txv_en, txv_sv, txv_result;
    Button btn1, btn2, btn3;
    WordMatching wordMatching = new WordMatching();
    ImageButton nextWord;
    String[] buttonLetters;
    String[] threeLetters;
    char rightLetter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_puzzle);
        txv_sv = findViewById(R.id.txv_wordSV);
        txv_en = findViewById(R.id.txv_wordEN);
        txv_result = findViewById(R.id.txt_quizResult);
        nextWord = findViewById(R.id.imageButton);

        btn1 = findViewById(R.id.btn_choice1);
        btn2 = findViewById(R.id.btn_choice2);
        btn3 = findViewById(R.id.btn_choice3);
        game();
    }

    public void game()
    {

        rightLetter = wordMatching.takeRightLetter(wordMatching.svWord);

        //To show the English word
        txv_en.setText(wordMatching.enWord);

        //To show the Swedish word with an empty blank
        txv_sv.setText(wordMatching.makeEmptyPlace(rightLetter, wordMatching.svWord));

        //Get three letters for the 3 buttons
            threeLetters
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


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String btnChoice = btn1.getText().toString().toLowerCase();
                    Log.d("Button 1 letter is :", btnChoice);
                    getRightAnswer(btnChoice, String.valueOf(rightLetter), btn1, btn2, btn3);
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String btnChoice = btn2.getText().toString().toLowerCase();
                    Log.d("Button 2 letter is :", btnChoice);
                    getRightAnswer(btnChoice, String.valueOf(rightLetter), btn2, btn1, btn3);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String btnChoice = btn3.getText().toString().toLowerCase();
                    Log.d("Button 3 letter is :", btnChoice);
                    getRightAnswer(btnChoice, String.valueOf(rightLetter), btn3, btn1, btn2);

                }
            });

        btn1.setBackgroundColor(Color.LTGRAY);
        btn2.setBackgroundColor(Color.LTGRAY);
        btn3.setBackgroundColor(Color.LTGRAY);
    }



    public void getRightAnswer(String buttonLetter,String rLetter,Button btnChosen,Button btnWrong1,Button btnWrong2)
    {

        if(buttonLetter.equals(rLetter))
        {
            btnChosen.setBackgroundColor(Color.GREEN);
            btnWrong1.setBackgroundColor(Color.LTGRAY);
            btnWrong2.setBackgroundColor(Color.LTGRAY);
            nextWord.setVisibility(View.VISIBLE);
            String result = getResources().getString(R.string.rightResult);
            txv_result.setText(result);


        }else
        {
            btnChosen.setBackgroundColor(Color.RED);
            btnWrong1.setBackgroundColor(Color.LTGRAY);
            btnWrong2.setBackgroundColor(Color.LTGRAY);
            nextWord.setVisibility(View.INVISIBLE);
            String result = getResources().getString(R.string.wrongResult);
            txv_result.setText(result);
        }
    }

         public void nextWord(View v)
         {
             //To make text_en and text_sv have new content
             wordMatching.counterPlus();

             if(wordMatching.getCounter()<wordMatching.sv.length) {
                 wordMatching.enWord =wordMatching.en[wordMatching.getCounter()];
                 wordMatching.svWord = wordMatching.sv[wordMatching.getCounter()];
                 game();
                 nextWord.setVisibility(View.INVISIBLE);
                 txv_result.setText(" ");
             }else
             {
                 String result = getResources().getString(R.string.gameOver);
                 txv_result.setText(result);
                 Intent intent = new Intent(this, MainActivity.class);
                 startActivity(intent);
             }
         }

}

