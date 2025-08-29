import java.util.Scanner;

public class Dijkstras {
    static int n;
    static int MinDistance(int [] Distance,Boolean visit[]) {
        int M = Integer.MAX_VALUE;
        int mIndex = -1;
        for (int vx = 0; vx < n; vx++) {
            if (visit[vx] == false && Distance[vx] < M) {
                M = Distance[vx];
                mIndex = vx;
            }
        }

        return mIndex;
    }
    void printsolution(int [] Distance ,int n){
        System.out.println("the shortest distance from 0: ");
        for(int i=0;i<n;i++){
            System.out.println(" to "+i+" shortest distance is "+Distance[i]);

        }
    }

    public void DJKS(int Dcost[][],int s){
        int Distance[]=new int [n];
        Boolean visit[]=new Boolean[n];
        for(int i=0;i<n;i++){
            Distance[i]= Integer.MAX_VALUE;
            visit[i]=false;
        }
        Distance[s]=0;
        for(int j=0;j<n-1;j++){
            int ux=MinDistance(Distance,visit);
            visit[ux]=true;
            for(int vx=0;vx<n;vx++){
                if(!visit[vx] && Dcost[ux][vx]!=-1 && Distance[ux]!=Integer.MAX_VALUE && Distance[ux]+Dcost[ux][vx]<Distance[vx]){
                    Distance[vx]=Distance[ux]+Dcost[ux][vx];
                }
            }
        }
        printsolution(Distance,n);
    }
    public static void main(String[] args) {
        Dijkstras D=new Dijkstras();
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the total number of Edges: ");
        n=s.nextInt();
        int [][] Dcost=new int[n][n];
        System.out.println("Enter the value of Matrix(INF = -1 ):");
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Dcost[i][j]=s.nextInt();
            }
        }
        D.DJKS(Dcost,0);
    }
}