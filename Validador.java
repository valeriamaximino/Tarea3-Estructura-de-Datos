
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Validador {

    public static ArrayList<String> validar(Registro r) {

        ArrayList<String> errores = new ArrayList<>();

        if (r.getId() <= 0) {
            errores.add("El ID debe ser mayor que cero.");
        }

        if (r.getUbicacion() == null ||
            r.getUbicacion().trim().isEmpty()) {
            errores.add("La ubicacion no puede estar vacia.");
        }

        if (r.getValor() < 0 || r.getValor() > 1000) {
            errores.add("El valor debe estar entre 0 y 1000.");
        }

        if (r.getUnidad() != 'C' &&
            r.getUnidad() != 'H' &&
            r.getUnidad() != 'P') {
            errores.add("Unidad no valida. Use C, H o P.");
        }

        try {
            DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            LocalDateTime.parse(r.getFechaHora(), formato);

        } catch (DateTimeParseException e) {
            errores.add("La fecha debe tener formato dd/MM/yyyy HH:mm.");
        }

        return errores;
    }
}
