package net.carwinz.commons

import static java.util.Calendar.getInstance as now
import static java.util.Calendar.DAY_OF_YEAR
import static java.util.Calendar.DAY_OF_MONTH
import static java.util.Calendar.MONTH
import static java.util.Calendar.YEAR
import static java.util.Calendar.MINUTE
import static java.util.Calendar.HOUR_OF_DAY
import static java.util.Calendar.SECOND
import static java.util.Calendar.MILLISECOND

class DateFunctions {

    public static final long ONE_SEC_LONG = 1000L;
    public static final long ONE_MIN_LONG = 60L * ONE_SEC_LONG;
    public static final long ONE_HOUR_LONG = 60L * ONE_MIN_LONG;
    public static final long ONE_DAY_LONG = 24L * ONE_HOUR_LONG;

    def init(){
      
        java.util.Date.metaClass.static.date = { year, month, day  ->
            def cal = now()
            cal.set(YEAR, year)
            cal.set(MONTH, month - 1)
            cal.set(DAY_OF_MONTH, day)
            cal.time
        }

        java.util.Date.metaClass.static.date = {  year, month, day, hour, minute, second, millisecond ->
            def cal = now()
            cal.set(YEAR, year)
            cal.set(MONTH, month - 1)
            cal.set(DAY_OF_MONTH, day)
            cal.set(HOUR_OF_DAY, hour)
            cal.set(MINUTE, minute)
            cal.set(SECOND, second)
            cal.set(MILLISECOND, millisecond)
            cal.time
        }
    
        java.util.Date.metaClass.startOfDay = { ->
            def cal = now()
            cal.time = delegate
            cal.set HOUR_OF_DAY, 0
            cal.set MINUTE, 0
            cal.set SECOND, 0
            cal.set MILLISECOND, 0
            cal.time
        }
  
        java.util.Date.metaClass.endOfDay = { ->
            def cal = now()
            cal.time = delegate
            cal.set HOUR_OF_DAY, 23
            cal.set MINUTE, 59
            cal.set SECOND, 59
            cal.set MILLISECOND, 999
            cal.time
        }
    }

}
