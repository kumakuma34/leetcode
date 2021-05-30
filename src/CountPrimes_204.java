class CountPrimes_204 {
    public static int countPrimes(int n) {
        int MAXVAL = 5000000;
        int ans = 0 ;
        boolean isPrime[] = new boolean[MAXVAL+1];

        for(int i = 2; i <= n ; i ++) {
            isPrime[i] = true;
        }

        for(int i = 2;i <= n ; i++){
            if(isPrime[i]){
                for(int j = i+i ; j <= n ;j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 1 ; i < n ; i++){
            if(isPrime[i]) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1));
    }
}