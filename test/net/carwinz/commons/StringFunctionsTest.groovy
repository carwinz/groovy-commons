package net.carwinz.commons;

import javax.swing.plaf.basic.DragRecognitionSupport.BeforeDrag;

import groovy.util.GroovyTestCase;

class StringFunctionsTest extends BaseTestCase {

  protected void setUp() throws Exception {
    super.setUp();
    registerMetaClass String
    new StringFunctions().init()
  }
  
  public void testIsEmailAddressShouldReturnTrueWhenItIsValid() {
    assertTrue "a@b.c".isEmailAddress()
    assertTrue "fred@hotmail.com".isEmailAddress()
  }
  
  public void testIsEmailAddressShouldReturnFalseWhenItIsValid() {
    assertFalse "@b.c".isEmailAddress()
    assertFalse "fredhotmail.com".isEmailAddress()
  }
  
  public void testIsBlankShouldReturnFalseWhenStringHasCharacters() {
    assertFalse "a".isBlank()
  }
  
  public void testIsBlankShouldReturnTrueWhenStringHasOnlySpaces() {
    assertTrue " ".isBlank()
  }
  
  public void testIsBlankShouldReturnTrueWhenStringIsEmpty() {
    assertTrue "".isBlank()
  }
  
	public void testIsNotBlankShouldReturnTrueWhenStringHasCharacters() {
    assertTrue "a".isNotBlank()
	}
  
	public void testIsNotBlankShouldReturnFalseWhenStringHasOnlySpaces() {
	  assertFalse " ".isNotBlank()
	}
  
	public void testIsNotBlankShouldReturnFalseWhenStringIsEmpty() {
	  assertFalse "".isNotBlank()
	}
  
}
