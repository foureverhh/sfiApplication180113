package com.nackademin.foureverhh.sfiapplication180113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Stockholm extends AppCompatActivity {

    TextView  HyperLink;
    Spanned Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockholm);
        /*
        HyperLink = (TextView)findViewById(R.id.stockholmPage);

        Text = Html.fromHtml(
                "<a href='http://www.stockholm.se/ForskolaSkola/Vuxenutbildning/SFI---Utbildning-i-svenska-for-invandrare/Vem-far-studera/></a>");

        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Text);
        */

    }
}
