package com.my_reflection.basic_usage;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class ReflectionDemo1 {

    public static void main(String[] args) throws Exception {
        Class<UserReflection> reflectionClass = UserReflection.class;
        // 获取Class对象的三种方式
        System.out.println("根据类名:  \t" + UserReflection.class);
        System.out.println("根据对象:  \t" + new UserReflection().getClass());
        System.out.println("根据全限定类名:\t" + Class.forName("com.my_reflection.basic_usage.UserReflection"));
        // 常用的方法
        System.out.println("获取全限定类名:\t" + reflectionClass.getName());
        System.out.println("获取类名:\t" + reflectionClass.getSimpleName());
        System.out.println("实例化:\t" + reflectionClass.newInstance());
    }

}

 class UserReflection {
    private String name = "init";
    private int age;

    public UserReflection(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserReflection() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
