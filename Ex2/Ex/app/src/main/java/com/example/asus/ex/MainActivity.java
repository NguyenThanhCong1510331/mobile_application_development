package com.example.asus.ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnFrom;
    Button btnTo;
    Button btnCon;
    Button btnClear;
    EditText moneyText;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyText = (EditText) findViewById(R.id.txt_input);

        btnFrom = (Button) findViewById(R.id.btn_from);
        btnFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                showMenuFrom();
            }
        });

        btnTo = (Button) findViewById(R.id.btn_to);
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                showMenuTo();
            }
        });

        btnCon = (Button) findViewById(R.id.btn_convert);
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConvert();
            }
        });

        result = (TextView) findViewById(R.id.txt_output);

        btnClear = (Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClear();
            }
        });

    }

    private void showMenuFrom() {
        PopupMenu popupMenu = new PopupMenu(this, btnFrom);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_vnd: btnFrom.setText("VND");
                        break;
                    case R.id.menu_eur: btnFrom.setText("EUR");
                        break;
                    case R.id.menu_usd: btnFrom.setText("USD");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void showMenuTo() {
        PopupMenu popupMenu = new PopupMenu(this, btnTo);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_vnd: btnTo.setText("VND");
                        break;
                    case R.id.menu_eur: btnTo.setText("EUR");
                        break;
                    case R.id.menu_usd: btnTo.setText("USD");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void showConvert() {
        String money = moneyText.getText().toString();
        if (!money.equals("")) {
            float aMoney = Float.parseFloat(money);
            if (btnFrom.getText().equals("USD") && btnTo.getText().equals("VND")) {
                aMoney = aMoney * 22802;
                result.setText(money + " USD = " + aMoney + " VND");
            } else if (btnFrom.getText().equals("VND") && btnTo.getText().equals("USD")) {
                aMoney = aMoney / 22802;
                result.setText(money + " VND = " + aMoney + " USD");
            } else if (btnFrom.getText().equals("EUR") && btnTo.getText().equals("VND")) {
                aMoney = aMoney * 28007;
                result.setText(money + " EUR = " + aMoney + " VND");
            } else if (btnFrom.getText().equals("VND") && btnTo.getText().equals("EUR")) {
                aMoney = aMoney / 28007;
                result.setText(money + " VND = " + aMoney + " EUR");
            } else if (btnFrom.getText().equals("EUR") && btnTo.getText().equals("USD")) {
                aMoney = aMoney * 1.2282f;
                result.setText(money + " EUR = " + aMoney + " USD");
            } else if (btnFrom.getText().equals("USD") && btnTo.getText().equals("EUR")) {
                aMoney = aMoney / 1.2282f;
                result.setText(money + " USD = " + aMoney + " EUR");
            } else {
                Toast.makeText(MainActivity.this, "Select the currency", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(MainActivity.this, "Enter the money", Toast.LENGTH_LONG).show();
        }
    }

    private void showClear() {
        moneyText.setText("");
        btnFrom.setText("PRESS TO CHANGE");
        btnTo.setText("PRESS TO CHANGE");
        result.setText("Result");
    }

}
