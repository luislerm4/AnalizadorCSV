import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AnalizadorCSV {

    public static void main(String[] args) {
        // 1. Cargar archivo de propiedades
        Properties propiedades = new Properties();

        try (FileInputStream archivo = new FileInputStream("config/application.properties")) {
            propiedades.load(archivo);
        } catch (IOException e) {
            System.out.println("Se utilizará configuración predeterminada.");
        }

        String separador = ",";

        separador = propiedades.getProperty("separador", separador);

        // 4. Revisar variable de ambiente
        separador = System.getenv().getOrDefault("CSV_SEPARATOR", separador);

        if (args.length >= 2) {
            separador = args[1];
        }

        String archivoDatos = args.length >= 1
                ? args[0]
                : propiedades.getProperty("archivo", "datos/datos.csv");

        System.out.println("Archivo: " + archivoDatos);
        System.out.println("Separador final utilizado: " + separador);
    }
}