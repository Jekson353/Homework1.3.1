package com.samoylenko.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class IndicatorActivity extends AppCompatActivity {
    private EditText weight;
    private EditText steps;
    private EditText date;
    private TextView result;
    private Button save;
    private Button cancel;
    private static final String TAG = "Жизненные показатели";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MainActivity.user == null) {
            Log.i(TAG, "Пользователь не заведен, перенаправление на страницу с уведомлением");
            Intent intent = new Intent(getApplicationContext(), EmptyActivity.class);
            startActivity(intent);
            finish();
        } else {
            Log.i(TAG, "Пользователь заведен. Начало отображения окна");
            setContentView(R.layout.activity_indicator);
            init();
        }
    }

    private void init() {
        weight = findViewById(R.id.value_weight);
        steps = findViewById(R.id.value_steps);
        date = findViewById(R.id.value_meassurement_indicator);
        save = findViewById(R.id.button_save_pressure);
        cancel = findViewById(R.id.cancel_indicator);
        result = findViewById(R.id.result_indicator);
        date.setEnabled(false);
        date.setFocusable(false);

        DateFormat dateFormat = DateFormat.getDateInstance();
        final Date dates = new Date();
        final String nowData = dateFormat.format(dates);
        date.setText(nowData);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Клик по кнопке Сохранить");
                String weightNow = weight.getText().toString();
                String stepsNow = steps.getText().toString();
                if (weightNow.isEmpty() | stepsNow.isEmpty()) {
                    Log.i(TAG, "Сработало условие Введены не все данные");
                    Toast.makeText(getApplicationContext(), R.string.no_all_value,
                            Toast.LENGTH_SHORT).show();
                } else {
                    double weight = Double.parseDouble(stepsNow);
                    int steps = Integer.parseInt(stepsNow);
                    Indicator indicator = new Indicator(MainActivity.user, weight, steps, dates);
                    Log.i(TAG, "Сохранение результатов");

                    String res = getString(R.string.result_indicator_text, MainActivity.user.getFmn(), weightNow, stepsNow, nowData);
                    result.setText(res);

                    Toast.makeText(getApplicationContext(), R.string.all_value_success,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Клик по кнопке Отмена");
                finish();
            }
        });
    }
}
