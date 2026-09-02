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

        String archivoDatos = propiedades.getProperty("archivo", "datos/datos.csv");
        String separador = propiedades.getProperty("separador", ",");
        String directorioSalida = propiedades.getProperty("directorioSalida", "salida");

        boolean mostrarDetalles = Boolean.parseBoolean(
                propiedades.getProperty("mostrarDetalles", "false")
        );
        int maxRegistros = Integer.parseInt(
                propiedades.getProperty("maxRegistros", "100")
        );

        System.out.println("Archivo: " + archivoDatos);
        System.out.println("Separador: " + separador);
        System.out.println("Directorio: " + directorioSalida);
        System.out.println("Mostrar detalles: " + mostrarDetalles);
        System.out.println("Max registros: " + maxRegistros);
    }
}