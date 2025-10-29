class Solution {
    public boolean isValid(String s) {
        if(s.length()==0 || s.length()==1)return false;
        Map<Character,Character>map=Map.of('(',')','[',']','{','}');
        char []brack=s.toCharArray();
        Stack<Character>stack=new Stack<>();
        for(char c:brack){
            if(map.containsKey(c)){
                stack.push(c);
            }else if(map.containsValue(c)){
                if(stack.isEmpty() || map.get(stack.pop())!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}