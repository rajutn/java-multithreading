package com.home.executer.api.service;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int s = Integer.parseInt(scan.nextLine());
//        double d =  Double.parseDouble(scan.nextLine());;
//        String s1 = scan.nextLine();
//
//
//        System.out.println("String: " + s1);
//        System.out.println("Double: " + d);
//        System.out.println("Int: " + s);
        int N=20;
        IntStream.rangeClosed(1,N).forEach(i->System.out.println(N+"*"+i+"="+(N*i)));
//        Scanner sc=new Scanner(System.in);
//        System.out.println("================================");
//        for(int i=0;i<3;i++)
//        {
//            String s1=sc.next();
//            int x=sc.nextInt();
//            System.out.format("%-15s%03d%n", s1, x);
//        }
//        System.out.println("================================");

        NumberFormat use = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat ind = NumberFormat.getCurrencyInstance(new Locale("hi", "IN"));
        NumberFormat  chn = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat  france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("use--->"+ind.format(213123123.13));
        /*Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int k=scan.nextInt();
        SortedSet<String> sets=new TreeSet<>();
        for(int i=0;i<=str.length()-k;i++) {
            sets.add(str.substring(i,i+k));
        }
        System.out.println(sets.first());
        System.out.println(sets.last());*/

        //System.out.println(sumOfIndixes());
        String str = "Hello Nooka";
        StringBuffer buffer=new StringBuffer();
       System.out.println("str.length()"+str.length());
        for(int i =str.length()-1;i>=0;i--){
            System.out.println(i);

            //System.out.println(str.charAt(i));
            buffer.append(str.charAt(i));
        }
        System.out.println(buffer.toString());

    }
    public static int[] sumOfIndixes() {
        int num[] = {1, 4, 6, 9, 10};
        int sum = 10;
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Integer> result1 = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            int local = sum - num[i];
            if (result.containsKey(local)) {
                System.out.println(i+"==="+result.get(local));
                result1.put(i, result.get(local));
               // return new int[]{i, result.get(local)};

            }
            result.put(num[i], i);
        }
        return new int[] {-1,-1};

    }

//

}
