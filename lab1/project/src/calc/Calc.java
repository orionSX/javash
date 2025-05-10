package calc;
public class Calc{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Calculator calc = new Calculator();
        System.out.println("2+2=" + calc.sum(2, 2));
        System.out.println("8-2-4=" + calc.sub(8, 2, 4));
        System.out.println("20/2/2=" + calc.div(20, 2, 2));
        System.out.println("18*2.5*11.5=" + calc.mult(18, 2.5, 11.5));
        System.out.println("5 & 3 = " + calc.conjuct((short)5,(short)3));
    }
}
