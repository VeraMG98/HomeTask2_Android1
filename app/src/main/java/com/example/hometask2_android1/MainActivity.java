package com.example.hometask2_android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num_first, num_second, num_third, num_calculate;
    Button button_result, button_second_result;
    TextView textView_result, textView_second_result;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inElements();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(key, textView_result.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = savedInstanceState.getString(key);
        textView_result.setText(text);
    }

    public void inElements() {
        key = "Key";
        num_first = findViewById(R.id.first_num);
        num_second = findViewById(R.id.second_num);
        num_third = findViewById(R.id.third_num);
        num_calculate = findViewById(R.id.calculate_edit);
        textView_result = findViewById(R.id.result);
        textView_second_result = findViewById(R.id.second_result);
        button_result = findViewById(R.id.button_sum);
        button_second_result = findViewById(R.id.button_result);

        button_result.setOnClickListener(v -> {
            if (TextUtils.isEmpty(num_first.getText().toString())
                    || TextUtils.isEmpty(num_second.getText().toString())
                    || TextUtils.isEmpty(num_third.getText().toString())) {
                return;
            }
            int result = Integer.parseInt(num_first.getText().toString())
                    + Integer.parseInt(num_second.getText().toString())
                    + Integer.parseInt(num_third.getText().toString());
            textView_result.setText( "Result: " + result);
        });
    }
}