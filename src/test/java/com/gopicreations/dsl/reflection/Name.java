package com.gopicreations.dsl.reflection;

import java.util.Date;

public class Name {

  private final String firstName;
  private final String lastName;
  private final Date birthDate;
  
  public Name(String firstName, String lastName) {
    this(firstName,lastName, new Date(System.currentTimeMillis()));
  } 
  
  public Name(String firstName, String lastName, Date birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Date getBirthDate() {
    return birthDate;
  } 
  
  
  
}
