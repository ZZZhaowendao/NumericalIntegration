package MatrixEigenvalueCalculation;

public class Split {

    //字符串表示的矩阵转化为数组表示的矩阵
    public static double[][] StringToArray(String str) {
        String[] row = str.substring(1, str.length() - 1).split(";");
        int r = row.length,l = row[0].split(" ").length;
        double[][] arr = new double[r][l];
        for (int i = 0;i < r;i++) {
            String[] line = row[i].split(" ");
            for (int j = 0; j < l; j++) {
                arr[i][j] = Double.valueOf(line[j]);
            }
        }
        return arr;
    }

}
