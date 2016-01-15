package net.carwinz.commons;

import groovy.util.GroovyTestCase;

abstract class TestHelper extends GroovyTestCase {

  WithMetaClass meta

  protected void setUp() throws Exception {
    super.setUp()
    meta = new WithMetaClass()
  }

  protected void tearDown() throws Exception {
    super.tearDown();
    meta.unregister()
  }

  protected void registerMetaClass(Class clazz) {
    meta.register(clazz)
  }
}
