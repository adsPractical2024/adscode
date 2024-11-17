import java.util.*;

public class BST {

    static class node{
        int data;
        node left, right;
        node(int data){
            this.data =data;
            this.left=null;
            this.right=null;
        }
    }


    static node addrecursive(node root, int val){
        if(root==null){
            node n1 = new node(val);
            return n1;
        }
        if(val<root.data){
            root.left =addrecursive(root.left, val);
        }
        else if(val>root.data){
            root.right=addrecursive(root.right, val);
        }
        return root;

    }

    static node delete(node root, int val){
        if(root==null){
            System.out.println("tree is empty");
            return null;
        }

        if(val<root.data){
            root.left=delete(root.left, val);
        }
        else if(val>root.data){
            root.right=delete(root.right,val);
        } else{
        

        if(root.left==null&&root.right==null){
            return null;
        }
        else if(root.right==null){
            return root.left;
        }
        else if(root.left==null){
            return root.right;
        }
        else{
            node temp = getsucc(root);
            root.data=temp.data;
            root.right=delete(root.right, temp.data);
        }
    }
        return root ;
    }

    static node getsucc(node root){
        node n1 = root.right;

        while(n1.left!=null && n1.left!=null){
            n1 = n1.left;
        }
        return n1;
    }

    static node search(node root, int val){
        if (root==null) {
            return null;
        }
        if(val<root.data){
            root.left=search(root.left, val);  
        }
        else if(val>root.data){
            root.right=search(root.right, val);
        }
        else if(val ==root.data){
            System.out.println("value is found");
            return root;
        }
        else{
            System.out.println("value not found");
        }
        return root;
    }

    static void BFS(node root){
        Queue <node> que = new LinkedList<node>();
        que.add(root);
        while(!que.isEmpty()){
            node temp=que.poll();
            System.out.print(temp.data+"-->");
            if(temp.left!=null){
                que.add(temp.left);
            }
            if(temp.right!=null){
                que.add(temp.right);
            }
        }
    }
    
    static void inorder(node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+ ",");
        inorder(root.right);
    }

    public static void main(String[] args) {
        node root=null;
        int choice= 0;
        Scanner sc = new Scanner(System.in);
        while (choice!=-1){
            System.out.print("enter 1.to insert 2. to delete value 3.print inorder 4.search 5.BFS \n");
            choice =sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("enter value to insert");
                    int val = sc.nextInt();
                    root=addrecursive(root, val);
                    inorder(root);
                    break;
                case 2:
                    System.out.println("enter value to delete");
                    int del=sc.nextInt();
                    root=delete(root, del) ;
                    inorder(root);
                    break;
                case 3:
                    System.out.println("inorder travelsal is ");
                    inorder(root);
                    break;

                case 4:
                    System.out.println("enter value to search");
                    int search=sc.nextInt();
                    search(root, search);
                    break;                
                case 5:
                    BFS(root);
                    break;

            
                default:;
                    break;
            }
        }
    }
}
