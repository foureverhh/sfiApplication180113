package com.nackademin.foureverhh.sfiapplication180113;

/**
 * Created by foureverhh on 2018-01-31.
 */

public class WordMatching {

  public String[] en;
  public String[] sv;
  public String[] svEmpty;
  private int counter;



    public WordMatching()
  {
      en = new String[]{"Hi", "Bye"};
      sv = new String[]{"Hej","Hej då"};
      svEmpty = new String[]{"H_j","Hej d_"};
      counter = 0;

  }

  public void nextWord()
  {
      counter++;
  }

  public int getCounter()
  {
      return counter;
  }

  public boolean match (String str,int counter)
    {
        return str.equals(sv[counter]);
    }

}
