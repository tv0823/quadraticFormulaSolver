package com.example.quadraticformulasolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText a, b, c;
    Intent si;
    String aStr, bStr, cStr;
    Random rnd = new Random();;
    final int REQUEST_CODE = 3602;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);

        si = new Intent(this,SolutionActivity.class);
    }

    public void randomNums(View view) {
        a.setText("" + (rnd.nextInt(1000 + 1000)-1000));
        b.setText("" + (rnd.nextInt(1000 + 1000)-1000));
        c.setText("" + (rnd.nextInt(1000 + 1000)-1000));
    }

    public void getValues(View view) {
        aStr = a.getText().toString();
        bStr = b.getText().toString();
        cStr = c.getText().toString();

        if (aStr.isEmpty() || bStr.isEmpty() || cStr.isEmpty() || aStr.equals("-") || cStr.equals("-") || bStr.equals("-") || aStr.equals(".") || bStr.equals(".") || cStr.equals(".") || aStr.equals("-.") || cStr.equals("-.") || bStr.equals("-.")) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
        else if(Double.parseDouble(aStr) == 0.0) {
            Toast.makeText(this, "a cannot be equal to 0", Toast.LENGTH_SHORT).show();
        }
        else {
            si.putExtra("a", Double.parseDouble(aStr));
            si.putExtra("b", Double.parseDouble(bStr));
            si.putExtra("c", Double.parseDouble(cStr));
            startActivityForResult(si, REQUEST_CODE);
        }
    }
}