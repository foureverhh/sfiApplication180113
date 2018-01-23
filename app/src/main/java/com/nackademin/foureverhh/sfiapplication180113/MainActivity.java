package com.nackademin.foureverhh.sfiapplication180113;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    RadioGroup municipality;
    Button confirm;
    Button quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        municipality = (RadioGroup) findViewById(R.id.rdg_Kommun);
        confirm = (Button)findViewById(R.id.btn_Confirm);
        quiz = findViewById(R.id.btn_prove);

        confirm.setOnClickListener(this);
        quiz.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent intent;

        if(municipality.getCheckedRadioButtonId()==R.id.stockholm) {
            intent = new Intent(this,Stockholm.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.btn_prove)
        {
            intent = new Intent(this,WordPuzzle.class);
            startActivity(intent);
        }

    }

}



