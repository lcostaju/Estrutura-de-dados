package ex3;

public class ex3 {
    /*
     * StringBuilder sb1 = new StringBuilder("Olá");
     * StringBuilder sb2 = sb1;
     * sb2.append(" Mundo");
     * System.out.println(sb1); // Será exibido "Olá Mundo"
     * String s1 = "Olá";
     * String s2 = s1;
     * s2 = s2 + " Mundo";
     * System.out.println(s1); // Será exibido Olá
     */

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Olá");
        StringBuilder sb2 = sb1;
        sb2.append(" Mundo");
        System.out.println(sb1); // ???

        String s1 = "Olá";
        String s2 = s1;
        s2 = s2 + " Mundo";
        System.out.println(s1); // ???
    }
}
