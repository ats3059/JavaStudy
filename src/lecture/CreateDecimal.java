package algo;

public class CreateDecimal {
    public static void main(String[] args) {
        CreateDecimal createDecimal = new CreateDecimal();
        createDecimal.solution(new int[]{1,2,7,6,4});
    }
    public int solution(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int answer = 0;

        for (int i = 0; i < len-2; i++) {
            for (int j = i + 1; j < len-1; j++) {
                for (int k = j+1; k < len; k++) {
                    answer += nums[i] + nums[j] + nums[k];
                    if(isTrue(answer)) cnt++;
                    answer = 0;
                }
            }
        }



        return cnt;
    }
    boolean isTrue(int answer){
        boolean is = true;
        for (int k = 2; k < answer; k++) {
            if (answer % k == 0) {
                is = false;
                break;
            }
        }
        return is;
    }
}
