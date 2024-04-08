package com.example.quadraticformulasolver;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class SolutionActivity extends AppCompatActivity {
    Intent gi;
    TextView showAns;
    WebView wV;
    double a, b, c, discriminant, root1, root2;
    String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        showAns = findViewById(R.id.showAns);
        wV =findViewById(R.id.wV);

        wV.getSettings().setJavaScriptEnabled(true);
        wV.setWebViewClient(new MyWebViewClient());

        gi = getIntent();
        a = gi.getDoubleExtra("a",1);
        b = gi.getDoubleExtra("b",1);
        c = gi.getDoubleExtra("c",1);

        solveEquation();
        createAns();

        showAns.setText(ans);
        //wV.loadUrl("https://www.google.com/search?q=" + a + "x%5E2%2B" + b + "*x%2B" + c);
        wV.loadUrl("https://mathforyou.net/en/online/equation/arbitrary/?e0=" + a + "x%5E2%2B" + b + "*x%2B" + c + "&v0=x&o0=1&from=google");
    }

    public void solveEquation(){
        discriminant = b*b-4*a*c;
        root1 = (-b + Math.sqrt(discriminant))/(2*a);
        root2 = (-b - Math.sqrt(discriminant))/(2*a);
    }

    public void createAns(){
        if(discriminant > 0) {
            ans = "X1= " + root1 + "\nX2= " + root2;
        } else if (discriminant == 0) {
            ans = "X1= " + root1;
        } else{
            ans = "There is no solution for this equation";
        }
    }

    public void goBack(View view) {
        gi.putExtra("ans", ans);
        setResult(RESULT_OK, gi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}