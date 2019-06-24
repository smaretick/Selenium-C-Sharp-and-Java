package com.latimes.pages;

import java.io.File;

public class ArticlePage extends TribunePage {
    
    GigyaPage gigyaPage = new GigyaPage();
    
    public WebElement findElementByXpath(String xpathElement){
        return TribuneDriver.getInstance().getDriver().findElement(By.xpath(xpathElement));
    }
    
    public List<WebElement> findElementsByXpath(String xpathElement){
        return TribuneDriver.getInstance().getDriver().findElements(By.xpath(xpathElement));
    }
    
    private WebDriver driver = TribuneDriver.getInstance().getDriver();
    
    @FindBy(xpath = "//a[@class='trb_bnn_close']")
    private WebElement trbBanerClose;
    
    //SOCIALIZATION BAR
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[@data-socialshare-type='facebook']")
    public WebElement facebookIconElement;
    
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[@data-socialshare-type='twitter']")
    public WebElement twitterIconElement;
    
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[3]/div/span[@data-socialshare-type='pinterest']")
    public WebElement pinterestIconElement;
    
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[3]/div/span[@data-socialshare-type='googleplus']")
    public WebElement googleplusIconElement;
    
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[3]/div/span[@data-socialshare-type='linkedin']")
    public WebElement linkedinIconElement;
    
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[3]/div/span[@data-socialshare-type='stumbleupon']")
    public WebElement stumbleuponIconElement;
    
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[3]/div/span[@data-socialshare-type='digg']")
    public WebElement diggIconElement;
    
