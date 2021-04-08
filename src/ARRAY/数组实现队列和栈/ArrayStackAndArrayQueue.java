package ARRAY.数组实现队列和栈;

public class ArrayStackAndArrayQueue {
    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;//如果新来一个数，我们将新来的数放在索引size位置

        //这里的构造函数是为这个栈中存储元素的数组进行初始化
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;//定义为下一个元素需要进行存放的位置
        }

        //查看栈顶元素，但是不进行弹栈
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int obj) {

            //如果size即下一个元素存放的位置将为数组的length索引处
            //而如果在数组的length索引位置存放值的话就越界了，此时应该抛出异常

           if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
           //否则进行元素的放置并且将size进行递增的操作
            arr[size++] = obj;
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];//循环队列的总长度为initSize
            size = 0;
            first = 0;//指向的是队头元素
            last = 0;//指向的是队尾元素的下一个元素
            //初始状态
            /*
            *   [] start = end = 0           [7] start = 0
            *   []   --> 插入了一个元素7之后     [] end = 1
            *   []                           []
            * */
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            //如果队尾已经来到了数组的最后一个元素，再进行入队的话将跳回到0
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        public Integer poll() {
            //当size==0的时候说明空闲空间已经没有了，不能再向其中push元素了
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            //同样的如果队头已经来到了数组的最后一个元素，再进行入队的话将跳回到0
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {

    }
}
