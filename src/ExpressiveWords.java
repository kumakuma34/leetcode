import java.util.Vector;

class ExpressiveWords {
    static class Pair{
        char first;
        int second;

        public Pair(char charAt, int cnt) {
            this.first = charAt;
            this.second = cnt;
        }
    }
    static public Vector<Pair> compressWord(String s){
        Vector<Pair> v = new Vector<>();
        if(s.length() == 1){
            v.add(new Pair(s.charAt(0), 1));
            return v;
        }
        int cnt = 0;
        for(int i = 0 ; i < s.length()-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                v.add(new Pair(s.charAt(i), cnt+1));
                cnt = 0;
            }
            else{
                cnt++;
            }
        }
        if(s.charAt(s.length() - 2) == s.charAt(s.length()-1)){
            v.add(new Pair(s.charAt(s.length()-1), cnt+1));
        }
        else{
            if(cnt != 0)
                v.add(new Pair(s.charAt(s.length()-2), cnt));
            v.add(new Pair(s.charAt(s.length()-1), 1));
        }
        System.out.println(s);
        for(int i = 0 ; i < v.size(); i++){
            System.out.println(v.elementAt(i).first +  ": " + v.elementAt(i).second);
        }
        System.out.println();

        return v;
    }
    static public int expressiveWords(String s, String[] words) {
        if(s.length() == 0) return 0;
        int ans = 0;
        Vector<Pair> source = compressWord(s);
        for(int test = 0 ; test< words.length; test++){
            String cmp = words[test];
            if(cmp.length() == 0) continue;
            Vector<Pair> compare = compressWord(cmp);
            if(compare.size() != source.size()) continue;
            boolean flag = true;
            for(int i = 0 ; i < source.size(); i++){
                if(source.elementAt(i).first != compare.elementAt(i).first) {
                    flag = false;
                    break;
                }
                if(source.elementAt(i).second < compare.elementAt(i).second){
                    flag = false;
                    break;
                }
                if(!(source.elementAt(i).second == compare.elementAt(i).second || source.elementAt(i).second >= 3))
                {
                    flag = false;
                    break;
                }
            }
            if(flag) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"};
        System.out.println(expressiveWords("dddiiiinnssssssoooo" , words));
    }

}