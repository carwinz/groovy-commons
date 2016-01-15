groovy-commons
==============

Add common functions to String, List, etc via metaClass.

## Lists

### random

Return a random element from the list

    ["a", "b", "c"].random()

### shuffle

    [1,2,3,4,5].shuffle()

### findTill

Returns all items up to (and excluding) the matched element

    assertEquals(1..2, (1..5).findTill { it == 3})

### onlyOrNull

Return the only element in a list, or null if there is none

### addOnce

Adds an element if it doesn't already exist

    assertEquals([1], [].addOnce(1))
    assertEquals([1], [1].addOnce(1))

### toTree(String... propertiesToGroupBy)

Groups by the specified properties

        def michael = [name:'michael', gender: 'm', age: 30]
        def amaia = [name:'amaia', gender: 'f', age: 20]
        def don = [name:'don', gender: 'm', age: 20]
        def expecting = [20 : ['f': [amaia], 'm':[don]], 30 : ['m' : [michael]]]
        def result = [michael, don, amaia].toTree("age", "gender")
        assertEquals(expecting, result);

### contiguous

Checks if the elements of the list are contiguous. 

        assert [1,2,3,4,5].contiguous()
        assert [5,4,3,2,3,2,1].contiguous()

A closure can be provided to convert each element to a numeric value

        assert ["a","aa","aaa","aaaa"].contiguous({ it.length() })

## Strings

### isEmailAddress

    assertTrue "a@b.c".isEmailAddress()
    assertTrue "fred@hotmail.com".isEmailAddress()
    assertFalse "@b.c".isEmailAddress()
    assertFalse "fredhotmail.com".isEmailAddress()

### isBlank

    assertFalse "a".isBlank()
    assertTrue " ".isBlank()
    assertTrue "".isBlank()

### isNotBlank

    assertTrue "a".isNotBlank()
    assertFalse " ".isNotBlank()
    assertFalse "".isNotBlank()

### random

Get a random character from the string

    "abc".random()
