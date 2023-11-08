import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardManager {
    private static final String NOMBRE_ARCHIVO = "cartas.ser";

    public static void guardarCartas(List<Cards> cartas) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            outputStream.writeObject(cartas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cards> cargarCartas() {
        List<Cards> cartas = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            cartas = (List<Cards>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // No hay cartas guardadas o el archivo no se puede leer, en este caso, retornamos una lista vacía.
            e.printStackTrace();
        }
        return cartas;
    }
}