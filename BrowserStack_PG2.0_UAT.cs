//scott.maretick@pg50.com; Enter123#
//NEW PGO DEV: http://pe-ir-web1d/#/login
//New PGO QA:  http://pe-ir-web1q/#/login
//New PGO UAT: https://pgouat.pressganey.com/#/login
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

namespace BrowserStack_PG2._0_UAT
{
    class Program
    {
        static void Main(string[] args)
        {
            ////++++++++++++++++++++++++++++++++++++CHROME+++++++++++++++++++++++++++++++++++++++++++++++++++++
            var options = new ChromeOptions();
            options.AddArguments("–disable-extensions", "start-maximized");
            IWebDriver driver = new ChromeDriver(options);
            var browser = driver.GetType().ToString();
            ////++++++++++++++++++++++++++++++++++++FIREFOX++++++++++++++++++++++++++++++++++++++++++++++++
            //IWebDriver driver = new FirefoxDriver();
            //var browser = driver.GetType().ToString();
            //++++++++++++++++++++++++++++++++++++IE+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //set Tools->Internet options->Security==Internet-Local intetnet-Trusted sites-Restricted sites
            //var options = new InternetExplorerOptions();
            //options.IntroduceInstabilityByIgnoringProtectedModeSettings = true;
            ////IWebDriver driver = new InternetExplorerDriver(@"C:\Users\marets\Downloads\IEDriverServer");
            //IWebDriver driver = new InternetExplorerDriver(@"C:\Users\marets\Downloads\IEDriverServer", options);  //64 bit
            //var browser = driver.GetType().ToString();
            ////++++++++++++++++++++++++++++++++++++SAFARI+++++++++++++++++++++++++++++++++++++++++++++++++
            //IWebDriver driver = new SafariDriver();
            //var browser = driver.GetType().ToString();
            ////DOWNLOAD & INSTALL http://selenium-release.storage.googleapis.com/2.48/SafariDriver.safariextz W/safari
            ////+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //*****************************BROWSERSTACK CODE***********************************************
            DesiredCapabilities capability = DesiredCapabilities.Chrome();
            //DesiredCapabilities capability = DesiredCapabilities.Firefox();
            //DesiredCapabilities capability = DesiredCapabilities.InternetExplorer();
            //DesiredCapabilities capability = DesiredCapabilities.Safari();
            capability.SetCapability("browserstack.user", "scottmaretick1");
            capability.SetCapability("browserstack.key", "wWzHgVGrUqgDXdjZ5qKd");
            driver = new RemoteWebDriver(
                new Uri("http://hub.browserstack.com/wd/hub/"), capability
            );
            System.Console.WriteLine(browser);
            Thread.Sleep(1000);
            driver.Navigate().GoToUrl("https://pgouat.pressganey.com/#/login");
            //*********************************************************************************************
            ////+++++++++++++++++++++++++++++++++++++++++++++++++LOG ON PG2.0 UAT++++++++++++++++++++++++++++++
            ////driver.Url = "http://pe-ir-web1q/#/login";  //QA
            //driver.Url = "https://pgouat.pressganey.com/#/loginn";  //UAT
            ////*********************************************************************************************
            driver.FindElement(By.Id("passwordInput")).Clear();
            Thread.Sleep(1000);
            driver.FindElement(By.Id("passwordInput")).SendKeys("Enter123#");
            Thread.Sleep(1000);
            driver.FindElement(By.Id("emailInput")).Clear();
            Thread.Sleep(1000);
            driver.FindElement(By.Id("emailInput")).SendKeys("scott.maretick@pg50.com");
            Thread.Sleep(3000);
            System.Console.WriteLine(browser);
            driver.FindElement(By.XPath("//input[@value='Login']")).Click();
            System.Console.WriteLine(browser);
            Thread.Sleep(1000);
            //OPEN ACCOUNT Central Health Demo System (50000)
            new SelectElement(driver.FindElement(By.XPath("//select"))).SelectByText("Central Health Demo System (50000)");
            Thread.Sleep(1000);
            //hit ENTER
            driver.FindElement(By.CssSelector("div.modal-footer > input.btn.btn-primary")).Click();
            System.Console.WriteLine(browser);
            ////CREATE NEW BOARD
            //Thread.Sleep(1000);
            //driver.FindElement(By.Name("boardName")).SendKeys("TestDashboardBrowserStack");
            //Thread.Sleep(1000);
            //hit ENTER to create board
            Thread.Sleep(4000);
            ////CREATE WIDGET
            //driver.FindElement(By.CssSelector("p.ng-binding")).Click();
            //Thread.Sleep(1000);
            //new SelectElement(driver.FindElement(By.XPath("//div[@id='screen-name']/div[2]/div[2]/div/select"))).SelectByText("Ambulatory Surgery");
            //Thread.Sleep(1000);
            //driver.FindElement(By.XPath("//div[@id='screen-name']/div[3]/div/div/div/div/div[2]/button[2]")).Click();
            //driver.FindElement(By.XPath("//input[@type='checkbox']")).Click();
            //Thread.Sleep(1000);
            //driver.FindElement(By.XPath("//div[@id='screen-survey-item']/div[2]/div/div/div/div/div[2]/button[2]")).Click();
            //driver.FindElement(By.XPath("//div[@id='screen-date']/div[2]/div/div/div/div/div[2]/button[2]")).Click();
            //Thread.Sleep(1000);
            //driver.FindElement(By.XPath("//div[@id='screen-metrics']/div[2]/div/div/div/div/div[2]/button[2]")).Click();
            //driver.FindElement(By.XPath("//div[@id='screen-visualizations']/div[3]/div/div/div/div/div[2]/button[2]")).Click();
            //Thread.Sleep(1000);
            ////DELETE WIDGET
            //driver.FindElement(By.XPath("//a[@id='dropdownMenu1']/i")).Click();
            //driver.FindElement(By.LinkText("Delete")).Click();
            //Thread.Sleep(1000);
            //driver.FindElement(By.CssSelector("button.btn.btn-primary")).Click();
            //Thread.Sleep(1000);
            ////DELETE TestDashboardBrowserStack
            //driver.FindElement(By.Id("dropdownMenu1")).Click();
            //Thread.Sleep(1000);
            //driver.FindElement(By.LinkText("Delete Dashboard")).Click();
            //Thread.Sleep(1000);
            //driver.FindElement(By.CssSelector("button.btn.btn-primary")).Click();
            //Thread.Sleep(1000);
            //GO TO DROPDOWN TO LOG OFF
            System.Console.WriteLine(browser);
            driver.FindElement(By.XPath("//div[@id='navbar']/ul/li[2]/a/i[2]")).Click();
            System.Console.WriteLine(browser);
            Thread.Sleep(4000);
            driver.FindElement(By.LinkText("Log out")).Click();
            System.Console.WriteLine(browser);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Done();
            driver.Quit();
            //driver.Close();
        }
    }
}