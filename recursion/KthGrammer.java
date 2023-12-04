public class KthGrammer {

    int[][] grammarBase = {{0,1},{1,0}};
    public int solve(int n, int k) {
        if(n<0 || k<0 || k>Math.pow(2,n-1)) {
            return -1;
        }
        if(n == 1 && k==1) {
            return 0;
        }
        return applyGrammar(solve(n-1, (k+1)/2), k);
    }

    int applyGrammar(int base, int k) {
        if(k%2==0) {
            return grammarBase[base][1];
        } else  {
            return grammarBase[base][0];
        }
    }

    public int solve2(int n, int k) {
        if(n<0 || k<0 || k>Math.pow(2,n-1)) {
            return -1;
        }
        if(n == 1 && k==1) {
            return 0;
        }
        int mid = (int) (Math.pow(2, n-1)/2);
        if(k<=mid) {
            return solve2(n-1, k);
        } else {
            return Math.abs(solve2(n-1, k-mid) - 1);
        }
    }

    public static void main(String[] args) {
        KthGrammer g = new KthGrammer();
        System.out.println(g.solve2(3,3));
    }
}
