
package calc.operation;
   public class Multiplicator {
        private double mult;

        public Multiplicator(double a) {
            this.mult = a;
        }

        public void mult(double b) {
            mult *= b;
        }

        public double getMult() {
            return mult;
        }
    }
