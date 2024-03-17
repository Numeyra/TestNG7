package Gun01;
/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)  , işlemin başarılı olduğunu kontrol ediniz.
  3- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
  4- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.
 */

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _08_SubscribeNewsletter extends BaseDriver {

By link=By.linkText("Newsletter");
By subYes=By.xpath("//input[@value='1']");
By ctnBtn=By.xpath("//input[@value='Continue']");
By subNo=By.xpath("//input[@value='0'] ");


 @Test(priority = 1)
 public void SubscribeFunctionYes() {

     WebElement newsletterLink = driver.findElement(link);
     newsletterLink.click();


     WebElement subscribeYes = driver.findElement(subYes);
     subscribeYes.click();

     WebElement continueButton = driver.findElement(ctnBtn);
     continueButton.click();

    // WebElement msgLabel = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    // Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));

 }
    @Test(priority = 2)
    public void SubscribeFunctionNo() {

        WebElement newsletterLink = driver.findElement(link);
        newsletterLink.click();

        WebElement subscribeNo = driver.findElement(subNo);
        subscribeNo.click();

        WebElement continueButton = driver.findElement(ctnBtn);
        continueButton.click();

        Tools.SuccessMessageValidation();

    }
    @Test(priority = 3)
    public void SubscribeFunctionForBoth() {
        WebElement newsLetterLink = driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeYes = driver.findElement(subYes);
        WebElement subscribeNo = driver.findElement(subNo);

        if (subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();

        WebElement continueButton = driver.findElement(ctnBtn);
        continueButton.click();

        Tools.SuccessMessageValidation();


    }



    }