package basic;

import java.io.*;
public class Main{
    public static void main(String[] args){
        solve1();
    }
    public static void solve1(){
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        double[] arr = null;
        try {
            n = Integer.parseInt(bReader.readLine());
            arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Double.parseDouble(bReader.readLine());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double max = Double.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {


            for (int j = 0; j < i; j++) {

                double temp = arr[i]-arr[j];
                if(temp>180){
                    temp = 360-temp;
                }
                if(temp>max){
                    max = temp;
                    break;
                }
            }
        }
        System.out.print(String.format("%.8f", max));
    }
}
