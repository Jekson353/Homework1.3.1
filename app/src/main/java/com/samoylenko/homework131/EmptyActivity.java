package com.samoylenko.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class EmptyActivity extends AppCompatActivity {
    private static final String TAG = "Окно Пустые данные";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        Log.i(TAG, "Сработало окно уведомлений о пустых данных");
    }
}
