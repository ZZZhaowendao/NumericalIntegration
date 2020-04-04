package NumericalIntegration;

import java.util.ArrayList;
import java.util.List;

import static NumericalIntegration.Function.function;

public class NumericalIntegration {

    /**
     * 复合梯形公式
     * @param low:积分下届，high:积分上届，n:区间等分段数
     */
    public double compoundTrapezoidFormula (double low, double high, int n) {
        double T = 0;
        double h = (high - low) / n;
        for (int k = 1;k < n;k++) {
            double x = low + k * h;
            T += function(x);
        }
        T = h * ((function(low) + function(high)) / 2 + T);
        return T;
    }

    /**
     * 复合辛普森公式
     * @param low:积分下届，high:积分上届，n:区间等分段数
     */
    public double compoundSimpsonFormula (double low, double high, int n) {
        double S = 0;
        double h = (high - low) / n;
        for (int k = 1;k < n;k++) {
            double x = low + k * h;
            S += 4 * function(x + h / 2) + 2 * function(x);
        }
        S = h * (S + 4 * function(low + h / 2) + function(low) + function(high)) / 6;
        return S;
    }

    /**
     * 龙贝格求积公式
     * @param low:积分下届，high:积分上届，e:误差界
     */
    public double rombergQuadratureFormula (double low, double high, double e) {
        double T0 = (function(low) + function(high)) * (high - low) / 2;
        List<Double> temp = new ArrayList<>();
        temp.add(T0);
        System.out.printf("      k=%2d%9.5f\n",0, temp.get(0));
        double I = Double.MAX_VALUE;
        for (int k = 1;;k++) {
            double[] arr = new double[k + 1];
            arr[0] = recurrence(temp.get(0), k, low, high);
            System.out.printf("      k=%2d%9.5f",k, arr[0]);
            for (int m = 1;m <= k;m++) {
                arr[m] = expedite(m, arr[m - 1], temp.get(m - 1));
                System.out.printf("%9.5f", arr[m]);
            }
            System.out.println();
            I = arr[arr.length - 1];
            if (Math.abs(I - temp.get(k - 1)) < e) {
                System.out.println("      终止计算时|Tk(0)-Tk-1(0)|为：" + Math.abs(I - temp.get(k - 1)));
                break;
            }
            else {
                temp.clear();
                for (double item : arr)
                    temp.add(item);
            }
        }
        return I;
    }
    //递推梯形公式
    private double recurrence(Double T, int k, double low, double high) {
        double sum = 0;
        for (int j = 0;j <= Math.pow(2, k - 1) - 1;j++) {
            double x = low + (2 * j + 1) * (high - low) / Math.pow(2, k);
            sum += function(x);
        }
        double Tk = T / 2 + (high- low) * sum / Math.pow(2, k);
        return Tk;
    }
    //求加速值
    private double expedite(int m, double Tk1, Double Tk) {
        double t = Math.pow(4, m);
        double Tmk = t * Tk1 / (t - 1) - Tk / (t - 1);
        return Tmk;
    }

    /**
     * 辛普森自适应求积公式
     * @param low:积分下届，high:积分上届，e:误差界
     */
    //为节点计数
    public int nodeCount = 2;
    public double adaptiveSimpsonFormula (double low, double high, double e) {
        nodeCount++;
        double mid = (low + high) / 2;
        double s = simpsonFormula(low, high);
        double s1 = simpsonFormula(low, mid);
        double s2 = simpsonFormula(mid, high);
        if (Math.abs(s1 + s2 - s) <= 15 * e) {
            return s1 + s2 + (s1 + s2 - s) / 15;
        }
        else {
            return adaptiveSimpsonFormula(low, mid, e / 2) + adaptiveSimpsonFormula(mid, high, e / 2);
        }
    }
    //辛普森求积公式
    private double simpsonFormula (double low, double high) {
        double mid = (low + high) / 2;
        return (high - low) * (function(low) + 4 * function(mid) + function(high)) / 6;
    }


    public static void main(String[] args) {

    }

}
