package net.carwinz.commons;


class DateFunctionsTest extends BaseTestCase {

    protected void setUp() throws Exception {
        super.setUp()
        registerMetaClass Date
        new DateFunctions().init()
    }

    public void testShouldCreateDate() {
        def date = Date.date(2012, 9, 26)
        Calendar cal = Calendar.getInstance()
        cal.time = date
        
        assertEquals(2012, cal.get(Calendar.YEAR))
        assertEquals(8, cal.get(Calendar.MONTH))
        assertEquals(26, cal.get(Calendar.DAY_OF_MONTH))
    }
    
    public void testShouldCreateDateWithTimeInfo() {
        def date = Date.date(2012, 9, 26, 13, 2, 3, 4)
        
        Calendar cal = Calendar.getInstance()
        cal.time = date
        assertEquals(2012, cal.get(Calendar.YEAR))
        assertEquals(8, cal.get(Calendar.MONTH))
        assertEquals(26, cal.get(Calendar.DAY_OF_MONTH))
        assertEquals(13, cal.get(Calendar.HOUR_OF_DAY))
        assertEquals(2, cal.get(Calendar.MINUTE))
        assertEquals(3, cal.get(Calendar.SECOND))
        assertEquals(4, cal.get(Calendar.MILLISECOND))
    }
    
    public void testStartOfDayShouldBlankOutAllTimeInfo() {
        def date = Date.date(2012, 9, 26, 13, 2, 3, 4).startOfDay()
        
        Calendar cal = Calendar.getInstance()
        cal.time = date
        assertEquals(2012, cal.get(Calendar.YEAR))
        assertEquals(8, cal.get(Calendar.MONTH))
        assertEquals(26, cal.get(Calendar.DAY_OF_MONTH))
        assertEquals(0, cal.get(Calendar.HOUR_OF_DAY))
        assertEquals(0, cal.get(Calendar.MINUTE))
        assertEquals(0, cal.get(Calendar.SECOND))
        assertEquals(0, cal.get(Calendar.MILLISECOND))
    }
    
    public void testEndOfDayShouldMoveTimeInfoToTheLastSecondOfTheDay() {
        def date = Date.date(2012, 9, 26, 13, 2, 3, 4).endOfDay()
                
        Calendar cal = Calendar.getInstance()
        cal.time = date
        assertEquals(2012, cal.get(Calendar.YEAR))
        assertEquals(8, cal.get(Calendar.MONTH))
        assertEquals(26, cal.get(Calendar.DAY_OF_MONTH))
        assertEquals(23, cal.get(Calendar.HOUR_OF_DAY))
        assertEquals(59, cal.get(Calendar.MINUTE))
        assertEquals(59, cal.get(Calendar.SECOND))
        assertEquals(999, cal.get(Calendar.MILLISECOND))
    }

}
