package com.example.alumno.clasetres;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by alumno on 25/04/2019.
 */

public class ParseXml {
    public static List<Persona> getPersonas(String miString){
        List<Persona> personas = new ArrayList<>();

        XmlPullParser parser = Xml.newPullParser();

        try {
            parser.setInput(new StringReader(miString));
             int event = parser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){
                if (event == XmlPullParser.START_TAG){
                    if ("Persona".equals(parser.getName())){

                        Persona p = new Persona();
                        String n = parser.getAttributeValue(null,"nombre");
                        p.setNombre(n);
                        String a = parser.getAttributeValue(null,"apellido");
                        p.setApellido(a);
                        String t = parser.getAttributeValue(null,"tel");
                        p.setTelefono(a);
                        String i = parser.nextText();
                        p.setImagen(i);
                        personas.add(p);
                    }
                }

                event = parser.next();
            }
            return personas;

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
