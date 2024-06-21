import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static double sumPower = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double Z = in.nextDouble();
        double r = in.nextDouble();
        Master[] clan=new Master[N];
        for(int i = 0 ; i<clan.length ; i++) {
            int n=in.nextInt();
            clan[i] = new Master(0);
            if(n==0) {
                clan[i].time=in.nextInt();
                continue;
            }
            for(int j=0;j<n;j++) {
                clan[i].sonList.add(in.nextInt());
            }
        }
        clan[0].power=Z;
        setPower(clan, clan[0], r);
        System.out.println((int)sumPower);
    }

    public static void setPower(Master[] clan,Master master,double r) {
        //先遍历宗门中的每个人
        int i=0;
        while(i<master.sonList.size()) {
            Master master2=clan[master.sonList.get(i)];
            master2.power=master.getPower()*(100.0-r)/(100.0);
            if(master2.time!=1) {
                sumPower+= master2.getPower();
            }
            setPower(clan, master2, r);
            i++;//visit next son
        }
    }
}

class Master{
    double power;
    int time=1;
    ArrayList<Integer> sonList = new ArrayList<>();

    public Master(double power){
        this.power=power;
    }
    public Master() {

    }

    public double getPower() {
        return power*time;
    }
}
