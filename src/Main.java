// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import  java.util.*;
public class Main {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {

       ListNode head = new ListNode(0);
       ListNode temp = head;

       head.next = new ListNode(1);
       head = head.next;
        head.next = new ListNode(8);
        head = head.next;
        head.next = new ListNode(9);
        head = head.next;

//        while(temp!=null)
//        {
//            System.out.print(temp.val+"-->");
//            temp = temp.next;
//        }
//        ListNode revlist = reverseList(temp.next);
////        while(revlist!=null)
////        {
////            System.out.print(revlist.val+"-->");
////            revlist = revlist.next;
////        }
//
//        int sum = 0;
//        int carry = 0;
//
//        ListNode res = new ListNode(0);
//        ListNode curr = res;
//
//        while(revlist!=null)
//        {
//            int num = revlist.val;
//            sum = num+num+carry;
//            ListNode node = new ListNode(sum%10);
//            carry = sum/10;
//            curr.next=node;
//            curr = curr.next;
//            revlist = revlist.next;
//        }
//        if(carry>0)
//        {
//            ListNode node = new ListNode(carry);
//            curr.next = node;
//        }
//        ListNode newRev = reverseList(res.next);
//        while(newRev!=null)
//        {
//            System.out.print(newRev.val+"-->");
//            newRev = newRev.next;
//        }
   String ans[] = ranking(new int[]{10,3,8,9,4});
   for(String str : ans) System.out.print(str+" , ");
    }
    public static void removeNodes(ListNode head) {

        while(head!=null)
        {
            System.out.println(head.val+"-->");
            head = head.next;
        }


    }
    public static ListNode reverseList(ListNode head)
    {
        if(head == null) return head;

        ListNode prev = null;
        ListNode present = head;
        ListNode Next = head.next;

        while(present!=null)
        {
            present.next = prev;
            prev = present;
            present = Next;
            if(Next!=null) Next = Next.next;
        }
        return prev;
    }
    private static String[] ranking(int []score) {
        String[] ans = new String[score.length];
        if(score.length==1) return new String[]{"GoldMedal"};
        int[] temp = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            temp[i] = score[i];
        }
        Arrays.sort(temp);
        reverse(temp);
        int i = 0;
        HashMap<Integer, String> map = new HashMap();
        map.put(temp[i++], "Glod Medal");
        map.put(temp[i++], "Silver Medal");
        map.put(temp[i++], "Bronze Medal");

        while (i < score.length) {
            map.put(temp[i++], i+"");

        }
        int j = 0;

        while (map.size() > 0) {
            ans[j] = map.get(score[j]);
            map.remove(score[j]);
            j++;
        }
        return ans;
    }
    private static void reverse(int []A)
    {
        int i=0,j=A.length-1;
        while(i<j)
        {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;j--;
        }
    }


    public static int compareVersion(String version1, String version2) {

       String []arr1 = version1.split("\\.");
       String []arr2 = version2.split("\\.");

       int i=0,j=0;
       while(i<arr1.length || j<arr2.length)
       {
           int v1=0,v2=0;
           if(i<arr1.length )
            v1 = Integer.valueOf(arr1[i]);
           if(j<arr2.length )
            v2 = Integer.valueOf(arr2[j]);


           i++;j++;

           if(v1>v2) return 1;
           else if(v2>v1) return -1;
       }

      return 0;
    }
}