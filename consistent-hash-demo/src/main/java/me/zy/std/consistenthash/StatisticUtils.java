package me.zy.std.consistenthash;

/**
 * @author zhaoyang on 2020-07-03.
 */
public class StatisticUtils {

    /**
     * Standard Deviation algorithm
     *
     * @param dataArr data array
     * @return standard deviation result
     */
    public static double stdev(Long[] dataArr){
        double sum = 0.0;
        double mean = 0.0;
        double num = 0.0;
        double numi = 0.0;

        for (long i : dataArr) {
            sum+=i;
        }
        mean = sum/dataArr.length;

        for (long i : dataArr) {
            numi = Math.pow(((double) i - mean), 2.0D);
            num+=numi;
        }

        return Math.sqrt(num/dataArr.length);
    }

}
