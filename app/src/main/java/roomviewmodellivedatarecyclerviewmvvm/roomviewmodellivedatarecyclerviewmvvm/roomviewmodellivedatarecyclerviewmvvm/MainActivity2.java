package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.roomviewmodellivedatarecyclerviewmvvm.R;

import java.util.Calendar;

import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.BroadcastReceiver.Catcher;

public class MainActivity2 extends AppCompatActivity {

   // DatePicker datePicker;
   // TimePicker timePicker;

     EditText date;
     EditText time;

    Button button;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

       // datePicker = (DatePicker) findViewById(R.id.datePickertime);
       // timePicker = (TimePicker) findViewById(R.id.timePickertime);

        date = (EditText) findViewById(R.id.editTextTextPersonName2);
        time = (EditText) findViewById(R.id.editTextTextPersonName3);

        button = (Button) findViewById(R.id.buttontime);

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
              //  c.set(date.getYear(), date.getMonth(), date.getDayOfMonth(), time.getCurrentHour(), time.getCurrentMinute());
                long time = c.getTimeInMillis();
                SharedPreferences sh = getSharedPreferences("save", 0);
                SharedPreferences.Editor e = sh.edit();
                e.putLong("mills", time);
                e.putBoolean("state",true);
                e.commit();
                Intent intent = new Intent(MainActivity2.this, Catcher.class);
                PendingIntent p = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager v3 = (AlarmManager) getSystemService(ALARM_SERVICE);
                v3.set( AlarmManager.RTC_WAKEUP, time, p);
                finish();
            }
        }); */
    }
}