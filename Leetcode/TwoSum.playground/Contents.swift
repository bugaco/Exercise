import Foundation

class Solution {
    func removeElement(_ nums: inout [Int], _ val: Int) -> Int {
        nums.removeAll(where: { num in
            return num == val
        })
        return nums.count
    }
}

class Solution2 {
    func removeElement(_ nums: inout [Int], _ val: Int) -> Int {
        nums = nums.filter { $0 != val }
        print(nums)
        return nums.count
    }
}

var nums = [0,1,2,2,3,0,4,2]
let count = Solution().removeElement(&nums, 2)
print(count)
