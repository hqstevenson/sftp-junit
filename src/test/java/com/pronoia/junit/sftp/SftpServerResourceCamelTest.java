package com.pronoia.junit.sftp;

import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.camel.EndpointInject;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

public class SftpServerResourceCamelTest extends CamelTestSupport {
  static final String TRIGGER_URI = "direct://trigger";
  static final String RESULT_URI = "mock://result";
  static final String SFTP_USER = "user";
  static final String SFTP_PASSWORD = "passwd";
  static final String HOME_DIR_FILENAME = "should-be-in-home-dir.txt";
  static final String DATA_DIR_FILENAME = "should-be-in-data-dir.txt";

  @Rule
  public EmbeddedSftpServerResource sshd = new EmbeddedSftpServerResource()
      .user("user", "passwd");

  @EndpointInject( uri = "mock://result")
  MockEndpoint target;

  @Override
  protected RoutesBuilder createRouteBuilder() throws Exception {
    return new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from(TRIGGER_URI)
            .toF("sftp://%s@localhost:%d/?password=%s&fileName=%s", SFTP_USER, sshd.getPort(), SFTP_PASSWORD, HOME_DIR_FILENAME)
            .toF("sftp://%s@localhost:%d/../../data?password=%s&fileName=%s", SFTP_USER, sshd.getPort(), SFTP_PASSWORD, DATA_DIR_FILENAME)
            .to(RESULT_URI);
      }
    };
  }

  /**
   * Description of test.
   *
   * @throws Exception in the event of a test error.
   */
  @Ignore("Need to figure out how to configure a non-chrooted user that is initially in hom")
  @Test
  public void testRouteWithoutChrootedUser() throws Exception {
    final Path homeDir = sshd.getRootDirectory().resolve("home/user");
    final Path dataDir = sshd.getRootDirectory().resolve("data");
    final Path expectedInHome = homeDir.resolve(HOME_DIR_FILENAME);
    final Path expectedInData = dataDir.resolve(DATA_DIR_FILENAME);

    target.expectedMessageCount(1);

    homeDir.toFile().mkdirs();
    dataDir.toFile().mkdirs();

    template.sendBody("direct://trigger", "test.txt");

    assertMockEndpointsSatisfied();

    assertTrue("Expected file '" + HOME_DIR_FILENAME + "' missing from " + homeDir + " directory", Files.exists(expectedInHome));
    assertTrue("Expected file '" + DATA_DIR_FILENAME + "' missing from " + dataDir + " directory", Files.exists(expectedInData));
  }

  /**
   * Description of test.
   *
   * @throws Exception in the event of a test error.
   */
  @Test
  public void testRouteWithChrootedUser() throws Exception {
    final Path homeDir = sshd.getRootDirectory();
    final Path dataDir = sshd.getRootDirectory().resolve("data");
    final Path expectedInHome = homeDir.resolve(HOME_DIR_FILENAME);
    final Path expectedInData = dataDir.resolve(DATA_DIR_FILENAME);

    target.expectedMessageCount(1);

    homeDir.toFile().mkdirs();
    dataDir.toFile().mkdirs();

    template.sendBody("direct://trigger", "test.txt");

    assertMockEndpointsSatisfied();

    assertTrue("Expected file '" + HOME_DIR_FILENAME + "' missing from " + homeDir + " directory", Files.exists(expectedInHome));
    assertTrue("Expected file '" + DATA_DIR_FILENAME + "' missing from " + dataDir + " directory", Files.exists(expectedInData));
  }

}
