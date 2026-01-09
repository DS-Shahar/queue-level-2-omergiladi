public static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
    Node<Integer> dummy = new Node<>(0);
    Node<Integer> t = dummy;

    while (a != null && b != null) {
        if (a.getValue() <= b.getValue()) {
            t.setNext(new Node<>(a.getValue()));
            a = a.getNext();
        } else {
            t.setNext(new Node<>(b.getValue()));
            b = b.getNext();
        }
        t = t.getNext();
    }

    while (a != null) {
        t.setNext(new Node<>(a.getValue()));
        t = t.getNext();
        a = a.getNext();
    }

    while (b != null) {
        t.setNext(new Node<>(b.getValue()));
        t = t.getNext();
        b = b.getNext();
    }

    return dummy.getNext();
}

public static Node<Integer> unique(Node<Integer> head) {
    if (head == null) return null;

    Node<Integer> newHead = new Node<>(head.getValue());
    Node<Integer> t = newHead;
    int last = head.getValue();
    head = head.getNext();

    while (head != null) {
        if (head.getValue() != last) {
            t.setNext(new Node<>(head.getValue()));
            t = t.getNext();
            last = head.getValue();
        }
        head = head.getNext();
    }

    return newHead;
}

public static int weaklyIncreasingOrder(Node<Integer> head) {
    if (head == null) return 0;

    int max = 1, curr = 1;
    int prev = head.getValue();
    head = head.getNext();

    while (head != null) {
        if (head.getValue() >= prev) {
            curr++;
        } else {
            curr = 1;
        }
        if (curr > max) max = curr;
        prev = head.getValue();
        head = head.getNext();
    }

    return max;
}

public static boolean hasDuplicates(Queue<String> q1) {
    Queue<String> q2 = new Queue<>();
    boolean found = false;

    while (!q1.isEmpty()) {
        String s = q1.remove();
        if (isIn(q2, s)) {
            found = true;
        }
        q2.insert(s);
    }

    while (!q2.isEmpty()) {
        q1.insert(q2.remove());
    }

    return found;
}
