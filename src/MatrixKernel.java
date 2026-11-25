import components.standard.Standard;

public interface MatrixKernel extends Standard<Matrix> {

    /**
     * Resizes {@code this} to {@code r} x {@code c} with every entry 0
     *
     * @param r
     *            the number of rows
     * @param c
     *            the number of columns
     * @replaces this
     * @requires r >= 0 and c >= 0
     * @ensures that his has r rows and c columns and every entry is value 0
     */
    void setDimensions(int r, int c);

    /**
     * Returns the value of {@code this} at row {@code r} and column {@code c}.
     *
     * @param r
     *            the row index
     * @param c
     *            the column index
     * @return the value of entry at row {@code r} and column {@code c}
     * @requires 0 <= r <= this.rows() and 0 <= c <= this.columns()
     * @ensures the value = [the value of this at row r and column c]
     */
    double entry(int r, int c);

    /**
     * Sets the entry of {@code this} at row {@code r} and column {@code c} to
     * {@code value}.
     *
     * @param r
     *            the row index
     * @param c
     *            the column index
     * @param value
     *            the value of the entry
     * @updates this
     * @requires 0 <= r < this.rows() and 0 <= c < this.columns()
     * @ensures the entry of this at row r and column c is set to value and
     *          every other entry remains unchanged
     */
    void setEntry(int r, int c, double value);

    /**
     * Returns the number of rows in {@code this}.
     *
     * @return the number of rows
     * @ensures r = [the number of rows in this]
     */
    int rows();

    /**
     * Returns the number of columns in {@code this}.
     *
     * @return the number of columns
     * @ensures columns = [the number of columns in this]
     */
    int columns();
}
