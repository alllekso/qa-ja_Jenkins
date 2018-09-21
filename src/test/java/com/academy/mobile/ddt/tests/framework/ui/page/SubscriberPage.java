package com.academy.mobile.ddt.tests.framework.ui.page;

import com.academy.automationpractice.ddt.framework.page.BasePage;
import com.academy.mobile.ddt.tests.framework.model.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriberPage extends BasePage {

    @FindBy(css="body > div > div:nth-child(4) > div > table > tbody > tr > td:nth-child(2) > a")
    private List<WebElement> idList;

    @FindBy(css="body > div > div:nth-child(4) > div > table > tbody > tr > td:nth-child(3)")
    private List<WebElement> firstNameList;

    @FindBy(css="body > div > div:nth-child(4) > div > table > tbody > tr > td:nth-child(4)")
    private List<WebElement> lastNameList;

    @FindBy(css="body > div > div:nth-child(4) > div > table > tbody > tr > td:nth-child(5)")
    private List<WebElement> ageList;

    @FindBy(css="body > div > div:nth-child(4) > div > table > tbody > tr > td:nth-child(6)")
    private List<WebElement> genderList;

    public SubscriberPage(WebDriver driver) {
        super(driver);
    }

    public List<Long> getIdList() {
        return
                idList.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .map(Long::valueOf)
                        .collect(Collectors.toList());
    }

    public List<String> getFirstNameList() {
        return
                firstNameList.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .collect(Collectors.toList());
    }

    public List<String> getLastNameList() {
        return
                lastNameList.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .collect(Collectors.toList());
    }

    public List<Gender> getGenderList() {
        return
                genderList.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .map(s->s.charAt(0))
                        .map(Gender::fromRu)
                        .collect(Collectors.toList());
    }

    public List<Integer> getAgeList() {
        return
                ageList.stream()
                        .map(WebElement::getText)
                        .map(String::trim)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
    }
}