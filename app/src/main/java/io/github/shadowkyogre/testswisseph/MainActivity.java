package io.github.shadowkyogre.testswisseph;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import swisseph.SweDate;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView)findViewById(R.id.text_disp);

        Date d = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(d);
        DateFormat DATE_FMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        double hour_double = (double)cal.get(Calendar.HOUR_OF_DAY) +
                ((double)cal.get(Calendar.MINUTE)/60.) +
                ((double)cal.get(Calendar.SECOND)/3600.) +
                ((double)cal.get(Calendar.MILLISECOND)/3600000.);

        SweDate sd = new SweDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1,
                cal.get(Calendar.DAY_OF_MONTH), hour_double, SweDate.SE_GREG_CAL);

        String fmt = "Today is %1$s,\nthat's %2$.5f Julian days";
        tv.setText(String.format(fmt, DATE_FMT.format(d), sd.getJulDay()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
