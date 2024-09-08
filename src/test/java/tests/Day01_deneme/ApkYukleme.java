package tests.Day01_deneme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYukleme {

    AndroidDriver<AndroidElement> driver;


    //AppiumDriver<MobileElement>appiumDriver;
    //IOSDriver<IOSElement>iosDriver;
    @Test
    public void deneme() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 Deneme");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

         capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\qenbe\\IdeaProjects\\Appium_T_141\\Apps\\all-currency-converter-3-9-0 (1).apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // kullanici gerekli kurulumlari yapar
         // uygulamanin yuklendigini dogrular(isInstalled)
        // uygulamanin acildigini dogrular
         // 400 un 3 katininin 1200 oldugunu hesap makinasindan dogrulayalim

    }
}
