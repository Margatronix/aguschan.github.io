import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Clientes {
    private int id;
    private int edad;
    private String nombre;
    private ArrayList<Libros> librosComprados;
     private HashMap<Libros, Integer> cantidadLibros;

    public Clientes(int id, int edad, String nombre, ArrayList<Libros> librosComprados, HashMap<Libros, Integer> cantidadLibros) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.librosComprados = new ArrayList<Libros>();
        this.cantidadLibros = new HashMap<Libros, Integer>();
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<Libros, Integer> getCantidadLibros() {
        return cantidadLibros;
    }

    public ArrayList<Libros> getLibrosComprados() {
        return librosComprados;
    }

    public void llenarCantidadLibros() {
        Libros libroejemplo = new Libros();
        int cantidad = 0;
        HashSet<Integer> ids = new HashSet<Integer>();
        for (Libros i:this.librosComprados) {
            ids.add(i.getId());
        }
            for (int e:ids) {
                for (Libros a:this.librosComprados) {
                    if (e == a.getId()) {
                        libroejemplo = a;
                        cantidad ++;
                    }
                }
                cantidadLibros.put(libroejemplo, cantidad);
            }
    }
}
