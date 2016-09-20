package com.example.saisurajreddy.epitome.ekadanta;

/**
 * Created by SaiSurajReddy on 12/10/2015.
 */
import java.util.*;
public class Bc {
    private int[][] elements=new int[5][5];
    private int[][] switches=new int[5][5];
    private int[] markings=new int[12];

    private Stack<Integer> stack=new Stack<Integer>();

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void initializer(){
        LinkedList<Integer> ll=new LinkedList<Integer>();
        for(int i=1;i<=25;i++){
            ll.add(i);
        }
        int max=24;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int index=0;
                if(ll.size()!=1){
                    index=getRandomNumberInRange(0,max);
                    max--;
                }
                elements[i][j]=ll.get(index);
                index=ll.remove(index);
                System.out.print(elements[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private void marker(int r,int c){
        markings[r]++;
        markings[5+c]++;
        if(r==c){
            markings[10]++;
        }else if(r+c==4) {
            markings[11]++;
        }
    }

    private void ticker(int n){
        //to find the indices of n in elements array
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(elements[i][j]==n){
                    switches[i][j]=1;
                    marker(i,j);
                    return;
                }
            }
        }
    }

    private void maxfinder() {
        int max=0;
        for(int i=0;i<12;i++){
            if(markings[i]>max && markings[i]<5){
                max=markings[i];
            }
        }
        for(int i=0;i<12;i++) {
            if(markings[i]==max) {
                stack.push(i);
            }
        }
    }

    private int resultproducer() {
        if(stack.size()==1) {
            int temp=stack.pop();
            stack.clear();
            return temp;
        } else {
            int temp=getRandomNumberInRange(0,stack.size()-1);
            temp=stack.get(temp);
            stack.clear();
            return temp;
        }
    }

    private void areafinder(int n,int ofs) {
        if(ofs==1) {
            for(int i=0;i<5;i++) {
                if(switches[n][i]==0) {
                    stack.push(i);
                }
            }
        } else {
            for(int i=0;i<5;i++) {
                if(switches[i][n]==0) {
                    stack.push(i);
                }
            }
        }
    }

    private void areafinder(int ofs) {
        if(ofs==1) {
            for(int i=0;i<5;i++) {
                if(switches[i][i]==0) {
                    stack.push(i);
                }
            }
        } else{
            for(int i=0;i<5;i++) {
                if(switches[4-i][i]==0) {
                    stack.push(i);
                }
            }
        }
    }

    public void printSwitches(){
        System.out.println("aiSwitches");
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(switches[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void printMarkings(){
        System.out.print("ai ");
        for(int i=0;i<12;i++){
            System.out.print(markings[i]+" ");
        }
        System.out.println("");
    }

    public int[] getElements(){
        int[] temp=new int[25];
        int index=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                temp[index++]=elements[i][j];
            }
        }
        return temp;
    }

    public int[] getSwitches(){
        int[] temp=new int[25];
        int index=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                temp[index++]=switches[i][j];
            }
        }
        return temp;
    }

    public int predict(int n)
    {
        int res,temp,row,column;
        ticker(n);
        maxfinder();
        res=resultproducer();
        if (res==0)
        {
            row=0;
            areafinder(0,1);
            temp=resultproducer();
            column=temp;
        } else if(res==1){
            row=1;
            areafinder(1,1);
            temp=resultproducer();
            column=temp;
        } else if(res==2){
            row=2;
            areafinder(2,1);
            temp=resultproducer();
            column=temp;
        } else if(res==3){
            row=3;
            areafinder(3,1);
            temp=resultproducer();
            column=temp;
        } else if(res==4){
            row=4;
            areafinder(4,1);
            temp=resultproducer();
            column=temp;
        } else if(res==5){
            column=0;
            areafinder(0,2);
            temp=resultproducer();
            row=temp;
        } else if(res==6){
            column=1;
            areafinder(1,2);
            temp=resultproducer();
            row=temp;
        } else if(res==7){
            column=2;
            areafinder(2,2);
            temp=resultproducer();
            row=temp;
        } else if(res==8){
            column=3;
            areafinder(3,2);
            temp=resultproducer();
            row=temp;
        } else if(res==9){
            column=4;
            areafinder(4,2);
            temp=resultproducer();
            row=temp;
        }
        else if(res==10) {
            areafinder(1);
            temp=resultproducer();
            row=temp;
            column= temp;
        }
        else {
            areafinder(2);
            temp=resultproducer();
            row=4-temp;
            column=temp;
        }
        switches[row][column]=1;
        marker(row,column);
        return elements[row][column];
    }

    public boolean bingo(){
        int counter=0;
        for(int in=0;in<12;in++){
            if(markings[in]==5){
                counter++;
            }
        }
        return (boolean)(counter>=5);
    }
}
