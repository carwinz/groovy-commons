package net.carwinz.commons

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringFunctions {

    def init(){
        String.metaClass.isEmailAddress = {
            Pattern.compile(".+@.+\\.[a-z]+").matcher(delegate).matches()
        }
        
        String.metaClass.insertHtmlTags = {
            delegate.replaceAll("((http|ftp|https):\\/\\/\\S*)", "<a href=\"\$1\">\$1</a>" );
        }

        String.metaClass.isBlank = {
            delegate.trim() == ''
        }

        String.metaClass.isNotBlank = {
            delegate.trim() != ''
        }
  
        String.metaClass.random = {
            delegate.empty ? null : delegate[new Random().nextInt(delegate.size())-1]
        }
    }
}
