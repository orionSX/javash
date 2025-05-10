
package calc.operation;
  public class Divider {
        private double div;

        public Divider(double a) {
            this.div = a;
        }

        public void div(double b) {
            div /= b;
        }

        public double getDiv() {
            return div;
        }
    }
