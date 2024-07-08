package leetcode.stack.medium;
import java.util.*;
public class SimplifyPath_71 {
    static

    class Solution {
        public String simplifyPath(String path) {
            if(path.length() == 1) return path;
            path = path.replace("//", "/");
            StringTokenizer st = new StringTokenizer(path, "/");
            Stack<String> stack = new Stack<>();

            while(st.hasMoreTokens()){
                String str = st.nextToken();
                if(str.equals("..")){
                    if(!stack.isEmpty()) stack.pop();
                } else if(str.equals(".")){
                    continue;
                } else{
                    stack.push(str);
                }
            }

            if(stack.size() == 0){ return "/";}

            StringBuilder sb = new StringBuilder();
            Stack<String> temp = new Stack<>();
            while(!stack.isEmpty()){
                temp.push(stack.pop());
            }

            while(!temp.isEmpty()){
                sb.append("/").append(temp.pop());
            }

            return sb.toString();
        }
    }
}
