package com.company;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE }

/// 待学：3.6.6  4.2.2
public class Main {
    static final double CM_PER_INCH_ = 2.54;

    public static void main(String[] args) {
        String greeting = "Hello World";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();
        var val = 10;
        System.out.println(val);

        final double CM_PER_INCH = 2.54; // 常量

        System.out.println(CM_PER_INCH_);

        Size size = Size.SMALL;

        System.out.println(size);

        long lval = 10L;

        float fval = 10f;

        System.out.println("100_000_000");

        System.out.println(-11 % -3);

        System.out.println(Math.floorMod(-10, 3));

        Main.stringNotes();
    }

    /// 字符串
    public static void stringNotes() {
        String greeting = "Hello";
        // substring(startIdx, endIndex) substring(startIndex)
        // Q: 为什么一个函数名可以是两个函数，重载？
        // A: 重载
        String s = greeting.substring(0, 3); // 执行的是复制操作

        /// 拼接
        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;

        /// String和int类型的拼接
        int age = 13;
        String rating = "PG" + age;

        /// 拼接特性常用于println
        System.out.println("The answer is " + age);

        /// String常用的拼接方法
        //  join 表现为插入到每个元素中间，只有一个元素就不添加
        String all = String.join(" / ", "S", "M", "L", "XL");
        String repeated = "Java".repeat(13);
        System.out.println(all + repeated);

        /// String 类没有修改字符串的方法，要修改字符串可以使用substring
        /// Q: 好像也可以直接修改字符串本身？ A: 可以修改字符串变量，让它引用到另一个字符串
        /// Q2: 怎么又是引用了？
        greeting = greeting.substring(0, 3) + "p!";
        System.out.println(greeting);

        // A2: 通过测试，两个字符串的行为不是指向同一个引用
        // A2补充：因为字符串是不可变类型，当修改一个字符串对象时，相当于重新为对象赋值
        String anotherGreeting = greeting;
        // 下面为证实A2的代码
        // 让greeting和another指向同一个引用，再修改anotherGreeting
        // 此时anotherString被重新赋值一个新的字符串对象，而不是修改它指向的地址
//        anotherGreeting = anotherGreeting.substring(0, 3) + "!";
        anotherGreeting = "greeting";
        System.out.println(anotherGreeting + greeting);

        // String之所以是不可变的，是为了让编译器中字符串实现共享
        // 各种字符串存放在字符串共享池中，字符串变量指向池中相应的位置，当复制发生的时候，原始的字符串和字串共享相同的字符串
        // Q3: 也就是写时复制？
        // 只有字符串字面量是共享的，通过 + 和 substring创建的字符串不是共享的

        // 当把字符串greeting替换成另一个字符串时，Java相当于做了如下操作
        // char *temp = malloc(6); strncpy(temp, greeting, 3);
        // strncpy(temp + 3, "p!", 3); greeting = temp;
        // 因为 垃圾回收 机制，在Java中这样做不会内存泄漏


        /// 检测字符串是否相等
        greeting.equals(anotherGreeting); // 常量直接的比较
        "Hello".equals(greeting); // 字面量和常量的比较
        "Hello".equalsIgnoreCase(greeting); // 忽视大小写
        /// 一定不要使用 == 来比较两个字符串，在这里 == 用于确定两个字符串是否在同一个地址上

        /// 空串与 null
        String str = "str";
        if (str.length() == 0) return; // 判断字符串是否为空
        if (str.equals("")) return; // 判断字符串是否为空
        // String还可以存放一个特殊值，为null，表示当前没有任何对象和变量相关联
        if (str == null) return; // 判断一个字符串是否为null
        // 这里要注意判断的顺序，先判断 null 的情况， 在null的对象上调用方法会产生错误
        if (str != null && str.length() == 0) return; // 判断一个字符串不为null也不为空

        /// 获取字符串的长度
        String codeString = "😀code point";
        char firstChar = codeString.charAt(0);
        System.out.println(firstChar);

        int targetIndex = codeString.offsetByCodePoints(0, 1);
        int codePoint = codeString.codePointAt(targetIndex);

        int[] codePoints = codeString.codePoints().toArray();
        System.out.println("Code Points: " + codePoints.toString());

        String firstStr = new String(codePoints, 0, 1);
        System.out.println("First Str" + firstStr);

        System.out.println("codePoint");
        // 遍历字符串
        String sentence = "Sentence";
        int i = 1;
        // 正向遍历
        int codePoint = sentence.codePointAt(i);
        if (Character.isSurrogate(sentence.charAt(i))) i += 2;
        else i ++;
        // 反向遍历
        i --;
        if (Character.isSurrogate(sentence.charAt(i))) i --;
        int ca = sentence.codePointAt(i);

        /// 常用的String API 参考 《Java核心卷 卷1》 49页
        /// API 文档参考 org.oracle.com/javase

        /// 每次拼接字符串都会构建一个String对象，使用StringBuilder来避免
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        builder.append(greeting);
        String completedString = builder.toString(); // 构建完成后创建 String
    }

