# 1.直观思路

首先遍历一遍数列，用另个数列按顺序存储所有非 0 的元素，在将存储的非零元素按顺序复制到原数列中，空位补 0 即可。直观的解题思路新建额外的数组，不符合要求，但是对于我们下面的优化算法很有起始。

![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/LCCN-Articles/explore/%E6%95%B0%E7%BB%84%E4%B8%93%E9%A2%98/640.png)

# 2.优化思路

我们肯定不想使用额外的空间，我们发现可以使用同向双指针，其中一个指针指向的是当前检查的元素，另一个元素指向的是下一个非0元素所存放的位置，进行遍历即可。