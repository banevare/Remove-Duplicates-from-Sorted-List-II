class DeleteDuplicates{                                                                                         // deletes duplicates from a singly-linked list and tests it works                                                                           
    static int COUNT = 0;                                                                                       // tracks passing tests 
    public ListNode deleteDuplicates(ListNode head) {                                                           // deletes duplicates from a singly-linked list
        if (head == null || head.next == null) return head;
        ListNode a = head, b = a.next, c = b.next;
        while (a.val == b.val){                                                                                 // duplicates @ beginning
            while (c != null && c.val == a.val) c = c.next;                                                     // looks for all consecutive nodes to delete
            a = head = c; if (a == null) return head;
            b = a.next;   if (b == null) return head;
        }
        while (a != null) {                                                                                     // step 3 nodes at a time looking for duplicates
            b = a.next;
            c = b != null ? b.next : null;
            if (b != null && c != null && a.val != b.val && b.val == c.val){
                ListNode p = c.next;
                while(p != null && p.val == c.val) {                                                            // looks for all consecutive nodes to delete
                    if (p.next != null) p = p.next;
                    else {
                        a.next = null;                                                                          // end of list being a duplicate
                        return head;
                    }
                }
                a.next = p;                                                                                     // delete duplicates
                continue;                                                                                
            }
            else if (b != null && c != null) a = a.next;                                                        // no consecutive duplicates
            else break;                                                                                         // end of list  
        }
        return head;
    }
    public class ListNode {											// definition for singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode prev) { this.val = val; if(prev != null) prev.next = this; }
	}
    public String print(final ListNode head){									 // printing method of our singly-linked list
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}
    public ListNode list(String str){                                                                           // creates ListNode
        if(str.length() == 0) return null;
        String[] arr = str.split(" ");
        ListNode a = new ListNode(Integer.parseInt(arr[0]));
        ListNode p = a, b = null;
        for( int i= 1; i < arr.length; i++ ){
            b = new ListNode(Integer.parseInt(arr[i]),p);
            p = b;
        }
        return a;
    }
    // ----------- TESTING ------------
    public static void test(String tb, String ta){                                                              // general test function
        DeleteDuplicates s = new DeleteDuplicates();
		ListNode head = s.list(tb);
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.deleteDuplicates(head);
		String ra = s.print(r);
		assert(ta.equals(ra));
        COUNT++;
    }
    public static ListNode listTest(){                                                                          // tests list method
        DeleteDuplicates s = new DeleteDuplicates();
        String tb = "1 2 3";
        ListNode a = s.list(tb);
        String str = s.print(a);
        assert(tb.equals(str)); 
        return a;
    }
    public static void main(String args[]){                                                                     // run tests
        listTest();
        test("",                  ""     );
        test("1",                 "1"    );
        test("1 2 3",             "1 2 3");
        test("1 2 2 3",           "1 3"  );
        test("1 2 2 2 2 2 2 2 3", "1 3"  );
        test("1 1 2 3 3",         "2"    );
        test("1 2 2 2 2",         "1"    );
        test("1 1 1 1 2 3 4",     "2 3 4");
        test("1 2 3 3",           "1 2"  );
        test("1 2 2 2 3 3",       "1"    );
        test("1 2 2 2 3 4 4 4 5", "1 3 5");
        test("1 1 1 2 2 2 3",     "3"    );
        test("1 1 1 1",           ""     );
        System.out.println("Passes: "+ COUNT + " Tests");
    }
}
