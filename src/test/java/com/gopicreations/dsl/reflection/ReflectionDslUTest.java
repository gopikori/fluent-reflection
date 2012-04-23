package com.gopicreations.dsl.reflection;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.gopicreations.dsl.reflection.ReflectionDSL.*;

public class ReflectionDslUTest {
  
  @Test
  public void testClassSpecification() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    create("java.lang.StringBuffer");
  }
  
  @Test 
  public void testObjectCreation() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
    create("java.lang.StringBuffer").withValue("hakuna");
  }
  
  @Test
  public void testMethodInvocation() throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
    Object result = create("java.lang.StringBuffer").withValue("Hakuna").call("append", " Matata").call("toString").get();
    
    assertEquals(String.class, result.getClass());
    assertEquals(result, "Hakuna Matata");
  }
}
