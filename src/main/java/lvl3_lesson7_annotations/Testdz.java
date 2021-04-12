package lvl3_lesson7_annotations;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;

public class Testdz {
    public static void check() throws Exception{
        File file = new File("D:/dz");
        String[] fileList = file.list();
        ArrayList<String> fileName = new ArrayList<>();
        for(String o:fileList){
            String[] arr = o.split("\\.");
            if(arr[1].equalsIgnoreCase("class")){
                fileName.add(arr[0]);
            }
        }

        Iterator it = fileName.iterator();
        while (it.hasNext()){
            String name = String.valueOf(it.next());
            Class ch = URLClassLoader.newInstance(new URL[]{new File("D:/dz").toURL()}).loadClass(name);
            Constructor constructor = ch.getConstructor();
            Object dz = constructor.newInstance();
            Method m = ch.getDeclaredMethod("calculate",float.class,float.class,float.class,float.class);
            float res = (float) m.invoke(dz,1.0F, 2.0F, 4.0F, 2.0F);
            System.out.println(res);

            m = ch.getDeclaredMethod("checkSum10to20",int.class, int.class);
            boolean res2 = (boolean) m.invoke(dz,11, 3);
            System.out.println(res2);

            m = ch.getDeclaredMethod("checkNumber",int.class);
            res2 = (boolean) m.invoke(dz,11);
            System.out.println(res2);

            m = ch.getDeclaredMethod("checkNumber",int.class);
            res2 = (boolean) m.invoke(dz,11);
            System.out.println(res2);
        }

    }
}
