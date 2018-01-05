import java.util.*;
class Solution {
    // Given an absolute path for a file (Unix-style), simplify it.
    //
    // For example,
    // path = "/home/", => "/home"
    // path = "/a/./b/../../c/", => "/c"

    // first idea, just use stack
    public static String simplifyPath(String path) {
        String [] nameArray = path.split("/");
        ArrayList<String> result = new ArrayList<>();
        for(String name: nameArray) {
            if(name.equals("")||name.equals(".")) continue;
            // BUG: what if the .. is the first name, we have to ignore it .
            // corner case
            if(name.equals("..")) {
                if(result.size() != 0)
                    result.remove(result.size()-1);
                continue;
            }
            result.add(name);
        }
        StringBuilder sb = new StringBuilder();
        if(result.size() == 0) sb.append("/");
        for(String name:result) {
            sb.append("/");
            sb.append(name);
        }
        return sb.toString();
    }


    // fastest from leetcode
    // just use char array rather than StringBuilder
    // without using split!
    // amazing but not useful for interview...
    public String fastest(String path) {
        char[] res = new char[path.length()+1];
        char[] input = path.toCharArray();
        int slow = 0;
        int fast = 0;
        if(input[0] != '/' ){
            res[0] = '/';
            slow = 1;
        }
        while(fast < path.length()){
            if(input[fast] == '/'){
                res[slow++] = input[fast++];
                while(fast < input.length && input[fast] == '/'){
                    fast++;
                }
            } else if(input[fast] != '.' && input[fast] != '/'){
                while(fast < input.length && input[fast] != '/'){
                    res[slow++] = input[fast++];
                }
            } else if(input[fast] == '.'){
                if(fast+1 == path.length()){
                    break;
                }
                if(input[fast+1] == '/'){
                    fast += 1;
                    while(fast < input.length && input[fast] == '/'){
                        fast++;
                    }

                } else if(input[fast+1] != '.' && input[fast+1] != '/'){

                    while(fast < input.length && input[fast] != '/'){
                        res[slow++] = input[fast++];
                    }
                } else if(input[fast+1] == '.'){
                    if(fast+2 == path.length()){
                         if(slow>=2){
                            slow-=2;
                        }
                        while(slow > 0 && res[slow] != '/'){
                            slow--;
                        }
                        break;
                    }
                    if(input[fast+2] == '/'){
                        if(slow>=2){
                            slow-=2;
                        }
                        while(slow > 0 && res[slow] != '/'){
                            slow--;
                        }
                        fast+=2;
                    } else{
                        while(fast < input.length && input[fast] != '/'){
                            res[slow++] = input[fast++];
                        }
                    }
                }
            }
        }
        if(slow > 1 && res[slow-1] == '/'){
          slow-=1;
        }
        return slow == 0? "/" :new String(res, 0, slow);
    }
}
