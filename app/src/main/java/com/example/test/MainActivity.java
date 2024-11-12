package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText kefel, x1, hibor;
    Button page2;
    Switch hibor_kefel;


    boolean ok = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        x1 = findViewById(R.id.x1111);
        kefel = findViewById(R.id.kefel);
        hibor = findViewById(R.id.hibor);
        page2 = findViewById(R.id.page2);
        hibor_kefel = findViewById(R.id.hibor_kefel);


        x1.setHint("x1");
        kefel.setHint("k");
        hibor.setHint("H");


        kefel.setVisibility(View.INVISIBLE);
        hibor.setVisibility(View.INVISIBLE);
        x1.setVisibility(View.INVISIBLE);
    }

    public void switch2(View v) {
        if (hibor_kefel.isChecked()) {
            kefel.setVisibility(View.INVISIBLE);
            hibor.setVisibility(View.VISIBLE);
            x1.setVisibility(View.VISIBLE);
            ok = true;
        } else {
            hibor.setVisibility(View.INVISIBLE);
            kefel.setVisibility(View.VISIBLE);
            x1.setVisibility(View.VISIBLE);
            ok = false;

        }
    }

    public void nextbtn(View view) {

        String hiborr = hibor.getText().toString();
        String x11 = x1.getText().toString();
        String kefell = kefel.getText().toString();


        if (ok == false) {
            if (x11.isEmpty() || x11.equals("-") || x11.equals("-.") || x11.equals("+") || x11.equals("+.") || kefell.isEmpty() || kefell.equals("-") || kefell.equals("-.") || kefell.equals("+") || kefell.equals("+."))
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();

            else {

                Intent si = new Intent(this, Page2.class);
                si.putExtra("x111", x11);
                si.putExtra("kefel2", kefell);
                si.putExtra("handsit_hesbonit", ok);


                startActivity(si);


            }
        } else if (ok == true) {
            if (x11.isEmpty() || x11.equals("-") || x11.equals("-.") || x11.equals("+") || x11.equals("+.") || hiborr.isEmpty() || hiborr.equals("-") || hiborr.equals("-.") || hiborr.equals("+") || hiborr.equals("+."))
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();

            else {

                Intent si = new Intent(this, Page2.class);
                si.putExtra("x111", x11);
                si.putExtra("hibor2", hiborr);
                si.putExtra("handsit_hesbonit", ok);
                x1.setText("");
                kefel.setText("");
                hibor.setText("");

                startActivity(si);


            }
        }


    }
}