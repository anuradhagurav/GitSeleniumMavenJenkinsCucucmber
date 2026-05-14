package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class GoogleSearch {
	WebDriver driver;
	public GoogleSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private By searchBox = By.name("q");
//
	public void EnterKeyword(String keyword) {
		driver.findElement(searchBox).sendKeys(keyword);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
	
	
	@FindBy(id="name")
	WebElement name;
	public void enterKeyword(String keyword) {
		name.sendKeys(keyword);
	}
	
}