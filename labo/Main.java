import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner nums = new Scanner(System.in);
        int numerosIngresar;
        ArrayList<Integer> arrei = new ArrayList<Integer>();
        HashSet<Integer> hashito = new HashSet<Integer>();
        System.out.println("CUANTOS NUM QUIERE INGRESHAR");
        numerosIngresar = nums.nextInt();
        System.out.println("INTRODUSHKA NUMEROS:");
        for (int i = 0; i < numerosIngresar; i++) {
            arrei.add(nums.nextInt());
            hashito.add(arrei.get(i));
        }
        System.out.println(hashito);
    }
}
    
