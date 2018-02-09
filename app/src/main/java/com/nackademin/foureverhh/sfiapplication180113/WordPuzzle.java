package com.nackademin.foureverhh.sfiapplication180113;

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
    boolean next;


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
        next =false;

       /* btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        nextWord.setOnClickListener(this);*/

        //while(wordMatching.getCounter()<wordMatching.sv.length)
        do
       {
           next = false; // to wait until nextWord allow the game to go on
           rightLetter = wordMatching.takeRightLetter(wordMatching.svWord);
           Log.d("The right letter is ", String.valueOf(rightLetter));
           Log.d("The Swedish word",wordMatching.svWord);

           //wordMatching.counter();

           //To show the English word
           txv_en.setText(wordMatching.enWord);

           //To show the Swedish word with an empty blank
           txv_sv.setText(wordMatching.makeEmptyPlace(rightLetter, wordMatching.svWord));
           Log.d("Empty sv word", wordMatching.makeEmptyPlace(rightLetter, wordMatching.svWord));



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
                   Log.d("Button 1 letter is :",btnChoice);
                   getRightAnswer(btnChoice,String.valueOf(rightLetter),btn1,btn2,btn3);
               }
           });

           btn2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String btnChoice = btn2.getText().toString().toLowerCase();
                   Log.d("Button 2 letter is :",btnChoice);
                   getRightAnswer(btnChoice,String.valueOf(rightLetter),btn2,btn1,btn3);
               }
           });

           btn3.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String btnChoice = btn3.getText().toString().toLowerCase();
                   Log.d("Button 3 letter is :",btnChoice);
                   getRightAnswer(btnChoice,String.valueOf(rightLetter),btn3,btn1,btn2);

               }
           });

           nextWord.setOnClickListener(new View.OnClickListener()
           {
               @Override
               public void onClick(View v)
               {
                    if(wordMatching.getCounter()<wordMatching.sv.length)
                    {
                        next = true;
                        wordMatching.counterPlus();
                        wordMatching.enWord =wordMatching.en[wordMatching.getCounter()];
                        wordMatching.svWord = wordMatching.sv[wordMatching.getCounter()];
                    }else
                        next =false;
                    Log.d("Txv_en ",txv_en.getText().toString());
                    Log.d("Txv_sv ",txv_sv.getText().toString());
                    nextWord.setVisibility(View.INVISIBLE);
                    Log.d("Bool after image",String.valueOf(next));
                   }
           });

           if(next)
           {
               Log.d("Program is here",String.valueOf(next));

               rightLetter = wordMatching.takeRightLetter(wordMatching.svWord);

               //To show the English word
               txv_en.setText(wordMatching.enWord);

               //To show the Swedish word with an empty blank
               txv_sv.setText(wordMatching.makeEmptyPlace(rightLetter, wordMatching.svWord));
           }
           //wordMatching.counterPlus();
           Log.d("The boolean is",String.valueOf(next));

       }while(next);
    }

    public void getRightAnswer(String buttonLetter,String rLetter,Button btnChosen,Button btnWrong1,Button btnWrong2)
    {

        if(buttonLetter.equals(rLetter))
        {
            btnChosen.setBackgroundColor(Color.GREEN);
            btnWrong1.setBackgroundColor(Color.GRAY);
            btnWrong2.setBackgroundColor(Color.GRAY);
            nextWord.setVisibility(View.VISIBLE);
            Log.d("Counter in next",String.valueOf(wordMatching.getCounter()));


        }else
        {
            btnChosen.setBackgroundColor(Color.RED);
            btnWrong1.setBackgroundColor(Color.GRAY);
            btnWrong2.setBackgroundColor(Color.GRAY);
            nextWord.setVisibility(View.INVISIBLE);

        }
    }
      /* public void button1Click(View v)
        {
            String btnChoice = btn1.getText().toString().toLowerCase();
            Log.d("Button 1 letter is :",btnChoice);
            getRightAnswer(btnChoice,String.valueOf(rightLetter),btn1,btn2,btn3);
        }

         public void button2Click(View v)
         {
            String btnChoice = btn2.getText().toString().toLowerCase();
            Log.d("Button 2 letter is :",btnChoice);
            getRightAnswer(btnChoice,String.valueOf(rightLetter),btn2,btn1,btn3);
         }

         public void button3Click(View v)
         {
            String btnChoice = btn3.getText().toString().toLowerCase();
            Log.d("Button 3 letter is :",btnChoice);
            getRightAnswer(btnChoice,String.valueOf(rightLetter),btn3,btn1,btn2);
         }

         public void counterRise(View v)
         {



             //To make text_en and text_sv have new content
             wordMatching.counterPlus();

             if(wordMatching.getCounter()<wordMatching.sv.length) {
                 next = true;

                 wordMatching.enWord =wordMatching.en[wordMatching.getCounter()];
                 wordMatching.svWord = wordMatching.sv[wordMatching.getCounter()];
             }else
                 next =false;
             Log.d("Txv_en ",txv_en.getText().toString());
             Log.d("Txv_sv ",txv_sv.getText().toString());
             nextWord.setVisibility(View.INVISIBLE);
             Log.d("Bool after image",String.valueOf(next));
         }
*/

       /*@Override
    public void onClick(View v)
    {
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
                next = true;
                nextWord.setVisibility(View.INVISIBLE);
                //To make text_en and text_sv have new content
                if(wordMatching.getCounter()<wordMatching.sv.length) {
                    wordMatching.enWord =wordMatching.en[wordMatching.getCounter()];
                    wordMatching.svWord = wordMatching.sv[wordMatching.getCounter()];
                }
                rightLetter = wordMatching.takeRightLetter(wordMatching.svWord);

                //To show the English word
                txv_en.setText(wordMatching.enWord);

                //To show the Swedish word with an empty blank
                txv_sv.setText(wordMatching.makeEmptyPlace(rightLetter, wordMatching.svWord));


                break;

        }
    }*/
}

