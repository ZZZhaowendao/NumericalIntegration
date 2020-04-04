package NumericalIntegration;

public class Main {

    public static void main(String[] args) {
        //Function.choose决定被积函数，修改和查看见Function.class

        NumericalIntegration T = new NumericalIntegration();

        Function.choose = "f3";
        System.out.println("一、对f(x) = 1 / x^2在区间[0.2,1]上求积");
        System.out.println("  (1) 32等分的复合辛普森法求得：\n" +
                "      " + T.compoundSimpsonFormula(0.2, 1, 32));
        System.out.println("  (2) 辛普森法自适应积分（控制误差界epsilon设为1.1E4）求得：\n" +
                "      " + T.adaptiveSimpsonFormula(0.2, 1, 0.00011) + " 计算节点数：" + T.nodeCount);

        NumericalIntegration T0 = new NumericalIntegration();
        System.out.println();
        Function.choose = "f2";
        System.out.println("二、对f(x) = sqrt(x) * log(x)在区间（0,1）上求积");
        System.out.println("  (1) 分别以复合梯形法和复合辛普森法求积：");
        System.out.printf("      %-8c%-12s%-12s\n",'n',"复合梯形法误差","复合辛普森法误差");
        for (int n = 2,k = 1;k <= 12;n *= 2,k++) {
            double difference1 = T0.compoundTrapezoidFormula(0,1, n) + 4.0 / 9;
            double difference2 = T0.compoundSimpsonFormula(0, 1, n) + 4.0 / 9;
            System.out.printf("      %-8d%-18.8f%-12.8f\n", n, difference1, difference2);
        }
        System.out.println("  (2) 龙贝格积分：(控制误差界epsilon设为5E-5)");
        double value1 = T0.rombergQuadratureFormula(0, 1, 0.00005);
        System.out.println("      龙贝格积分结果：" + value1);
        System.out.println("      与精确值的误差比较：" +
                (value1 + 4.0 / 9));
        System.out.println("  (3) 辛普森自适应积分：(控制误差界epsilon设为5E-5)");
        double value2 = T0.adaptiveSimpsonFormula(0, 1, 0.0005);
        System.out.println("      " + "自适应积分结果：" +
                value2);
        System.out.println("      与精确值的误差比较：" +
                (value2 + 4.0 / 9));
        System.out.println("      " + "计算节点数:" +
                T0.nodeCount);
    }
}
