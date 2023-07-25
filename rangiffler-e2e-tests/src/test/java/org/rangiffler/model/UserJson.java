package org.rangiffler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class UserJson {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("username")
    private String username;
    private transient String password;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("photo")
    private String avatar;
    @JsonProperty("friendStatus")
    private FriendStatus friendStatus;

    private transient List<UserJson> friends = new ArrayList<>();
    private transient List<UserJson> outcomeInvitations = new ArrayList<>();
    private transient List<UserJson> incomeInvitations = new ArrayList<>();
    private transient List<UserJson> photos = new ArrayList<>();

    public UserJson() {
    }

    public List<UserJson> getPhotos() {

        return photos;
    }

    public void setPhotos(List<UserJson> photos) {
        this.photos = photos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<UserJson> getFriends() {
        return friends;
    }

    public void setFriends(List<UserJson> friends) {
        this.friends = friends;
    }

    public List<UserJson> getOutcomeInvitations() {
        return outcomeInvitations;
    }

    public void setOutcomeInvitations(List<UserJson> outcomeInvitations) {
        this.outcomeInvitations = outcomeInvitations;
    }

    public List<UserJson> getIncomeInvitations() {
        return incomeInvitations;
    }

    public void setIncomeInvitations(List<UserJson> incomeInvitations) {
        this.incomeInvitations = incomeInvitations;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public FriendStatus getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(FriendStatus friendStatus) {
        this.friendStatus = friendStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJson userJson = (UserJson) o;
        return Objects.equals(id, userJson.id) && Objects.equals(username, userJson.username) && Objects.equals(password, userJson.password) && Objects.equals(firstname, userJson.firstname) && Objects.equals(surname, userJson.surname) && Objects.equals(avatar, userJson.avatar) && friendStatus == userJson.friendStatus && Objects.equals(friends, userJson.friends) && Objects.equals(outcomeInvitations, userJson.outcomeInvitations) && Objects.equals(incomeInvitations, userJson.incomeInvitations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstname, surname, avatar, friendStatus, friends, outcomeInvitations, incomeInvitations);
    }

    @Override
    public String toString() {
        return "UserJson{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", firstname='" + firstname + '\'' +
               ", surname='" + surname + '\'' +
               ", avatar='" + avatar + '\'' +
               ", friendStatus=" + friendStatus +
               ", friends=" + friends +
               ", outcomeInvitations=" + outcomeInvitations +
               ", incomeInvitations=" + incomeInvitations +
               '}';
    }

}
