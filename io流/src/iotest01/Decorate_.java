package iotest01;

/**
 * 装饰类的使用
 */
public class Decorate_ {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.say();
//        Amplifier amplifier = new Amplifier(person);
//        amplifier.say();

        Drink coffee =new Coffee();
        Drink suger =new Suger(coffee); //装饰
        System.out.println(suger.info()+"-->"+suger.cost());
        Drink milk =new Milk(coffee);//装饰
        System.out.println(milk.info()+"-->"+milk.cost());
        milk =new Milk(suger);//装饰
        System.out.println(milk.info()+"-->"+milk.cost());
    }
}

/**
 * 定义一个叫说话的接口
 */
interface say{
    void say();
}

/**
 * 定义一个叫人的类实现说话say的接口
 * 属性为说话音量
 */
class Person implements say{
    private int voice = 10;

    public Person() {
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    @Override
    public void say() {
        System.out.println("人的声音大小是："+voice);
    }
}

/**
 * 设置扩音器实现say的接口
 * 传入一人的声音实现对人声音的放大
 */
class Amplifier implements say{
    private Person person;
    private int multiple = 10;

    public Amplifier() {
    }

    Amplifier(Person person){
        this.person = person;
    }

    @Override
    public void say() {
        System.out.println("人的声音大小为："+person.getVoice()+"*"+multiple);
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

}


    /**
     * 模拟咖啡
     * 1、抽象组件:需要装饰的抽象对象(接口或抽象父类) 为2、3进行服务是它们的父类或者接口
     * 2、具体组件:需要装饰的对象 是1的实现或者子类
     * 3、抽象装饰类:包含了对抽象组件的引用以及装饰着共有的方法 为4进行服务 是1的实现或者子类
     * 4、具体装饰类:被装饰的对象 对2进行装饰 是3的子类
     * */

//抽象组件
interface Drink{
    double cost(); //花费
    String info(); //说明
}

//具体组件
class Coffee implements Drink{
    private String name ="原味咖啡";

    public Coffee() {
    }

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

//抽象装饰类
abstract class decorate implements Drink{
    //对抽象组件的引用
    private Drink drink;
    public decorate(Drink drink) {
        this.drink =drink;
    }
    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

//具体装饰类
class Milk extends decorate{
    /**
     *报错，因为父类没有无参构造器 所以加super(); 依然报错
     * 类里不手动创建构造器，编译器会自动创建，但是手动创建了一个带参或者不带参构造器之后
     * 编译器就不会自动生成无参构造器了
     */
//    public Milk() {
//
//    }

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加入了牛奶";
    }
}

//具体装饰类
class Suger extends decorate{

    public Suger(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"加入了蔗糖";
    }
}
