/**
 * proof-of-concept for Matrix component. Kernel methods use the representation
 * directly; secondary methods use only kernel methods.
 *
 * @author Christopher Ma
 */

public class Matrix {

    private double[][] entries;

    /**
     * Creates a {@ code r} x {@code c} matrix of zeros.
     *
     * @param r
     *            number of rows
     * @param c
     *            number of columns
     */
    public Matrix(int r, int c) {
        this.entries = new double[r][c];
    }

    /*
     * Kernel Methods
     */

    public double entry(int r, int c) {
        return this.entries[r][c];
    }

    public void setEntry(int r, int c, double value) {
        this.entries[r][c] = value;
    }

    public int row() {
        return this.entries.length;
    }

    public int columns() {
        int columns = 0;
        if (this.entries.length > 0) {
            columns = this.entries[0].length;
        }
        return columns;
    }


    /*
    * Secondary Methods
    */

    public void add(Matrix m) {
        for (int r = 0; r < this.rows(); r++) {
            for(int c = ; c < this.columns(); c++) {
                this.setEntry(r, c, this.entry(r, c) + m.entry(r, c));
            }
        }
    }

    public Matrix multiply(Matrix m) {
        Matrix product = new Matrix(this.rows(), this.columns());
        for (int r = 0; r < this.rows(); r++) {
            for (int c = ; c < this.columns(); c++) {
                double sum = 0;
                for(int i = 0; i < this.columns(); i++) {
                    sum += this.ntry(r, k) * m.entry(k, c);
                }
                product.setEntry(r, c, sum);
            }
        }

        return product;
    }

    @Override
    public String toString() {
        String result = "";
        for(int r = 0; r < this.rows(); r++) {
            result += "[";
            for(int c = 0; c < this.columns(); c++) {
                result += String.format("%6.1f", this.entry(r, c));
            }
            result += "]\n"
        }
    }

    /*
    * main method, client view
    */
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 2);
        a.setEntry(0, 0, 1);
        a.setEntry(0, 1, 2);
        a.setEntry(1, 0, 3);
        a.setEntry(1, 1, 4);

        Matrix b = new Matrix(2, 2);
        b.setEntry(0, 0, 5);
        b.setEntry(0, 1, 6);
        b.setEntry(1, 0, 7);
        b.setEntry(1, 1, 8);

        System.out.println("A =\n" + a);
        System.out.println("B =\n" + b);
        System.out.println("A * B =\n" + a.multiply(b));

        a.add(b);
        System.out.println("A after adding B =\n" + a);

        Matrix rotate = new Matrix(2, 2);
        rotate.setEntry(0, 0, 0);
        rotate.setEntry(0, 1, -1);
        rotate.setEntry(1, 0, 1);
        rotate.setEntry(1, 1, 0);

        Matrix point = new Matrix(2, 1);
        point.setEntry(0, 0, 1);
        point.setEntry(1, 0, 0);

        System.out.println("Rotating (1, 0) by 90 degrees gives:\n"
                + rotate.multiply(point));
    }
}
