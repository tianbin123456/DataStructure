//设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
//
// 
// insert(val)：当元素 val 不存在时，向集合中插入该项。 
// remove(val)：元素 val 存在时，从集合中移除该项。 
// getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。 
// 
//
// 示例 : 
//
// 
//// 初始化一个空的集合。
//RandomizedSet randomSet = new RandomizedSet();
//
//// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomSet.insert(1);
//
//// 返回 false ，表示集合中不存在 2 。
//randomSet.remove(2);
//
//// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomSet.insert(2);
//
//// getRandom 应随机返回 1 或 2 。
//randomSet.getRandom();
//
//// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomSet.remove(1);
//
//// 2 已在集合中，所以返回 false 。
//randomSet.insert(2);
//
//// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
//randomSet.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 276 👎 0


package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class T380InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        RandomizedSet solution = new T380InsertDeleteGetrandomO1().new RandomizedSet();
        solution.insert(1);
        solution.remove(2);
        solution.insert(2);
        solution.getRandom();
        solution.remove(1);
        solution.insert(2);
        solution.getRandom();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;
        private Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashMap<>(16);
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         * 数组要达到o(1)时间复杂度，需进行一次交换，先将需要删除的数据移到数字末尾，再进行删除。
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Integer last = list.get(list.size() - 1);
            Integer index = map.get(val);
            map.put(last, index);
            list.set(index, last);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}