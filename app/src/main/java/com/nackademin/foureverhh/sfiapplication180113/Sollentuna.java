package com.nackademin.foureverhh.sfiapplication180113;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sollentuna extends AppCompatActivity implements View.OnClickListener{

    static final Uri Sollentuna_SFI_Link = Uri.parse("https://www.sollentuna.se/sv/uweb/kunskapsparken/om-oss/drop-in-tider/");
    TextView hyperLink;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sollentuna);

        hyperLink = findViewById(R.id.sollentunaPage);
        hyperLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Sollentuna_SFI_Link);
        startActivity(intent);
    }
}
