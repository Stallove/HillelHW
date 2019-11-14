package HW11;

public class QuadraticEquation {
    static void root(int a, int b, int c) {
        double root1, root2;
        double dis = b * b - 4 * a * c;

        if(dis > 0) {
            root1 = (-b + Math.sqrt(dis)) / (2 * a);
            root2 = (-b - Math.sqrt(dis)) / (2 * a);
            System.out.println("root1 = " + root1 + " root2 = " + root2);
        }

        else if(dis == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.println("root1 = root2 = " + root1);
        }
        else {
            System.out.println("Discriminant < 0");
        }
    }
}

