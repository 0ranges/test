package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {

        Person zs = new Student("张三");

        /*//静态代理测试

        Person monitor = new StudentProxy(zs);
        monitor.giveMoney();
        //结果：张三上交50元班费*/

        //动态代理
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zs);
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},stuHandler);
        stuProxy.giveMoney();

    }
}
interface Person{
    void giveMoney();
}
class Student implements Person{
    private String name;
    public Student(String name){
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交50元班费");
    }
}
class StudentProxy implements Person{
    Student stu;
    public StudentProxy(Person stu){
        if(stu.getClass() == Student.class){
            this.stu = (Student) stu;
        }
    }

    @Override
    public void giveMoney() {
        stu.giveMoney();
    }
}
class StuInvocationHandler<T> implements InvocationHandler{
    T target;
    public StuInvocationHandler(T target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}
class MonitorUtil {

    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}