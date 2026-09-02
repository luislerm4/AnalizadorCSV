public class AnalizadorCSV {

    public static void main(String[] args) {
        Configuracion config = new Configuracion(args);

        System.out.println("Archivo: " + config.getArchivo());
        System.out.println("Separador final utilizado: " + config.getSeparador());
        System.out.println("Directorio de salida: " + config.getDirectorioSalida());
        System.out.println("Mostrar detalles: " + config.isMostrarDetalles());
        System.out.println("Max registros: " + config.getMaxRegistros());
    }
}