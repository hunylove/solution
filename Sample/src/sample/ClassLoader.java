package sample;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoader {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {

        Class<?> loadClass;

        String classPath = "";
        String className = "";
        String methodName = "";

        URL[] urls = new URL[1];
        urls[0] = new File(classPath).toURI().toURL();

        // main 이 아닌 경우
        // loadClass = new URLClassLoader(urls, getClass().getClassLoader()).loadClass(className);
        loadClass = new URLClassLoader(urls, ClassLoader.class.getClassLoader()).loadClass(className);

        Method method = loadClass.getMethod(methodName, String.class, String.class, String.class);

        Object[] parameter = new Object[3];
        parameter[0] = "ReturnValue";
        parameter[1] = "InputValue1";
        parameter[2] = "InputValue2";

        String returnVal = null;

        try {
            returnVal = (String) method.invoke(loadClass, parameter);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(returnVal);
    }
    
}
