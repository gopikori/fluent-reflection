package com.gopicreations.dsl.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * To be deleted.
 *
 */
public class NonDsl {

  /**
   * @param args
   * @throws ClassNotFoundException 
   * @throws NoSuchMethodException 
   * @throws SecurityException 
   * @throws InvocationTargetException 
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   * @throws InstantiationException 
   */
  public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
    
    Class<StringBuffer> cls = (Class<StringBuffer>) Class.forName("java.lang.StringBuffer");
    Constructor<StringBuffer> constr = cls.getConstructor(String.class);
    Object obj = constr.newInstance("Gopi");
    Method method = cls.getMethod("append", String.class);
    Object objResult = method.invoke(obj, " Kori");
    
    System.out.println(objResult);

  }

}
