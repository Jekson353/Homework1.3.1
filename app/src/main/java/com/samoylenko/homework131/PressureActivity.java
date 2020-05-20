package com.samoylenko.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

public class PressureActivity extends AppCompatActivity {

    private TextView textResult;
    private EditText nowDate;
    private EditText nowTime;
    private EditText lowPres;
    private EditText highPres;
    private EditText pulse;
    private Button save;
    private Button cancel;
    //public  Time time;
    private static final String TAG = "Окно Запись давления";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //txtName = getIntent().getExtras().getString("user");
        //txtName = getIntent().getStringExtra("user");
        if (MainActivity.user == null) {
            Log.i(TAG, "Пользователь не заведен, перенаправление на страницу с уведомлением");
            Intent intent = new Intent(getApplicationContext(), EmptyActivity.class);
            startActivity(intent);
            finish();
        } else {
            Log.i(TAG, "Пользователь заведен. Начало отображения окна");
            setContentView(R.layout.activity_pressure);
            init();
        }
    }

    private void init() {

        textResult = findViewById(R.id.textView14);
        nowDate = findViewById(R.id.date_meassurement);
        nowTime = findViewById(R.id.time_meassurement);
        lowPres = findViewById(R.id.value_lower_pressure);
        highPres = findViewById(R.id.value_top_pressure);
        pulse = findViewById(R.id.value_pulse);
        save = findViewById(R.id.button_save_pressure);
        cancel = findViewById(R.id.cancel_pressure);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(R.id.tachycardia_no);


        final DateFormat dateFormat = DateFormat.getDateInstance();
        final Date date = new Date();
        final String data1 = dateFormat.format(date);
        nowDate.setText(data1);
        nowDate.setEnabled(false);
        nowDate.setFocusable(false);

        final Time time = new Time(date.getTime());
        final String nowTime2 = time.toString();
        nowTime.setText(nowTime2);
        nowTime.setEnabled(false);
        nowDate.setFocusable(false);

        String patient = getString(R.string.patient, MainActivity.user.getFmn());
        textResult.setText(patient);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), R.string.no_val_tach,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tachycardia_yes:
                        Log.i(TAG, "Выбран параметр тахикардия = да");
                        Toast.makeText(getApplicationContext(), R.string.tachy_yes,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tachycardia_no:
                        Log.i(TAG, "Выбран параметр тахикардия = нет");
                        Toast.makeText(getApplicationContext(), R.string.tachy_no,
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажата кнопка Сохранить");
                String lPres = lowPres.getText().toString();
                String hPres = highPres.getText().toString();
                String puls = pulse.getText().toString();
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (lPres.isEmpty() | hPres.isEmpty() | puls.isEmpty()) {
                    Log.i(TAG, "Сработала проверка введения всех данных");
                    Toast.makeText(getApplicationContext(), R.string.no_all_value,
                            Toast.LENGTH_SHORT).show();
                } else {
                    int lower = Integer.parseInt(lPres);
                    int high = Integer.parseInt(hPres);
                    int pulse = Integer.parseInt(puls);
                    if (lower > 300 | lower < 10) {
                        Log.i(TAG, "Срабатывание условия параметра Нижнее давление");
                        Toast.makeText(getApplicationContext(), getString(R.string.lowPres_sure, lower),
                                Toast.LENGTH_SHORT).show();
                    } else if (high > 200 | high < 10) {
                        Log.i(TAG, "Срабатывание условия параметра Вернее давление");
                        Toast.makeText(getApplicationContext(), getString(R.string.highPres_sure, high),
                                Toast.LENGTH_SHORT).show();
                    } else if (pulse < 1 | pulse > 400) {
                        Log.i(TAG, "Срабатывание условия параметра Пульс");
                        Toast.makeText(getApplicationContext(), getString(R.string.pulse_sure, pulse),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Button radioButton = (RadioButton) findViewById(selectedId);
                        Pressure pressure = new Pressure(MainActivity.user, lower, high, pulse, radioButton.getText().toString(), date, time);
                        Log.i(TAG, "Успешно добавлена запись о состоянии здоровья");

                        String res = getString(R.string.result_pressure_text, MainActivity.user.getFmn(), lower, high, pulse, radioButton.getText(), data1, time);
                        textResult.setText(res);

                        Toast.makeText(getApplicationContext(), R.string.all_value_success,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажата кнопка Отмена");
                finish();
            }
        });

    }
}
