package MatrixEigenvalueCalculation;

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

    }
}
