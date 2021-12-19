var deleteDuplicates = function(head) {                                                                     // deletes duplicates from a singly-linked list
    if (head == null || head.next == null) return head;
    var a = head, b = a.next, c = b.next;
    while (a.val == b.val){                                                                                 // duplicates @ beginning
        while (c != null && c.val == a.val) c = c.next;                                                     // looks for all consecutive nodes to delete
        a = head = c; if (a == null) return head;
        b = a.next;   if (b == null) return head;
    }
    while (a != null) {                                                                                     // step 3 nodes at a time looking for duplicates
        b = a.next;
        c = b != null ? b.next : null;
        if (b != null && c != null && a.val != b.val && b.val == c.val){
            var p = c.next;
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
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
 }
function ListNode(val,prev){
    this.val = (val===undefined ? 0 : val)
    if(prev != null) prev.next = this;
};
