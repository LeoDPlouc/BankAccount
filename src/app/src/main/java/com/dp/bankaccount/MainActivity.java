package com.dp.bankaccount;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.util.Base64;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView balance;
    Button refresh;
    Spinner spinner;

    Account[] accounts;

    @Override
    protected void onStart() {
        super.onStart();

        balance = (TextView)findViewById(R.id.main_balance);
        refresh = (Button)findViewById(R.id.main_refresh);
        spinner = (Spinner)findViewById(R.id.main_account);

        refresh.setOnClickListener(view -> fetchBalance());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                balance.setText(String.valueOf(accounts[i].getAmount()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fetchBalance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected  void fetchAccounts(){
        accounts = API.FetchAcounts();

        List<String> accountsName = new ArrayList<String>();
        for (Account a: accounts) {
            accountsName.add(a.getAccountName());
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                accountsName);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    protected void fetchBalance() {
        fetchAccounts();
        balance.setText(String.valueOf(accounts[0].getAmount()));
    }
}