    /// 输入输出
    public static void inputAndOutPut() {
        // 读取"标准输入流"控制台窗口，需要构建一个System.in 的关联对象 Scanner对象
        Scanner in = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = in.nextLine();
        String nameWithoutSpace = in.next(); // 当输入值没有空格的时候
        int age = in.nextInt(); // 整数

        /// 输出
        double x = 1000 / 3.0; // 默认 除法运算符 返回double类型
        System.out.printf("%8.2f", x); // 包含8个字符串，最多精确到后两位

        /// Format类型的列表见 《Java核心技术 卷1》58页
        /// %s转换符格式化任意的对象。对于实现了formattable接口的对象，会调用对象的formatTo方法
        // 否则调用toString方法把这个对象转换为字符串
        /// 创建 Format 类型的 String
        String message = String.format("Hello, %s. Next year, you'll be %d", name, age);


    }

    /// 控制流
    public static void controlFlow() {
        /// while 循环
        boolean condition = true;
        while (condition) {
            // 实现
        }

        /// for 循环
        for (int i = 0; i < 10; i ++) {
            // 实现
        }

        // 带标签的break语句
        read_data:
        while (condition) {
            for (int i = 0; i < 10; i ++) {
                break read_data;
            }
        }
    }

    /// 大数
    public static void bigNumber() {
        /// BigInteger和BigDecimal分别用来表示Int类型和浮点数的大数
        // 使用静态方法 valueOf 可以将普通数值转为大数
        BigInteger a = BigInteger.valueOf(100);
        // 一些常量 BigInteger.ZERO, BigInteger.ONE
        // 相加
        BigInteger b = BigInteger.ONE;
        BigInteger c = b.add(a);
    }

    /// 数组
    public static void arrays() {
        int[] a; // 这里只声明了变量a，并没有将a初始化成一个真正的数组
        int[] a1 = new int[100]; // 创建数组 数组长度不要求是常量 可以是 n
        /// 如果经常要改变数组的大小，应该使用 数组列表

        // 创建数组简写 不用写 new
        int[] smallPrimes = { 2, 3, 5, 7, 11, 13 };

        // 数组可以创建长度为0的数组
        int[] anonymous = new int[0]; // new int{}

        /// 创建一个初始化数组的时候，所有元素都初始化为0
        /// boolean类型数组初始化为false，对象数组的初始化为 null
        String[] names = new String[10]; // 创建一个10个null的数组

        /// for each循环 for (variable : collection) statement
        /// 定义一个变量并暂存集合里所有元素。collection这一集合的表达式必须是一个数组或者实现了 Iterable接口的类对象
        for (int element : a1) {
            // 遍历每个元素而不是下标值
            System.out.println(element);
        }

        /// 打印Array中所有值的小技巧
        System.out.println(a1.toString());

        /// 数组拷贝
        // 数组拷贝是拷贝引用，一个引用改变之后另一个也会改变
        int[] luckyNumbers = smallPrimes;
        luckyNumbers[5] = 12; // smallPrimes也会改变
        // 把数组中所有的值拷贝到新的数组中
        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);
        // 第二个参数是数组大小，通常用来增加数组容量
        luckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length * 2);
        /// 当数组的元素是数值型，额外元素被赋值为0，boolean类型赋值为false，如果小于原始数组长度，只拷贝前面的值
        /// Java中的[]运算符被预定义为会完成 越界检查，而且没有指针运算，即不能通过 a加1 得到数组中的下一个元素

        /// 命令行参数，每个Java程序都有一个带String args[]参数的main方法，这个参数表明main方法将接收一个字符串数组
        /// 也就是命令行上指定的参数，详情见 《Java核心卷 卷1》 82页

        /// Arrays 排序
        int[] array = new int[10000];
        Arrays.sort(array); // 使用优化的快速排序
    }

    /// 根据 k个数 n最大 生成不重复的随机数
    public static void buildRandomArray() {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers?");
        int k = in.nextInt();

        System.out.println("What is the highest number");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i ++) {
            numbers[i] = i + 1;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i ++) {
            int r = (int) (Math.random() * n); // random返回一个 0 - 1的随机数
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1]; // 把已经取出的随机数从原数组中删除
            n -= 1;
        }

        Arrays.sort(result);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static void prebuildClassDate() {
        Date birthday = new Date();
        Date deadline; // 创建一个可以引用Date的对象 但此时deadline并不是一个对象
//        deadline.toString(); // 这样的函数调用会报错
        deadline = new Date(); // 引用一个新的构造对象
        deadline = birthday; // 引用已有对象

        deadline = null; // 显示的赋值为 null，表示deadline没有引用任何对象

        /// 所有Java的对象都保存在堆里，当一个对象包含另一个对象变量时，它只是包含另一个变量的堆对象指针

    }

    public static void EmployeeTest() {
//        Employee employee = new Employee("employee", 50000, 1989, 10, 1);
        // 上面的代码等效于下面的代码 var关键字只用于局部变量
        var employee = new Employee("name", 50000, 1989, 10, 1);


    }
}













