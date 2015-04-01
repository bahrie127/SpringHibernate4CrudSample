import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: saifulbahri
 * Date: 4/1/15
 * Time: 7:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    private static class Node{
        Node left, right;
        int data;
        Node(int newData){
            left=right=null;
            data=newData;
        }
    }
    private static Node insert(Node node, int data){
        if(node==null){
                node=new Node(data);
        }
        else {
            if(data<node.data){
                node.left=insert(node.left,data);
            }
            else {
                node.right=insert(node.right,data);
            }
        }
        return (node);
    }
    private static Node addRandomElement(Node node, int data, int index){
        if(node==null){
            node=new Node(data);
        }
        else{
            if(index<=2){
                node.left=addRandomElement(node.left, data, index);
            }
            else {
                node.right=addRandomElement(node.right,data,index);
            }
        }
        return (node);
    }

    public static int heightOfBinaryTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            return 1 +
                    Math.max(heightOfBinaryTree(node.left),
                            heightOfBinaryTree(node.right));
        }
    }

    static int diameterOfTree(Node root){
        if (root == null)
        {
            return 0;
        }

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);

        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);

        return Math.max(leftHeight + rightHeight + 1,
                Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String args[]) throws Exception{
        Scanner sc=new Scanner(System.in);
        Node root;
        int root_i=0,root_cnt=0, root_num=0;
        root=null;
        //int isBst=sc.nextInt();
        root_cnt=sc.nextInt();
        for(root_i=0;root_i<root_cnt;root_i++){
            root_num=sc.nextInt();
            root=insert(root,root_num);
        }

        System.out.println(String.valueOf(diameterOfTree(root)));

    }
}
