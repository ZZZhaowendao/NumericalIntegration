package NumericalIntegration;

public class Function {
    /**
     * 此处修改具体的被积函数
     * 使用时由choose变量进行选择
     * @param x:函数参数
     */
    public static String choose = "";
    public static double function (double x) {
        switch (choose) {
            case "f1":
                //f(x) = x / (x^2 + 4)
                double f1 =  x / (x * x + 4);
                return f1;

            case "f2":
                //f(x) = sqrt(x) * ln(x)
                double f2 = 0;
                if (x == 0)
                    return f2;
                f2 = Math.sqrt(x) * Math.log(x);
                return f2;

            case "f3":
                //f(x) = 1 / x^2
                double f3 = 1.0 / x / x;
                return f3;

            default:
                return 0;
        }
    }
}
