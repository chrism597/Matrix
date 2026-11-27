/**
 * Layered implementations of secondary methods for {@code Matrix}. All methods
 * are implemented using only kernel and {@code Standard} methods.
 *
 * @author Christopher Ma
 */
public abstract class MatrixSecondary implements Matrix {
    @Override
    public final void matrixAddition(Matrix m) {
        assert m != null : "Violation of: m is not null";
        assert this.rows() == m.rows() && this.columns() == m
                .columns() : "Violation of this and m having the same dimensions";

        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                this.setEntry(i, j, this.entry(i, j) + m.entry(i, j));
            }
        }
    }

    @Override
    public final void matrixSubtraction(Matrix m) {
        assert m != null : "Violation of m is not null";
        assert this.rows() == m.rows() && this.columns() == m
                .columns() : "Violation of this and m having the same dimensions";

        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                this.setEntry(i, j, this.entry(i, j) - m.entry(i, j));
            }
        }
    }

    @Override
    public final void matrixMultiplication(Matrix m) {
        assert m != null : "Violation of m is not null";
        assert this.columns() == m
                .rows() : "Violation of this.columns() = m.rows()";

        Matrix product = this.newInstance();
        product.setDimensions(this.rows(), m.columns());
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < m.columns(); j++) {
                double dotProduct = 0;
                for (int k = 0; k < this.columns(); k++) {
                    dotProduct += this.entry(i, k) * m.entry(k, j);
                }
                product.setEntry(i, j, dotProduct);
            }
        }

        this.transferFrom(product);
    }

    @Override
    public final double determinant() {
        assert this.isSquare() : "Violation of: this is a square matrix";

        int n = this.rows();
        double determinant = 1;

        if (n > 0) {
            determinant = 0;
            double sign = 1;
            for (int c = 0; c < n; c++) {
                Matrix subMatrix = this.newInstance();
                subMatrix.setDimensions(n - 1, n - 1);
                for (int i = 1; i < n; i++) {
                    int subMatrixColumn = 0;
                    for (int j = 0; j < n; j++) {
                        if (j != c) {
                            subMatrix.setEntry(i - 1, subMatrixColumn,
                                    this.entry(i, j));
                            subMatrixColumn++;
                        }
                    }
                }
                determinant += sign * this.entry(0, c)
                        * subMatrix.determinant();
                sign = -sign;
            }
        }
        return determinant;
    }

    @Override
    public final void transpose() {
        Matrix transposeMatrix = this.newInstance();
        transposeMatrix.setDimensions(this.columns(), this.rows());
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                transposeMatrix.setEntry(j, i, this.entry(i, j));
            }
        }
        this.transferFrom(transposeMatrix);
    }

    @Override
    public final boolean isSquare() {
        return this.rows() == this.columns();
    }

    @Override
    public final void scalarMultiplication(double scalar) {
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                this.setEntry(i, j, scalar * this.entry(i, j));
            }
        }
    }

    @Override
    public final boolean isSymmetric() {
        boolean symmetric = this.isSquare();
        for (int i = 0; i < this.rows() && symmetric; i++) {
            for (int j = i + 1; j < this.columns() && symmetric; j++) {
                if (Double.compare(this.entry(i, j), this.entry(j, i)) != 0) {
                    symmetric = false;
                }
            }
        }

        return symmetric;
    }

    @Override
    public final String toString() {
        StringBuilder sBuild = new StringBuilder();
        for (int i = 0; i < this.rows(); i++) {
            sBuild.append("[");
            for (int j = 0; j < this.columns(); j++) {
                sBuild.append(String.format("%8.2f", this.entry(i, j)));
            }
            sBuild.append(" ]");
            if (i < this.rows() - 1) {
                sBuild.append("\n");
            }
        }
        return sBuild.toString();
    }

    @Override
    public final boolean equals(Object obj) {
        boolean result = true;
        if (obj == this) {
            result = true;
        } else if (!(obj instanceof Matrix)) {
            result = false;
        } else {
            Matrix m = (Matrix) obj;
            if (this.rows() != m.rows() || this.columns() != m.columns()) {
                result = false;
            } else {
                for (int i = 0; i < this.rows() && result; i++) {
                    for (int j = 0; j < this.columns() && result; j++) {
                        if (Double.compare(this.entry(i, j),
                                m.entry(i, j)) != 0) {
                            result = false;
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public final int hashCode() {
        int hash = this.rows() * this.columns();
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                hash += (i + 1) * (j + 1) * Double.hashCode(this.entry(i, j));
            }
        }
        return hash;
    }
}
