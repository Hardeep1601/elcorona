/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_ElCorona;

/**
 *
 * @author USER
 */
public class BSTNode<T extends Comparable<T>> {
    
    private T data;
    private int ID;
    private BSTNode leftLink;
    private BSTNode rightLink;
    
    public BSTNode(){
        data=null;
        leftLink=null;
        rightLink=null;
        ID=-1;
    }
    
    public BSTNode(T t,BSTNode a, BSTNode b, int id){
        data=t;
        leftLink=a;
        rightLink=b;
        ID=id;
    }

    BSTNode(Character operator, Character left, Character right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setData(T t){data=t;}
    public T getData(){return data;}
    
    public void setLeft(BSTNode a){leftLink=a;}
    public BSTNode getLeft(){return leftLink;}
    
    public void setRight(BSTNode a){rightLink=a;}
    public BSTNode getRight(){return rightLink;}

    
}
