package com.chenqi.framework.protocol.http;

import com.chenqi.framework.Invocation;
import com.chenqi.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse res) {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(req.getInputStream());
            Invocation invocation = (Invocation) objectInputStream.readObject();

            String interfaceName = invocation.getInterfaceName();
            Class implClass = LocalRegister.get(interfaceName);

            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            System.out.println("tomcat:" + result);

            IOUtils.write(result, res.getOutputStream());

        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
