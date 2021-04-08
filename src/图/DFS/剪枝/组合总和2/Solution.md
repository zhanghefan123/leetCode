# 1.组合总和2

如果解决一个问题有多个步骤，每一个步骤有多种方法，题目又要我们找出所有的方法，可以使用回溯算法

剪枝操作：

1.在for循环的搜索范围上，也就是sum + candidates[i] 已经大于target，就可以结束本轮for循环。

2.同一树层上去重，也就是if(i > start && candidates[i] == candidates[i - 1])也就是说同一树层使用过candidates[i - 1]; 此时应continue。如下图所示：

![2222.png](https://pic.leetcode-cn.com/1614139502-mgZDle-2222.png)