package com.example.gestionmateriel;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.entite.Ville;
import com.example.gestionmateriel.service.RequestMaker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    public void testConversion() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON file and convert to java object

        InputStream fileInputStream = InstrumentationRegistry.getTargetContext().getAssets().open("clients_contacts.json");
        List<Client> clients = mapper.readValue(fileInputStream, new TypeReference<List<Client>>(){});
        fileInputStream.close();

        assertEquals(5, clients.size());
    }

    @Test
    public void testRequete() {

    }


}
