package org.ff4j.sample;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class DummyFF4JProvider implements FF4jProvider {

  //private final FF4j ff4j;
  //@Autowired
  private FF4j ff4j;

  /**
   * Required as the provider will be instanciated with Reflect.
   */
  public DummyFF4JProvider() {
    // Or use a Singleton class you created
    ff4j = new FF4j("ff4j.xml");
  }

  /**
   * The real method expected by Interface FF4JProvider
   */
  public FF4j getFF4j() {
    return ff4j;
  }
}
