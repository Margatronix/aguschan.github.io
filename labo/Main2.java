import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner nums = new Scanner(System.in);
        int numerosIngresar;
        ArrayList<Integer> arrei = new ArrayList<Integer>();
        ArrayList<Integer> arrei2 = new ArrayList<Integer>();
        System.out.println("CUANTOS NUM QUIERE INGRESHAR PAL PRIMER AREI");
        numerosIngresar = nums.nextInt();
        System.out.println("INTRODUSHKA NUMEROS:");
        for (int i = 0; i < numerosIngresar; i++) {
            arrei.add(nums.nextInt());
        }
        System.out.println("CUANTOS NUM QUIERE INGRESHAR PAL ZEGUNDO AREI");
        numerosIngresar = nums.nextInt();
        System.out.println("INTRODUSHKA NUMEROSH:");
        for (int i = 0; i < numerosIngresar; i++) {
            arrei2.add(nums.nextInt());

        }
        boolean estam = true;
        boolean estam2 = true;
        HashSet<Integer> hashito = new HashSet<Integer>(arrei2);
        HashSet<Integer> hashito2 = new HashSet<Integer>(arrei);
        for (int i: arrei) {
            if(hashito.contains(i)){
                estam = true;
            }
            else {
                estam = false;
            }
        }
        for (int i: arrei2) {
            if(hashito2.contains(i)){
                estam2 = true;
            }
            else {
                estam2 = false;
            }
        }
        if(estam == true && estam2 == true){
            System.out.println("estam");
        }
        else {
            System.out.println("no estam :(");
        }
    }
}

