package MatrixEigenvalueCalculation;

import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

public class Eigenvalue {
    //全局变量
    private Matrix matrix = null;
    private final int TIMES = 1000;

    //构造函数
    public Eigenvalue(double[][] matrix) {
        int row = matrix.length;
        int line = matrix[0].length;
        this.matrix = Matrix.Factory.ones(row, line);
        for (int i = 0;i < row;i++)
            for (int j = 0;j < line;j++)
                this.matrix.setAsDouble(matrix[i][j], i, j);
    }
    public Eigenvalue(int[][] matrix) {
        int row = matrix.length;
        int line = matrix[0].length;
        this.matrix = Matrix.Factory.ones(row, line);
        for (int i = 0;i < row;i++)
            for (int j = 0;j < line;j++)
                this.matrix.setAsDouble(matrix[i][j], i, j);
    }
    public Eigenvalue(Double[][] matrix) {
        int row = matrix.length;
        int line = matrix[0].length;
        this.matrix = Matrix.Factory.ones(row, line);
        for (int i = 0;i < row;i++)
            for (int j = 0;j < line;j++)
                this.matrix.setAsDouble(matrix[i][j], i, j);
    }
    public Eigenvalue (Integer[][] matrix) {
        int row = matrix.length;
        int line = matrix[0].length;
        this.matrix = Matrix.Factory.ones(row, line);
        for (int i = 0;i < row;i++)
            for (int j = 0;j < line;j++)
                this.matrix.setAsDouble(matrix[i][j], i, j);
    }

    //打印当前matrix
    public void print() {
        System.out.print(this.matrix);
    }

    //幂法求特征值即特征向量
    public Value PowerMethod() {
        int dimension = (int) matrix.getColumnCount();
        Matrix v = Matrix.Factory.rand(dimension, 1);
        double mu = 1.0;
        for (int i = TIMES;i > 0;i--) {
            v = matrix.mtimes(v);
            mu = max(v);
            v = v.times(1.0 / mu);
        }
        return new Value(mu, v);
    }
    //求向量v中绝对值最大的元素
    private double max(Matrix v) {
        double absMax = Double.MIN_VALUE;
        double temp = 0;
        for (int i = 0;i < v.getRowCount();i++) {
            temp = Math.abs(v.getAsDouble(i, 0));
            if (temp > absMax)
                absMax = temp;
        }
        return absMax;
    }

    //构造一个内部类用于返回特征值和特征向量
    class Value {
        double eigenvalue = 0;
        Matrix eigenvector = null;
        public Value(double eigenvalue, Matrix eigenvector) {
            this.eigenvalue = eigenvalue;
            this.eigenvector = eigenvector;
        }
    }

    public Matrix getMatrix() {
        return matrix;
    }

}
