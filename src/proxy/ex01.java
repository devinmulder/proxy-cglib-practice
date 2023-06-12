package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ex01 {

    public static void main(String[] args) {

        AImpl target = new AImpl();

        A proxyInstance = (A) Proxy.newProxyInstance(
                A.class.getClassLoader(),
                new Class[]{A.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("ex01.invoke");
                        method.invoke(target);
                        return null;
                    }
                });

        proxyInstance.a1();
        proxyInstance.a2();

    }
}
