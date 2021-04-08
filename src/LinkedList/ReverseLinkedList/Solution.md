# 1.反转链表

思路：

> `按原始顺序迭代结点`，并将它们`逐个移动到列表的头部`。似乎很难理解。我们先用一个例子来说明我们的算法.

算法图述：

> 1.链表的初始情况如下
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/14/screen-shot-2018-04-14-at-163143.png)
>
> 2.将头结点的下一个结点拿出来作为头结点
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/14/screen-shot-2018-04-14-at-163336.png)
>
> 3.将下一个结点拿出来作为头结点
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/14/screen-shot-2018-04-14-at-163525.png)

时间复杂度分析：

> 在该算法中，每个结点只移动一次。
>
> 因此，时间复杂度为 O(N)，其中 N 是链表的长度。我们只使用常量级的额外空间，所以空间复杂度为 O(1)。
>
> 这个问题是你在面试中可能遇到的许多链表问题的基础。如果你仍然遇到困难，我们的下一篇文章将更多地讨论实现细节。