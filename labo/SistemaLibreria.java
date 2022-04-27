import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class SistemaLibreria {
    private String nombre;
    private ArrayList<Libros> librosEnVenta = new ArrayList<Libros>();
    private ArrayList<Clientes> clientes = new ArrayList<Clientes>();
    private HashSet<Clientes> clientes2 = new HashSet<Clientes>();
    private ArrayList<Integer> librosEnOferta = new ArrayList<Integer>();
    private ArrayList<Libros> librosVendidos = new ArrayList<Libros>();
    private HashSet<String> editorialesDescuento = new HashSet<String>();
    private HashMap<Integer, Float> clienteYMontoTotal = new HashMap<Integer, Float>();

    public SistemaLibreria(String nombre, ArrayList<Libros> librosEnVenta, ArrayList<Clientes> clientes, HashSet<Clientes> clientes2, ArrayList<Integer> librosEnOferta, ArrayList<Libros> librosVendidos, HashSet<String> editorialesDescuento, HashMap<Integer, Float> clienteYMontoTotal) {
        this.nombre = nombre;
        this.librosEnVenta = new ArrayList<Libros>();
        this.clientes = new ArrayList<Clientes>();
        this.clientes2 = new HashSet<Clientes>();
        this.librosEnOferta = new ArrayList<Integer>();
        this.librosVendidos = new ArrayList<Libros>();
        this.editorialesDescuento = new HashSet<String>();
        this.clienteYMontoTotal = new HashMap<Integer, Float>();
    }

    public ArrayList<Clientes> clientesFrecuentes() {
        ArrayList<Clientes> clientesfrecuentes = new ArrayList<Clientes>();
        for (Clientes i: clientes) {
            if (i.getLibrosComprados().size() > 10) {
                clientesfrecuentes.add(i);
            }
        }
        return clientesfrecuentes;
    }
    public ArrayList<Libros> librosMasVendidos() {
        ArrayList<Libros> librosVendidos = new ArrayList<Libros>();
        int contador = 0;
        for (Libros i: librosEnVenta) {
            for (Clientes messi: clientes2) {
                for (int j = 0; j < clientes.size(); j++) {
                    if (i == messi.getLibrosComprados().get(j)) {
                        contador ++;
                    }
            }


            }
            if (contador > 100) {
                librosVendidos.add(i);
            }
            contador = 0;
        }
        return librosVendidos;
    }
    public ArrayList<Integer> edades(){
        ArrayList<Integer> edadesClientesFrec = new ArrayList<Integer>();
        for (Clientes i: clientesFrecuentes()) {
            edadesClientesFrec.add(i.getEdad());
        }
        return edadesClientesFrec;
    }
    public ArrayList<Libros> librosCaros() {
        ArrayList<Libros> librosMasCaros = new ArrayList<Libros>();
        for (Libros i: librosEnVenta) {
            if (i.getPrecio() > 5500.50) {
                librosMasCaros.add(i);
            }
        }
        return librosMasCaros;
    }
    public void agregarLibro( int id, Libros libro) {
        for (Clientes i: clientes) {
            if (i.getId() == id) {
                i.getLibrosComprados().add(libro);
            }
        }
    }
    public ArrayList<Libros> librosEspecificos(char letra) {
        ArrayList<Libros> librosConXletra = new ArrayList<Libros>();
        for (Libros i: librosEnVenta) {
            if (i.getNombre().charAt(0) == letra ) {
                librosConXletra.add(i);
            }
        }
        return librosConXletra;
    }
    public float precioLibros(ArrayList<Libros> librosAcomprar) {
        float montoTotal = 0;
        for (Libros l: librosAcomprar) {
            if (l.getEditorial() == "ElAteneo" || l.getEditorial() =="Interzona" || l.getEditorial() == "Sur y Alianza") {
                montoTotal += 50*l.getPrecio()/100;
            }else{
                montoTotal += l.getPrecio();
            }
        }
        return montoTotal;
    }
    public void cambiarPrecio(int porcentaje, float precio, int id) {
        for (Libros i: librosEnVenta) {
            if (i.getId() == id) {
                i.setPrecio(precio);
            }
        }
    }
    public void preciosNavideños() {
        for (Libros i: librosEnVenta) {
            if (i.getId()%2 == 0) {
                i.setPrecio(i.getPrecio()-25*i.getPrecio()/100);
            }else {
                i.setPrecio(i.getPrecio()-35*i.getPrecio()/100);
            }
        }
    }
    public float precioLibrosComprados(int id_cliente) {
        float montoTotal = 0;
        for (Clientes i:clientes) {
            if (id_cliente == i.getId()) {
                montoTotal = precioLibros(i.getLibrosComprados());
            }
        }
        return montoTotal;
    }
    public void agregarEditorial(String editorialDesc) {
        editorialesDescuento.add(editorialDesc);
    }
    public void pagoCliente() {
        for (Clientes i:clientes) {
            clienteYMontoTotal.put(i.getId(), precioLibros(i.getLibrosComprados()));
        }
    }
    public void mostrarCompra (int id) {
        System.out.println("libros y sus respectivas unidades:");
        for(Clientes messi : clientes2) {
            if (id == messi.getId()) {
                for (Libros i : messi.getCantidadLibros().keySet()) {
                    System.out.println(i.getNombre() + " " + messi.getCantidadLibros().get(i));
                }
            }
        }
        System.out.println("el monto total es: "+precioLibrosComprados(id));
    }
}
