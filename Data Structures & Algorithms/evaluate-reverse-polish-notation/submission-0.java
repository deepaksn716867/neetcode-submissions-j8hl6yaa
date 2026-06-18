class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int indx = 0;
        while(indx < tokens.length) {
            String c = tokens[indx];
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int right = stack.pop();               
                int left = stack.pop();
                int result;
                switch(c) {
                    case "*":
                        result = left * right;
                        stack.push(result);
                        break;
                    case "-":
                        result = left - right;
                        stack.push(result);
                        break;
                    case "/":
                        result = left / right;
                        stack.push(result);
                        break;
                     case "+":
                        result = left + right;
                        stack.push(result);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(c));
            }
            indx++;
        }
        return stack.pop();
    }
}
