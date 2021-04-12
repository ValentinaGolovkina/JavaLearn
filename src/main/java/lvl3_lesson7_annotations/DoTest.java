package lvl3_lesson7_annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.TreeMap;

public class DoTest {
    public static void start(Class testClass) {
        try {
            TreeMap<Integer,String> methoodsTest = new TreeMap(Collections.reverseOrder());
            Object obj = testClass.newInstance();
            Method[] methods = testClass.getDeclaredMethods();
            String nameMethodBefore ="";
            String nameMethodAfter ="";
            for (Method o : methods) {
                if(o.getAnnotation(BeforeSuite.class) != null) {
                    if(nameMethodBefore.equals("")){
                        nameMethodBefore=o.getName();
                    } else {
                        throw new RuntimeException("Более одного метода помеченного аннотацией BeforeSuite");
                    }
                }
                if(o.getAnnotation(AfterSuite.class) != null) {
                    if(nameMethodAfter.equals("")){
                        nameMethodAfter=o.getName();
                    } else {
                        throw new RuntimeException("Более одного метода помеченного аннотацией AfterSuite");
                    }
                }
                if(o.getAnnotation(Test.class) != null) {
                    Integer priotity = o.getAnnotation(Test.class).priority();
                    if(priotity<1 || priotity>10){
                        throw new RuntimeException("Приоритет должен быть от 1 до 10");
                    }
                    methoodsTest.put(priotity,o.getName());
                }
            }
            if(!nameMethodBefore.equals("")) {
                Method methodBefore = testClass.getDeclaredMethod(nameMethodBefore);
                methodBefore.invoke(obj);
            }

            for(String nameMethod : methoodsTest.values()){
                Method method = testClass.getDeclaredMethod(nameMethod);
                method.invoke(obj);

            }

            if(!nameMethodAfter.equals("")) {
                Method methodAfter = testClass.getDeclaredMethod(nameMethodAfter);
                methodAfter.invoke(obj);
            }
        } catch (NoSuchMethodException| InvocationTargetException |InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void start(String nameTestClass) {
        try {
            start(Class.forName(nameTestClass));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
