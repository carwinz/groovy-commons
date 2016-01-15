package net.carwinz.commons;


class StringFunctionsTest extends TestHelper {

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

    public void testInsertHtmlTagsShouldDetectAllHttpLinksAndWrapThemInHtmlTags(){
        assertEquals "a <a href=\"http://www.google.com\">http://www.google.com</a> b", "a http://www.google.com b".insertHtmlTags()
    }
  
    public void testRandomShouldReturnOneOfTheGivenValues(){
        assertTrue (["a", "b", "c"].contains("abc".random()))
    }
    
    public void testRandomShouldReturnTheValueWhenThereIsOnlyOneValue(){
        assertEquals "a", "a".random()
    }
    
    public void testRandomShouldReturnNullWhenThereAreNoValues(){
        assertNull "".random()
    }
    
}
