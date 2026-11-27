/**
 * {@code Matrix} represented as a 2D array of doubles with stored dimensions,
 * with implementations of primary methods.
 *
 * @convention <pre>
 * $this.rows >= 0 and $this.columns >= 0 and
 * $this.matrix.length = $this.rows and
 * [for every i with 0 <= i < $this.rows: $this.matrix[i].length = $this.columns]
 * </pre>
 * @correspondence <pre>
 * this = [a $this.rows x $this.columns matrix where the entry at row r,
 *         column c is $this.matrix[r][c]]
 * </pre>
 *
 * @author Christopher Ma
 */
public class Matrix1L extends MatrixSecondary {

    /**
     * This is the matrix with all of the entries, entries[r][c] is the entry at
     * row r and column c.
     */
    private double[][] matrix;

    /**
     * Number of rows.
     */
    private int rows;

    /**
     * Number of columns.
     */
    private int columns;

    /**
     * Initializes the data to a valid defaut inital value.
     */
    private void createNewRep() {
        this.matrix = new double[0][0];
        this.rows = 0;
        this.columns = 0;
    }

    /*
     * Constructors
     */

    /**
     * No argument constructor.
     */
    public Matrix1L() {
        this.createNewRep();
    }

    /**
     * Creates a matrix with r rows and c columns.
     *
     * @param r
     *            the amount of rows
     * @param c
     *            the amount of columns
     * @requires r >= 0 and c >=0
     * @ensures this has r rows and c columns and every entry of this is 0
     */
    public Matrix1L(int r, int c) {
        assert r >= 0 && c >= 0 : "Violation of r >=0 and c >= 0";

        this.matrix = new double[r][c];
        this.rows = r;
        this.columns = c;
    }

    /*
     * Standard Methods.
     */

    @Override
    public final Matrix newInstance() {
        return new Matrix1L();
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Matrix m) {
        assert m != null : "Violation of m is not null";
        assert m != this : "Violation of m is not this";
        assert m instanceof Matrix1L : "Violation of m is of dyanmic type Matrix1L";
        Matrix1L localM = (Matrix1L) m;
        this.matrix = localM.matrix;
        this.rows = localM.rows;
        this.columns = localM.columns;
        localM.createNewRep();
    }

    /*
     * Kernel Methods.
     */

    @Override
    public final void setDimensions(int r, int c) {
        assert r >= 0 && c >= 0 : "Violation of r >=0 and c >= 0";

        this.matrix = new double[r][c];
        this.rows = r;
        this.columns = c;
    }

    @Override
    public final double entry(int r, int c) {
        assert 0 <= r && r < this.rows : "Violation of r is a valid row";
        assert 0 <= c && c < this.columns : "Violation of c is a valid column";

        return this.matrix[r][c];
    }

    @Override
    public final void setEntry(int r, int c, double value) {
        assert 0 <= r && r < this.rows : "Violation of r is a valid row";
        assert 0 <= c && c < this.columns : "Violation of c is a valid column";

        this.matrix[r][c] = value;
    }

    @Override
    public final int rows() {
        return this.rows;
    }

    @Override
    public final int columns() {
        return this.columns;
    }
}