    @FindBy (xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[@data-socialshare-type='email']")
    public WebElement emailIconElement;
    
    //LEADART
    @FindBy (xpath = "//aside[@data-content-size='leadart']")
    private WebElement leadArtElement;
    
    @FindBy (xpath = "//aside[@data-content-size='leadart']/div[@class='trb_embed_media ']/figure/img" )
    private WebElement leadArtMediaElement;
    
    @FindBy(xpath="//aside[@data-content-size='leadart']/div[@class='trb_embed_media ']/div[@class='trb_embed_related']/div[@class='trb_embed_related_credit_and_caption']")
    private WebElement captionCreditElement;
    
    @FindBy (xpath = "//*[@class='trb_article_title']")
    private WebElement headlineElement;
    
    @FindBys(@FindBy(className="trb_article_page"))
    public  List<WebElement> artclePageList;
    /**
     * Verify if headline element exists and it's visible.
     *
     * @return true it's visible, false it's hidden or missing.
     */
    private boolean isHeadlineElementVisible() {
        boolean visible = true;
        
        try {
            visible = headlineElement.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        
        return visible;
    }
    
    String socialBarTopElement = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span";
    String shareParentElementTop = "//header[@class='trb_article_articleHeader']/div[@class='trb_socialize']/span[3]/div/span";
    
    //	String socialBarBottomElement =  "//section[@class='trb_mainContent']/div/div[@class='trb_article_page']/div[@class='trb_socialize']/span";
    @FindBys(@FindBy (xpath = "//section[@class='trb_mainContent']/div/div[@class='trb_article_page']/div[@class='trb_socialize']/span"))
    private List<WebElement> socialBarBottomElement;
    String shareParentElementBottom = "//section[@class='trb_mainContent']/div/div[@class='trb_article_page']/div[@class='trb_socialize']/span[3]/div/span";
    
    @FindBys(@FindBy (xpath = "//div[@class='trb_sharelines']/div[@class='trb_sharelines_list']/span"))
    private List<WebElement> sharelinesList;
    
    //Added by Mitza: So we can check size and click any of them.
    @FindBys(@FindBy (xpath = "//div[@class='trb_sharelines']/div[@class='trb_sharelines_list']/a/span[@data-socialshare-type='facebook']"))
    private List<WebElement> facebookSharelinesList;
    
    //Added by Mitza: So we can check size and click any of them.
    @FindBys(@FindBy (xpath = "//div[@class='trb_sharelines']/div[@class='trb_sharelines_list']/a/span[@data-socialshare-type='twitter']"))
    private List<WebElement> twitterSharelinesList;
    
    @FindBy(xpath="//div[@class='trb_article_dateline']/time")
    private WebElement datelineElement;
    
    @FindBy (xpath = "//*[@data-content-svgtype='articlesLogo']")
    private WebElement logoElement;
    
    @FindBys (@FindBy (xpath = "//div[@class='trb_article_breadcrumbs']/a"))
    private List<WebElement> breadcrumElementsList;
    
    @FindBy (xpath = "//*[@class='trb_article_title']/span")
    private WebElement kickerElement;
    
    /**
     * Get the kicker text from page.
     *
     * @return A String with the kicker text from page.
     */
    private String getKickerFromTitle() {
        try {
            return kickerElement.getText();
        } catch(WebDriverException e) {
            return "";
        }
    }
    
    @FindBy (xpath = "//div[@class='trb_background']/h3[@class='trb_background_header']")
    private WebElement backgroundHeaderElement;
    
    public String getBackgroundTitle() {
        return backgroundHeaderElement.getText();
    }
    
    @FindBy (xpath = "//div[@class='trb_background']")
    private WebElement backgroundElement;
    
    public String getBackgroundText() throws InterruptedException {
        return backgroundElement.getText();
    }
    
    public int getArticlesPagesCount(){
        return artclePageList.size();
    }
    /**************LEAD ART**********************/
    
    public String getLeadArtCaptionCredit() {
        
        try {
            if(captionCreditElement.isDisplayed()) {
                return captionCreditElement.getText();
            }
            else {
                return "NOTHING";
            }
        }catch (NoSuchElementException e) {
            //e.printStackTrace();
            return "no such element";
        }
    }
    
    @FindBy (xpath = "//span[@class='trb_bylines_name_author']")
    private WebElement bylineElement;
    
    private String getBylineText() {
        return bylineElement.getText();
    }
    
    private boolean isBylineElementVisible() {
        boolean visible = true;
        
        try {
            visible = bylineElement.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        
        return visible;
    }
    
    @FindBy (xpath = "//span[@class='trb_bylines_name_publication']")
    private WebElement titlelineElement;
    
    private String getTitlelineText() {
        return titlelineElement.getText();
    }
    
    private boolean isTitlelineElementVisible() {
        boolean visible = true;
        
        try {
            visible = titlelineElement.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        
        return visible;
    }
    
    /**************PAGINATION********************/
    @FindBy(xpath="//section[@class='trb_mainContent']/div/div[@data-content-page='6']/p[2]")
    private WebElement articleTextPageSix;
    
    @FindBy(xpath="//section[@class='trb_mainContent']/div/div[@data-content-page='1']/p[2]")
    private WebElement articleTextPageOne;
    
    @FindBy(xpath="//section[@class='trb_mainContent']/div/div[@data-content-page='8']/p[2]")
    private WebElement articleTextPageEight;
    
    public String getTextOnPageSix() {
        return articleTextPageSix.getText();
    }
    
    public String getTextOnPageOne() {
        return articleTextPageOne.getText();
    }
    
    public String getTextOnPageEight() {
        return articleTextPageEight.getText();
    }
    
    /***********Socialization Bar**********/
    /**
     * Clicks on Facebook icon on Top Socialization Bar
     */
    public void clickFacebookIcon() {
        String fbXpath = "//div[@class='trb_article_articleHeader_head']/preceding-sibling::div/span[@data-socialshare-type='facebook']";
        try{
            if(facebookIconElement.isDisplayed())
                facebookIconElement.click();
            else{
                findElementByXpath(fbXpath).click();
            }
        }catch(WebDriverException e){
            Utils.writeToLog("FB icon is not displayed:");
        }
        
    }
    
    /**
     * Clicks on Twitter icon on Top Socialization Bar
     */
    public void clickTwitterIcon() {
        twitterIconElement.click();
    }
    
    /**
     * Clicks on Pinterest icon on Top Socialization Bar
     */
    public void clickPinterestIcon() {
        pinterestIconElement.click();
    }
    
    /**
     * Clicks on GooglePlus icon on Top Socialization Bar
     */
    public void clickGooglePlusIcon() {
        googleplusIconElement.click();
    }
    
    /**
     * Clicks on LinkedIn icon on Top Socialization Bar
     */
    public void clickLinkedInIcon() {
        scrollTo(linkedinIconElement);
        linkedinIconElement.click();
    }
    
    /**
     * Clicks on Stumble Upon icon on Top Socialization Bar
     */
    public void clickStumbleUponIcon() {
        scrollTo(stumbleuponIconElement);
        stumbleuponIconElement.click();
    }
    
    /**
     * Clicks on Digg icon on Top Socialization Bar
     */
    public void clickDiggIcon() {
        diggIconElement.click();
    }
    
    /**
     * Clicks on Email icon on Top Socialization Bar
     */
    public void clickEmailIcon() {
        emailIconElement.click();
    }
    
    /**
     * Get the number of breadcrum elements in the page.
     *
     * @return A int with the number of breadcrum elements.
     */
    private int getNumberOfBreadcrumbElements() {
        return breadcrumElementsList.size();
    }
    
    /**************NAV MENU********************/
    String sectionElement = "//div[@class='trb_nav_bottomBox']/div[@data-role='navmenu_mainMenu scrollable_inner']/div";
    
    public int getNumberOfSectionElements() {
        return findElementsByXpath(sectionElement).size();
    }
    
    /**
     * Get the leadart subtype from page.
     *
     * @return A String with the leadart subtype.
     */
    private String getLeadArtContentType() {
        try {
            return leadArtElement.getAttribute("data-content-subtype");
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    
    /**
     * Get the src attribute from Leadart of photo or graphic type.
     *
     * @return A String with the image url.
     */
    private String getLeadArtSource() {
        return leadArtMediaElement.getAttribute("src");
    }
    
    //TODO remove this.
    @Deprecated
    public String getHeadlineFromPage() {
        return headlineElement.getText();
    }
    
    /**
     * Get text in the headline
     *
     * @return
     */
    private String getHeadlineText() {
        return headlineElement.getText();
    }
    
    /****************SHARELINES********************/
    /**
     * Clicks on Facebook icon of first shareline.
     */
    public void clickFacebookOnSharelines() {
        if (facebookSharelinesList.size() > 0) {
            scrollTo(facebookSharelinesList.get(0));
            facebookSharelinesList.get(0).click();
        }
    }
    
    /**
     * Clicks in Twitter icon of first shareline.
     */
    public void clickTwitterOnSharelines() {
        if (twitterSharelinesList.size() > 0) {
            scrollTo(twitterSharelinesList.get(0));
            twitterSharelinesList.get(0).click();
        }
    }
    
    
    /**
     * Verify there is a social bar displayed on top of the article
     * @throws InterruptedException
     */
    public void verifySocialBarDisplayedTop() throws InterruptedException {
        int elements = findElementsByXpath(socialBarTopElement).size();
        Assert.assertTrue(findElementByXpath(socialBarTopElement).isDisplayed());
        
        Utils.writeToLog("Number of icons on socialization bar on top is "+elements);
        Assert.assertEquals(elements, 5);
        
        int shareparentelements = findElementsByXpath(shareParentElementTop).size();
        Assert.assertEquals(shareparentelements, 5);
    }
    
    /**
     * Verify there is a social bar displayed at the bottom of the article
     * @throws InterruptedException
     */
    public void verifySocialBarDisplayedBottom() throws InterruptedException {
        //		int elements = findElementsByXpath(socialBarBottomElement).size();
        //		Assert.assertTrue(findElementByXpath(socialBarBottomElement).isDisplayed());
        int elements = socialBarBottomElement.size();
        Assert.assertTrue(socialBarBottomElement.get(0).isDisplayed());
        
        Utils.writeToLog("Number of icons on socialization bottom is "+elements);
        Assert.assertEquals(elements, 5);
        
        int shareparentelements = findElementsByXpath(shareParentElementBottom).size();
        Assert.assertEquals(shareparentelements, 5);
    }
    
    /**
     * Verify that when each social icon is clicked the corresponding new window opens
     * @throws InterruptedException
     */
    public void verifyPopUp() throws InterruptedException {
        clickFacebookIcon();
        clickAndVerifyFacebookPopup();
        
        clickTwitterIcon();
        clickAndVerifyTwitterPopup();
        
        verifyShareParentPopups();
        clickEmailIcon();
        clickAndVerifyEmailPopup();
    }
    
    public void verifyShareParentPopups() throws InterruptedException {
        hoverHackForShareparent();
        clickPinterestIcon();
        clickAndVerifyPinterestPopup();
        
        clickGooglePlusIcon();
        clickAndVerifyGooglePlusPopup();
        
        clickLinkedInIcon();
        clickAndVerifyLinkedInPopup();
        
        clickStumbleUponIcon();
        clickAndVerifyStumbleUponPopup();
        
        clickDiggIcon();
        clickAndVerifyDiggPopup();
    }
    
    /**
     * Click on facebook icon and verify that a pop up appears
     * @throws InterruptedException
     */
    private void clickAndVerifyFacebookPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyFacebookURL();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    private void verifyFacebookURL() throws InterruptedException {
        WebDriver newwindow = switchHandleToPopup();
        newwindow.findElement(By.id("facebook"));
        
        if(getTitle().contains("Facebook")) {
            Utils.logCorrectCheck("Window title " + getTitle());
        } else {
            Utils.logWrongCheck("Window title " + getTitle());
        }
        
        TribuneDriver.getInstance().getDriver().close();
    }
    
    /**
     * Click on twitter icon and verify that a pop up appears
     * @throws InterruptedException
     */
    private void clickAndVerifyTwitterPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyTwitterURL();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    
    private void verifyTwitterURL() throws InterruptedException {
        WebDriver newwindow = switchHandleToPopup();
        newwindow.findElement(By.id("header"));
        
        if(getTitle().contains("Twitter")) {
            Utils.logCorrectCheck("Window title " + getTitle());
        } else {
            Utils.logWrongCheck("Window title " + getTitle());
        }
        
        TribuneDriver.getInstance().getDriver().close();
    }
    
    /**
     * Click on pinterest icon and verify that a pop up appears
     * @throws InterruptedException
     */
    private void clickAndVerifyPinterestPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyPinterestText();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    public void clickAndVerifyPinterestPopupLightbox() throws InterruptedException {
        String parentWindowHandle = driver.getWindowHandle();
        verifyPinterestText();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    private void verifyPinterestText() throws InterruptedException {
        WebDriver newwindow = switchHandleToPopup();
        newwindow.findElement(By.xpath("/html/head/title"));
        
        if(getTitle().contains("Pinterest")) {
            Utils.logCorrectCheck("Window title " + getTitle());
        } else {
            Utils.logWrongCheck("Window title " + getTitle());
        }
        
        TribuneDriver.getInstance().getDriver().close();
    }
    
    
    /**
     * Click on google plus icon and verify that a pop up appears
     * @throws InterruptedException
     */
    public void clickAndVerifyGooglePlusPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyPlusURL();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    private void verifyPlusURL() throws InterruptedException {
        WebDriver newwindow = switchHandleToPopup();
        
        newwindow.findElement(By.xpath("//*[@class='logo']"));
        
        if(getTitle().contains("Google")) {
            Utils.logCorrectCheck("Window title " + getTitle());
        } else {
            Utils.logWrongCheck("Window title " + getTitle());
        }
        
        TribuneDriver.getInstance().getDriver().close();
    }
    
    /**
     * Click on Linkedin icon and verify that a pop up appears
     * @throws InterruptedException
     */
    public void clickAndVerifyLinkedInPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyLinkedinURL();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    private void verifyLinkedinURL() throws InterruptedException {
        WebDriver newwindow = switchHandleToPopup();
        //		newwindow.findElement(By.id("header")); //TODO With error, it can't find the element.
        
        if(getTitle().contains("LinkedIn")) {
            Utils.logCorrectCheck("Window title " + getTitle());
        } else {
            Utils.logWrongCheck("Window title " + getTitle());
        }
        
        TribuneDriver.getInstance().getDriver().close();
    }
    
    /**
     * Click on stumble upon icon and verify that a pop up appears
     * @throws InterruptedException
     */
    public void clickAndVerifyStumbleUponPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyStumbleText();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    private void verifyStumbleText() throws InterruptedException {
        //		WebDriver newwindow = switchHandleToPopup();
        switchHandleToPopup();
        String currentURL = getCurrentUrl();
        
        if (currentURL.contains("www.stumbleupon.com")) {
            Utils.logCorrectCheck("Window url " + currentURL);
        } else {
            Utils.logWrongCheck("Window url " + currentURL);
        }
        
        TribuneDriver.getInstance().getDriver().close();
    }
    
    /**
     * Click on digg icon and verify that a pop up appears
     * @throws InterruptedException
     */
    public void clickAndVerifyDiggPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyDiggText();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    private void verifyDiggText() throws InterruptedException {
        WebDriver newwindow = switchHandleToPopup();
        newwindow.findElement(By.xpath("/html/head/title"));
        
        if(getTitle().contains("Digg")) {
            Utils.logCorrectCheck("Window title " + getTitle());
        } else {
            Utils.logWrongCheck("Window title " + getTitle());
        }
        
        TribuneDriver.getInstance().getDriver().close();
    }
    
    /**
     * Click on email icon and verify that a pop up appears
     * @throws InterruptedException
     */
    public void clickAndVerifyEmailPopup() throws InterruptedException {
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        verifyEmailText();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
    }
    
    private void verifyEmailText() throws InterruptedException {
        WebDriver newwindow = switchHandleToPopup();
        newwindow.findElement(By.xpath("/html/body/div[2]/table"));
        
        Utils.writeToLog("Window title "+getTitle());
    }
    
    
    /**
     * Hack for hover- remove the class that open the sub menu
     * @throws InterruptedException
     */
    public void hoverHackForShareparent() throws InterruptedException {
        String script = "$('.trb_socialize_submenu').removeClass('trb_socialize_submenu')";
        ((JavascriptExecutor)TribuneDriver.getInstance().getDriver()).executeScript(script);
    }
    
    //WORK AROUND: NoSuchElementException generate a time out and an error connection.
    @FindBys (@FindBy (xpath = "//aside[@data-content-size='leadart']"))
    private List<WebElement> leadartList;
    
    public void verifyLeadArt(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        String contenttype = null;
        
        if (leadartList.size() > 0)
            contenttype = getLeadArtContentType();
        Utils.writeToLog("The lead art content type is "+contenttype);
        
        if (contenttype==null) {
            Utils.writeToLog("no lead art");
            
            verifyNoLeadArt(url);
        } else if (contenttype.equalsIgnoreCase("photo") || contenttype.equalsIgnoreCase("graphic")) {
            Utils.writeToLog("photo or graphic");
            
            verifyImageLeadArt(url);
        } else if (contenttype.equalsIgnoreCase("photogallery")) {
            Utils.writeToLog("photogallery");
            
            verifyPhotoGalleryLeadArt(url);
        } else if (contenttype.equalsIgnoreCase("embeddedvideo-youtube")) {
            Utils.writeToLog("youtube video");
            
            YoutubePlayerPage videoPlayerPage = PageFactory.initElements(TribuneDriver.getInstance().getDriver(), YoutubePlayerPage.class);
            videoPlayerPage.verifyYoutubeLeadArt();
        } else if (contenttype.equalsIgnoreCase("embeddedvideo-vimeo")) {
            Utils.writeToLog("vimeo video");
            
            VimeoPlayerPage videoPlayerPage = PageFactory.initElements(TribuneDriver.getInstance().getDriver(), VimeoPlayerPage.class);
            videoPlayerPage.verifyVimeoLeadArt();
        } else if (contenttype.equalsIgnoreCase("premiumvideo")) {
            Utils.writeToLog("premium video");
            
            PremiumVideoPlayerPage videoPlayerPage = PageFactory.initElements(TribuneDriver.getInstance().getDriver(), PremiumVideoPlayerPage.class);
            videoPlayerPage.verifyPremiumVideoLeadArt();
        } else {
            Utils.logWarning("Unhandle leadart type!");
        }
    }
    
    /**
     * Verify that lead art is displayed. Also log what content-type it is
     *
     * @throws InterruptedException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public void verifyImageLeadArt(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String contenttype = null;
        if (leadartList.size() > 0)
            contenttype = getLeadArtContentType();
        
        ArticleQueries articleDB = new ArticleQueries();
        String slug = Utils.getSlug(url);
        
        Map<String, String> relatedItemMap = articleDB.getRelatedItemMap(slug);
        int relatedItems = Integer.parseInt(relatedItemMap.get("itemsCount"));
        
        int errors = 0;
        
        if (relatedItems > 0) {
            //Check type of related items
            //just print it
            try {
                Utils.writeToLog("The lead art source is "+getLeadArtSource());
            }catch (org.openqa.selenium.NoSuchElementException e) {
                Utils.writeToLog("There is no lead art source. Really???");
            }
            
            //The first related item should be the leadart.
            Map<String, String> leadArtInfoFromDB = articleDB.getMultimediaInfo(relatedItemMap.get("contentItemId"+0));
            
            String credit = leadArtInfoFromDB.get("credit");
            String caption = leadArtInfoFromDB.get("caption");
            
            //caption
            if(caption!=null) {
                if(getLeadArtCaptionCredit().contains(caption)) {
                    Utils.logCorrectCheck("Caption from web and DB are the same("+caption+").");
                } else {
                    Utils.logWrongCheck("Thats weird, the lead arts from DB and web dont match");
                    Utils.writeToLog("caption from web "+getLeadArtCaptionCredit());
                    Utils.writeToLog("caption from db "+caption);
                }
            } else {
                Utils.writeToLog("caption is null on db");
                //				Assert.assertEquals(caption, null);
            }
            
            //credit
            if(credit!=null) {
                if(getLeadArtCaptionCredit().contains(credit)) {
                    Utils.logCorrectCheck("Credit from web and DB are the same("+credit+").");
                }else {
                    Utils.logWrongCheck("Thats weird, the lead arts from DB and web dont match");
                    Utils.writeToLog("caption from web "+getLeadArtCaptionCredit());
                    Utils.writeToLog("caption from db "+credit);
                }
            } else {
                Utils.writeToLog("credit is null on db");
                //				Assert.assertEquals(credit, null);
            }
            
        } else {
            //relatedItem <= 0
            Utils.logWrongCheck("There is an unexpected leadart in the page.");
            
            Utils.writeToLog("contenttype from page: " + contenttype);
            Utils.writeToLog("article thumbnail fron DB:" + articleDB.getArticleThumbnail(slug));
            
            errors++;
        }
        
        Assert.assertTrue(errors == 0, "Some errors are ocurred (" + errors + "), please verify logs.");
    }
    
    public void verifyNoLeadArt(String url) throws SQLException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //contentitemtype => null
        ArticleQueries articleDB = new ArticleQueries();
        String slug = Utils.getSlug(url);
        
        Map<String, String> relatedItemMap = articleDB.getRelatedItemMap(slug);
        int relatedItems = Integer.parseInt(relatedItemMap.get("itemsCount"));
        
        if (relatedItems == 0) {
            Utils.logCorrectCheck("No lead art as expected.");
        } else {
            //Expected: related items are not images/videos type.
            Utils.writeToLog("Expected: related items are not images/videos type.");
            
            Map<String, String> firstRelatedItem = articleDB.getRelatedItemAtPosition(slug, 1);
            
            //Verify relatedItems are not images/videos
            //			int leadartItemIndex = -1;
            ////			for (int i=0; i<relatedItems; i++) {
            //			int i=0;	//first related item is the leadart is it's multimedia.
            ////				String relatedItemCode = relatedItemMap.get("code"+i);
            ////
            ////				if (relatedItemCode.equalsIgnoreCase("photo") ||
            ////						relatedItemCode.equalsIgnoreCase("graphic") ||
            ////						relatedItemCode.equalsIgnoreCase("photogallery") ||
            ////						relatedItemCode.equalsIgnoreCase("premiumvideo") ||
            ////						relatedItemCode.equalsIgnoreCase("embeddedvideo")) {
            ////					leadartItemIndex = i;
            ////				}
            //			String relateditemTypeClass = relatedItemMap.get("typeClass"+i);
            //			if (relateditemTypeClass.equalsIgnoreCase("4")) { //4 means multimedia.
            //				leadartItemIndex = i;
            //			}
            //			}
            
            //			if (leadartItemIndex<0) {
            //typeClass 4 is multimedia, that means there is a leadart.
            if (!firstRelatedItem.get("typeClass").equalsIgnoreCase("4")) {
                Utils.logCorrectCheck("No lead art as expected.");
            } else {
                Utils.logWrongCheck("Leadart is missing on the page. A related item can be used as Leadart.");
                //				Utils.writeToLog("Related item id from db:" + relatedItemMap.get("contentItemId"+leadartItemIndex));
                //				Utils.writeToLog("Related item type from db: " + relatedItemMap.get("code"+leadartItemIndex));
                Utils.writeToLog("Related item slug from db:" + firstRelatedItem.get("slug"));
                //				Utils.writeToLog("Related item typeClass from db: " + firstRelatedItem.get("typeClass"));
                Utils.writeToLog("Related item title from db: " + firstRelatedItem.get("title"));
                
            }
            //			Assert.assertTrue(leadartItemIndex<0, "Leadart is missing on the page.");
            Assert.assertFalse(firstRelatedItem.get("typeClass").equalsIgnoreCase("4"), "Leadart is missing on the page.");
        }
    }
    
    /**
     * Verify headline in the given page.
     *
     * @param url
     * @throws InterruptedException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public void verifyHeadline(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        //Verify visibility
        if(isHeadlineElementVisible()) {
            Utils.logCorrectCheck("Headline is visible");
        } else {
            Utils.logWrongCheck("Headline is hidden or missing from page.");
        }
        Assert.assertTrue(isHeadlineElementVisible(), "Headline is hidden or missing from page");
        
        //Get headline from page
        // title = title - kicker
        String headlineFromWeb = getHeadlineText();
        headlineFromWeb = headlineFromWeb.replace(getKickerFromTitle(), "");
        Utils.writeToLog("The headline on the page is "+headlineFromWeb);
        
        //Get the value from DB
        ArticleQueries articleDB = new ArticleQueries();
        String slug = Utils.getSlug(url);
        
        String titleFromDB = articleDB.getArticleTitle(slug);
        
        //Make comparison of db and web values
        if (Utils.compareArticleTitle(titleFromDB, headlineFromWeb)) {
            Utils.logCorrectCheck("Headline in page is the expected from db("+titleFromDB+")");
        } else {
            Utils.logWrongCheck("Headline in page("+headlineFromWeb+") is NOT the expected from db("+titleFromDB+")");
        }
        Assert.assertTrue(Utils.compareArticleTitle(titleFromDB, headlineFromWeb), "Headline in page is NOT the expected from db");
    }
    
    /**
     * Verify that socialization bar is displayed and also all the functions work
     * according to NGUX- 550
     * @throws InterruptedException
     */
    public void verifySocializationBarIsDisplayed(String url) throws InterruptedException {
        goToUrl(url);
        
        verifySocialBarDisplayedTop();
        verifySocialBarDisplayedBottom();
        verifyPopUp();
    }
    
    /**
     * Verify that the date and time displayed is the same as the one in DB
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InterruptedException
     * @throws SQLException
     * @throws ParseException
     *
     * @author Mitza Oyaneder
     * @email moyaneder@tribune.com
     */
    public void verifyDateline(String url) throws SQLException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        
        ArticleQueries articleDB = new ArticleQueries();
        Date dateDB = articleDB.getArticleDisplayTime(Utils.getSlug(url));
        
        String dateWebString = getDateUnderArticle();
        Utils.writeToLog("Display time from article "+dateWebString);
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
        inputFormat.setTimeZone(getTimeZone());	//TimeZone based on the market
        Date dateWeb = inputFormat.parse(dateWebString);
        
        DateFormat outputFormat = new SimpleDateFormat("MMM. d, yyyy, HH:mm aa", Locale.ENGLISH);
        if(dateWeb.equals(dateDB)) {
            Utils.logCorrectCheck("Publish date in page is expected from DB("+outputFormat.format(dateDB)+").");
        } else {
            Utils.logWrongCheck("Publish date in page("+outputFormat.format(dateWeb)+") is not the expected from DB("+outputFormat.format(dateDB)+").");
        }
        
        Assert.assertEquals(dateWeb, dateDB);
    }
    
    /**
     * Get datetime value from web page.
     *
     * @return
     */
    private String getDateUnderArticle() {
        return datelineElement.getAttribute("datetime");
    }
    
    /**
     * Verify number of sharelines and content based on db info.
     *
     * @param expectedSharelines
     * @param url
     * @throws InterruptedException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     *
     * @author Mitza Oyaneder
     */
    public void verifySharelinesIsDisplayed(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        ArticleQueries articleDB = new ArticleQueries();
        LinkedList<String> sharelinesFromDB = articleDB.getSharelines(Utils.getSlug(url), getMarketCode());
        
        if(sharelinesFromDB.size() == getNumberOfSharelines()) {
            Utils.logCorrectCheck("Number of sharelines in page is the expected from DB("+sharelinesFromDB.size()+").");
        } else {
            Utils.logWrongCheck("Number of sharelines in page("+getNumberOfSharelines()+") is not the expected from DB("+sharelinesFromDB.size()+").");
        }
        Assert.assertEquals(sharelinesFromDB.size(), getNumberOfSharelines());
        
        int errors=0;
        for (int i=0; i<sharelinesFromDB.size(); i++) {
            scrollTo(getSharelineInPosition(i));
            if (Utils.compareStringRemovingFormat(sharelinesFromDB.get(i), getSharelineTextInPosition(i))) {
                Utils.logCorrectCheck("Shareline "+i+" in page is the expected from db(" + sharelinesFromDB.get(i)+")");
            } else {
                Utils.logWrongCheck("Shareline "+i+" in page() is not the expected from db(" + sharelinesFromDB.get(i)+")");
                errors++;
            }
        }
        
        Assert.assertTrue(errors == 0, "Some errors are ocurred (" + errors + "), please verify logs.");
    }
    
    /**
     * Get the number of sharelines in the web page.
     * @return
     */
    private int getNumberOfSharelines() {
        return sharelinesList.size();
    }
    
    /**
     * Get the text of the shareline in the given position.
     * @param position
     * @return
     */
    private String getSharelineTextInPosition(int position) {
        return sharelinesList.get(position).getText();
    }
    
    /**
     * Get shareline web element in the given position.
     * @param position
     * @return
     */
    private WebElement getSharelineInPosition(int position) {
        return sharelinesList.get(position);
    }
    
    /**
     * Hover over sharepoint to display the icons
     * @throws InterruptedException
     */
    public void hoverHackForSharelines() throws InterruptedException{
        
        String script1 = "$('.trb_shareline_item').show()";
        ((JavascriptExecutor)TribuneDriver.getInstance().getDriver()).executeScript(script1);
        
        String script2 = "$('a.trb_shareline').removeClass('trb_shareline')";
        ((JavascriptExecutor)TribuneDriver.getInstance().getDriver()).executeScript(script2);
    }
    
    /**
     * Share two articles
     * 1) Article without facebook text when sharing
     * 2) Article with facebook text when sharing
     * @throws InterruptedException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public void articleSharedFacebook(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        String article1 = getCurrentUrl();
        
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        
        ArticleQueries articleDB = new ArticleQueries();
        String articleheadline1 = articleDB.getArticleTitle(Utils.getSlug(article1));
        String windowtitle1 = getTitle();
        
        clickFacebookIcon();
        
        gigyaPage.shareViaFacebook("null", "fbpopup1"); /* dont send any text */
        
        Utils.writeToLog("Article one- (without comments or description) is shared");
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        gigyaPage.verifySharingOnFacebook(article1, articleheadline1, "facebook1", windowtitle1);
        
        goToUrl(url);
        
        String article2 = getCurrentUrl();
        
        parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        
        Utils.writeToLog("Second share adding text.");
        
        String articleheadline2 = articleDB.getArticleTitle(Utils.getSlug(article2));
        String windowtitle2 = getTitle();
        
        clickFacebookIcon();
        
        gigyaPage.shareViaFacebook("send", "fbpopup2"); /* this time send text */
        
        Utils.writeToLog("Article two- (adding comment/description) is shared");
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        gigyaPage.verifySharingOnFacebook(article2, articleheadline2, "facebook2", windowtitle2);
        
        //delete articles shared on facebook
        Utils.writeToLog("deleting articles shared on facebook...");
        gigyaPage.cleanFacebookShares();
    }
    
    /**
     * Share two articles
     * 1) Article without twitter text when sharing
     * 2) Article with twitter text when sharing
     * @throws InterruptedException
     */
    public void articleSharedTwitter(String url) throws InterruptedException {
        goToUrl(url); /* article 1 */
        
        String article1 = getCurrentUrl();
        
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        String articleheadline1 =getTitle();
        
        clickTwitterIcon();
        
        gigyaPage.shareViaTwitter("null"); /* dont send any text */
        
        
        
        Utils.writeToLog("Article one- (without comments or description) is shared");
        
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        Utils.writeToLog("Starting verification...");
        
        
        gigyaPage.verifySharingOnTwitter(article1, articleheadline1, "twitter1");
        
        goToUrl(url);
        String article2 = getCurrentUrl();
        
        parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        String articleheadline2 =getTitle();
        
        clickTwitterIcon();
        
        gigyaPage.shareViaTwitter("send"); /* this time send text */
        
        Utils.writeToLog("Article two- (adding comment/description) is shared");
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        gigyaPage.verifySharingOnTwitter(article2, articleheadline2, "twitter2");
        
        //delete tweets.
        Utils.writeToLog("deleting tweets...");
        gigyaPage.cleanTwitterShares();
    }
    
    /**
     * Share two articles
     * 1) Article without pinterest text when sharing
     * 2) Article with pinterest text when sharing
     * @throws InterruptedException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public void articleSharedPinterest(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url); /* article 1 */
        
        String article1 = getCurrentUrl();
        
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        
        ArticleQueries articleDB = new ArticleQueries();
        String articleheadline1 = articleDB.getArticleTitle(Utils.getSlug(url));
        String windowtitle1 = getTitle();
        
        hoverHackForShareparent();
        clickPinterestIcon();
        
        gigyaPage.shareViaPinterest("null", "pinterestpopup"); /* dont send any text */
        
        Utils.writeToLog("Article is shared");
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        gigyaPage.verifySharingOnPinterest(article1, articleheadline1, "pinterest1", windowtitle1);
        
        TribuneDriver.getInstance().getDriver().manage().deleteAllCookies();
    }
    
    /**
     * Share two articles
     * 1) Article without google plus text when sharing
     * 2) Article with google plus text when sharing
     * @throws InterruptedException
     */
    public void articleSharedGooglePlus(String url) throws InterruptedException {
        goToUrl(url); /* article 1 */
        
        String article1 = getCurrentUrl();
        
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        String articleheadline1 =getTitle();
        
        hoverHackForShareparent();
        
        clickGooglePlusIcon();
        
        gigyaPage.shareViaPlus("send"); /* dont send any text */
        
        Utils.writeToLog("Article one- (without comments or description) is shared");
        
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        gigyaPage.verifySharingOnGooglePlus(article1, articleheadline1, "plus1");
    }
    
    /**
     * Share two articles
     * 1) Article without linkedin text when sharing
     * 2) Article with linkedin text when sharing
     * @throws InterruptedException
     */
    public void articleSharedLinkedin(String url) throws InterruptedException {
        gigyaPage.loginToLinkedIn();
        
        goToUrl(url);
        String article1 = getCurrentUrl();
        
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        String articleheadline1 =getTitle();
        
        hoverHackForShareparent();
        clickLinkedInIcon();
        
        gigyaPage.shareViaLinkedIn("send"); /* dont send any text */
        
        Utils.writeToLog("Article one- (without comments or description) is shared");
        
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        //linked in logout
        goToUrl("https://www.linkedin.com/");
        gigyaPage.hoverHackForLinkedin();
        gigyaPage.clickLogoutLinkedIn();
        
        gigyaPage.verifySharingOnLinkedin(article1, articleheadline1, "linkedin1");
    }
    
    /**
     * Share two articles
     * 1) Article without linkedin text when sharing
     * 2) Article with linkedin text when sharing
     * @throws InterruptedException
     *
     *  TODO Some errors to fix.
     */
    public void articleSharedStumbleUpon(String url) throws InterruptedException {
        gigyaPage.loginToStumbleUpon();
        goToUrl(url); /* article 1 */
        String article1 = getCurrentUrl();
        String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
        
        String articleheadline1 = getTitle();
        hoverHackForShareparent();
        
        clickStumbleUponIcon();
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        gigyaPage.shareViaStumbleUpon();
        
        Utils.writeToLog("Article one- (without comments or description) is shared");
        
        TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
        
        gigyaPage.verifySharingOnStumbleUpon(article1, articleheadline1, "stumbleupon1");
    }
    
    public void sharelineSharedFacebook(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        if (getNumberOfSharelines() != 0) {
            String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
            
            ArticleQueries articleDB = new ArticleQueries();
            String articleheadline1 = articleDB.getArticleTitle(Utils.getSlug(url));
            String windowtitle = getTitle();
            
            scrollTo(facebookSharelinesList.get(0));
            
            hoverHackForSharelines();
            clickFacebookOnSharelines();
            
            gigyaPage.shareViaFacebook("null", "fbpopup3"); /* dont send any text */
            
            Utils.writeToLog("Shareline one is shared");
            
            TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
            
            gigyaPage.verifySharingOnFacebook(url, articleheadline1, "facebookshareline1", windowtitle);
        } else {
            Utils.logWarning("No shareline to run this test.");
        }
    }
    
    public void sharelineSharedTwitter(String url) throws InterruptedException {
        goToUrl(url);
        
        if (getNumberOfSharelines() != 0) {
            
            String article1 = getCurrentUrl();
            
            String parentWindowHandle = TribuneDriver.getInstance().getDriver().getWindowHandle();
            String articleheadline1 =getTitle();
            
            scrollTo(twitterSharelinesList.get(0));
            
            hoverHackForSharelines();
            clickTwitterOnSharelines();
            
            gigyaPage.shareViaTwitter("null");  //dont send any text
            
            Utils.writeToLog("Shareline one is shared");
            
            TribuneDriver.getInstance().getDriver().switchTo().window(parentWindowHandle);
            
            gigyaPage.verifySharingOnTwitter(article1, articleheadline1, "twitter3");
            
        } else {
            Utils.logWarning("No sharelines to run this test.");
        }
    }
    
    
    public void verifyLogo(String url) throws InterruptedException {
        goToUrl(url);
        
        if(logoElement.isDisplayed()) {
            Utils.logCorrectCheck("Logo is displayed on page.");
        } else {
            Utils.logWrongCheck("Logo is missing on page.");
        }
        Assert.assertTrue(logoElement.isDisplayed(), "Logo shoudl be visible.");
        
        
        if(logoElement.getAttribute("title").equalsIgnoreCase(getMarketName())) {
            //			Utils.writeToLog("There's a logo present and it is "+findElementByXpath("//header[@class='trb_article_articleHeader']/a").getAttribute("title"));
            Utils.logCorrectCheck("Logo present is the expected for the current market.");
        } else {
            Utils.logWrongCheck("Logo present is NOT the expected for the current market.");
        }
        Assert.assertTrue(logoElement.getAttribute("title").equalsIgnoreCase(getMarketName()), "It looks like the logo market is the incorrect.");
    }
    
    /**
     * Verify that when clicking on bread crumbs goes to corresponding article
     * @throws InterruptedException
     *
     * @author Mitza Oyaneder
     * @email moyaneder@tribune.com
     */
    public void verifyBreadCrumbs(String url) throws InterruptedException {
        goToUrl(url);
        
        int errors = 0;
        if (breadcrumExpected()) {
            
            checkBreadcrumVisibility();
            
            getNamesOfAllCrumbs();
            
            Utils.writeToLog("Now checking if each breadcrumb goes to correct url");
            for(int i=1; i<=getNumberOfBreadcrumbElements(); i++) {
                //we need "find" the object every time because the click action
                //that it makes lose the breadcrumList object from memory.
                String tempxpath = "//div[@class='trb_article_breadcrumbs']/a["+i+"]"; //Here it seems like the xpath is not getting specific breadCrum
                WebElement currentBreadcrum = TribuneDriver.getInstance().getDriver().findElement(By.xpath(tempxpath));
                
                String breadcrumbname = currentBreadcrum.getText();
                Utils.writeToLog("Clicking on breadcrumb " + currentBreadcrum.getText());
                currentBreadcrum.click(); //TODO is not clicking
                
                //the same than before, because the click, new page is not in memory.
                Utils.writeResultToLog("URL Before break", getCurrentUrl()); //TODO Remove this line
                String sectionTitleXpath = "//h1[@class='trb_masthead_subtitle']";
                String sectionTitle = findElementByXpath(sectionTitleXpath).getText();
                if(sectionTitle.equalsIgnoreCase(breadcrumbname)) {// Here may be convenient to check if it is similar, not sure, if they should match
                    Utils.logCorrectCheck("Clicking on breadcrumb goes to the right section("+breadcrumbname+")");
                } else {
                    Utils.logWrongCheck("Clicking on breadcrumb("+ breadcrumbname +") goes to the different section("+sectionTitle+")");
                    errors++;
                }
                
                goToUrl(url);
            }
        } else {
            if (getNumberOfBreadcrumbElements() == 0) {
                Utils.logCorrectCheck("Breadcrum is not present in the page as expected.");
            } else {
                Utils.logWrongCheck("Breadcrum is visible in the page but it should not be present.");
                errors++;
            }
        }
        
        Assert.assertTrue(errors == 0, "Some errors are ocurred (" + errors + "), please verify logs.");
    }
    
    /**
     * Verify that breadcrumbs appear under market logo
     */
    private void checkBreadcrumVisibility() {
        if (getNumberOfBreadcrumbElements() > 0) {
            Utils.logCorrectCheck("Breadcrum is present in the page.");
        } else {
            Utils.logWrongCheck("Breadcrum is missing in the page");
        }
        Assert.assertTrue(getNumberOfBreadcrumbElements() > 0, "Breadcrum doesn't have any element.");
        
        //This is not testing what it says.
        //		if((findElementByXpath("//header[@class='trb_article_articleHeader']/div[1]").getAttribute("class")).equalsIgnoreCase("trb_article_breadcrumbs")) {
        //			Utils.writeToLog("Breacrumbs appear under logo");
        //		}
    }
    
    /**
     * Get the path of breadcrumbs
     */
    private void getNamesOfAllCrumbs() {
        Utils.writeToLog("The number of breadrumbs is "+getNumberOfBreadcrumbElements());
        
        Utils.writeToLog("Breadcrumbs are ");
        for(int i=0; i<getNumberOfBreadcrumbElements(); i++) {
            String breadcrumbname = breadcrumElementsList.get(i).getText();
            
            if (breadcrumElementsList.get(i).isDisplayed()) {
                Utils.logCorrectCheck(breadcrumbname + "/ is visible.");
            } else {
                Utils.logWrongCheck(breadcrumbname + "/ is hidden.");
            }
        }
    }
    
    
    @FindBys(@FindBy (xpath = "//section[@class='trb_mainContent']/div[@data-role='panelmod_articleBodyParagraphs']/div[@class='trb_article_page']"))
    private List<WebElement> pagesList;
    
    private int getNumberOfPagesInArticle() {
        return pagesList.size();
    }
    
    /**
     * Verify that urls change when scrolling down through a lengthy article
     * @throws InterruptedException
     *
     * TODO Pagination: Refactor pending
     */
    public void articlePagination(String url) throws InterruptedException {
        goToUrl(url);
        int errors = 0;
        
        int numberOfPagesInArticle = getNumberOfPagesInArticle();
        System.out.println(numberOfPagesInArticle);
        
        for(int i = 1; i<=numberOfPagesInArticle; i++) {
            scrollTo(pagesList.get(i-1));
            String [] spliturl = getCurrentUrl().split("#");
            String pagenumber = spliturl[1];
            System.out.println("i "+i);
            System.out.println("page number "+pagenumber);
            
            if(pagenumber.equalsIgnoreCase("page="+i)) {
                Utils.logCorrectCheck("Page number match with the scrolling("+pagenumber+")");
            }else {
                Utils.logWrongCheck("Page numbers dont match with scrolling.");
                Utils.writeToLog("pagenumber("+pagenumber+")");
                Utils.writeToLog("expected(page="+i+")");
                errors++;
            }
        }
        
        //scroll page up
        for (int i=numberOfPagesInArticle; i>0; i--) {
            scrollTo(pagesList.get(i-1));
        }
        scrollTo(headlineElement);
        
        
        //		System.out.println(getCurrentUrl());
        if(getCurrentUrl().contains("#page=1")) {
            Utils.logCorrectCheck("Pagination change page number when scroll up.");
        } else {
            Utils.logWrongCheck("Pagination is not changing the number when scroll up.");
            Utils.writeToLog("current url("+getCurrentUrl()+")");
            Utils.writeToLog("expected url("+url+"#page=1");
            errors++;
        }
        
        //		String lastPageString = "#page="+numberOfPagesInArticle;
        //		Utils.writeToLog("url to load: " + url+lastPageString);
        //		goToUrl(url+lastPageString);
        //
        //		WebElement contentPage = findElementByXpath("//section[@class='trb_mainContent']/div/div[@data-content-page='"+numberOfPagesInArticle+"']/p[2]");
        //		if (contentPage.isDisplayed()) {
        //			Utils.logCorrectCheck("Try to open page "+numberOfPagesInArticle+" of the article directly works rightly. Content of the given page is visible.");
        //		} else {
        //			Utils.logWrongCheck("Tried to open page "+numberOfPagesInArticle+" of that article directly, The correct page doesnt open.");
        //			Utils.writeToLog("current url: " + getCurrentUrl());
        //
        //			errors++;
        //		}
        
        //Verify refresh in the last page.
        //		String urlBeforeRefresh = getCurrentUrl();
        //		refresh();
        //		if(urlBeforeRefresh.equalsIgnoreCase(getCurrentUrl())) {
        //			Utils.logCorrectCheck("Page opens at the same place after refreshed.");
        //		}else {
        //			Utils.logWrongCheck("Page doesn't open at the same place after refreshed.");
        //			Utils.writeToLog("url before refresh: " + urlBeforeRefresh);
        //			Utils.writeToLog("url after refresh: " + getCurrentUrl());
        //
        //			errors++;
        //		}
        //
        Assert.assertTrue(errors == 0, "Some errors are ocurred (" + errors + "), please verify logs.");
    }
    
    public void verifyArticlePaginationRefresh(String url) throws InterruptedException {
        goToUrl(url);
        
        if(!TribuneDriver.getInstance().isSafariDriver()) {
            //Verify refresh in the last page.
            String urlBeforeRefresh = getCurrentUrl();
            refresh();
            if(urlBeforeRefresh.equalsIgnoreCase(getCurrentUrl())) {
                Utils.logCorrectCheck("Page opens at the same place after refreshed.");
            }else {
                Utils.logWrongCheck("Page doesn't open at the same place after refreshed.");
                Utils.writeToLog("url before refresh: " + urlBeforeRefresh);
                Utils.writeToLog("url after refresh: " + getCurrentUrl());
            }
            
            Assert.assertEquals(urlBeforeRefresh, getCurrentUrl());
        } else {
            Utils.logWarning("SAFARI was issues with refresh instruction.");
        }
    }
    
    public void verifyArticlePaginationbyUrl(String url) throws InterruptedException {
        goToUrl(url);
        
        int lastPage = Math.max(getNumberOfPagesInArticle(), 1);
        String lastPageString = "#page="+lastPage;
        Utils.writeToLog("url to load: " + url+lastPageString);
        goToUrl(url+lastPageString);
        
        WebElement contentPage = findElementByXpath("//section[@class='trb_mainContent']/div/div[@data-content-page='"+lastPage+"']/p[2]");
        if (contentPage.isDisplayed()) {
            Utils.logCorrectCheck("Try to open page "+lastPage+" of the article directly works rightly. Content of the given page is visible.");
        } else {
            Utils.logWrongCheck("Tried to open page "+lastPage+" of that article directly, The correct page doesnt open.");
            Utils.writeToLog("current url: " + getCurrentUrl());
        }
        
        Assert.assertTrue(contentPage.isDisplayed(), "Article doesn't load in the expected page("+lastPage+")");
    }
    
    /**
     * @throws InterruptedException
     *
     * TODO Navigation: Out of Scope for this delivery.
     */
    public void articleNavigation(String url) throws InterruptedException {
        
        //goToUrl("http://ngux_beta_la:ngux2013@ngux.latimes.stage.tribdev.com/");
        
        goToUrl(url);
        TribuneDriver.getInstance().getDriver().manage().window().maximize();
        //TribuneDriver.getInstance().waitForLoad();
        //Thread.sleep(5000);
        
        //		TribuneDriver.getInstance().getDriver().findElement(By.cssSelector("section.trb_bnn_close")).click();
        //		//Thread.sleep(5000);
        gigyaPage.closeAnnoyingBreakingNews();
        System.out.println("Number of sections = "+getNumberOfSectionElements());
        
        for(int i = 1; i<= getNumberOfSectionElements(); i++) {
            
            String sectionElementNames = "//div[@class='trb_nav_bottomBox']/div[@data-role='navmenu_mainMenu scrollable_inner']/div["+i+"]/a";
            String sectionname = findElementByXpath(sectionElementNames).getText();
            Utils.writeToLog("Section name = "+sectionname);
            //Reporter.log("<br>Section name = "+sectionname);
            
            
            //Thread.sleep(2000);
            //System.out.println("Number of sub sections = "+getNumberOfSubsectionElements());
            String subSectionElement = "//div[@class='trb_nav_bottomBox']/div[@data-role='navmenu_mainMenu scrollable_inner']/div["+i+"]/div[@data-role='navmenu_subMenu_container scrollable']/div[@data-role='navmenu_subMenu scrollable_inner']/a";
            int numberOfSubSection = findElementsByXpath(subSectionElement).size();
            System.out.println("Number of sub sections = "+numberOfSubSection);
            
            for(int j = 1; j<= numberOfSubSection; j++) {
                
                if (j!=1) {
                    String subSectionElementNames = "//div[@class='trb_nav_bottomBox']/div[@data-role='navmenu_mainMenu scrollable_inner']/div["+i+"]" +
                    "/div[@data-role='navmenu_subMenu_container scrollable']/div[@data-role='navmenu_subMenu scrollable_inner']/a["+j+"]";
                    String subsectionname = findElementByXpath(subSectionElementNames).getText();
                    //Thread.sleep(2000);
                    Utils.writeToLog("Sub Section name = "+subsectionname);
                    //Reporter.log("<br>Sub Section name = "+subsectionname);
                    //Thread.sleep(2000);
                    
                    /*findElementByLinkText(subsectionname).click();
                     //TribuneDriver.getInstance().waitForLoad();
                     //Thread.sleep(5000);
                     
                     System.out.println("Url landed on = "+getCurrentUrl());
                     Reporter.log("<br>Url landed on = "+getCurrentUrl());
                     
                     TribuneDriver.getInstance().getDriver().navigate().back();
                     //TribuneDriver.getInstance().waitForLoad();
                     //Thread.sleep(5000);*/
                }
                
            }
            
        }
        
        String script1 = " $('html').attr('data-state', 'navmenu_expanded')";
        //TribuneDriver.getInstance().getDriver().findElement(By.linkText("Classifieds"));
        ((JavascriptExecutor)TribuneDriver.getInstance().getDriver()).executeScript(script1);
        //Thread.sleep(5000);
        TribuneDriver.getInstance().captureScreen("navmenu_opened");
        
        //TribuneDriver.getInstance().getDriver().findElement(By.linkText("LA Now")).click();
        
        /*TribuneDriver.getInstance().getDriver().findElement(By.cssSelector("a.trb_nav_VBButton_menu")).click();
         //Thread.sleep(5000);
         String script2 = " $('html').attr('data-state', 'visualbrowse_expanded navmenu_expanded')";
         //TribuneDriver.getInstance().getDriver().findElement(By.linkText("Classifieds"));
         ((JavascriptExecutor)TribuneDriver.getInstance().getDriver()).executeScript(script2);
         //Thread.sleep(5000);
         
         captureScreen("visualbrowse_opened");
         //Thread.sleep(5000);*/
    }
    
    /**
     * Verify the kicker on he given page.
     *
     * @param url
     * @throws SQLException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     *
     * @author Mitza Oyaneder
     * @email moyaneder@tribune.com
     */
    public void verifyKicker(String url) throws SQLException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        String slug = Utils.getSlug(url);
        
        ArticleQueries articleDB = new ArticleQueries();
        Map<String, String> kickerDB = articleDB.getKickerInfo(slug);
        
        if (kickerDB.get("id") == null) {
            Utils.logWarning("There is NO kicker");
            //TODO confirm there is no kicker
        }
        else {
            Utils.writeToLog("Kicker id "+kickerDB.get("id"));
            
            if (Utils.compareStringRemovingFormat(getKickerFromTitle(), kickerDB.get("text"))){
                Utils.logCorrectCheck("Kickers match! Kicker is " + getKickerFromTitle());
            } else {
                Utils.logWrongCheck("Kickers dont match!");
                Utils.writeToLog("kicker from db: " + kickerDB.get("text"));
                Utils.writeToLog("kicker from web: " + getKickerFromTitle());
            }
            
            Assert.assertTrue(Utils.compareStringRemovingFormat(getKickerFromTitle(), kickerDB.get("text")));
        }
    }
    
    public boolean verifyBackgroundIsSame(String backgroundheader, String backgroundtext) throws InterruptedException {
        getBackgroundTitle();
        //Thread.sleep(3000);
        getBackgroundText();
        //Thread.sleep(3000);
        //System.out.println();
        if(backgroundheader.equalsIgnoreCase(getBackgroundTitle())&&(getBackgroundText().contains(backgroundtext))) {
            Utils.writeToLog("Background headers and title match!!");
            Assert.assertEquals(backgroundheader, getBackgroundTitle());
            Assert.assertTrue(getBackgroundText().contains(backgroundtext));
            return true;
        }else {
            Utils.writeToLog("This is what I see. Background TITLE from DB is "+backgroundheader+" and from UI is "+getBackgroundTitle());
            Utils.writeToLog("This is what I see. Background TEXT from DB is "+backgroundtext+" and from UI is "+getBackgroundText());
            Assert.fail("Backgrounds dont match");
            return false;
        }
    }
    
    //TODO Background: out of scope
    public void checkBackground() throws SQLException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //		FrontPage home = PageFactory.initElements(TribuneDriver.getInstance().getDriver(),FrontPage.class);
        //		DBConnect dbconnect = home.dbconnect();
        //
        ////		String slugid = gigyaPage.getSlugFromURL(getCurrentUrl());
        //		String slugid = Utils.getSlug(getCurrentUrl());
        //		//Utils.writeToLog(slugid);
        //		//String slugid = "la-tr-petalumaescape-20120805";
        //		String query1 = "select id from TURBINE.contentitem where slug='"+slugid+"'";
        //		System.out.println(slugid);
        //		ResultSet rs1 = dbconnect.dbFetch(query1);
        //		String id = null;
        //		String backgroundheader = null;
        //		String backgroundtext = null;
        //		while(rs1.next()) {
        //			System.out.println("here");
        //			//System.out.println(rs.toString());
        //			id = rs1.getString(1);
        //			System.out.println(id);
        //			String query2 = "select header, body from TURBINE.contentitem_background where contentitem_id='"+id+"'";
        //			ResultSet rs2 = dbconnect.dbFetch(query2);
        //			while(rs2.next()) {
        //				System.out.println("here");
        //				backgroundheader = rs2.getString(1);
        //				backgroundtext = rs2.getString(2);
        //				System.out.println(backgroundheader);
        //				System.out.println(backgroundtext);
        //				if(backgroundheader==null) {
        //					Utils.writeToLog("There is no background header");
        //					if(backgroundtext==null) {
        //						Utils.writeToLog("There is no background text");
        //					}
        //				}else {
        //					boolean result = verifyBackgroundIsSame(backgroundheader, backgroundtext);
        //					if(result==true) {
        //						Utils.writeToLog("TEST CASE PASSES!");
        //					}else {
        //						Utils.writeToLog("TEST CASE FAILS!");
        //					}
        //				}
        //			}
        //		}
        //		dbconnect.close();
    }
    
    public void verifyPhotoGalleryLeadArt(String url) throws InterruptedException {
        String datacontentidelement = "//header[@class='trb_article_articleHeader']/div[@class='trb_article_articleHeader_head']/div[@class='trb_article_leadart']/aside[@class='trb_embed  ']";
        String datacontentid = findElementByXpath(datacontentidelement).getAttribute("data-content-id");
        
        String storygallerytempxpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_article_articleHeader_head']/div[@class='trb_article_leadart']/aside[@data-content-id = '"+datacontentid+"']/div[@class='trb_embed_media ']";
        String numberofphotoselement =  storygallerytempxpath+"/aside[@class='trb_embed  ']";
        int numberofphotos = findElementsByXpath(numberofphotoselement).size();
        Utils.writeToLog("Number of photos "+numberofphotos);
        String opencaptionscript = "document.getElementsByClassName('trb_embed_related_galleryToggleCaption')[0].click()";
        ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(opencaptionscript);
        
        for(int i=0; i<numberofphotos; i++) {
            
            Utils.writeToLog("\n");
            Utils.writeToLog("Navigating forward. On photo #"+i);
            
            String creditscript = "return document.getElementsByClassName('trb_embed_related_credit')["+i+"].textContent";
            String titlescript = "return document.getElementsByClassName('trb_embed_related_title')["+i+"].textContent";
            String captionscript = "return document.getElementsByClassName('trb_embed_related_caption')["+i+"].textContent";
            
            try {
                String credit = (String) ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(creditscript);
                Utils.writeToLog("The credit is "+credit);
                
            }catch (org.openqa.selenium.WebDriverException e1) {
                Utils.writeToLog("There is no credit element");
            }
            
            try {
                String caption = (String) ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(captionscript);
                Utils.writeToLog("The caption is "+caption);
                
            }catch (org.openqa.selenium.WebDriverException e2) {
                Utils.writeToLog("There is no caption element");
            }
            
            try {
                String title = (String) ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(titlescript);
                Utils.writeToLog("The title is "+title);
                
            }catch (org.openqa.selenium.WebDriverException e3) {
                Utils.writeToLog("There is no title element");
            }
            
            String forwardarrow = storygallerytempxpath+"/span[@class='trb_embed_media_next']";
            
            boolean adflag = verifyAd();
            
            if(i!=numberofphotos-1) {
                WebElement fowardArrowElement = findElementByXpath(forwardarrow);
                scrollTo(fowardArrowElement);
                fowardArrowElement.click();
                
                if(adflag==true) {
                    i=i-1;
                }
            }else {
                break;
            }
            
        }
        
        for(int j=numberofphotos-1; j>=0; j--) {
            
            Utils.writeToLog("\n");
            boolean adflag = verifyAd();
            String backarrow = storygallerytempxpath+"/span[@class='trb_embed_media_prev']";
            Utils.writeToLog("Navigating backward. On photo #"+j);
            
            String creditscript = "return document.getElementsByClassName('trb_embed_related_credit')["+j+"].textContent";
            String titlescript = "return document.getElementsByClassName('trb_embed_related_title')["+j+"].textContent";
            String captionscript = "return document.getElementsByClassName('trb_embed_related_caption')["+j+"].textContent";
            
            try {
                String credit = (String) ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(creditscript);
                Utils.writeToLog("The credit is "+credit);
                
            }catch (org.openqa.selenium.WebDriverException e1) {
                Utils.writeToLog("There is no credit element");
            }
            
            try {
                String caption = (String) ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(captionscript);
                Utils.writeToLog("The caption is "+caption);
                
            }catch (org.openqa.selenium.WebDriverException e1) {
                Utils.writeToLog("There is no caption element");
            }
            
            try {
                String title = (String) ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(titlescript);
                Utils.writeToLog("The title is "+title);
                
            }catch (org.openqa.selenium.WebDriverException e1) {
                Utils.writeToLog("There is no title element");
            }
            
            if(j!=0) {
                if(adflag==true) {
                    findElementByXpath(backarrow).click();
                    j=j+1;
                }else if(adflag==false) {
                    findElementByXpath(backarrow).click();
                }
            }else {
                break;
            }
            
            
        }
        
    }
    
    public boolean verifyAd() {
        String adscript = "return $('span.adcontainer').is(':visible')";
        
        boolean adpresent = (Boolean) ((JavascriptExecutor) TribuneDriver.getInstance().getDriver()).executeScript(adscript);
        
        if(adpresent==true) {
            Utils.writeToLog("I see AN AD!!");
            return true;
        }else {
            Utils.writeToLog("I don't see an ad");
            return false;
        }
    }
    
    public void verifyAds(String url) throws InterruptedException {
        goToUrl(url);
        
        int errors = 0;
        
        errors = errors + checkTopAd();
        errors = errors + checkAdUnderMastheadLogo();
        
        Assert.assertTrue(errors == 0, "Some errors are ocurred (" + errors + "), please verify logs.");
    }
    
    public int checkTopAd() {
        String topAdXPath = "//*[@data-state='adloader_loaded'][@class='trb_header_adBanner_combo']";
        if (TribuneDriver.getInstance().isChromeDriver()) {
            topAdXPath = "//*[@data-state='adloader_loaded'][@class='trb_header_adBanner_large']";
        }
        List<WebElement> topAd = findElementsByXpath(topAdXPath);
        int errors = 0;
        
        if (topAd.size() > 0) {
            scrollTo(topAd.get(0));
            
            if (topAd.get(0).isDisplayed()) {
                Utils.logCorrectCheck("Top Ad is visible.");
            }else {
                Utils.logWrongCheck("Top Ad is not visible.");
                errors++;
            }
        } else {
            Utils.logWrongCheck("Top Ad is missing in the page.");
            errors++;
        }
        return errors;
    }
    
    private int checkAdUnderMastheadLogo() {
        List<WebElement> underMastheadLogoAd = findElementsByXpath("//*[@data-state='adloader_loaded'][@class='trb_gptAd']");
        int errors = 0;
        
        if(underMastheadLogoAd.size() > 0) {
            scrollTo(underMastheadLogoAd.get(0));
            
            if (underMastheadLogoAd.get(0).isDisplayed()) {
                Utils.logCorrectCheck("Ad under masthead is visible.");
            }else {
                Utils.logWrongCheck("Ad under masthead is not visible.");
                errors++;
            }
        } else {
            Utils.logWrongCheck("Ad under masthead is missing in the page.");
            errors++;
        }
        return errors;
    }
    
    /**
     * Verify byline in the given url.
     *
     * @param url
     * @throws InterruptedException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public void verifyByline(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        //Get byline from db
        ArticleQueries articleDB = new ArticleQueries();
        
        //Get Byline. Advanced bylines is also set on byline field.
        String bylineFromDB = articleDB.getArticleByline(Utils.getSlug(url));
        
        if (bylineFromDB != null) {
            //Fix for "by" in the db field.
            bylineFromDB = bylineFromDB.replace("^[B|b][Y|y]\\ ", "");
            
            
            //Something expected, then checking is visible
            if (isBylineElementVisible()) {
                Utils.logCorrectCheck("Byline is present in the page.");
            } else {
                Utils.logWrongCheck("Byline is missing in the page. Expected from db (" + bylineFromDB + ")");
            }
            Assert.assertTrue(isBylineElementVisible(), "Byline is missing in the page. Expected from db (" + bylineFromDB + ")");
            
            //Compare both are the same
            bylineFromDB = Utils.html2text(bylineFromDB);
            String bylineFromWeb = Utils.html2text(getBylineText());
            //Fix for "by" in the db field.
            bylineFromWeb = bylineFromWeb.replace("By ", "");
            
            //Fix for last "," when the are various
            if(bylineFromWeb.endsWith(",")) {
                bylineFromDB = bylineFromDB+",";
            }
            
            if (Utils.compareArticleTitle(bylineFromDB, bylineFromWeb)) {
                Utils.logCorrectCheck("Byline in the page is the expected from db(" + bylineFromDB + ")");
            } else {
                Utils.logWrongCheck("Byline in the page(" + bylineFromWeb + ") is NOT the expected from db(" + bylineFromDB + ")");
            }
            Assert.assertTrue(Utils.compareArticleTitle(bylineFromDB, bylineFromWeb), "Byline in the page(" + bylineFromWeb + ") is NOT the expected from db(" + bylineFromDB + ")");
        } else {
            //Nothing expected
            if (!isBylineElementVisible()) {
                Utils.logCorrectCheck("There is not a byline on the page as it's expected.");
            } else {
                Utils.logWrongCheck("There is a byline in the page but nothing was expected from db.");
            }
            
            Assert.assertFalse(isBylineElementVisible(), "There is a byline in the page but nothing was expected from db.");
        }
    }
    
    /**
     * Verify titleline for the given url.
     *
     * @param url Article url to verify.
     * @throws InterruptedException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public void verifyTitleline(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        //Get byline from db
        ArticleQueries articleDB = new ArticleQueries();
        String titlelineFromDB = articleDB.getArticleTitleline(Utils.getSlug(url));
        
        if (titlelineFromDB != null) {
            //Something expected, then checking is visible
            if (isTitlelineElementVisible()) {
                Utils.logCorrectCheck("Titleline is present in the page.");
            } else {
                Utils.logWrongCheck("Titleline is missing in the page. Expected from db (" + titlelineFromDB + ")");
            }
            Assert.assertTrue(isTitlelineElementVisible(), "Titleline is missing in the page. Expected from db (" + titlelineFromDB + ")");
            
            //Compare both are the same
            if (Utils.compareArticleTitle(titlelineFromDB, getTitlelineText())) {
                Utils.logCorrectCheck("Titleline in the page is the expected from db(" + titlelineFromDB + ")");
            } else {
                Utils.logWrongCheck("Titleline in the page(" + getTitlelineText() + ") is NOT the expected from db(" + titlelineFromDB + ")");
            }
            Assert.assertTrue(Utils.compareArticleTitle(titlelineFromDB, getTitlelineText()), "");
        } else {
            if (!isTitlelineElementVisible()) {
                Utils.logCorrectCheck("There is not a titleline on the page as it's expected.");
            } else {
                Utils.logWrongCheck("There is a titleline in the page but nothing was expected from db.");
            }
            
            //Nothing expected
            Assert.assertFalse(isTitlelineElementVisible(), "There is a titleline in the page but nothing was expected from db.");
        }
    }
    
    @FindBy (xpath = "//div[@class='trb_article_page']")
    private WebElement bodyElement;
    
    /**
     * Verify the body content of a given article.
     *
     * @param url Article url to verify.
     * @throws SQLException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public void verifyBody(String url) throws SQLException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        goToUrl(url);
        
        ArticleQueries articleDB = new ArticleQueries();
        String bodyFromDB = articleDB.getArticleBody(Utils.getSlug(url));
        
        String firstParagraph = "";
        String bodyFromWeb = "";
        //Verifies if there is an element, and if it is displayed
        if(isBodyElementPresent()) {
            Utils.logCorrectCheck("Body is present on the page.");
            //firist i should get the firist paragraph from the db string, then clean the html on it, and then decompose
            firstParagraph = Utils.getFirstParagraph(bodyFromDB);
            //then get the htmlbody, just the paragraphs, then clean the html, then decompose
            bodyFromWeb = Utils.getParagraphText(bodyElement);
            //then find out if the result from database is contained on the html decomposed text
            if(Utils.compareStringFromDBAndWebPage(firstParagraph, bodyFromWeb) ) {
                Utils.logCorrectCheck("Body article in page is the expected from db.");
            } else {
                Utils.logWrongCheck("Body article in page is NOT the expected from db.");
            }
        } else {
            if(bodyFromDB.equals("")){
                Utils.logCorrectCheck("Body article in page is the expected from db, both are empty");
            } else {
                Utils.logWrongCheck("Body article in page is not present.");
            }
        }
        //if the body element can't be found on the webpage, check if there is a body on the DataBase
        
        Assert.assertTrue(Utils.compareStringFromDBAndWebPage(firstParagraph, bodyFromWeb), "Body article in page is NOT the expected from db.");
    }
    
    @FindBys(@FindBy ( xpath = "//header[@class='trb_article_articleHeader']/div[@class='trb_article_relatedTopics']/div[@class='trb_article_relatedTopics_list']/a" ))
    private List<WebElement> relatedTopicsList;
    
    /**
     * Get the related topic in the given position.
     *
     * @param position
     * @return A WebElement with the related topic in the given position.
     */
    private WebElement getRelatedTopicsElement(int position) {
        if (relatedTopicsList.size() == 0 || relatedTopicsList.size() <= position)
            return null;
        return relatedTopicsList.get(position);
    }
    
    /**
     * Verify the related topics are present in the article and the number of they is in the limit.
     *
     * @param url
     * @throws InterruptedException
     *
     * TODO A future improvement is verify the content against the database
     */
    public void verifyRelatedTopics(String url) throws InterruptedException {
        goToUrl(url);
        
        int relatedTopicLimit = 7;
        
        if (relatedTopicsList.size() <= relatedTopicLimit) {
            Utils.logCorrectCheck("Number of related topics is on the limit.");
        } else {
            Utils.logWrongCheck("Number of related topics is greater than the allowable limit("+relatedTopicsList.size()+")");
        }
        
        int errors = 0;
        for (int i=0; i<relatedTopicsList.size(); i++) {
            if (relatedTopicsList.get(i).isDisplayed()) {
                Utils.logCorrectCheck("related topic " + i + ": " + getRelatedTopicsElement(i).getText());
            } else {
                Utils.logWrongCheck("related topic " + i + ": " + getRelatedTopicsElement(i).getText());
                errors++;
            }
        }
        
        Assert.assertTrue(relatedTopicsList.size()<=relatedTopicLimit, "Number of related topics is greater than the allowable limit("+relatedTopicsList.size()+")");
        
        Assert.assertTrue(errors == 0, "Some errors are occurred (" + errors + "), please verify logs.");
    }
    
    /**
     * Check the visibility of logo in the masthead.
     *
     * @return True if it's visible and false if it's hidden or it doesn't exist.
     */
    public boolean isLogoElementVisible() {
        boolean visible = true;
        try {
            visible = logoElement.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        return visible;
    }
    
    /**
     * Check visibility of breadcrums based in number of elements present.
     *
     * @return True if it's visible and false if it's hidden or it doesn't exist.
     */
    public boolean isBreadcramElementVisible() {
        return breadcrumElementsList.size() != 0;
    }
    
    /**
     * Check visibility of related topics based on number of elements present.
     *
     * @return True if it's visible and false if it's hidden or it doesn't exist.
     */
    public boolean isRelatedTopicListElementVisible() {
        return relatedTopicsList.size() != 0;
    }
    
    /**
     * Check visibility of the Body Eleent on the web page
     *
     * @return True if it's visible and false if it's hidden or it doesn't exist.
     */
    public boolean isBodyElementPresent() {
        boolean visible = true;
        try {
            visible = bodyElement.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        return visible;
    }
    
    public  boolean verifyShareQuoteONFB(String shareSocialXpath,WebDriver driver,String fbXpath, String articleTitle,String quote) throws InterruptedException{
        String currentUrl = getCurrentUrl();
        String parentHandler = driver.getWindowHandle();
        String windowtitle = getTitle();
        boolean flag = false;
        
        WebDriverWait wait = new WebDriverWait(driver, 8);
        
        //trbBannerClose();
        if(shareSocialXpath != "")
            try{
                new Actions(driver).moveToElement(driver.findElement(By.xpath(shareSocialXpath))).build().perform();
            }catch(WebDriverException e1){
                Utils.writeToLog("share on social elements are not displayed:"+e1.getStackTrace());
            }
        int k =1;
        
        do{
            try{
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fbXpath)));
                new Actions(driver).moveToElement(driver.findElement(By.xpath(fbXpath))).click().build().perform();
                flag = true;
            }catch(WebDriverException e2){
                Utils.writeToLog("FB share icon is not displayed:"+e2.getStackTrace());
                driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
                new Actions(driver).moveToElement(driver.findElement(By.xpath(shareSocialXpath))).build().perform();
                
            }
            if(k==4)
                break;
            
            k++;
        }while(!flag);
        
        Assert.assertTrue(flag, "share on social elements FB , Twitter elements are not displayed");
        gigyaPage.shareViaFacebook("null", "fb1");
        
        driver.switchTo().window(parentHandler);
        
        gigyaPage.verifySharingPullQuoteOnFacebook(currentUrl, articleTitle, "facebooksharelinePQuote", windowtitle,quote);
        
        return flag;
    }
    
    
    public boolean verifyShareQuoteONTwitter(String shareSocialXpath,String twitterXpath, String articleTitle,String quote, boolean isPullquote) throws InterruptedException{
        boolean flag = false;
        String currentUrl = getCurrentUrl();
        String parentHandler = driver.getWindowHandle();
        String windowtitle = getTitle();
        
        WebDriverWait wait = new WebDriverWait(driver, 8);
        
        if(shareSocialXpath != "")
            new Actions(driver).moveToElement(driver.findElement(By.xpath(shareSocialXpath))).build().perform();
        
        
        //		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(twitterXpath))));
        
        
        new Actions(driver).moveToElement(driver.findElement(By.xpath(twitterXpath))).click().build().perform();
        
        String handler =	gigyaPage.shareViaTwitterReturnHandle("null");
        
        driver.switchTo().window(parentHandler);
        driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
        new Actions(driver).sendKeys(Keys.SPACE).build().perform();
        if(isPullquote)	
            flag =	gigyaPage.verifySharingPullQuoteOnTwitter(currentUrl, articleTitle, "TwitterlinePQuote", windowtitle,quote,handler);
        else
            flag = gigyaPage.verifySharingPullQuoteOnTwitter(currentUrl, articleTitle, "TwitterlinePQuote", windowtitle,articleTitle,handler);
        
        return flag;
    }
    // this is to close the tribune banner down the bottom inorder to make sure the elements are not being blocked by this
    public void trbBannerClose(){
        try{
            if(trbBanerClose.isDisplayed())
                trbBanerClose.click();
        }catch(WebDriverException e){
            Utils.writeToLog("no banner");
            
        }
    }
    // this is to find the tribune leaderboard on the Comments page
    public boolean isleaderboardVisible() {
        boolean visible = true;
        try {
            visible = commentsLeaderboard.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        return visible;
    }
    @FindBy(xpath="//*[@data-state='adloader_loaded'][@data-adloader-positionoverride ='c1']")
    private WebElement commentsLeaderboard;
    public void verifyCommentsAdLeaderboard(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        TribuneDriver.getInstance().waitForLoad();
        if(isleaderboardVisible()) {	
            Utils.logCorrectCheck("Leaderboard is displayed on page.");
        } else {
            Utils.logWrongCheck("Leaderboard is missing on page.");
        }
        Assert.assertTrue(isleaderboardVisible(), "leaderboard is not visible");
    }
    
    public boolean isMastheadVisible() {
        boolean visible = true;
        try {
            visible = commentsMasthead.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        return visible;
    }
    //this is to find the tribune masthead on the Comments page
    @FindBy(css="html body div.trb_allContentWrapper div.trb_article_panelWrapper div section div.trb_panelmod_openPanel header span.trb_panelmod_openPanel_title header.trb_mastheadsmall")
    private WebElement commentsMasthead;
    public void verifyCommentsMasthead(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        Thread.sleep(30000);
        TribuneDriver.getInstance().waitForLoad();
        if(isMastheadVisible()) {	
            Utils.logCorrectCheck("Masthead is displayed on page.");
        } else {
            Utils.logWrongCheck("Masthead is missing on page.");
        }
        Assert.assertTrue(isMastheadVisible(), "masthead is not visible");
    }
    public boolean isSignInLinkVisible() {
        boolean visible = true;
        try {
            visible = signInLink.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        return visible;
    }
    
    public boolean isSubmitLogInButtonVisible() {
        boolean visible = true;
        try {
            visible = submitLogInButton.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
        }
        return visible;
    }
    
    //this is to Log In to the Comments page & make a comment
    @FindBy(xpath="//a[@data-reg-handler='signInHandler']") //data-reg-text='Log In'
    private WebElement signInLink; //LOG IN LINK
    @FindBy(css = "html body div#reg-overlay div.reg-dialog.login div.reg-content form button.reg-submit")  // SIGN IN BUTTON VISIBLE AFTER EMAIL & PASSWD
    private WebElement submitLogInButton;
    @FindBy (css = "html body div.trb_allContentWrapper div.trb_article_panelWrapper div section div.trb_panelmod_openPanel section.trb_panelmod_openPanel_mainContents div.viafoura div.vf-comments.vf-widget div.vf-commenting ul.vf-comments-meta.vf-clearfix li.vf-left b b.vf-total-comments")
    private WebElement commentsElement;
    @FindBy (css = "html body div#reg-overlay div.reg-dialog.login")
    private WebElement signInPanel;
    
    //	private WebElement submitLogInButton = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-reg-handler='signInHandler']")));
    
    /**
     * Get the comments number from Comments page (#panel=comments)
     */
    private String getCommentsNumber() {
        try {
            return commentsElement.getText();
        } catch(WebDriverException e) {
            return "";
        }
    }
    
    @FindBy (css = "html body div.trb_allContentWrapper div.trb_article_panelWrapper div article.trb_article section.trb_mainContent div div.trb_article_page aside.trb_panelmod_container div.trb_panelmod_showpener div.trb_panelmod_showpener_row a.trb_panelmod_showpener_a")
    private WebElement commentsOpenerElement;
    
    /**
     * Get the comments number from the Article page 
     */
    private String getCommentsOpenerNumber() {
        try {
            return commentsOpenerElement.getText();
        } catch(WebDriverException e) {
            return "";
        }
    }
    public void signIntoCommentsAccount(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        TribuneDriver.getInstance().waitForLoad();
        if(isSignInLinkVisible()) {
            Utils.logCorrectCheck("signInLink is displayed on page.");
        } else {
            Utils.logWrongCheck("signInLink is missing on page.");
        }
        Assert.assertTrue(isSignInLinkVisible(), "signInLink is not visible");
        scrollTo(signInLink); //firefox local=waiting for evaluate.js load failed
        TribuneDriver.getInstance().waitForLoad();
        signInLink.click();
        
        signInPanel.findElement(By.name("email")).clear();
        signInPanel.findElement(By.name("email")).sendKeys("scottmaretick@tribune.com");
        signInPanel.findElement(By.name("password")).clear();
        signInPanel.findElement(By.name("password")).sendKeys("sm110751");
        TribuneDriver.getInstance().waitForLoad();
        
        //        //Wait for submitLogInButton element to be clickable
        //        WebElement waitElement = (new WebDriverWait(driver, 50)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("submitLogInButton"))));
        //        Utils.writeToLog("try wait.message:"+waitElement);
        
        if(isSubmitLogInButtonVisible()) {
            Assert.assertTrue(isSubmitLogInButtonVisible(), "submitLogInButton is not visible");
            Utils.logCorrectCheck("submitLogInButton is displayed on page.");
            //          new Actions(driver).moveToElement(driver.findElement(By.cssSelector("submitLogInButton")));
            Utils.writeToLog("try Actions.message:"+driver);
            submitLogInButton.click();
            TribuneDriver.getInstance().waitForLoad();
        } else {
            Utils.writeToLog("submitLogInButton is NOT visable");
            Utils.logWrongCheck("submitLogInButton is missing on page.");
        }
        
        //call to verify comment
        verifyCommentsPanelModBody(url);
    }
    
    public boolean isCommentsTextAreaVisible() {
        if (commentsTextArea.size() > 0) 
            return true;
        return false;
    }
    
    @FindBys(@FindBy(xpath="//div[@class='vf-comment-textarea']"))
    private List<WebElement> commentsTextArea;
    public void verifyCommentsTextArea(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        Thread.sleep(30000);
        TribuneDriver.getInstance().waitForLoad();
        if(isCommentsTextAreaVisible()) {
            Utils.logCorrectCheck("CommentsTextArea is on the page.");
        } else {
            Utils.logWrongCheck("CommentsTextArea is missing on the page.");
        }
        Assert.assertTrue(isCommentsTextAreaVisible(), "CommentsTextArea is not visible");
        if(commentsTextArea.size() > 0) {
            Utils.logCorrectCheck("commentsTextArea is there the size is:" + commentsTextArea.size());
        } else {
            Utils.logWrongCheck("commentsTextArea is not there the size is:" + commentsTextArea.size());
            Assert.fail("commentsTextArea is not there");
        }
    }
    
    public boolean isCommentsPanelModBodyVisible() {
        if (commentsPanelModBody.size() > 0) 
            return true;
        return false;
    }
    
    @FindBys(@FindBy(xpath="//div[@class='trb_panelmod_body_content']"))
    private List<WebElement> commentsPanelModBody;	
    public void verifyCommentsPanelModBody(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        String commentsNumbFromPage = getCommentsNumber();
        TribuneDriver.getInstance().waitForLoad();
        //back to Article Page using css selector
        TribuneDriver.getInstance().getDriver().findElement(By.cssSelector("html body a.trb_panelmod_closer div.trb_panelmod_closer_wedge")).click();
        //TribuneDriver.getInstance().getDriver().findElement(By.xpath("/html/body/a")).click();  XPATH
        Utils.writeToLog("commentsNumbFromPage is:" + commentsNumbFromPage);
        //commentsNumbFromPage is the number of comments on the article page
        String commentsNumbFromOpener = getCommentsOpenerNumber();
        TribuneDriver.getInstance().waitForLoad();
        Utils.writeToLog("getCommentsOpenerNumber is:" + commentsNumbFromOpener);
        //commentsNumbFromOpener is the number of comments on the article page comments opener
        if(isCommentsPanelModBodyVisible()) {
            Utils.logCorrectCheck("commentsPanelModBody is on the page.");
        } else {
            Utils.logWrongCheck("commentsPanelModBody is missing on the page.");
        }
        if(commentsPanelModBody.size() > 0) { 
            Utils.logCorrectCheck("commentsPanelModBody is there the size is:" + commentsPanelModBody.size());
        } else {
            Utils.logWrongCheck("commentsPanelModBody is not there the size is:" + commentsPanelModBody.size());
            Assert.fail("commentsPanelModBody is not there");
        }
    }
    
    public boolean isCommentsPanelOpenerVisible() {
        if (commentsPanelCloser.size() > 0)
            return true;
        return false;
    }
    
    @FindBys(@FindBy(xpath="//div[@class='trb_panelmod_showpener']"))
    private List<WebElement> commentsPanelOpener;	
    public void verifyCommentsPanelOpener(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        TribuneDriver.getInstance().waitForLoad();
        if(isCommentsPanelOpenerVisible()) {
            Utils.logCorrectCheck("commentsPanelOpener is on the page.");
        } else {
            Utils.logWrongCheck("commentsPanelOpener is missing on the page.");
            Assert.fail("commentsPanelOpener is not there");
        }
        if(commentsPanelOpener.size() > 0) {
            Utils.logCorrectCheck("commentsPanelOpener is there the size is:" + commentsPanelOpener.size());
        } else {
            Utils.logWrongCheck("commentsPanelOpener is not there the size is:" + commentsPanelOpener.size());
            Assert.fail("commentsPanelOpener is not there");
        }
    }
    public boolean isCommentsPanelCloser() {
        if (commentsPanelCloser.size() > 0)
            return true;        
        return false;
    }
    
    //@FindBy(xpath="//div[@class='trb_panelmod_closer_wedge_row']")
    //@FindBy (css = “html body a.trb_panelmod_closer div.trb_panelmod_closer_wedge”)
    //@FindBys(@FindBy(xpath="/html/body/a"))
    @FindBys(@FindBy(xpath="/html/body/a/div"))
    private List<WebElement> commentsPanelCloser;	
    public void verifyCommentsPanelCloser(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        TribuneDriver.getInstance().waitForLoad();
        if(isCommentsPanelCloser()) {	
            Utils.logCorrectCheck("commentsPanelCloser is there the size is:" + commentsPanelCloser.size());
        } else {
            Utils.logWrongCheck("commentsPanelCloser is not there the size is:" + commentsPanelCloser.size());
            Assert.fail("commentsPanelCloser problem");	
        }
    }
    
    
    public boolean isChildCommentsVisible() {
        if (childComments.size() > 0) 
            return true;
        return false;
    }
    
    @FindBys(@FindBy(xpath="//div[@class='vf-child-comments']"))
    private List<WebElement> childComments;
    public void verifyChildComments(String url) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ParseException {
        goToUrl(url);
        TribuneDriver.getInstance().waitForLoad();
        if(isChildCommentsVisible()) {
            Utils.logCorrectCheck("childComments are on the page."); //10 comments per page
        } else {
            Utils.logWrongCheck("childComments are missing on the page.");
        }
        
        if(childComments.size() > 0) {
            Utils.logCorrectCheck("childComments is there the size is:" + childComments.size());
        } else {
            Utils.logWrongCheck("childComments are not there the size is:" + childComments.size());
            Assert.fail("childComments problem");	
        }
    }
}