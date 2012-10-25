package net.carwinz.commons;


class ListFunctionsTest extends BaseTestCase {

    protected void setUp() throws Exception {
        super.setUp()
        registerMetaClass List
        new ListFunctions().init()
    }

    public void testShuffleShouldMoveStuffAround() {
        assertTrue([1,2,3,4,5] != [1,2,3,4,5].shuffle().shuffle().shuffle())
    }

    public void testShuffleShouldNotChangeTheSizeOfTheList() {
        assertEquals 5, [1,2,3,4,5].shuffle().size()
    }

    public void testShuffleShouldNotChangeTheElementsThatAreInTheList() {
        assertEquals([], [1,2,3,4,5] - [1,2,3,4,5].shuffle())
    }

    public void testToTreeShouldGroupByASingleSpecifiedProperty() {
        def michael = [name:'michael', gender: 'm']
        def amaia = [name:'amaia', gender: 'f']
        def don = [name:'don', gender: 'm']
        
        def expecting = ['f': [amaia], 'm':[michael, don]]
        def result = [michael, don, amaia].toTree("gender")

        assertEquals(expecting, result);
    }

    public void testToTreeShouldGroupMultipleSpecifiedProperties() {
        def michael = [name:'michael', gender: 'm', age: 30]
        def amaia = [name:'amaia', gender: 'f', age: 20]
        def don = [name:'don', gender: 'm', age: 20]

        def expecting = [20 : ['f': [amaia], 'm':[don]], 30 : ['m' : [michael]]]
        def result = [michael, don, amaia].toTree("age", "gender")

        assertEquals(expecting, result);
    }

    public void testContiguousShouldReturnFalseWhenNumbersAreNotContiguous() {
        assertFalse([1,2,3,5,6].contiguous())
        assertFalse([1,2,3,5,4].contiguous())
    }

    public void testContiguousShouldReturnTrueWhenNumbersAreContiguous() {
        assert [1,2,3,4,5].contiguous()
        assert [5,4,3,2,1].contiguous()
        assert ["a","aa","aaa","aaaa"].contiguous({ it.length() })
        assert ["1","2","3","4"].contiguous({ it as int })
    }

    public void testFindTillShouldReturnAllItemsUpToAndExcludingTheMatchedElement(){
        assertEquals(1..2, (1..5).findTill { it == 3})
    }
    
    public void testAddOnceShouldAddTheItemWhenItDoesNotYetExist(){
        assertEquals([1], [].addOnce(1))
    }
    
    public void testAddOnceShouldNotAddTheItemWhenItAlreadyExists(){
        assertEquals([1], [1].addOnce(1))
    }
    
    public void testRandomShouldReturnOneOfTheGivenValues(){
        assertTrue (["a", "b", "c"].contains(["a", "b", "c"].random()))
    }
    
    public void testRandomShouldReturnTheValueWhenThereIsOnlyOneValue(){
        assertEquals "a", ["a"].random()
    }
    
    public void testRandomShouldReturnNullWhenThereAreNoValues(){
        assertNull ([].random())
    }
}
