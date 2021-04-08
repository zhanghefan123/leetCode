# 1.链表--LinkedList

## 1.1 链表结点的定义

![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/08/05/screen-shot-2018-04-12-at-152754.png)

```java
// Definition for singly-linked list.
public class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}
```

## 1.2 链表的插入操作

### 1.2.1 插入结点的步骤

> 1.使用给定值初始化新结点cur：
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/08/05/screen-shot-2018-04-25-at-163224.png)
>
> 2.将cur的next字段链接到prev的下一个结点next
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/26/screen-shot-2018-04-25-at-163234.png)
>
> 3.将prev之中的next字段链接到cur
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/26/screen-shot-2018-04-25-at-163243.png)

### 1.2.2 在没有DummyNode的情况下，在开头添加结点

> 1.首先初始化一个新结点并将其链接到当前的头结点
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/19/screen-shot-2018-04-19-at-125118.png)
>
> 2.然后指定这个新结点作为新的头结点
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/19/screen-shot-2018-04-19-at-125350.png)

### 1.2.3 在存在DummyNode的情况下，在开头进行结点的添加的操作与其余位置操作一致。

### 1.2.4 存在DummyNode的优点

> 1.链表的第一个位置和其他位置的操作统一
>
> 2.空表和非空表的操作统一，head指针始终都是指向DummyNode的非空指针。



## 1.3 单链表的删除操作

### 1.3.1 删除结点的步骤

> 1.找到 cur 的上一个结点 `prev` 及其下一个结点 next
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/27/screen-shot-2018-04-26-at-203558.png)
>
> 2.接下来链接prev到cur的下一个结点next
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/26/screen-shot-2018-04-26-at-203640.png)

### 1.3.2 当不存在DummyNode时，删除第一个结点

> 1.让head指向原先head的下一个结点即可。
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/19/screen-shot-2018-04-19-at-130031.png)



# 2.双向链表

## 2.1 双向链表的插入操作

如果我们想在现有的结点 `prev` 之后插入一个新的结点 `cur`，我们可以将此过程分为两个步骤：

> step1：链接 `cur` 与 `prev` 和 `next`，其中 `next` 是 `prev` 原始的下一个节点；
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/28/screen-shot-2018-04-28-at-173045.png)
>
> step2：用 `cur` 重新链接 `prev` 和 `next`。
>
> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/29/screen-shot-2018-04-28-at-173055.png)

## 2.2 双向链表的删除操作

说明：

> 如果我们想从双链表中删除一个现有的结点 `cur`，我们可以简单地将它的前一个结点 `prev` 与下一个结点 `next` 链接起来。与单链表不同，使用“prev”字段可以很容易地在常量时间内获得前一个结点。因为我们不再需要遍历链表来获取前一个结点，所以时间和空间复杂度都是`O(1)`。

删除步骤：

> ![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/04/18/screen-shot-2018-04-18-at-142428.png)

