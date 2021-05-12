package sg.edu.rp.id20006707.l04_reservation;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Button confirm, reset;
    CheckBox smoke;
    EditText name, phone, size;
    DatePicker date;
    TimePicker time;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirm = findViewById(R.id.buttonConfirm);
        reset = findViewById(R.id.buttonReset);
        smoke = findViewById(R.id.checkBoxSmoking);
        name = findViewById(R.id.textName);
        phone = findViewById(R.id.textPhone);
        size = findViewById(R.id.textSize);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isSmoke;
                if (smoke.isChecked()) {
                    isSmoke = "Smoking area";
                } else {
                    isSmoke = "No smoking area";
                }

                if (name.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Name is empty", Toast.LENGTH_LONG).show();
                } else if (phone.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Phone is empty", Toast.LENGTH_LONG).show();
                } else if (size.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Size is empty", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Name: " + name.getText().toString()
                            + "\nPhone: " + phone.getText().toString()
                            + "\nSize: " + size.getText().toString()
                            + "\n" + isSmoke
                            + "\nDate: " + date.getDayOfMonth() + "/" + (date.getMonth() + 1) + "/" + date.getYear()
                            + "\nTime: " + time.getCurrentHour() + ":" + String.format("%02d", time.getCurrentMinute()), Toast.LENGTH_LONG).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                size.setText("");
                date.updateDate(2021, 5, 1);
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                smoke.setChecked(false);
            }
        });
    }
}