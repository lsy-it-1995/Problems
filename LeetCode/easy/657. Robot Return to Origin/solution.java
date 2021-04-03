class Solution {
    public boolean judgeCircle(String moves) {
        int upDown = 0, leftRight = 0;
        for(char c: moves.toCharArray()){
            if(c == 'U'){
                upDown++;
            }else if(c =='D'){
                upDown--;
            }else if(c =='L'){
                leftRight--;
            }else if(c =='R'){
                leftRight++;
            }
        }
        return (leftRight == 0 && upDown == 0);
    }
}
