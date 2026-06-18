class Solution {
    public boolean isValid(String s) {
        if(s.length() <=0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        int indx = 0;
        while(indx < s.length()) {
            Character c = s.charAt(indx);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                Character lastBracket = stack.pop();
                switch(c) {
                    case ')': 
                        if(lastBracket != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if(lastBracket != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if(lastBracket != '{') {
                            return false;
                        }
                        break;
                }
            }
            indx++;
        }
        return stack.isEmpty();
        
    }
}
