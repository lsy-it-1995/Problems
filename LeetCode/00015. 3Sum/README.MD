# 3 Pointers
* Time Complexity: O(N)
* Space Complexity: O(N)
	
## Java
### Solution 1
```
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet();
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return new ArrayList(list);
    }
}
```
### Solution 2
```
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            } 
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                    
                }
            }
        }
        return new ArrayList(list);
    }
}
```

## Python 3
```
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            left = i+1
            right = len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum > 0:
                    right -= 1
                elif sum < 0:
                    left += 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left+1]:
                        left += 1
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1
                    left += 1
                    right -= 1
        return res
```

# 2Sum helping

## Python 3
```
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = set()
        for i, value in enumerate(nums):
            self.twoSum(nums[i+1:], -value, ans)
        return ans
    def twoSum(self, nums, target, ans):
        d = {}
        for i, value in enumerate(nums):
            if target - value in d:
                ans.add((value, target-value, -target))
            d[value] = i
```

## C++
```
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        return threeSum(nums, 0);
    }
    vector<vector<int>> threeSum(vector<int>& nums, int target){
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<vector<int>> res;
        for(int i = 0; i < n; i++){
            vector<vector<int>> tuples = twoSum(nums, i+1, target - nums[i]);
            for(vector<int>& tuple: tuples){
                tuple.push_back(nums[i]);
                res.push_back(tuple);
            }
            while(i < n - 1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return res;
    }
    vector<vector<int>> twoSum(vector<int>& nums, int start, int target){
        // sort(nums.begin(), nums.end());
        int lo = start, hi = nums.size() - 1;
        vector<vector<int>> res;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if(sum == target){
                res.push_back({left, right});
                while(lo < hi && nums[lo] == left){
                    lo++;
                }
                while(lo < hi && nums[hi] == right){
                    hi--;
                }
            }else if(sum < target){
                while(lo < hi && nums[lo] == left){
                    lo++;
                }
            }else if(sum > target){
                while(lo < hi && nums[hi] == right){
                    hi--;
                }
            }
        }
        return res;
    }
};
```