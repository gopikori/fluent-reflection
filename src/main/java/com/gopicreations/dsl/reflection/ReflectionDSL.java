package com.gopicreations.dsl.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDSL {

  private Object object;
  
  public ReflectionDSL(Object object) {
    this.object = object;
  }

  public static ReflectionDSL create(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    return new ReflectionDSL(Class.forName(className));
  }

  public ReflectionDSL withValue(Object...parameters) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    object = ((Class)this.object).getConstructor(getParameterTypes(parameters)).newInstance(parameters);
    return this;
  }

  public ReflectionDSL call(String method, Object...parameters) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    this.object = object.getClass().getMethod(method, getParameterTypes(parameters)).invoke(object, parameters); 
    return this;
  }

  public Object get() {
    return object;
  }
  
  private Class<?>[] getParameterTypes(Object[] parameters) {
    Class<?>[] paramTypes = new Class<?>[parameters.length];
    for(int i = 0; i< parameters.length; i++) {
      paramTypes[i] = parameters[i].getClass();
    }
    return paramTypes;
  }

}
