package com.company;


import java.time.LocalDate;
import java.util.Objects;

public class Employee
{

    /// 理解方法的参数是对象的引用的副本
    /// 传入参数时，传入的是对象引用的副本，在函数中交换x，y的引用只是交换这两个临时对象的引用
    /// 也就是说 swap(employeeA, employeeB); 在函数中 a -> employeeA， b -> employeeB 转变为
    /// a -> employeeB， b -> employeeA，但传入的变量本身并没有任何改变
    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }

    /// final 修饰的字段必须在构造方法中进行初始化，在这之后这个字段不能被修改，没有setName方法
    /// final 对于基本类型或者不可变类型尤其有用，如果类中所有的方法都不会改变其对象，这个类就是不可变类，比如String
    /// String 被改变之后相当于赋值了一个新的对象的引用
    /// final 修饰 可变对象 的时候，这个对象还是可以改变，但是不能指向另一个引用
    private final String name;
    private double salary;
    private LocalDate hireDay;

    private static int nextId = 1;
    private int id;

    public Employee(String n, double s, int year, int month, int day) {
        // 判断 n 是否为空，在空的时候赋值
        name = Objects.requireNonNullElse(n, "unkonwn");
        //
        Objects.requireNonNull(n, "The name cannot be null");
        salary = s;
        hireDay =  LocalDate.of(year, month, day);
    }

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        /// 这里的 hireDay使用了 LocalDate类型 没有 setTime方法 所以不能改变对象
        /// 假设使用 Date()对象 调用setTime会改变 hireDate引用的对象
        /// 解决方案为 return (Date) hireDay.clone();
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /// 一个对象可以访问其中所有对象的私有数据
    public boolean equals(Employee other) {
        return name.equals(other.name);
    }


    public void setId() {
        id = nextId;
        nextId ++;
    }

    /// 静态方法不能获取普通的 字段，但是可以获取静态字段
    /// 对象也可以调用静态方法，但不推荐这样做
    public static int getNextId() {
        return nextId;
    }

    /// 工厂方法的意义
    /// 无法命名构造器，构造器的名字必须和类名相同
    /// 使用构造器无法改变所构造对象的类型，而工厂类型可以放回当前类型的子类

    /// 重载
    /// 重载可以应用于构造器和普通的方法
    /// 不能用于 函数名称相同参数相同但返回值不同的函数

    /// 默认字段的初始化
    /// 在构造器 中 没有显式地为字段设置初始值，那么就会被自动设置为默认值，数值为0，boolean值为false，对象为null


    /// 默认构造器
    /// 当类没有写构造器就会提供一个无参数构造器，为所有参数设置默认值
    /// 当类提供了至少一个构造器时，但没有提供无参数构造器，就会报错

}
