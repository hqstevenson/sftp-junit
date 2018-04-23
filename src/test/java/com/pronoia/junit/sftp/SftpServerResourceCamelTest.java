package com.pronoia.junit.sftp;

import java.io.File;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SftpServerResourceCamelTest extends CamelSpringTestSupport {

  @Rule
  public EmbeddedSftpServerResource sshd = new EmbeddedSftpServerResource()
      .user("user", "passwd");

  @EndpointInject( uri = "mock://result")
  MockEndpoint target;


  @Override
  protected AbstractApplicationContext createApplicationContext() {
    return new FileSystemXmlApplicationContext(new String[]{"src/test/context/camel-context.xml"},false);
  }

  /**
   * Description of test.
   *
   * @throws Exception in the event of a test error.
   */
  @Test
  public void testRoute() throws Exception {
    target.expectedMessageCount(1);

    new File("target/sftp/data/").mkdirs();
    new File("target/sftp/home/user/data/").mkdirs();
    FileUtils.copyFileToDirectory( new File("src/test/data/test.txt"), new File("target/sftp/data/"));
    template.sendBody("direct://trigger", "test.txt");

    // Thread.sleep(300000);
    assertMockEndpointsSatisfied();
  }

}
