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
    ImageButton nextWord,lastWord;
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
        lastWord = findViewById(R.id.imageButton2);

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
                    = wordMatching.getAllThreeLettersTest(rightLetter, wordMatching.alphabet);

        //Get random letters for the 3 buttons
        buttonLetters = wordMatching.getRandomSequence3Letters(threeLetters);

        btn1.setText(buttonLetters[0]);
        btn2.setText(buttonLetters[1]);
        btn3.setText(buttonLetters[2]);


        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //If enables that when the right button is shown, the two others will not work
                if(nextWord.getVisibility()==View.INVISIBLE)
                {
                    String btnChoice = btn1.getText().toString().toLowerCase();
                    getRightAnswer(btnChoice, String.valueOf(rightLetter), btn1, btn2, btn3);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //If enables that when the right button is shown, the two others will not work
                if(nextWord.getVisibility()==View.INVISIBLE)
                {
                    String btnChoice = btn2.getText().toString().toLowerCase();
                    getRightAnswer(btnChoice, String.valueOf(rightLetter), btn2, btn1, btn3);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //If enables that when the right button is shown, the two others will not work
                if(nextWord.getVisibility()==View.INVISIBLE)
                {
                    String btnChoice = btn3.getText().toString().toLowerCase();
                    getRightAnswer(btnChoice, String.valueOf(rightLetter), btn3, btn1, btn2);
                }
            }
        });

        //All buttons will become light gray again in the end of the game
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
            //On the first group there is no last word the last button should not show
            if(wordMatching.getCounter()==0)
                lastWord.setVisibility(View.INVISIBLE);
            else
                lastWord.setVisibility(View.VISIBLE);
            String result = getResources().getString(R.string.rightResult);
            txv_result.setText(result);
            //Show the right answer
            txv_sv.setText(wordMatching.displayRightAnswer(rLetter,txv_sv.getText().toString()));


        }else
        {
            btnChosen.setBackgroundColor(Color.RED);
            btnWrong1.setBackgroundColor(Color.LTGRAY);
            btnWrong2.setBackgroundColor(Color.LTGRAY);
            nextWord.setVisibility(View.INVISIBLE);
            lastWord.setVisibility(View.INVISIBLE);
            String result = getResources().getString(R.string.wrongResult);
            txv_result.setText(result);
        }
    }

    public void nextWord(View v)
    {
        //To make text_en and text_sv have new content
        wordMatching.counterPlus();

        if(wordMatching.getCounter()<wordMatching.sv.length)
        {
            wordMatching.enWord =wordMatching.en[wordMatching.getCounter()];
            wordMatching.svWord = wordMatching.sv[wordMatching.getCounter()];
            game();
            nextWord.setVisibility(View.INVISIBLE);
            lastWord.setVisibility(View.INVISIBLE);
            txv_result.setText(" ");
        }else
        {
            String result = getResources().getString(R.string.gameOver);
            txv_result.setText(result);
            nextWord.setVisibility(View.INVISIBLE);
        }
    }

    public void lastWord(View v)
    {
       /* if(wordMatching.getCounter()<=1)
            lastWord.setVisibility(View.INVISIBLE);
        else
        {*/
            wordMatching.counterMinus();
            wordMatching.enWord =wordMatching.en[wordMatching.getCounter()];
            wordMatching.svWord = wordMatching.sv[wordMatching.getCounter()];
            game();
            nextWord.setVisibility(View.INVISIBLE);
            lastWord.setVisibility(View.INVISIBLE);
            txv_result.setText(" ");

        //}
    }

}

