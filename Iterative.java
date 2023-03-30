import java.util.Scanner;

public class Iterative {
    class Stack {
        int capacity;
        int top;
        int arr[];
    }

    Stack create(int capacity) {

        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.arr = new int[capacity];

        return stack;
    }

    boolean isFull(Stack stack) {
        return (stack.top == stack.capacity - 1);
    }

    boolean isEmpty(Stack stack) {
        return (stack.top == -1);
    }

    void push(Stack stack, int item) {
        if (isFull(stack))
            return;

        stack.arr[++stack.top] = item;
    }

    int pop(Stack stack) {

        if (isEmpty(stack))
            return Integer.MIN_VALUE;

        return stack.arr[stack.top--];
    }
    void moveDisks(Stack src, Stack dest, char s, char d) {

        int pole1 = pop(src);
        int pole2 = pop(dest);


        if (pole1 == Integer.MIN_VALUE) {

            push(src, pole2);
            move(d, s, pole2);
        } else if (pole2 == Integer.MIN_VALUE) {

            push(dest, pole1);
            move(s, d, pole1);
        } else if (pole1 > pole2) {

            push(src, pole1);
            push(src, pole2);
            move(d, s, pole2);
        } else {

            push(dest, pole2);
            push(dest, pole1);
            move(s, d, pole1);
        }
    }

    void move(char fromPeg, char toPeg, int disk) {

        System.out.println("Move disk " + disk + " from rod " + fromPeg + " to rod " + toPeg);
    }

    void iterative(int num, Stack src, Stack aux, Stack dest) {

        int i, total_num_of_moves;
        char s = 'A', d = 'C', a = 'B';

        if (num % 2 == 0) {

            char temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int) (Math.pow(2, num) - 1);

        for (i = num; i >= 1; i--)
            push(src, i);

        for (i = 1; i <= total_num_of_moves; i++) {

            if (i % 3 == 1)
                moveDisks(src, dest, s, d);

            else if (i % 3 == 2)
                moveDisks(src, aux, s, a);

            else if (i % 3 == 0)
                moveDisks(aux, dest, a, d);
        }
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int num = scanner.nextInt();

        Iterative iter = new Iterative();
        Stack src, dest, aux;

        src = iter.create(num);
        dest = iter.create(num);
        aux = iter.create(num);


        iter.iterative(num, src, aux, dest);


    }
}
