import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by aimin on 2017/7/23.
 */
public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        ListNode l1 = s.create(Arrays.asList(5));
        ListNode l2 = s.create(Arrays.asList(1,2,4));
        //System.out.println(l1.toString()+l2.toString());

        System.out.println(s.improved(l1,l2).toString());
    }
    public ListNode create(List<Integer> l) {
        ListNode head = new ListNode(l.get(0));
        ListNode ptr = head;
        for(int i=1;i<l.size();i++) {
            ListNode temp = new ListNode(l.get(i));
            ptr.next = temp;
            ptr = temp;
        }
        return head;
    }
    //复杂 超时。。 傻了。。一直用next来判断。。。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        else if(l2 == null) return l1;
        ListNode before;
        ListNode insert = l2;
        ListNode nowPtr = l1;
        ListNode res;

        System.out.println("start; l1(nowPtr),l2(insert)="+l1.toString()+l2.toString());
        if(insert.val>=nowPtr.val){
            //由进入正常比较程序，由nowPtr开始
            before = nowPtr;
            res = before;
            if(nowPtr.next!=null) nowPtr = nowPtr.next;
            else {
                nowPtr.next = l2;
                return res;
            }
        } else {
            //insert < nowPtr,由insert开始
            res = insert;
            before = insert;
            if(insert.next!=null) {
                insert = insert.next;
                before.next = nowPtr;
            }
            else {
                insert.next = nowPtr;
                return res;
            }
        }

        print("after start: res, insert, nowPtr,before"+res.toString()+insert.toString()+nowPtr.toString()+before);

        while(insert.next!=null) {
            if(insert.val<=nowPtr.val) {
                before.next = insert;
                before = insert;
                ListNode temp = insert.next;
                insert.next = nowPtr;
                insert = temp;
                //nowPtr 维持
            } else {
                if(nowPtr.next!=null) {
                    before = nowPtr;
                    nowPtr = nowPtr.next;
                } else {
                    nowPtr.next = insert;
                    return res;
                }
            }
        }

        print("after cycle; res,insert,nowPtr,bef:"+res+insert+nowPtr+before);
        if(insert.val<=nowPtr.val) {
            before.next = insert;
            insert.next = nowPtr;
            //print("res:"+res.toString());
            return res;
        } else {
            nowPtr.next = insert;
            //print(("res"+res));
            return res;
        }
    }

    /**
     * 做这个问题最好画图，直接想象还是有点难，总是犯了这些错误：
     * 1.在插入的过程中，需要使用insert = isnert.next时与insert.next = nowPtr矛盾，一定要用temp记录
     * 2.总是忘记在插入之后before指针的移动
     * 3.之前代码写的非常繁琐是因为总是用.next!=null来判断结束，可以直接用!=null来判断
     * @param l1
     * @param l2
     * @return
     */
    public ListNode improved(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        else if(l2 == null) return l1;
        ListNode before;
        ListNode insert = l2;
        ListNode nowPtr = l1;
        ListNode res;

        if(insert.val>=nowPtr.val){
            //由进入正常比较程序，由nowPtr开始
            before = nowPtr;
            res = nowPtr;
            nowPtr = nowPtr.next;
            //nowPtr 可能为空
        } else {
            //insert < nowPtr,由insert开始
            ListNode temp = insert.next;
            res = insert;
            before = insert;
            before.next = nowPtr;
            insert = temp;
            //insert 可能为空
        }
        print("after start: res, insert, nowPtr,before"+res.toString()+insert.toString()+nowPtr.toString()+before);


        while (insert!=null) {
            if(nowPtr!=null) {
                if(nowPtr.val>=insert.val) {
                    ListNode temp = insert.next;
                    before.next = insert;
                    insert.next = nowPtr;
                    before = insert;
                    insert = temp;
                } else {
                    nowPtr = nowPtr.next;
                    before = before.next;
                }
            } else {
                before.next = insert;
                return  res;
            }
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        public String toString() {
            String res = "[";
            ListNode ptr = this;
            while (ptr.next!=null) {
                res+=ptr.val+", ";
                ptr = ptr.next;
            }
            res += ptr.val+",";
            return res.substring(0,res.length()-1)+"]";
        }
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
