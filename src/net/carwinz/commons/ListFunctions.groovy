package net.carwinz.commons

class ListFunctions {

  def init(){

    // Manipulation

    List.metaClass.shuffle = { ->
      Collections.shuffle(delegate)
      delegate
    }

    List.metaClass.findTill = { f = { it } ->
      boolean conditionMet = false
      delegate.inject([]) { list, item ->
        conditionMet = conditionMet || f(item)
        if (!conditionMet) list << item
        list
      }
    }

    // Grouping

    List.metaClass.groupByAll = { List closures ->
      delegate.groupBy(closures.head()).each({ entry ->
        if (closures.size() > 1)  {
          entry.value = entry.value.groupByAll(closures.tail())
        }
      }).sort({ a,b -> a.key <=> b.key })
    }

    List.metaClass.groupByAll = { Closure... closures ->
      delegate.groupByAll(closures as List);
    }

    List.metaClass.groupByAll = { String... properties ->
      delegate.groupByAll(properties.collect({ name -> { bean -> bean."${name}" } }));
    }


    List.metaClass.toTree = { List closures ->
      if(!closures.empty)
        delegate.groupBy(closures.head()).each({
          it.value = closures.tail().empty ? it.value : it.value.toTree(closures.tail())
        }).sort({ a,b -> a.key <=> b.key })
      else
        delegate
    }

    List.metaClass.toTree = { Closure... closures ->
      delegate.toTree(closures as List);
    }

    List.metaClass.toTree = { String... properties ->
      delegate.toTree(properties.collect({ name -> { bean -> bean?."${name}"  }  }));
    }

    // Analysis

    List.metaClass.contiguous = { asint = { value -> value } ->
      delegate.tail().inject(delegate.head(), { previous, current -> (previous && Math.abs(asint(current) - asint(previous)) == 1) ? current : false }) == delegate.last()
    }
  }
}
