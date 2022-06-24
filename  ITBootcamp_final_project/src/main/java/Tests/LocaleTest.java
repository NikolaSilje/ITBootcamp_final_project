package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BasicTest{
    @Test(priority = 10)
    public void setLocaleES(){
//        navPage.getLanguageElement().click();
        navPage.getESbutton().click();
        Assert.assertEquals(navPage.getHeaderElement().getText(), "Página de aterrizaje",
                "[Error] Header is not the same.");
    }
    @Test(priority = 20)
    public void setLocalEN(){
//        navPage.getLanguageElement().click();
        navPage.getENbutton().click();
        Assert.assertEquals(navPage.getHeaderElement().getText(), "Landing",
                "[Error] Header is not the same.");
    }
    @Test(priority = 30)
    public void setLocalCN(){
//        navPage.getLanguageElement().click();
        navPage.getCNbutton().click();
        Assert.assertEquals(navPage.getHeaderElement().getText(), "首页",
                "[Error] Header is not the same.");
    }
    @Test(priority = 40)
    public void setLocalFR(){
//        navPage.getLanguageElement().click();
        navPage.getFRbutton().click();
        Assert.assertEquals(navPage.getHeaderElement().getText(), "Page d'atterrissage",
                "[Error] Header is not the same.");
    }

}
