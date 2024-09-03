package com.netBanking1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccount
{
    WebDriver ldriver;
    
    private @FindBy(xpath="/html/body/div[3]/div/ul/li[5]/a")
    WebElement NewAccountBtn;
    
	private @FindBy(name="cusid")
	WebElement cusId;
	
	private @FindBy(name="selaccount")
	WebElement AccntType;
	
	private @FindBy(name="inideposit")
	WebElement InitDepo;
	
	private @FindBy(how=How.NAME,using="button2" )
	WebElement Submit;
	
	public void ClickNewAccountBtn()
	{
		NewAccountBtn.click();
	}
	
	
	public void setCusID(String CusId)
	{
		cusId.sendKeys(CusId);
		
	}
	
	public void setAccntType(String AccountType)
	{
		Select select=new Select(AccntType);
		select.selectByVisibleText(AccountType);
	}
	
	public void setInitDepo(String IntialDepo)
	{
		InitDepo.sendKeys(IntialDepo);
	}
	
	public void ClickSubmit()
	{
		Submit.click();
	}
	
	public NewAccount(WebDriver sDriver)
	{
		this.ldriver=sDriver;
		PageFactory.initElements(sDriver, this);
	}
	
}
