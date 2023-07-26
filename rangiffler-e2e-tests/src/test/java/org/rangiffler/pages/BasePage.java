package org.rangiffler.pages;

import io.qameta.allure.Step;

public abstract class BasePage<T extends BasePage> {

    private MainPage mainPage;
    private YourTravelsPage yourTravelsPage;
    private FriendsTravelsPage friendsTravelsPage;
    private PeopleAroundPage peopleAroundPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @Step("Check that Page loaded")
    public abstract T verifyPageLoaded();

    public MainPage mainPage() {
        return mainPage == null ? new MainPage() : mainPage;
    }

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
}
