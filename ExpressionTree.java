import java.util.*;
public class ExpressionTree {

    static class node{
        char data;
        node left,right;
        node(char data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static node root;

    static boolean isoperator(char ch){
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            return true;
        }
        return false;
    }

    static node convert(String postfix){
        Stack <node> stack = new Stack<node>();
        for(char ch:postfix.toCharArray()){
            if(!isoperator(ch)){
                node temp = new node(ch);
                stack.push(temp);
            }
            else{
                node op1,op2,oper;
                oper = new node(ch);
                op2=stack.pop();
                op1=stack.pop();
                oper.left=op1;
                oper.right=op2;
                stack.push(oper);
            }
        }
        root=stack.pop();
        return root;
    }

    static void inorder(){
        Stack <node> stack = new Stack<node>();
        node current = root;
        while (!stack.isEmpty()||current!=null){
            if(current!=null){
                stack.push(current);
                current=current.left;
            }
            else{
                node temp = stack.pop();
                System.out.print(temp.data+",");
                current=temp.right;
            }
        }
        System.out.println();
    }

    static void postorder(){
        Stack <node>stack1 = new Stack<node>();
        Stack <node>stack2 = new Stack<node>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            node temp = stack1.pop();
            stack2.add(temp);
            if (temp.left!=null) {
                stack1.push(temp.left) ;               
            }            
            if (temp.right!=null) {
                stack1.push(temp.right) ;               
            }
        }

        while (!stack2.isEmpty()) {
            node temp = stack2.pop();
            System.out.print(temp.data+" ");            
        }
        System.out.println();
    }

    static void preorder(){
        Stack <node> stack = new Stack<node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            node temp=stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }   
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice =0;
        while (choice!=-1){
            System.out.print("1.Enter Postfix expression\n2.inorder\n3.preorder\n4.postorder\n");
            choice =sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter postfix expression");
                    if(sc.hasNextLine()){
                        sc.nextLine();
                    }
                    String postfix = sc.nextLine();
                    convert(postfix);
                    break;

                case 2:
                    System.out.println("inorder traversal is ");;
                    inorder();
                case 3:
                    System.out.println("preorder traversal is ");;
                    preorder();
                case 4:
                    System.out.println("postorder traversal is ");;
                    postorder();
            
                default:
                    break;
            }
            
        }
    }
}
