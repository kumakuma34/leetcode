class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;
        //dp 초기값 설정
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ;j < m ;j++){
                if(i == 0 || j == 0){
                    if(matrix[i][j] == '1') {
                        ans = 1;
                        dp[i][j] = 1;
                    }
                    else dp[i][j] = 0;
                }
            }
        }

        for(int i = 1 ;i <n ; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == '0') continue;
                dp[i][j] = 1+ Math.min(dp[i-1][j-1] , Math.min(dp[i][j-1], dp[i-1][j]));
                ans = Math.max(ans, dp[i][j]);
            }
        }
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ;j < m ;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans * ans;
    }
}