package calc;
import calc.operation.Adder;
import calc.operation.Subtractor;
import calc.operation.Divider;
import calc.operation.Multiplicator;
import calc.operation.Conjuctor;
public class Calculator {
        public int sum(int... a) {
            Adder adder = new Adder();
            for (int i : a) {
                adder.add(i);
            }
            return adder.getSum();
        }

        public int sub(int... a) {
            Subtractor sub = new Subtractor(a[0]);
            for (int i = 1; i < a.length; i++) {
                sub.sub(a[i]);
            }
            return sub.getSub();
        }

        public double div(double... a) {
            Divider div = new Divider(a[0]  * 1.0 );
            for (int i = 1; i < a.length; i++) {
                div.div(a[i]  * 1.0 );
            }
            return div.getDiv();
        }

        public double mult(double... a) {
            Multiplicator mult = new Multiplicator(a[0]  * 1.0 );
            for (int i = 1; i < a.length; i++) {
                mult.mult(a[i]);
            }
            return mult.getMult();
        }

        public short conjuct(short... a) {
          Conjuctor conjuctor= new Conjuctor(a[0]);
          for (int i = 1; i < a.length; i++) {
              conjuctor.conjuct(a[i]);
          }
          return conjuctor.getCon();
        }

}
