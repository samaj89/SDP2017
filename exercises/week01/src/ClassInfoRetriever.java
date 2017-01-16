/**
 * Write a Java program that reads the name of a class from the command line and emits the
 * interface of the class in Java syntax (interface or class, modifiers, constructors, methods,
 * fields; no method bodies).
 */

import java.util.Scanner;

public class ClassInfoRetriever {
    private Class c;
    private Scanner in;

    private void launch() {
        try {
            in = new Scanner(System.in);
            System.out.println("Enter the name of a Java class: ");
            String className = in.next();
            c = Class.forName(className);
            System.out.println("Class Name: " + c.getName());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            in.close();
        }

    }

    public static void main(String[] args) {
        ClassInfoRetriever cir = new ClassInfoRetriever();
        cir.launch();
    }
}
