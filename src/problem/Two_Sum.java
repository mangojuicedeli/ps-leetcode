package problem;

import java.util.HashMap;

public class Two_Sum {
	
	/*
	 * ### 완전 탐색
	 * - O(n^2)의 성능으로 배열의 원소 개수가 10^4만 넘어가도 사용하기 힘들다
	 */
    public int[] solution1(int[] nums, int target) {
        int[] answer = new int[2];
        loop:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break loop;
                }
            }
        }
        return answer;
    }
    
    /*
     * ### Map 자료구조를 통한 메모이제이션 사용
     * 
     * ## Map 자료구조를 사용한 이유
     * 	1. 메모이제이션 배열의 인덱스에 음수를 넣어야 함
     * 	2. 메모이제이션 배열의 인덱스에 들어갈 수가 중복해서 나올 수 있음
     * 
     * ## Map 자료구조의 구성
     * 	key : 입력 배열의 요소값
     * 	value : 입력 배열의 인덱스
     * 
     * ## 유의점
     * 	- 입력 배열에 같은 수가 중복해서 있을 경우, Map의 value에 뒤에 나온 수의 입력 배열 인덱스가 들어가지만,
     *	어차피 중복해서 나온 수는 답이 될 리가 없으므로 상관이 없다.
     */
    public static int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        int idx = 0;
        
        for (int i = 0; i < nums.length; i++) {
            idx = target - nums[i];
            if (memo.get(idx) != null) {
                if (i >= memo.get(idx)) {
                    return new int[]{ memo.get(idx), i };
                } else {
                    return new int[]{ i, memo.get(idx) };
                }
            } else {
                memo.put(nums[i], i);
            }
        }
        return new int[]{ };
    }
}
