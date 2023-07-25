package org.rangiffler.test.web;

import org.rangiffler.config.Config;
import org.rangiffler.jupiter.annotation.WebTest;
import org.rangiffler.pages.*;

@WebTest
public abstract class BaseWebTest {

    private MainPage mainPage;
    private YourTravelsPage yourTravelsPage;
    private FriendsTravelsPage friendsTravelsPage;
    private PeopleAroundPage peopleAroundPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

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
