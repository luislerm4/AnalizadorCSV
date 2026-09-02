public class AnalizadorCSV {

    public static void main(String[] args) {
        Configuracion configuracion = new Configuracion(args);

        System.out.println("Configuración de la aplicación");
        System.out.println("Archivo: " + configuracion.getArchivo());
        System.out.println("Separador: " + configuracion.getSeparador());
        System.out.println("Salida: " + configuracion.getDirectorioSalida());
    }
}