package Gun06;
/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En son confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/

import Utlity.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_PlaceOrder_POM extends BaseDriver {

    @Test
    public void ProceedToCheckOut(){

        _01_PlaceOrder_Elementleri elements=new  _01_PlaceOrder_Elementleri();

        elements.searchBox.sendKeys("ipod"+Keys.ENTER);
       elements. addToCart.click();
        elements.shoppingCart.click();
        elements.checkOut .click();

       wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
       wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
       wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
       elements.agree.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.confirm.click();

       wait.until(ExpectedConditions.urlContains("success"));


       Assert.assertEquals(elements.ekranYazi.getText(), "Your order has been placed!", "Oluşan Mesajlar Eşleşmiyor");
    }
}











