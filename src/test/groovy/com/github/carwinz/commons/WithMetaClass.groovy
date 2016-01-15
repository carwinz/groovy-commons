package com.github.carwinz.commons

class WithMetaClass {

  def savedMetaClasses = [:]

  public WithMetaClass(){

  }

  public WithMetaClass(Class clazz){
    register(clazz)
  }

  public register(Class clazz){
    if (savedMetaClasses.containsKey(clazz)) return

      savedMetaClasses[clazz] = clazz.metaClass

    def emc = new ExpandoMetaClass(clazz, true, true)
    emc.initialize()
    GroovySystem.metaClassRegistry.setMetaClass(clazz, emc)
  }

  public unregister(){
    savedMetaClasses.each { claz, metaClass ->
      GroovySystem.metaClassRegistry.removeMetaClass(claz)
      GroovySystem.metaClassRegistry.setMetaClass(claz, metaClass)
    }
  }

  public static withMetaClass(Class clazz, Closure closure){
    def wmc = new WithMetaClass(clazz)
    closure.run()
    wmc.unregister()
  }
}
