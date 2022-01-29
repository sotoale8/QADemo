package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {
    //Atributo
    private static Properties properties;

    public static String obtenerProperty(String key){
        properties = new Properties();

        String rutaProperties= "C:\\Users\\sotoa\\IdeaProjects\\QADemoAutomationTests\\src\\test\\resources\\properties.properties";
        try {
            InputStream archivo = new FileInputStream(rutaProperties);
            properties.load(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return properties.getProperty(key);
    }
}
