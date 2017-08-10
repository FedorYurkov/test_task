package mail.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailHelper extends HelperBase {

  public MailHelper(WebDriver wd) {
    super(wd);
  }

  public void initMailCreation() {
    wd.findElement(By.linkText("Написать письмо")).click();

    /*
    !!! На другом языке страницы - текст ссылки будет другим.
    Если не привязываться к языку, то нужен другой локатор.
    Один из возможных костыликов:

    wd.findElements(By.cssSelector("[data-name=\"compose\"]")).get(0).click();
    */
  }

  public void typeMailRecipient(String recipientEmail) {
    wd.findElement(By.cssSelector("textarea[data-original-name=\"To\"]")).sendKeys(recipientEmail);
  }

  public void typeMailSubject(String mailSubject) {
    wd.findElement(By.name("Subject")).sendKeys(mailSubject);
  }

  public void typeMailText(String mailText) {
    WebElement mailTextIframe = wd.findElement(By.cssSelector("iframe[id*=\"composeEditor\"]"));
    wd.switchTo().frame(mailTextIframe);
    wd.findElement(By.id("tinymce")).sendKeys(mailText);
    wd.switchTo().defaultContent();
  }

  public void initMailSending() {
    wd.findElements(By.cssSelector("[data-name=\"send\"]")).get(0).click();
  }

}
