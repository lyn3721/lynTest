

import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
        public class Node{
            private E e;
            private Node left,right;

            public  Node(E e){
                this.e = e;
                left = null;
                right = null;
            }
        }

        public Node root;
        private int size;

        public BST(){
            root = null;
            size = 0;
        }

        public int size(){
            return size;
        }

        public Boolean isEmpty(){
            return size == 0;
        }

//        public void add(E e){
//            if(root == null){
//                root = new Node(e);
//                size ++;
//            }else{
//                add(root,e);
//            }
//        }

        //向以node为根的二分搜索树插入元素e，递归算法
//        public void add(Node node ,E e){
//            if(e.equals(node.e)){
//                return;
//            }else if(e.compareTo(node.e) < 0 && node.left == null){
//                node.left = new Node(e);
//                size ++;
//            }else if(e.compareTo(node.e) > 0 && node.right == null){
//                node.right = new Node(e);
//                size++;
//            }
//
//            if(e.compareTo(node.e) < 0 ){
//                add(node.left,e);
//            }else{
//                add(node.right,e);
//            }
//
//        }

        public void add(E e){
              root =  add(root,e);
        }
        //上面添加的简化版
        //向以node为根的二分搜索树插入元素e，递归算法
        //返回插入新节点的二叉树的根
        public Node add(Node node ,E e){
            if(node == null){
                size++;
                return new Node(e);
            }

            if(e.compareTo(node.e) < 0 ){
                node.left = add(node.left,e);
            }else if(e.compareTo(node.e) > 0 ){
                node.right = add(node.right,e);
            }
            return node;
        }

        //看二分搜索树是否包含元素e
        public Boolean contains(E e){
            return contains(root,e);
        }

        //以node 为根的二分搜索树是否包含元素e 递归算法
        public Boolean contains(Node node,E e){
            if(e.compareTo(node.e) == 0 ){
                return true;
            }else if(e.compareTo(node.e) < 0 ){
                return contains(node.left, e);
            }else{
                return contains(node.right, e);
            }

        }
        //二分搜索树前序遍历
        public void preOrder(){
            preOrder(root);
        }
        //以node 为根的二分搜索树前序遍历 递归算法
        private void preOrder(Node node){
            if(node == null){
                return;
            }
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }

        //以node 为根的二分搜索树前序遍历 非递归算法
        public void preOrderNR(){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node cur = stack.pop();
                System.out.println(cur.e);

                if (cur.right!=null) {
                    stack.push(cur.right);
                }
                if (cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }


        public void levelOrder(){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node cur = q.remove();
                System.out.println(cur.e);

                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }


            }
        }

        //二分搜索树中序遍历
        public void inOrder(){
            inOrder(root);
        }
        //以node 为根的二分搜索树中序遍历 递归算法
        private void inOrder(Node node){
            if(node == null){
                return;
            }

            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);

        }

        //二分搜索树后序遍历
        public void postOrder(){
            postOrder(root);
        }
        //以node 为根的二分搜索树中序遍历 递归算法
        private void postOrder(Node node){
            if(node == null){
                return;
            }

            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);

        }

        //寻找二分搜索树最小元素
        public E minmum(){
            if(size == 0){
                throw new IllegalArgumentException("node is empty");
            }
            return minmum(root).e;
        }
        private Node minmum(Node node){
            if(node.left == null){
                return node;
            }
            return minmum(node.left);
        }


        //寻找二分搜索树最大元素
        private E maxmum(){
            if(size == 0){
                throw new IllegalArgumentException("node is empty");
            }
            return maxmum(root).e;
        }
        public Node maxmum(Node node){
            if(node.right == null){
                return node;
            }
            return maxmum(node.right);
        }

        //删除最小值返回节点，返回最小值
        public E removeMin(){
            E ret = minmum();
            root = removeMin(root);
            return ret;
        }

        //删除以node 为根二分搜索树中的最小节点
        //返回删除节点后二分搜索树的跟

        private Node removeMin(Node node){
            if(node.left == null){
                Node rightnode = node.right;
                node.right = null;
                size --;
                return rightnode;
            }
            node.left = removeMin(node.left);
            return node;
        }

        //删除最大值返回节点，返回最大值
        public E removeMax(){
            E ret = maxmum();
            root = removeMax(root);
            return ret;
        }

        //删除以node 为根二分搜索树中的最da节点
        //返回删除节点后二分搜索树的跟

        private Node removeMax(Node node){
            if(node.right == null){
                Node rightnode = node.left;
                node.left = null;
                size --;
                return rightnode;
            }
            node.right = removeMax(node.right);
            return node;
        }

        public void remove(E e){
            root = remove(root,e);
        }

        //删除以node为根的二分搜索树中值为e 的节点，递归算法
        //返回删除后新的二叉树的跟
        private Node remove(Node node , E e){
            if(node == null){
                return null;
            }

            if(e.compareTo(node.e)<0){
                node.left= remove(node.left,e);
                return node;
            }else if (e.compareTo(node.e)>0){
                node.right= remove(node.right,e);
                return node;
            }else{//compareTo(node.e) == 0
                //待删除结点左子树为空
                if(node.left == null){
                    Node rightNode = node.right;
                    node.right = null;
                    size--;
                    return rightNode;
                }
                //待删除节点右子树为空
                if(node.right == null){
                    Node leftNode = node.left;
                    node.left = null;
                    size--;
                    return leftNode;
                }

                //待处理左右子树均不为空的情况
                //找到比待删除的节点大的最小节点，即待删除节点右子树的最小节点
                //用这个节点代替待删除节点的位置
                Node successor = minmum(node.right);
                System.out.println(successor.e);

                successor.right = removeMin(node.right);
                System.out.println(successor.right.e);

                successor.left = node.left;
                node.left = node.right = null;
                return  successor;
            }



        }
        public static void main(String[] args) {
            BST<Integer> bst = new BST<>();
            int nums[] = {5,3,8,4,2,7,10};
            for (int num : nums){
                bst.add(num);
            }
//            bst.postOrder();
            System.out.println(bst);
            bst.remove(5);

        }



        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            generateBSTstring(root,0,res);
            return res.toString();
        }

        private void generateBSTstring(Node node,int depth,StringBuilder res){
            if(node == null){
                res.append(generateDepthstring(depth) + "null\n");
                return;
            }
            res.append(generateDepthstring(depth) + node.e + "\n");
            generateBSTstring(node.left,depth+1,res);
            generateBSTstring(node.right,depth+1,res);
        }

        private String generateDepthstring(int depth){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                res.append("--");
            }
            return res.toString();
        }
}
