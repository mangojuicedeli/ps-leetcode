package problem;

import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args) {

		int[] arr = {3, 2, 3};
		System.out.println(majorityElement(arr));
	}

	public static int majorityElement(int[] nums) {
		int n = nums.length / 2;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int count = map.get(nums[i]) + 1;
				if (count > n)
					return nums[i];
				else
					map.replace(nums[i], count);
			} else {
				map.put(nums[i], 1);
			}
		}

		return nums[0];
	}
}
