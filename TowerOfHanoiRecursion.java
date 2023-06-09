import java.util.Scanner;

public class TowerOfHanoiRecursion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = input.nextInt();
        TowerOfHanoiRecursion.towerOfHanoi(n,'A','C','B');
        input.close();
    }

    public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        towerOfHanoi(n-1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        towerOfHanoi(n-1, auxRod, toRod, fromRod);
    }
}
