// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rangiffler-photo.proto

package org.grpc.rangiffler.grpc;

public interface PhotoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Photo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string username = 2;</code>
   * @return The username.
   */
  java.lang.String getUsername();
  /**
   * <code>string username = 2;</code>
   * @return The bytes for username.
   */
  com.google.protobuf.ByteString
      getUsernameBytes();

  /**
   * <code>string description = 3;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 3;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string photo = 4;</code>
   * @return The photo.
   */
  java.lang.String getPhoto();
  /**
   * <code>string photo = 4;</code>
   * @return The bytes for photo.
   */
  com.google.protobuf.ByteString
      getPhotoBytes();

  /**
   * <code>.Country country = 5;</code>
   * @return Whether the country field is set.
   */
  boolean hasCountry();
  /**
   * <code>.Country country = 5;</code>
   * @return The country.
   */
  org.grpc.rangiffler.grpc.Country getCountry();
  /**
   * <code>.Country country = 5;</code>
   */
  org.grpc.rangiffler.grpc.CountryOrBuilder getCountryOrBuilder();
}