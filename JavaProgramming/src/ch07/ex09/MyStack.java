package ch07.ex09;

import java.util.Vector;

public class MyStack<T> implements IStack<T>{
	Vector<T> stack;
	public MyStack() {
	    stack = new Vector<T>();
	}
	public T pop() {
	    if (stack.isEmpty())
	        return null;
	    else 
	        return stack.remove(stack.size()-1);
	}
	public boolean push(T ob) {
	    stack.add(ob);
	    return true;
	}
}
