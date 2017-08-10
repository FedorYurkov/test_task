package mail.tests;

import org.testng.annotations.Test;

public class SendMailTest extends TestBase {

  @Test
  public void testSendMail() {
    app.account().login("ql_test", "@uto123456");

    app.mail().initMailCreation();

    app.mail().typeMailRecipient("mail-auto.vymxgz3h@mailosaur.io");
    app.mail().typeMailSubject("test");
    app.mail().typeMailText("Hello! Test mail text!");

    app.mail().initMailSending();
  }
}
