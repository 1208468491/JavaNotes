package com.company;

/// 待读5.1.6
public class Manager extends Employee {
    /// 1. 子类不能直接访问父类的私有字段
    /// 2. 在子类中调用 getSalary() 会导致重复调用然后崩溃
    /// 3. super和this是不同的，this类似于引用的概念，而super是一个指示编译器引用父类的关键字
    /// 4. 当子类没有显式的调用超类的构造器，将自动调用超类的无参数构造器，超类没有构造器又没有显式的调用父类的构造器就会报错

    /// 关于4和Objective-C的类比和一些思考，Objective-C无论类是否实现自定义的构造方法，都会有默认的构造方法
    /// 除非父类把默认构造初始化方法标记为NS_UNAVAIABLE，这时就只能调用父类指定的初始化方法进行初始化
    public static void main(String args[]) {
        Employee e;
        e = new Employee(140000);

        Manager.getEmployee(e);

        /// 使用 instanceof 操作符可以检查是否能强制转型
        /// 当为null的对象做 instanceof 检查的时候不会报错
        if (e instanceof Manager) {
            Manager m = (Manager) e;
            m.setBonus(10000);
        }
    }

    private double bonus;

    /// this有两个含义，一是指示隐式参数的引用，二是调用该类的其他构造器
    /// super有两个含义，一是调用超类的方法，二是调用超类的构造器
    /// 调用构造器的语句只能出现在一个构造器的第一句
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public Manager(double bonus) {
        this("", 1000, 1, 1, 1);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /// Q: 子类把父类的public方法设置为private会怎么样？
    /// A：报错
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    /// 下面是重载方法，带有继承关系的参数不会报错
    public static void getEmployee(Employee employee) {

    }

    public static void getEmployee(Manager employee) {

    }
}
