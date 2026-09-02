import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {

    private String archivo;
    private String separador;
    private String directorioSalida;
    private boolean mostrarDetalles;
    private int maxRegistros;

    public Configuracion(String[] args) {
        Properties propiedades = cargarPropiedades();

        // 1. Valores por defecto y lectura de application.properties
        this.archivo = propiedades.getProperty("archivo", "datos/datos.csv");
        this.separador = propiedades.getProperty("separador", ",");
        this.directorioSalida = propiedades.getProperty("directorioSalida", "salida");

        this.mostrarDetalles = Boolean.parseBoolean(
                propiedades.getProperty("mostrarDetalles", "false")
        );

        try {
            this.maxRegistros = Integer.parseInt(
                    propiedades.getProperty("maxRegistros", "100")
            );
        } catch (NumberFormatException e) {
            this.maxRegistros = 100;
        }

        // 2. Variables de ambiente
        this.separador = System.getenv().getOrDefault("CSV_SEPARATOR", this.separador);
        this.directorioSalida = System.getenv().getOrDefault("ANALIZADOR_OUTPUT", this.directorioSalida);

        // 3. Argumentos de línea de comandos (Máxima prioridad)
        if (args.length >= 1) {
            this.archivo = args[0];
        }

        if (args.length >= 2) {
            this.separador = args[1];
        }
    }

    private Properties cargarPropiedades() {
        Properties propiedades = new Properties();

        try (FileInputStream entrada = new FileInputStream("config/application.properties")) {
            propiedades.load(entrada);
        } catch (IOException e) {
            System.out.println("Archivo de configuración no disponible.");
        }

        return propiedades;
    }

    public String getArchivo() {
        return archivo;
    }

    public String getSeparador() {
        return separador;
    }

    public String getDirectorioSalida() {
        return directorioSalida;
    }

    public boolean isMostrarDetalles() {
        return mostrarDetalles;
    }

    public int getMaxRegistros() {
        return maxRegistros;
    }
}