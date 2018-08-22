package org.lanqiao.oqaf.Utils;


public class NumCheck {
    public NumCheck() {
    }
    public static StringBuffer getNumCheck(){
        int[] ranDom = new int[6];
        for(int i=0;i<6;i++){
            ranDom[i]= (int) (Math.random()*10);
        }
        for(int b : ranDom){
            System.out.println(b);
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i <ranDom.length ; i++) {
            str = str.append(ranDom[i]);
        }
        System.out.println(str);
        return str;
    }
}
