package com.nackademin.foureverhh.sfiapplication180113;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by foureverhh on 2018-01-31.
 */

public class WordMatching
{
  String[] en = {"hi", "bye","thanks","good morning"};
  String[] sv = {"hej","hej då","tack","god morgon"};
  String[] alphabet = {  "A","B","C","D","E","F",
            "G","H","I","J","K","L",
            "M","N","O","P","Q","R",
            "S","T","U","V","W","X",
            "Y","Z","Ä","Ö","Å"};
  private int counter=0;


  String enWord= en[counter];
  String svWord=sv[counter];

  final Random RANDOM = new Random();

  public void counter()
  {
      Log.d("Counter in Class",String.valueOf(getCounter())+" "+svWord);
      Log.d("sv[1] is ",sv[1]);
  }

  //Get the right answer to the board
    public  char takeRightLetter(String svWord)
    {
        int index = RANDOM.nextInt(svWord.length());
        while(svWord.charAt(index)==' ')
        {
            index = RANDOM.nextInt(svWord.length());
        }
        return svWord.charAt(index);
    }



  //Replace the right letter with _
  public String makeEmptyPlace(char rightLetter,String svWord)
  {
      int index = svWord.indexOf(rightLetter);
      return svWord.substring(0,index)+"_"+svWord.substring(index+1);

  }



  //Get the all three letters from the alphabet
    public String[] getAllThreeLetters(char rightLetter,String[] alphabet)
    {
        //Besides the right letter, from the alphabet get the other two letters.
        String letter2 = alphabet[RANDOM.nextInt(alphabet.length)];
        while(letter2.equals(String.valueOf(rightLetter)))
        {
            letter2 = alphabet[RANDOM.nextInt(alphabet.length)];
        }

        String letter3 = alphabet[RANDOM.nextInt(alphabet.length)];
        while(letter3.equals(String.valueOf(rightLetter)) || letter3.equals(letter2))
        {
            letter3 = alphabet[RANDOM.nextInt(alphabet.length)];
        }

        String[] threeLetters = {String.valueOf(rightLetter),letter2,letter3};
        return  threeLetters;
    }

    //Random the sequence of the three letters so that the button could be randomly show the 3 letters
    public String[] getRandomSequence3Letters(String[] threeLetters)
    {
        String temp;
        for(int i=0;i<threeLetters.length;i++)
        {
            int index = RANDOM.nextInt(threeLetters.length);
            temp = threeLetters[index];
            threeLetters[index]=threeLetters[i];
            threeLetters[i]=temp;
        }
        String[] random3Letters = new String[threeLetters.length];
        for(int i =0;i<threeLetters.length;i++)
            random3Letters[i]=threeLetters[i];
        return random3Letters;
    }

    //To check whether user has clicked the right button
    public boolean findRightAnswer(String string)
    {
        return string.equalsIgnoreCase(String.valueOf(takeRightLetter(svWord)));

    }

    //show game result
    public String gameResult(boolean clickedRightBtn,int counter)
    {
        if(counter ==sv.length)
        {
            return "You have finished all questions";
        }
        else if(clickedRightBtn)
        {
            return "Congratulation!You are right";
        }else
        {
            return "Cheer up and try again!";
        }

    }
    //Counter plus
    public void counterPlus()
    {
        counter++;
        if(counter<4) {
            enWord = en[counter];
            svWord = sv[counter];
        }
        Log.d("Index is ",String.valueOf(counter));
    }

    public int getCounter() {
        return counter;
    }
}

