package tests.Day02_hesapMakinesi;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Day2_HesapMakinesi {
    AndroidDriver<AndroidElement>driver;


    @Test
    public void hesapMakinesiTesti() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\qenbe\\IdeaProjects\\Appium_T_141\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        // 1.kullanici gerekli kurulumlari yapar

       // 2.uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

       // 3.uygulamanin acildigini dogrular
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());


        //  4.400 un 3 katininin 1200 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("3").click();
        String islemSonucu=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        int expected=1200;
        System.out.println(islemSonucu);
        Assert.assertEquals(Integer.parseInt(islemSonucu),expected);





    }
}
