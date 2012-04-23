package com.gopicreations.dsl.reflection;

import java.lang.reflect.InvocationTargetException;

public class ReflectionDSL {

  private Object object;
  
  public ReflectionDSL(Object object) {
    this.object = object;
  }

  public static ReflectionDSL create(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    return new ReflectionDSL(Class.forName(className));
  }

  public ReflectionDSL withValue(String value) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    object = ((Class)this.object).getConstructor(String.class).newInstance(value);
    return this;
  }

  public ReflectionDSL call(String method) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    this.object = object.getClass().getMethod(method, null).invoke(object); 
    return this;
  }
  
  public ReflectionDSL call(String method, Object parameter) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    this.object = object.getClass().getMethod(method, parameter.getClass()).invoke(object, parameter); 
    return this;
  }

  public Object get() {
    return object;
  }
  
}
