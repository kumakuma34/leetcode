public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int ans = 0;
        StringBuffer str = new StringBuffer();
        while(str.toString().indexOf(b) < 0){
            if ((a.length() * 2 > 10000 || b.length() < ans)){
                return -1;
            }
            str.append(a);
            ans++;
        }
        return ans;
    }
}
