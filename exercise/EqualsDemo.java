package exercise;

public class EqualsDemo {
    public static void main(String[] args) {
        String a = "ab"; // a为一个引用
        String b = "ab"; // b为另一个引用

        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 常量池中查找

        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true 对象内容相同
            System.out.println("aEQb");
        // if (42 == 42.0) // true
        //     System.out.println("true");

        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress());
        func(dog);
        func1(dog);
        System.out.println("funv1->"+ dog.getName());
        short f= 1;
        f = (short)(f+1);

    }

    private static void func(Dog dog) {
        System.out.println(dog.getObjectAddress());
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

    private static void func1(Dog dog) {
        dog.setName("B");
    }

}

class Dog {

    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}
