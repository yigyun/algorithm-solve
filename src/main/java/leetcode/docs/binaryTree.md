# 이진 트리(Binary Tree)

각 노드가 최대 두 개의 자식 노드를 가지는 트리 ��조다. 데이터 검색 및 정렬에 효율적인 구조로 알려져 있다.

## 이진 트리 순회(Traversal)

1. **전위 순회(Preorder)**

   루트 -> 왼쪽 -> 오른쪽으로 순회하는 구조

2. **중위 순회(Inorder)**

   왼쪽 -> 루트 -> 오른쪽으로 순회하는 구조

3. **후위 순회(Postorder)**

   왼쪽 -> 오른쪽 -> 루트로 순회하는 구조

```java
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // 전위 순회
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // 중위 순회
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // 후위 순회
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
}