public interface Matrix extends MatrixKernel {

    /**
     * Matrix addition, adds each element entry by entry. Adds {@code m} to
     * {@code this}, entry by entry.
     *
     * @param m
     *            the matrix to add to this
     * @updates this
     * @requires this.rows() = m.rows() and this.columns() = m.columns()
     * @ensures [for every r, c, the entry at row r and column c of this = the
     *          entry at row r and column c of #this + the entry at row r and
     *          column c of m]
     */
    void matrixAddition(Matrix m);

    /**
     * Matrix subtraction, subtracts each elemnt entry by entry. Subtracts
     * {@code m} from {@code this}, entry by entry.
     *
     * @param m
     *            the matrix to subtract
     * @updates this
     * @requires this.rows() = m.rows() and this.columns() = m.columns()
     * @ensures [for every r, c, the entry at row r and column c of this = the
     *          entry at row r and column c of #this - the entry at row r and
     *          column c of m]
     */
    void matrixSubtraction(Matrix m);

    /**
     * Matrix multiplication. Replaces {@ccode this} with the matrix product
     * {@code this * m}.
     *
     * @param m
     *            the right-hand matrix
     * @updates this
     * @requires #this.columns() = m.rows()
     * @ensures this = #this * m
     */
    void matrixMultiplication(Matrix m);

    /**
     * Calulates the determinant of {@code this}.
     *
     * @return the determinant of {@code this}
     * @requires this.rows() = this.columns() and this.rows() > 0
     * @ensures [if this is 1 x 1, determinant = this(0, 0); otherwise,
     *          determinant = the sum over every column c of (-1)^c * this(0, c)
     *          * the determinant of the matrix formed by removing row 0 and
     *          column c from this]
     */
    double determinant();

    /**
     * Returns whether {@code this} is a square matrix or not.
     *
     * @return true if {@code this} has the same number of rows and columns
     * @ensures isSquare = (this.rows() = this.columns())
     */
    boolean isSquare();

    /**
     * Matrix transpose. replaces {@code this} with its transpose. The rows and
     * columns are flipped.
     *
     * @updates this
     * @ensures this.rows = #this.columns() and this.columns = #this.rows() and
     *          [for every r, c, the entry at row c and column c of this = this
     *          entry at row c and column r of #this]
     */
    void tranpose();

    /**
     * Scalar multiplication. Multiplies every entry of {@code this} by
     * {@code k}.
     *
     * @param scalar
     *            the scalar to multiply by
     * @updates this
     * @ensures [for every r, c, the entry at row r and column c of this =
     *          scalar * the entry at row r and column c of #this]
     */
    void scalarMultiplication(double scalar);

    /**
     * Returns whether {@code this} is symmetric.
     *
     * @return true if {@code this} is symmetric
     * @ensures isSymmetric = [this.rows() = this.columns() and for every r, c,
     *          the entry at row r and column c of this = the entry at row c and
     *          column r of this]
     */
    boolean isSymmetric();
}
