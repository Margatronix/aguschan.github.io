import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Alumno extends Persona{

private String curso;
private HashMap<String, ArrayList<Float>> notasPorMateria;



    public Alumno() {
        super();
        this.curso = "5 c" ;
        this.notasPorMateria = new HashMap<String, ArrayList<Float>>();
    }

    public Alumno(String nombre, int edad, int dni, int telefono, String direccion, String curso, HashMap<String, ArrayList<Float>> notasPorMateria) {
        super(nombre, edad, dni, telefono, direccion);
        this.curso = curso;
        this.notasPorMateria = new HashMap<String, ArrayList<Float>>();
    }
    public void agregarNota (String materia, float nota) {
        if(this.notasPorMateria.containsKey(materia))   this.notasPorMateria.get(materia).add(nota);
        else {
            this.agregarMateria(materia);
            this.notasPorMateria.get(materia).add(nota);
        };
    }
     public float menorNota(){
        float nota_menor=10;
        for (ArrayList<Float> notasTotales : this.notasPorMateria.values()) {
            for (float notas: notasTotales) {
                if(nota_menor>notas) nota_menor=notas;
            }
         }
        return nota_menor;
     }


    public float mayorNota(){
        float nota_mayor=0;
        for (ArrayList<Float> notasTotales : this.notasPorMateria.values()) {
            for (float notas: notasTotales) {
                if(nota_mayor<notas) nota_mayor=notas;
            }
        }
        return nota_mayor;
    }

    public float promedioNotas(){
        float nota_promedio=0;
        int contador=0;
        for (ArrayList<Float> notasTotales : this.notasPorMateria.values()) {
            contador+=notasTotales.size();
            for (float notas: notasTotales) {
                 nota_promedio+=notas;
            }
        }
        nota_promedio=nota_promedio/contador;
        return nota_promedio;
    }
    public void agregarMateria(String nombreDeMateria){
        ArrayList<Float>notasMateria=new ArrayList<Float>();
        this.notasPorMateria.put(nombreDeMateria,notasMateria);
    }
}
