import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AnalizadorCSV {

    public static void main(String[] args) {
        Properties propiedades = new Properties();

        try (FileInputStream archivo = new FileInputStream("config/application.properties")) {
            propiedades.load(archivo);
        } catch (IOException e) {
            System.out.println("No fue posible cargar la configuración.");
            return;
        }

        String archivoDatos = propiedades.getProperty("archivo");
        String separador = propiedades.getProperty("separador");
        String directorioSalida = propiedades.getProperty("directorioSalida");

        System.out.println("Archivo: " + archivoDatos);
        System.out.println("Separador: " + separador);
        System.out.println("Directorio: " + directorioSalida);
    }
}