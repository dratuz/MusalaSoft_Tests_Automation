package pages.components;

import core.BasePageAction;
import org.openqa.selenium.By;
import utils.Browser;

public class PageHeader extends BasePageAction {
    private static final By HEADER_COMPANY_ELEMENT = By.xpath("//*[@id=\"menu-main-nav-1\"]/li[1]/a");
    private static final By HEADER_CAREERS_ELEMENT = By.xpath("//*[@id=\"menu-main-nav-1\"]/li[5]/a");

    /**
     * Open Company page from the header
     */
    public static void openCompanyPage(){
        click(HEADER_COMPANY_ELEMENT);
    }

    public static void openCareersPage() {
        click(HEADER_CAREERS_ELEMENT);
    }
}
