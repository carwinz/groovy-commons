package net.carwinz.commons

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringFunctions {
	
	def init(){
		String.metaClass.isEmailAddress = {
			Pattern.compile(".+@.+\\.[a-z]+").matcher(delegate).matches()
		}
		
		String.metaClass.isBlank = {
			delegate.trim() == ''
		}
		
		String.metaClass.isNotBlank = {
			delegate.trim() != ''
		}
    
    // A very basic and un-educated attempt to make a singular word plural
    String.metaClass.pluralise = {
      if (delegate.endsWith("y")){
        return delegate.substring(0, delegate.length()-1) + "ies";
      }
      return delegate + "s";
    }
	}
	
}
