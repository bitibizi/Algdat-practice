package Recursion;

public class Recursion1 {
    public static void main(String[] args) {
        int resultat=faktorisering(5);
        System.out.println(resultat);
    }
    static int faktorisering(int value){

        if(value==1){
            return 1;
        }else{
            return value*faktorisering(value-1);
        }
    }
}
