public class AnalizadorCSV {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java AnalizadorCSV <archivo.csv> [separador]");
            return;
        }

        String archivo = args[0];
        String separador = ",";

        if (args.length >= 2) {
            separador = args[1];
        }

        String directorioSalida = System.getenv()
                .getOrDefault("ANALIZADOR_OUTPUT", "salida");

        System.out.println("Archivo: " + archivo);
        System.out.println("Separador: " + separador);
        System.out.println("Directorio de salida: " + directorioSalida);
    }
}