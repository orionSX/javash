
package calc.operation;
public class Conjuctor{
    private short con;

    public Conjuctor(short a) {
        this.con =a;
    }
    public void conjuct(short b){
        con&=b;
    }

    public short getCon() {
        return con;
    }
}
