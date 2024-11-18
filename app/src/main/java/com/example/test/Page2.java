package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Page2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView x1111, d, n, Sn;
    String kefel, x1, hibor;
    ListView listView;
    String[] arr = new String[20];
    boolean ok;
    Button return_btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2);
        listView = findViewById(R.id.listView);
        x1111 = findViewById(R.id.x1111);
        d = findViewById(R.id.d);
        n = findViewById(R.id.n);
        Sn = findViewById(R.id.Sn);
        return_btn = findViewById(R.id.return_btn);

        Intent gi = getIntent();
        ok = gi.getBooleanExtra("handsit_hesbonit", true);
        if (ok) {
            hibor = gi.getStringExtra("hibor2");
            x1 = gi.getStringExtra("x111");
            kefel = "0";
        } else {
            kefel = gi.getStringExtra("kefel2");
            x1 = gi.getStringExtra("x111");
            hibor = "0";
        }
        listView.setOnItemClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        llvie();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        listView.setAdapter(adapter);
    }

    public void llvie() {
        double hibor3 = Double.parseDouble(hibor);
        double x12 = Double.parseDouble(x1);
        double kefel3 = Double.parseDouble(kefel);
        for (int i = 0; i < 20; i++) {
            double term;
            if (ok) {
                term = x12 + i * hibor3;
            } else {
                term = x12 * Math.pow(kefel3, i);
            }
            arr[i] = String.valueOf(term);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long rowid) {
        x1111.setText("x1= " + x1);
        if (ok) {
            d.setText("d= hesbonit");
        } else {
            d.setText("d= handsit");
        }
        n.setText("n= " + pos);
        Sn.setText("Sn= " + arr[pos]);
    }

    public void prev3(View view)
    {
        finish();
    }
}