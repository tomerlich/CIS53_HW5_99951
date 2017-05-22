package edu.deanza.cis53_hw5_99951;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.deanza.cis53_hw5_99951.data.WeatherDbHelper;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static final String APP_TAG = "CIS53_HW6_99951";
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("edu.deanza.cis53_hw5_99951", appContext.getPackageName());
    }

    @Test
    public void testCreateDb() throws Throwable{
        Log.d(APP_TAG, "testCreateDb");
        Context appContext = InstrumentationRegistry.getTargetContext();
        appContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME);
        SQLiteDatabase db = new WeatherDbHelper(
                appContext).getWritableDatabase();
        assertEquals(true, db.isOpen());
        db.close();
    }
}
