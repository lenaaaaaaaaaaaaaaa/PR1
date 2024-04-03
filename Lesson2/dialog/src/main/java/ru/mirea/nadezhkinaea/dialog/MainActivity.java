package ru.mirea.nadezhkinaea.dialog;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.time.Month;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    public void onClickShowDialog(View view) {
        MyDialogActivity dialogFragment = new MyDialogActivity();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
    private String _showTextInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTimeDialog(View view) {
        MyTimeDialogFragment _timeDialog = new MyTimeDialogFragment(this, (view1, hourOfDay, minute) -> {
            _showTextInfo = String.format(Locale.getDefault(),
                    "ЧАСЫ: %d    МИНУТЫ: %d", hourOfDay, minute);
            useSnackbar(view, _showTextInfo);
        }, 0, 0, true);
        _timeDialog.show();
        useSnackbar(view, "Time Picker Opened");
    }

    public void showDateDialog(View view) {
        MyDateDialogFragment _dateDialog = new MyDateDialogFragment(this, (view1, year, month, dayOfMonth) -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                _showTextInfo = String.format(Locale.getDefault(),
                        "ГОД: %d    МЕСЯЦ: %s    ДЕНЬ: %d", year, Month.of(month + 1), dayOfMonth);
            }
            useSnackbar(view, _showTextInfo);
        }, 2024, 3, 10);
        _dateDialog.show();
        useSnackbar(view, "Date Picker Opened");
    }

    public void showProgressDialog(View view) {
        MyProgressDialogFragment _progressDialog = new MyProgressDialogFragment(this);
        _progressDialog.setTitle("Progress Dialog");
        _progressDialog.setMessage("Loading...");
        _progressDialog.show();
        useSnackbar(view, "Progress Dialog Opened");
    }

    private void useSnackbar(View view, String _showTextInfo) {
        Snackbar.make(view, _showTextInfo, Snackbar.LENGTH_LONG).show();
    }
}