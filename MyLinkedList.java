package com.bridgelab.linkedlist;

public class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;
	
	public MyLinkedList() {
		this.head=null;
		this.tail=null;
	}
	
	public void add(INode<K> newNode) {
		if(this.head==null) {
			this.head=newNode;
		}
		if(this.tail==null) {
			this.tail=newNode;
		}else {
			INode<K> tempNode=this.head;
			this.head=newNode;
			this.head.setNext(tempNode);
		}
	}
	
	public void append(INode<K> newNode) {
		if(this.head==null) {
			this.head=newNode;
		}
		if(this.tail==null) {
			this.tail=newNode;
		}else {
			this.tail.setNext(newNode);
			this.tail=newNode;
			
		}
	}
	
	public void insert(INode<K> myNode, INode<K> newNode) {
		INode<K> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}
	
	public void insertAfter(INode<K> myNode, INode<K> newData) {
		if(myNode == null) {
			System.out.println("the given previous node cannot be null");
		}else {
		INode<K> newNode=newData;
		newNode.setNext(myNode.getNext());
		myNode.setNext(newNode);
	}
	}
	
	public void deleteFirstNode(INode<K> head) {
		if(this.head != null) {
			INode<K> tempNode = this.head;
			this.head=this.head.getNext();
			tempNode=null;
		}
	}
	
	public void deleteLastNode() {
		if(this.head!=null) {
			if(this.head.getNext()==null) {
				this.head=null;
			}else {
				INode<K> tempNode=this.head;
				while(tempNode.getNext()!=null) {
					//tempNode=tempNode.getNext();
					INode<K> lastNode=tempNode.getNext();
					tempNode.setNext(null);
					lastNode=null;
				}
			}
		}
	}
	
	public void deleteNode(INode<K> head, int position) {
	    if (head != null) {
	    	INode<K> temp = head;
	    	if (position != 0) {
	    		for (int i = 0; temp != null && i < position-1; i++) {
	    			temp = temp.getNext();
	    			if (temp == null || temp.getNext() == null) {
	    						return;
	    			}else {
	    				INode<K> next = temp.getNext().getNext();
	    				temp.setNext(next);
	    				}
	   				}
	   			}
	   }
 }
	
   public void size() {
	    INode<K> temp = head;
        int count = 0;
        while (temp != null) {
	         temp = temp.getNext();
	         count++;
	        }
	        System.out.println("Now Total nodes in the linked list are:-"+" "+count);
	    }
	
	public void search(K x){
	    INode<K> tempNode = this.head; // Initialize current
	    boolean condition=false;
	    if(this.head==null) {
	    	System.out.println("Linked List is Empty");
	    }else {
	    	while ( tempNode!= null) {
	    		if (tempNode.getKey().equals(x)){	
	    			condition=true;
	    			break;
	    		}
	    		tempNode =tempNode.getNext();
	    	}
	    }
	    if(condition==true) {
	    	System.out.println("Node is present");
	    }else {
	    	System.out.println("Node is not present");
	    }  
	}
	
	public void printMyNodes() {
		StringBuffer myNodes=new StringBuffer("my nodes:");
		INode<K> tempNode=head;
		while(tempNode.getNext()!=null) {
			myNodes.append(tempNode.getKey());
			myNodes.append("->");
			tempNode=tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println("My Nodes:"+myNodes);
	}
}
