package Ejercicios;

public class Scope {
    int x = 10;

    private static int f1(int x) {
        x = 1;
        return x *= 2;
    }

    private void f2() {
        x -= 1;
    }

    private void print() {
        int x = 5;
        x = f1(x);
        System.out.println("x = " + x);
        System.out.println("x = " + this.x);
        f2();
        //f2();
        x = f1(this.x);
        System.out.println("x = " + x);
        System.out.println("x = " + this.x);
        this.x = f1(x);
        System.out.println("x = " + x);
        System.out.println("x = " + this.x);
    }

    public static void main(String[] args) {
        Scope scope = new Scope();
        scope.print();
    }
} 
