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
public class ListNode<T> {

    T data;
    ListNode link;

    public ListNode() {
        this.data = null;
        this.link = null;
    }
    
    
    public ListNode(T data, ListNode node) {
        this.data = data;
        this.link = node;
    }
    
    public void setLink(ListNode link){
        this.link=link;
    }
    
    public void setData(T data){
        this.data=data;
    }
    
    public ListNode getLink(){
        return this.link;
    }
    
    public T getData(){
        return this.data;
    }
    
}
