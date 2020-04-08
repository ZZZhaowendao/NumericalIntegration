package MatrixEigenvalueCalculation;


import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请输待求矩阵A：");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Eigenvalue eigenvalue = new Eigenvalue(Split.StringToArray(input));
        Eigenvalue.Value value = eigenvalue.PowerMethod();
        System.out.println("\n幂法求得：\n" +
                "特征值lamda = " + value.eigenvalue +
                "\n对应特征向量vector为\n" + value.eigenvector);
        System.out.print("A * vector为：\n" +
                eigenvalue.getMatrix().mtimes(value.eigenvector));
        System.out.println("lambda * vector为\n" +
                value.eigenvector.times(value.eigenvalue));


//        double[][] arr = {
//                {1,1,0.5},{1,1,0.25},{0.5,0.25,2}
//        };
//        Eigenvalue eigenvalue = new Eigenvalue(arr);
//        Eigenvalue.Value a = eigenvalue.PowerMethod();
//        double lambda = a.eigenvalue;
//        Matrix vector = a.eigenvector;
//        System.out.println(lambda + "\n");
//        System.out.println(vector);
//        System.out.println("A * vector = \n" + eigenvalue.getMatrix().mtimes(vector));
//        System.out.println("lambda * vector = \n" + vector.times(lambda));
    }
}
