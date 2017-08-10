package mail.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountHelper extends HelperBase {

  public AccountHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String login, String password) {
    wd.findElement(By.id("mailbox__login")).sendKeys(login);
    wd.findElement(By.id("mailbox__password")).sendKeys(password);
    wd.findElement(By.id("mailbox__auth__button")).click();
  }

}
