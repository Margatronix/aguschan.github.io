

public class Persona {


    private int edad;
    private int dni;
    private int telefono;
    private String nombre;
    private String direccion;
    public Persona(){
        this.nombre="Q bueno esta tobato";
        this.direccion="que bueno q esta tony 123";
        this.edad=5;
        this.telefono=12345678;
        this.dni=00000001;
    }
    public Persona(String nombre){
        this.nombre = nombre;
    }
    public Persona(String nombre, int edad, int dni, int telefono, String direccion){
        this.nombre = nombre;
        this.edad = edad;
        this.direccion=direccion;
        this.dni=dni;
        this.telefono=telefono;
    }

    public static void main(String[] args) {
        Persona p3 = new Persona();
        Persona p4 = new Persona();
        p3.sonlamismapersona(p4);
    }
    public int getDni(){
        return this.dni;
    }

    public int getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDni(int dni){
        this.dni=dni;
    }
    public boolean esMayorDeEdad(){
        return this.edad > 18;
    }
    //public boolean sonlamismapersona(int dni){
      //  return dni==this.dni;
    //}
    public boolean tienenlamismaedad(int edad){
        return edad==this.edad;
    }
    public boolean sonlamismapersona(Persona P1){
        return    this.dni==P1.getDni();
    }
}