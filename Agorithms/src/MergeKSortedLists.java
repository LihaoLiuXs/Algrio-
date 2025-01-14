import java.util.*;

public class MergeKSortedLists {

	public static void main(String[] args) {
		//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
		ListNode[] input = new ListNode[3];
		ListNode node1 = nodeBuilder("145");
		ListNode node2 = nodeBuilder("134");
		ListNode node3 = nodeBuilder("26");
		input[0] = node1;
		input[1] = node2;
		input[2] = node3;
		ListNode res = mergeKLists(input); //1->1->2->3->4->4->5->6
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
           return null; 
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy; 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode e1, ListNode e2){
                 if (e1.val == e2.val){
                     return 0; 
                 }
                 return e1.val < e2.val ? -1 : 1; 
            }
        }); 
        for (ListNode i : lists){
            if (i != null){
            minHeap.offer(i);
            }
        }
        while (!minHeap.isEmpty()){
              ListNode node = minHeap.poll();
              if (node.next != null){
                 minHeap.offer(node.next); 
              }
              cur.next = node;
              cur = cur.next;
        }
        return dummy.next; 
    }
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { 
    		val = x; 
    		next = null;
    	}
    }
    private static ListNode nodeBuilder(String a) {
    	ListNode head = new ListNode(a.charAt(0) - '0');
    	ListNode cur = head;
    	for (int i = 1; i < a.length(); i++) {
    		ListNode next = new ListNode(a.charAt(i) - '0');
    		cur.next = next;
    		cur = next;
    	}
    	return head; 
    }
}
