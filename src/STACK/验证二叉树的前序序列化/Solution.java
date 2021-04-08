package STACK.验证二叉树的前序序列化;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        char[] str=preorder.toCharArray();
        // 设置为-1是为了应对一开始为根节点的情况，除了根节点之外的所有节点的入度都为1
        int out=0,in=-1;
        for(int i=0;i<str.length;i++){
            if(str[i]==',') continue;
            in++;
            if(out<in) return false;
            if(str[i]<='9'&&str[i]>='0'){
                out+=2;
                while(i<str.length-1&&str[i+1]>='0'&&str[i+1]<='9') i++;
            }
        }
        return out==in;
    }
}