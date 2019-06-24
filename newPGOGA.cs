
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Safari;
using NUnit.Framework;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Remote;
using System.Net;
using System.Text.RegularExpressions;

namespace newPGO_GA
{
    class Program
    {
        static void Main(string[] args)
        {
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //string subPath = "C:\\Users\\TEMP\\newPGOGA";
            //System.IO.Directory.CreateDirectory(subPath);  //if dir exists doesn't exist create dir
            //Thread.Sleep(1000);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //string[] filePaths = Directory.GetFiles(@"C:\Users\TEMP\newPGOGA");
            //foreach (string filePath in filePaths)
            //    File.Delete(filePath);
            //Thread.Sleep(1000);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //    public static string username = "scott.maretick@pressganey.com";
            //    public static string authkey = "u4ff16f856c57c93";
            //++++++++++++++++++++++++++++++++++++CHROME+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            var options = new ChromeOptions();
            options.AddArguments("–disable-extensions", "start-maximized");
            IWebDriver driver = new ChromeDriver(options);
            DesiredCapabilities capability = DesiredCapabilities.Chrome();
            //++++++++++++++++++++++++++++++++++++FIREFOX++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //IWebDriver driver = new FirefoxDriver();
            //DesiredCapabilities capability = DesiredCapabilities.Firefox();
            //var browser = driver.GetType().ToString();
            ////++++++++++++++++++++++++++++++++++++IE+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //set Tools->Internet options->Security==Internet-Local intetnet-Trusted sites-Restricted sites
            //var options = new InternetExplorerOptions();
            //options.IntroduceInstabilityByIgnoringProtectedModeSettings = true;
            //IWebDriver driver = new InternetExplorerDriver(@"C:\Users\marets\Downloads\IEDriverServer", options);  //64 bit
            //var browser = driver.GetType().ToString();
            //DesiredCapabilities capability = DesiredCapabilities.InternetExplorer();
            ////++++++++++++++++++++++++++++++++++++SAFARI++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //IWebDriver driver = new SafariDriver();
            //var browser = driver.GetType().ToString();
            //DesiredCapabilities capability = DesiredCapabilities.Safari();
            ////DOWNLOAD & INSTALL v2.45 http://selenium-release.storage.googleapis.com/2.48/SafariDriver.safariextz W/safari
            ////+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            ////*****************************BROWSERSTACK CODE MOBILE********************************************
            //capability.SetCapability("browserstack.user", "scottmaretick1");
            //capability.SetCapability("browserstack.key", "wWzHgVGrUqgDXdjZ5qKd");
            //capability.SetCapability("project", "PG2.0 03/31/2016");
            //capability.SetCapability("platform", "MAC");
            //capability.SetCapability("device", "iPad Pro");
            //capability.SetCapability("browserName", "iPad");
            //capability.SetCapability("deviceOrientation", "portrait");
            ////capability.SetCapability("deviceOrientation", "landscape");
            //capability.SetCapability("resolution", "1024x768");
            //TimeSpan extendedTimeSpan = new TimeSpan(0, 4, 0);
            //driver = new RemoteWebDriver(
            //    new Uri("http://hub.browserstack.com/wd/hub/"), capability, extendedTimeSpan
            //);
            ////Thread.Sleep(1000);
            ////*****************************BROWSERSTACK CODE BROWSER*******************************************
            //capability.SetCapability("browserstack.user", "scottmaretick1");
            //capability.SetCapability("browserstack.key", "wWzHgVGrUqgDXdjZ5qKd");
            //capability.SetCapability("project", "PG2.0 04/05/2016");
            //capability.SetCapability("os", "OS X");
            //capability.SetCapability("os_version", "El Capitan");
            //capability.SetCapability("browser", "Safari");
            //capability.SetCapability("browser_version", "9");  //latest OS X
            ////capability.SetCapability("browserstack.local" = true);
            //capability.SetCapability("browserstack.local", "true");
            ////capability.SetCapability("browser", "IE");
            ////capability.SetCapability("browser_version", "10.0");
            ////capability.SetCapability("os", "Windows");
            ////capability.SetCapability("os_version", "8");
            //TimeSpan extendedTimeSpan = new TimeSpan(0, 6, 0);
            //driver = new RemoteWebDriver(
            //    //new Uri("http://hub.browserstack.com/wd/hub/"), capability, extendedTimeSpan
            //    new Uri("http://hub.browserstack.com/wd/hub/"), capability
            //);
            //Thread.Sleep(1000);
            ////*****************************BROWSERSTACK CODE BROWSER*******************************************
            capability.SetCapability("browserstack.user", "scottmaretick1");
            capability.SetCapability("browserstack.key", "wWzHgVGrUqgDXdjZ5qKd");
            capability.SetCapability("project", "GoogleAnalytics");
            //capability.SetCapability("os", "OS X");
            //capability.SetCapability("os_version", "El Capitan");
            //capability.SetCapability("browser", "Safari");
            //capability.SetCapability("browser_version", "9");  //latest OS X
            capability.SetCapability("browserstack.local", "true");
            ////capability.SetCapability("browser", "IE");
            ////capability.SetCapability("browser_version", "10.0");
            ////capability.SetCapability("os", "Windows");
            ////capability.SetCapability("os_version", "8");
            TimeSpan extendedTimeSpan = new TimeSpan(0, 6, 0);
            driver = new RemoteWebDriver(
                new Uri("http://hub.browserstack.com/wd/hub/"), capability, extendedTimeSpan
            );
            Thread.Sleep(1000);
            ////*************************END BROWSERSTACK CODE BROWSER*******************************************
            //////+++++++++++++++++++++++++++++++++++++++++++++++++LOG ON GA++++++++++++++++++++++++++++++++++++
            ////to test QA open CCTK command prompt & exec browserstack.batrked for
            //Thread.Sleep(6000);
            //driver.Url = "https://accounts.google.com/ServiceLogin?elo=1#identifier";  //QA
            //Thread.Sleep(8000);
            //IWebDriver driver = new ChromeDriver();
            //IWebDriver driver = new FirefoxDriver();
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(10));
            //DATE JUN 20 - JUL 21
            //driver.Navigate().GoToUrl("https://accounts.google.com/ServiceLogin?elo=1#identifier");
            Thread.Sleep(6000);
            driver.FindElement(By.Id("Email")).Clear();
            Thread.Sleep(1000);
            driver.FindElement(By.Id("Email")).SendKeys("scottmaretick51@gmail.com");
            Thread.Sleep(1000);
            driver.FindElement(By.Id("next")).Click();
            Thread.Sleep(1000);
            driver.FindElement(By.Id("Passwd")).Clear();
            Thread.Sleep(2000);
            driver.FindElement(By.Id("Passwd")).SendKeys("sm110751");
            Thread.Sleep(1000);
            driver.FindElement(By.Id("signIn")).Click();
            Thread.Sleep(1000);
            //ScreenShot(driver, 0);
            //LOGS INTO GOOGLE ANALYTICS
            driver.Navigate().GoToUrl("https://analytics.google.com/");
            Thread.Sleep(7000);
            //ScreenShot(driver, 1);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/#home/a39099721w75626535p78130152/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 2);
            //"Press Ganey"
            Thread.Sleep(9000);
            //ScreenShot(driver, 3);
            //driver.FindElement(By.XPath("//tr[@id='8-row-a39099721w118028697p0']/td[2]")).Click(); //ERROR
            //PGO 2.0 link 
            //ScreenShot(driver, 4);
            //driver.FindElement(By.LinkText("PGO 2.0")).Click();
            Thread.Sleep(9000);
            //ScreenShot(driver, 5);
            driver.FindElement(By.LinkText("All Web Site Data")).Click();  //OVERVIEW SESSIONS
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-overview/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 6);
            //PAGE VIEWS
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/defaultid/a39099721w118028697p123515106/%3Foverview-graphOptions.primaryConcept%3Danalytics.pageviews/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 7);
            //USERS
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/defaultid/a39099721w118028697p123515106/%3Foverview-graphOptions.primaryConcept%3Danalytics.totalVisitors/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 8);
            //ACTIVE USERS
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-actives/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 9);
            //DEMOGRAPHICS OVERVIEW
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-demographics-overview/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 10);
            //DEMOGRAPHICS AGE
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-demographics-age/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 11);
            //DEMOGRAPHICS GENDER
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-demographics-gender/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 12);
            //GEO LANGUAGE
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-language/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 13);
            //GEO LOCATION
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-geo/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 14);
            //BROWSER & OS
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-browser/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 15);
            //CHROME
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-browser/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721%26explorer-table.plotKeys%3D[]%26_r.drilldown%3Danalytics.browser%3AChrome/");
            Thread.Sleep(9000);
            //ScreenShot(driver, 16);
            //FIREFOX
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-browser/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721%26explorer-table.plotKeys%3D[]%26_r.drilldown%3Danalytics.browser%3AFirefox/");
            Thread.Sleep(9000);
            //IE
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-browser/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721%26explorer-table.plotKeys%3D[]%26_r.drilldown%3Danalytics.browser%3AInternet%20Explorer/");
            Thread.Sleep(9000);
            //driver.Quit();
        }
        ////+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //public static void ScreenShot(IWebDriver driver, int SS)
        //{
        //    var filename1 = "SeleniumTestingScreenshot" + SS + ".jpg";
        //    var filename2 = String.Format(@"C:\Users\TEMP\newPGOGA\{0}", filename1);
        //    Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
        //    ss.SaveAsFile(filename2, System.Drawing.Imaging.ImageFormat.Jpeg);

        //}
    }
}
