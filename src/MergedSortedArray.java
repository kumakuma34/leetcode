import java.util.Collections;
import java.util.Vector;

public class MergedSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Vector<Integer> v = new Vector<Integer>();
        for(int i= 0 ; i < m ; i++){
            v.add(nums1[i]);
        }
        for(int i = 0 ; i < n ; i++){
            v.add(nums2[i]);
        }
        Collections.sort(v);
        for(int i = 0 ; i <m+n ;i ++){
            nums1[i] = v.get(i);
        }
    }
}
