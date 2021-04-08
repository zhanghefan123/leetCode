package SORT.比较器;

import java.util.Arrays;
import java.util.Comparator;

class Comparator_Test {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    //id比较器
    public static class IdAscendingComparator implements Comparator<Student> {


        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

    }

    //id比较器
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }

    }

    //年龄比较器
    public static class AgeAscendingComparator implements Comparator<Student> {

        // 当返回的值小于0的时候,我认为第一个参数应该放在前面
        // 当返回的值大于0的时候，我认为第一个参数应该放在后面，即交换两个数的位置
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    //年龄比较器
    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }

    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

    }
}
