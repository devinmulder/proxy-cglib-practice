package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ex02 {

    public static void main(String[] args) {

        AService target = new AService();

        AService proxy = (AService) Enhancer.create(
                AService.class,
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        method.invoke(target);
                        System.out.println("ex02.intercept");
                        return null;
                    }
                }
        );

        proxy.a1();
        proxy.a2();

    }
}
