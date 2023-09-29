package ru.zentsova.yandex.sprint2.C;

// <template>
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

// <template>

public class Solution {

    public static Node<String> solution(Node<String> head, int idx) {
        if (idx < 0) return head;

        if (idx == 0) {
            Node<String> cur = head;
            head = head.next;
            cur.next = null;
            return head;
        }

        Node<String> node = getNodeByIndex(head, idx);
        if (node != head) {
            Node<String> nodePrev = getNodeByIndex(head, idx - 1);
            nodePrev.next = node.next;
            node.next = null;
        }
        return head;
    }

    public static Node<String> getNodeByIndex(Node<String> node, int idx) {
        while (idx > 0) {
            node = node.next;
            idx--;
        }
        return node;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 1);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}
