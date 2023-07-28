package org.rangiffler.db.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "friends")
@IdClass(FriendsId.class)
public class FriendsEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserdataEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    private UserdataEntity friend;

    @Column(name = "pending")
    private boolean pending;

    public UserdataEntity getUser() {
        return user;
    }

    public void setUser(UserdataEntity user) {
        this.user = user;
    }

    public UserdataEntity getFriend() {
        return friend;
    }

    public void setFriend(UserdataEntity friend) {
        this.friend = friend;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsEntity that = (FriendsEntity) o;
        return pending == that.pending && Objects.equals(user, that.user) && Objects.equals(friend, that.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, friend, pending);
    }
}