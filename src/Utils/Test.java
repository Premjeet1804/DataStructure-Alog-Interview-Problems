package Utils;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        int []ans =intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});


    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap();
        Map<Integer,Integer> map2 = new HashMap();
        List<Integer> list = new ArrayList();
        Set<Integer> set = new HashSet();

        for(int el : nums1) map1.put(el,map1.getOrDefault(el,0)+1);
        for(int el : nums2) map2.put(el,map2.getOrDefault(el,0)+1);

        for(int el:nums2) set.add(el);

        for(int el : nums1)
        {
            if(set.contains(el) && map1.containsKey(el) && map2.containsKey(el))
            {
                int min = Math.min(map1.get(el),map2.get(el));
                while(min>0)
                {
                    list.add(el);
                    min--;
                    map1.put(el,map1.get(el)-1);
                    map2.put(el,map2.get(el)-1);
                }

            }
        }
        System.out.println(list);
        int []ans = new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            ans[i] = list.get(i);
        }
        return  ans;

    }
}
