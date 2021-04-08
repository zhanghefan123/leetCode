package STRING.Z形变换;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows)
        {
            return s;
        }
        StringBuilder res = new StringBuilder();
        char[] charArray = s.toCharArray();
        int jump = (numRows-1);
        for(int i = 0;i<numRows;i++)
        {
            if(i==0 || i == numRows-1)
            {
                for(int j = i; j < s.length();j+=(2*jump))
                {
                    res.append(charArray[j]);
                }
                continue;
            }
            int j;
            for(j = i; j < s.length();j+=(2*jump))
            {
                if(j == i)
                {
                    res.append(charArray[j]);
                    continue;
                }
                res.append(charArray[j-i*2]);
                res.append(charArray[j]);
            }
            if((j-i*2)<s.length())
            {
                res.append(charArray[j-i*2]);
            }

        }
        return new String(res);
    }
}
