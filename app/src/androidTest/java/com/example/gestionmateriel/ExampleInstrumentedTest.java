package com.example.gestionmateriel;

import android.content.Context;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.example.gestionmateriel.entite.Ville;
import com.example.gestionmateriel.service.VilleRepository;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.gestionmateriel", appContext.getPackageName());
    }

    @Test
    public void testConversionJsonVille() throws IOException {
        VilleRepository vr = new VilleRepository();
        List<Ville> villes = vr.getAll();

        for(Ville v : villes) {
            Log.i("TEST", v.toString());
        }
    }
}
