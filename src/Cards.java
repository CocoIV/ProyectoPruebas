import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Cards implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String NOMBRE_ARCHIVO = "cartas.ser";

    private String nombre;
    private int vida;
    private int danio;
    private String habilidades;
    private int costoMana;

    public Cards(String nombre, int vida, int danio, String habilidades, int costoMana) {
        this.nombre = nombre;
        this.vida = vida;
        this.danio = danio;
        this.habilidades = habilidades;
        this.costoMana = costoMana;
    }

    Cards(String name, int health, int damage, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public int getCostoMana() {
        return costoMana;
    }

    // Otros getters y setters
    public void setCostoMana(int costoMana) {
        this.costoMana = costoMana;
    }

    public static Set<Cards> cargarCartas() {
        Set<Cards> cartas = new HashSet<>();
        File archivo = new File(NOMBRE_ARCHIVO);
        if (archivo.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
                cartas = (Set<Cards>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cartas;
    }

    public static void guardarCartas(Set<Cards> cartas) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            outputStream.writeObject(cartas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Cargar cartas existentes desde el archivo
        Set<Cards> cartas = cargarCartas();

        // Leer datos para crear una nueva carta
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Ingrese el nombre de la carta: ");
            String nombre = reader.readLine();
            System.out.print("Ingrese la vida de la carta: ");
            int vida = Integer.parseInt(reader.readLine());
            System.out.print("Ingrese el daño de la carta: ");
            int danio = Integer.parseInt(reader.readLine());
            System.out.print("Ingrese las habilidades de la carta: ");
            String habilidades = reader.readLine();
            System.out.print("Ingrese el costo de mana de la carta: ");
            int costoMana = Integer.parseInt(reader.readLine());

            // Crear nueva carta y agregarla al conjunto
            Cards nuevaCarta = new Cards(nombre, vida, danio, habilidades, 
                    costoMana);
            cartas.add(nuevaCarta);

            // Guardar las cartas actualizadas en el archivo
            guardarCartas(cartas);

            System.out.println("Carta creada y guardada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar las cartas
        for (Cards carta : cartas) {
            System.out.println("Nombre: " + carta.getNombre());
            System.out.println("Vida: " + carta.getVida());
            System.out.println("Daño: " + carta.getDanio());
            System.out.println("Habilidades: " + carta.getHabilidades());
            System.out.println("Costo de Mana: " + carta.getCostoMana());
            System.out.println("------------");
        
        }
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getHealth() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getDamage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}