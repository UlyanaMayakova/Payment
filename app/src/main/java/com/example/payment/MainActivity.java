package com.example.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {

    private EditText moneyInput;
    private CheckBox bank;
    private CheckBox mobile;
    private CheckBox cash;
    private EditText info;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyInput = findViewById(R.id.money);
        bank = findViewById(R.id.bankCheck);
        mobile = findViewById(R.id.mobileCheck);
        cash = findViewById(R.id.cashCheck);
        info = findViewById(R.id.information);
        ok = findViewById(R.id.okBtn);

        int money = 0;
        final int finalMoney;
        try {
            money = Integer.parseInt(moneyInput.getText().toString());
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Введите число", Toast.LENGTH_LONG).show();
        }
        finalMoney = money;

        bank.setOnCheckedChangeListener(checkedChangeListener);
        mobile.setOnCheckedChangeListener(checkedChangeListener);
        cash.setOnCheckedChangeListener(checkedChangeListener);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int money = 0;
                final int finalMoney;
                try {
                    money = Integer.parseInt(moneyInput.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Введите число", Toast.LENGTH_LONG).show();
                }
                finalMoney = money;
                String result = "Оплата " + finalMoney + " рублей";
                Toast.makeText(MainActivity.this, result , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void resetCheckBoxes() {
        bank.setChecked(false);
        mobile.setChecked(false);
        cash.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCheck:
                        resetCheckBoxes();
                        bank.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_NUMBER);
                        info.setHint(R.string.hint_bank);
                        break;
                    case R.id.mobileCheck:
                        resetCheckBoxes();
                        mobile.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_PHONE);
                        info.setHint(R.string.hint_mobile);
                        break;
                    case R.id.cashCheck:
                        resetCheckBoxes();
                        cash.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_TEXT);
                        info.setHint(R.string.hint_cash);
                        break;
                }
            }
        }
    };
}