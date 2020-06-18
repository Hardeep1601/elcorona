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
public class Queue<T> {

    private ListNode head;
    
    public Queue(){
        head=null;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public int getSize(){
        int count=0;
        ListNode current=head;
         while(current!=null){
             count++;
             current=current.getLink();
         }
        return count;
    }
    
    public void enqueue(T t){
        ListNode newNode=new ListNode(t,null);
        ListNode current=head;
        
        if(head==null){
            head=newNode;
        } else {
            
            while(current.getLink()!=null){
                current=current.getLink();
            }
            
            current.setLink(newNode);
        }
    }
    
    public T dequeue(){
        ListNode current=head;
        
        if(head==null){
            return null;
        } else {
            T temp=(T)current.getData();
            head=head.getLink();
            return temp;
        }
        
    }
    
    public T peek(){
        if(head==null){
            return null;
        } else {
            return (T) head.getData();
        }
            
    }
    
    public void showQueue(){
        if(head==null){
            System.out.println("The list is empty");
        } else {
            ListNode current=head;
            while(current!=null){
                System.out.print(current.getData()+" --> ");
                current=current.getLink();
            }
            System.out.println("");
            
        }
    }
    
}
