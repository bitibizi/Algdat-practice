public class Maksverdi {

    public static int Nestemaks(int [] a) {
        int sist = a.length - 1;
        int m = 0;
        int maksverdi =a[0];
        int temp=a[sist];
        a[sist]=Integer.MAX_VALUE;

        for(int i=1; ; i++){
            if(a[i]>=maksverdi){
                if(i==sist){
                    a[sist]=temp;
                    return temp>=maksverdi ? sist : m;

                }else{
                    maksverdi=a[i];
                    m=i;
                }
            }
        }


    }


    public static void main(String [] args){

        int [] a={2,4,7,20,11,15};
        System.out.println(Nestemaks(a));
    }
}
