using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;

namespace SeleniumTests
{
    [TestFixture]
    public class NewPGOUAT0807
    {
        private IWebDriver driver;
        private StringBuilder verificationErrors;
        private string baseURL;
        private bool acceptNextAlert = true;
        
        [SetUp]
        public void SetupTest()
        {
            driver = new FirefoxDriver();
            baseURL = "https://pgouat.pressganey.com/";
            verificationErrors = new StringBuilder();
        }
        
        [TearDown]
        public void TeardownTest()
        {
            try
            {
                driver.Quit();
            }
            catch (Exception)
            {
                // Ignore errors if unable to close the browser
            }
            Assert.AreEqual("", verificationErrors.ToString());
        }
        
        [Test]
        public void TheNewPGOUAT0807Test()
        {
            driver.Navigate().GoToUrl(baseURL + "/#/login");
            driver.FindElement(By.Id("passwordInput")).Clear();
            driver.FindElement(By.Id("passwordInput")).SendKeys("Enter123#");
            driver.FindElement(By.Id("emailInput")).Clear();
            driver.FindElement(By.Id("emailInput")).SendKeys("scott.maretick@1916.com");
            driver.FindElement(By.XPath("//input[@value='Login']")).Click();
            driver.FindElement(By.CssSelector("i.material-icons.pull-right")).Click();
            driver.FindElement(By.XPath("//div[@id='navbar']/ul/li/a/i[2]")).Click();
            new SelectElement(driver.FindElement(By.XPath("//form[@id='account-select']/div[2]/select"))).SelectByText("Memorial Hospital & Health Care Cen (1916)");
            driver.FindElement(By.CssSelector("input.btn.btn-primary")).Click();
            driver.FindElement(By.CssSelector("i.material-icons.pull-right")).Click();
            driver.FindElement(By.CssSelector("span.ng-binding")).Click();
            new SelectElement(driver.FindElement(By.Id("singleSelect"))).SelectByText("Able to participate decisions care - MD");
            new SelectElement(driver.FindElement(By.Id("singleSelect"))).SelectByText("Our sensitivity to patients' needs - MD");
            driver.FindElement(By.XPath("//div[@id='chevron-column']/span[2]/i")).Click();
            driver.FindElement(By.CssSelector("i.material-icons.magnet-chevron1")).Click();
            new SelectElement(driver.FindElement(By.XPath("(//select[@id='singleSelect'])[2]"))).SelectByText("Care provider staff work as a team - UC");
            new SelectElement(driver.FindElement(By.XPath("(//select[@id='singleSelect'])[2]"))).SelectByText("Hosp staff took pref into account - IN");
            driver.FindElement(By.CssSelector("option[value=\"number:87528\"]")).Click();
            new SelectElement(driver.FindElement(By.XPath("(//select[@id='singleSelect'])[7]"))).SelectByText("Information about home care - ER");
            new SelectElement(driver.FindElement(By.XPath("(//select[@id='singleSelect'])[9]"))).SelectByText("Ability staff answer questions - OU");
            driver.FindElement(By.CssSelector("option[value=\"number:19142\"]")).Click();
            new SelectElement(driver.FindElement(By.XPath("(//select[@id='singleSelect'])[9]"))).SelectByText("Informed about delays - ER");
            driver.FindElement(By.CssSelector("li.sub-nav-container > a")).Click();
            driver.FindElement(By.XPath("//div[@id='side-nav']/ul/li[2]/ul/static-board-menu/span/div/li[2]/a/span")).Click();
            new SelectElement(driver.FindElement(By.XPath("(//select[@name='singleSelect'])[2]"))).SelectByText("Nursing Administration");
            driver.FindElement(By.CssSelector("option[value=\"number:431\"]")).Click();
            new SelectElement(driver.FindElement(By.Name("singleSelect"))).SelectByText("Professional Development Opportunity");
            driver.FindElement(By.CssSelector("i.material-icons.pull-right")).Click();
            driver.FindElement(By.XPath("//div[@id='side-nav']/ul/li[2]/ul/static-board-menu/span/div/li[3]/a")).Click();
            driver.FindElement(By.XPath("(//div[@id='chevron-column']/span[2]/i)[2]")).Click();
            new SelectElement(driver.FindElement(By.CssSelector("div.col-md-6.magnet-soi-padding > div.ng-isolate-scope > div.col-xs-12.label-box > div.widget-data > #selectBenchmarks"))).SelectByText("Bed Size");
            driver.FindElement(By.XPath("(//button[@id='btnConfirm'])[2]")).Click();
            driver.FindElement(By.XPath("//div[@id='chevron-column']/span[2]/i")).Click();
            new SelectElement(driver.FindElement(By.Id("selectBenchmarks"))).SelectByText("Bed Size");
            driver.FindElement(By.Id("btnConfirm")).Click();
            driver.FindElement(By.XPath("(//div[@id='chevron-column']/span[2]/i)[2]")).Click();
            new SelectElement(driver.FindElement(By.CssSelector("div.col-md-6.magnet-soi-padding > div.ng-isolate-scope > div.col-xs-12.label-box > div.widget-data > #selectBenchmarks"))).SelectByText("Case Mix");
            driver.FindElement(By.XPath("(//button[@id='btnConfirm'])[2]")).Click();
            driver.FindElement(By.XPath("//div[@id='navbar']/ul/li[2]/a/i[2]")).Click();
            driver.FindElement(By.LinkText("Log out")).Click();
        }
        private bool IsElementPresent(By by)
        {
            try
            {
                driver.FindElement(by);
                return true;
            }
            catch (NoSuchElementException)
            {
                return false;
            }
        }
        
        private bool IsAlertPresent()
        {
            try
            {
                driver.SwitchTo().Alert();
                return true;
            }
            catch (NoAlertPresentException)
            {
                return false;
            }
        }
        
        private string CloseAlertAndGetItsText() {
            try {
                IAlert alert = driver.SwitchTo().Alert();
                string alertText = alert.Text;
                if (acceptNextAlert) {
                    alert.Accept();
                } else {
                    alert.Dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }
}
