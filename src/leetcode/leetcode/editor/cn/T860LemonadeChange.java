/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：bills = [5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= bills.length <= 10⁵
 * bills[i] 不是 5 就是 10 或是 20
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 360 👎 0
 */

package leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class T860LemonadeChange {
    public static void main(String[] args) {
        Solution solution = new T860LemonadeChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            Map<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(5, 0);
            hashMap.put(10, 0);
            hashMap.put(20, 0);
            for (int i = 0; i < bills.length; i++) {
                hashMap.put(bills[i], hashMap.get(bills[i]) + 1);
                Integer integer5 = hashMap.get(5);
                if (bills[i] == 10) {
                    if (integer5 <= 0) {
                        return false;
                    } else {
                        hashMap.put(5, integer5 - 1);
                    }
                }
                if (bills[i] == 20) {
                    Integer integer10 = hashMap.get(10);
                    if (integer10 > 0) {
                        hashMap.put(10, integer10 - 1);
                        if (integer5 > 0) {
                            hashMap.put(5, integer5 - 1);
                        } else {
                            return false;
                        }
                    } else {
                        if (integer5 >= 3) {
                            hashMap.put(5, integer5 - 3);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}