package april2020.week2;


public class MinStack {

	int stack[];
	int top;
	
	int minStack[];
	int topMin;
	int curMin;
	
    public MinStack() {
        top = -1;
        stack = new int[1];
        
        curMin = Integer.MAX_VALUE;
        topMin = -1;
        minStack = new int[1];
    }
    
    public void push(int x) {
        if(top + 1 == stack.length) {
        	int temp[] = new int[stack.length * 2];
        	for (int i = 0; i < stack.length; i++) {
        		temp[i] = stack[i];
			}
        	stack = temp;
        }
        stack[++top] = x;
        
        if(x > curMin) {
        	return;
        }
        curMin = x;
    	if(topMin + 1 == minStack.length) {
    		int temp[] = new int[minStack.length * 2];
        	for (int i = 0; i < minStack.length; i++) {
        		temp[i] = minStack[i];
			}
        	minStack = temp;
    	}
    	minStack[++topMin] = x;
    }
    
    public void pop() {
    	if(top == -1) {
    		return;
    	}
        if(stack[top--] == curMin) {
        	if(topMin == 0) {
        		curMin = Integer.MAX_VALUE;
        		topMin = -1;
        		return;
        	}
        	curMin = minStack[--topMin];
        }
    }
    
    public int top() {
    	System.out.println(stack[top]);
    	return stack[top];
    }
    
    public int getMin() {
    	System.out.println(curMin);
        return curMin;
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(0);
    	minStack.push(1);
    	minStack.push(0);
    	minStack.getMin(); //  --> Returns -3.
    	minStack.pop();//
    	minStack.top();//      --> Returns 0.
    	minStack.getMin();//   --> Returns -2.
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */