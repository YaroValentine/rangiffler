package org.rangiffler.db.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Entity
@Table(name = "photos")
public class PhotosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column()
    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] photo;

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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "PhotosEntity{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", countryCode='" + countryCode + '\'' +
               ", description='" + description + '\'' +
               ", photo=" + Arrays.toString(photo) +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotosEntity that = (PhotosEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(countryCode, that.countryCode) && Objects.equals(description, that.description) && Arrays.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, username, countryCode, description);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}
