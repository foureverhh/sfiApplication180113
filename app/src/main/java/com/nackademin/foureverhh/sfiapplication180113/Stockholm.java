package com.nackademin.foureverhh.sfiapplication180113;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Stockholm extends AppCompatActivity implements View.OnClickListener{

    static final Uri STOCKHOLM_SFI_URI = Uri.parse("http://www.stockholm.se/ForskolaSkola/Vuxenutbildning/SFI---Utbildning-i-svenska-for-invandrare/Vem-far-studera/");
    TextView  HyperLink;
    //Spanned Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockholm);

        HyperLink = (TextView)findViewById(R.id.stockholmPage);
        HyperLink.setOnClickListener(this);
 /*
        Text = Html.fromHtml(
                "<a href='http://www.stockholm.se/ForskolaSkola/Vuxenutbildning/SFI---Utbildning-i-svenska-for-invandrare/Vem-far-studera/></a>");

        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Text);
        */

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(STOCKHOLM_SFI_URI);
        startActivity(intent);
    }
}
