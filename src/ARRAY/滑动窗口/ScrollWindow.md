## 1.使用队列相加（实际上我们也可以把它称作是滑动窗口，这里的队列其实就相当于一个窗口）

我们把数组中的元素不停的入队，直到总和大于等于 s 为止，接着记录下队列中元素的个数，然后再不停的出队，直到队列中元素的和小于 s 为止（如果不小于 s，也要记录下队列中元素的个数，这个个数其实就是不小于 s 的连续子数组长度，我们要记录最小的即可）。接着再把数组中的元素添加到队列中……重复上面的操作，直到数组中的元素全部使用完为止。
这里以 [2,3,1,2,4,3] 举例画个图来看下

![image.png](https://pic.leetcode-cn.com/10ca012c2f0170afcac5e5996add20c32c36a82f4bb4a6187897bb948ace5fe2-image.png)

![image.png](https://pic.leetcode-cn.com/2da8cf86a2a3df3c95ed7d95add574dca2d8bae8420addd0fa6b8c55fa3db081-image.png)

![image.png](https://pic.leetcode-cn.com/ca74b1a2ad0eb5a4ebf8647a332161b140c8ebdd71cd5d19bef16e9bf0a43c95-image.png)

![image.png](https://pic.leetcode-cn.com/72f39b5cd7eb5f866e24d0a31eb3eac7d57cf3ad202ad40d30f103833c1f5a69-image.png)