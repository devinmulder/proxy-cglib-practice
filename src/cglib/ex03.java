package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.A;
import proxy.AImpl;

import java.lang.reflect.Method;

public class ex03 {

    public static void main(String[] args) {

        AImpl target = new AImpl();

        AImpl proxy = (AImpl) Enhancer.create(
                AImpl.class,
                new Class[] {A.class},
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
