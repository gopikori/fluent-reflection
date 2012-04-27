package com.gopicreations.dsl.reflection;

import static com.gopicreations.dsl.reflection.ReflectionDSL.create;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReflectionDslUTest {
  
  @Test
  public void testClassSpecification() throws Exception {
    create("java.lang.StringBuffer");
  }
  
  @Test 
  public void testObjectCreation() throws Exception {
    create("java.lang.StringBuffer").withValue("hakuna");
  }
  
  @Test 
  public void testObjectCreationWithMultipleConstructorArgs() throws Exception {
    create("com.gopicreations.dsl.reflection.Name").withValue("Michael", "Jackson");
  }
  
  @Test
  public void testMethodInvocation() throws Exception {
    Object result = create("java.lang.StringBuffer").withValue("Hakuna").call("toString").get();
    
    assertEquals(String.class, result.getClass());
    assertEquals("Hakuna", result);
  }
  
  @Test
  public void testMethodInvocationWithParameter() throws Exception {
    Object result = create("java.lang.StringBuffer").withValue("Hakuna").call("append", " Matata").call("toString").get();
    
    assertEquals(String.class, result.getClass());
    assertEquals("Hakuna Matata", result);
  }

  @Test
  public void testMethodInvocationWithTwoParameters() throws Exception {
    Object result = create("java.lang.String").withValue("aa bb aa bb").call("replaceAll", "bb", "aa").get();
    
    assertEquals(String.class, result.getClass());
    assertEquals("aa aa aa aa", result);
  }

}
