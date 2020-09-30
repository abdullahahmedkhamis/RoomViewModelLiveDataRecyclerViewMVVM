package roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import com.example.roomviewmodellivedatarecyclerviewmvvm.R;

import java.util.Calendar;

import roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.roomviewmodellivedatarecyclerviewmvvm.BroadcastReceiver.Notification_reciever;

public class MainActivity4 extends AppCompatActivity {

    final String WebsiteURL = "http://www.mytestbuddy.com";

    String cookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main4 );

        getWindow().getDecorView().setBackgroundColor( Color.WHITE );

        Intent myIntent = new Intent( MainActivity4.this, Notification_reciever.class );  // AlarmReceiver

        final PendingIntent pendingIntent = PendingIntent.getBroadcast(
                MainActivity4.this, 0, myIntent, 0 );
        final AlarmManager alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE );

        CookieSyncManager.createInstance( this );
        CookieManager cm = CookieManager.getInstance();
        cm.setAcceptCookie( true );
        CookieSyncManager.getInstance().sync();
        if (cm.getCookie( "" + WebsiteURL + "" ) != null) {
            cookie = cm.getCookie( "" + WebsiteURL + "" ).toString();
        } else {
            cookie = null;
        }

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep( 5000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (cookie == null) {
                        Intent openStartingPoint = new Intent(
                                "com.MobileWeb.mytestbuddy.Login" );
                        startActivity( openStartingPoint );
                    } else if (cookie.contains( "Premium" )) {

                        Calendar firingCal = Calendar.getInstance();
                        Calendar currentCal = Calendar.getInstance();

                        firingCal.set( Calendar.HOUR, 10 );
                        firingCal.set( Calendar.MINUTE, 30 );
                        firingCal.set( Calendar.SECOND, 0 );

                        long intendedTime = firingCal.getTimeInMillis();
                        long currentTime = currentCal.getTimeInMillis();

                        if (intendedTime >= currentTime) {
                            alarmManager.setRepeating( AlarmManager.RTC,
                                    intendedTime, AlarmManager.INTERVAL_DAY,
                                    pendingIntent );

                        } else {
                            firingCal.add( Calendar.DAY_OF_MONTH, 1 );
                            intendedTime = firingCal.getTimeInMillis();

                            alarmManager.setRepeating( AlarmManager.RTC,
                                    intendedTime, AlarmManager.INTERVAL_DAY,
                                    pendingIntent );
                        }

                        Intent openStartingPoint = new Intent(
                                "com.MobileWeb.mytestbuddy.PremiumMain" );
                        startActivity( openStartingPoint );
                    } else {

                        Calendar firingCal = Calendar.getInstance();
                        Calendar currentCal = Calendar.getInstance();

                        firingCal.set( Calendar.HOUR, 10 );
                        firingCal.set( Calendar.MINUTE, 30 );
                        firingCal.set( Calendar.SECOND, 0 );

                        long intendedTime = firingCal.getTimeInMillis();
                        long currentTime = currentCal.getTimeInMillis();

                        if (intendedTime >= currentTime) {
                            alarmManager.setRepeating( AlarmManager.RTC,
                                    intendedTime, AlarmManager.INTERVAL_DAY,
                                    pendingIntent );

                        } else {
                            firingCal.add( Calendar.DAY_OF_MONTH, 1 );
                            intendedTime = firingCal.getTimeInMillis();

                            alarmManager.setRepeating( AlarmManager.RTC,
                                    intendedTime, AlarmManager.INTERVAL_DAY,
                                    pendingIntent );
                        }

                        Intent openStartingPoint = new Intent(
                                "com.MobileWeb.mytestbuddy.Main" );
                        startActivity( openStartingPoint );
                    }
                }
            }
        };

        timer.start();
    }
}