
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
            //++++++++++++++++++++++++++++++++++++CHROME+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            var options = new ChromeOptions();
            options.AddArguments("–disable-extensions", "start-maximized");
            IWebDriver driver = new ChromeDriver(options);
            DesiredCapabilities capability = DesiredCapabilities.Chrome();
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
            ////*************************END BROWSERSTACK CODE BROWSER*******************************************
            //////+++++++++++++++++++++++++++++++++++++++++++++++++LOG ON GA++++++++++++++++++++++++++++++++++++
            ////to test QA open CCTK command prompt & exec browserstack.batrked for
            //driver.Url = "https://accounts.google.com/ServiceLogin?elo=1#identifier";  //QA
            //IWebDriver driver = new ChromeDriver();
            //IWebDriver driver = new FirefoxDriver();
            driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(10));
            //DATE JUN 20 - JUL 21
            //driver.Navigate().GoToUrl("https://accounts.google.com/ServiceLogin?elo=1#identifier");
            driver.FindElement(By.Id("Email")).Clear();
            driver.FindElement(By.Id("Email")).SendKeys("scottmaretick51@gmail.com");
            driver.FindElement(By.Id("next")).Click();
            driver.FindElement(By.Id("Passwd")).Clear();
            driver.FindElement(By.Id("Passwd")).SendKeys("sm110751");
            driver.FindElement(By.Id("signIn")).Click();
            //LOGS INTO GOOGLE ANALYTICS
            driver.Navigate().GoToUrl("https://analytics.google.com/");
            Thread.Sleep(7000);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/#home/a39099721w75626535p78130152/");
            //PGO 2.0 link 
            //driver.FindElement(By.LinkText("PGO 2.0")).Click();
            driver.FindElement(By.LinkText("All Web Site Data")).Click();  //OVERVIEW SESSIONS
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-overview/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            //PAGE VIEWS
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/defaultid/a39099721w118028697p123515106/%3Foverview-graphOptions.primaryConcept%3Danalytics.pageviews/");
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-browser/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721/");
            //IE
            driver.Navigate().GoToUrl("https://analytics.google.com/analytics/web/?pli=1#report/visitors-browser/a39099721w118028697p123515106/%3F_u.date00%3D20160620%26_u.date01%3D20160721%26explorer-table.plotKeys%3D[]%26_r.drilldown%3Danalytics.browser%3AInternet%20Explorer/");
            //driver.Quit();
        }
    }
}
