package org.rangiffler.pages;

import io.qameta.allure.Step;
import org.rangiffler.pages.component.MenuComponent;

public abstract class BasePage<T extends BasePage> {

    private YourTravelsPage yourTravelsPage;
    private FriendsTravelsPage friendsTravelsPage;
    private PeopleAroundPage peopleAroundPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private MenuComponent menuComponent;

    @Step("Check that Page loaded")
    public abstract T verifyPageLoaded();

    public YourTravelsPage travelsPage() {
        return yourTravelsPage == null ? new YourTravelsPage() : yourTravelsPage;
    }

    public FriendsTravelsPage friendsTravelsPage() {
        return friendsTravelsPage == null ? new FriendsTravelsPage() : friendsTravelsPage;
    }

    public PeopleAroundPage peopleAroundPage() {
        return peopleAroundPage == null ? new PeopleAroundPage() : peopleAroundPage;
    }

    public LoginPage loginPage() {
        return loginPage == null ? new LoginPage() : loginPage;
    }

    public RegistrationPage registrationPage() {
        return registrationPage == null ? new RegistrationPage() : registrationPage;
    }

    public MenuComponent navigation() {
        return menuComponent == null ? new MenuComponent() : menuComponent;
    }
}
