package com.samoylenko.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSave;
    private Button buttonIndicator;
    private Button buttonPressure;
    private EditText fmnPatient;
    private EditText agePatient;
    protected static User user = null;
    private static final String TAG = "Главное окно";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Открыто приложение. Начало отображения окна");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        buttonSave = findViewById(R.id.button_save_pressure);
        buttonIndicator = findViewById(R.id.button_go_indicator);
        buttonPressure = findViewById(R.id.button_go_pressure);
        fmnPatient = findViewById(R.id.fmn_patient);
        agePatient = findViewById(R.id.age_patient);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Клик по кнопке Сохранить");
                String fmn = fmnPatient.getText().toString();
                String ageString = agePatient.getText().toString();
                if (fmn.isEmpty() | ageString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.no_all_value,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Log.i(TAG, "Сохранение данных");
                    Integer age = Integer.parseInt(agePatient.getText().toString());
                    user = new User(fmn, age);
                    Log.i(TAG, "Начало перехода в окно Давление");
                    Intent intent = new Intent(getApplicationContext(), PressureActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), R.string.all_value_success,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Клик по кнопке - Показатели");
                Intent intent = new Intent(getApplicationContext(), IndicatorActivity.class);
                startActivity(intent);
            }
        });

        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Клик по кнопке Давление");
                Intent intent = new Intent(getApplicationContext(), PressureActivity.class);
                startActivity(intent);
            }
        });
    }


}
