package com.company;

public final class Executive extends Manager {
    /// final 修饰的类无法继承，修饰的方法无法覆盖
    /// 把一个类声明为fianl后所有方法会被自动标记为final，但字段不会被标记为final
    /// inlining 当一个方法很短且没有被继承，这个方法就会被编译器优化，这个过程被称为内联
    /// 内联是比如 getName 的方法调用会被替换为 this.name
    /// final不能用来修饰构造方法
    public Executive() {
        super(1000000);
    }

    public final String getName() {

    }
}
