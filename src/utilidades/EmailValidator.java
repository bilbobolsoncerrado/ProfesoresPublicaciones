package utilidades;

public class EmailValidator {
/*Método de VALIDACIÓN del Email [0.75p]: nombreusuario@nombreDominio.extensiónDominio
Se debe validar el formato y que solo contenga caracteres validos:
- Para el nombre del usuario son aceptados: letras, números, “.” y “_”
- Para el dominio y extensión solo letras
Ejemplo valido: carmen.pascual@tartanga.eus, ismael_molano7@hotmail.com
Ejemplos no validos: mariano@gmail, mariano r@gmail.com, asier@g.mail.com*/
    public static boolean validarEmail(String email) {
        // Dividir el email en partes usando el símbolo '@'
        String[] partes = email.split("@");
        if (partes.length != 2) {
            return false; // Debe haber una sola '@'
        }

        String nombreUsuario = partes[0];
        String dominioYExtension = partes[1];

        // Validar el nombre del usuario
        if (!validarNombreUsuario(nombreUsuario)) {
            return false;
        }

        // Dividir el dominio y la extensión
        String[] dominioPartes = dominioYExtension.split("\\.");
        if (dominioPartes.length != 2) {
            return false; // Debe tener dominio y extensión separados por un '.'
        }

        String dominio = dominioPartes[0];
        String extension = dominioPartes[1];

        // Validar dominio y extensión
        if (!esSoloLetras(dominio) || !esSoloLetras(extension)) {
            return false;
        }

        return true; // Si pasa todas las validaciones
    }

    private static boolean validarNombreUsuario(String nombreUsuario) {
        for (char c : nombreUsuario.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '.' || c == '_')) {
                return false; // Caracter no permitido
            }
        }
        return !nombreUsuario.isEmpty(); // No puede estar vacío
    }

    private static boolean esSoloLetras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false; // No es una letra
            }
        }
        return !texto.isEmpty(); // No puede estar vacío
    }

    public static void main(String[] args) {
        // Ejemplos de prueba
        String[] correos = {
            "carmen.pascual@tartanga.eus",
            "ismael_molano7@hotmail.com",
            "mariano@gmail",
            "mariano r@gmail.com",
            "asier@g.mail.com"
        };

        for (String correo : correos) {
            System.out.println(correo + " -> " + (validarEmail(correo) ? "Válido" : "Inválido"));
        }
    }
}
