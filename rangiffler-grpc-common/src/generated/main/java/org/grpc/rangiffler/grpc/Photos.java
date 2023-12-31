// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rangiffler-photo.proto

package org.grpc.rangiffler.grpc;

/**
 * Protobuf type {@code Photos}
 */
public final class Photos extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Photos)
    PhotosOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Photos.newBuilder() to construct.
  private Photos(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Photos() {
    photos_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Photos();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.grpc.rangiffler.grpc.RangifflerPhotoProto.internal_static_Photos_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.grpc.rangiffler.grpc.RangifflerPhotoProto.internal_static_Photos_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.grpc.rangiffler.grpc.Photos.class, org.grpc.rangiffler.grpc.Photos.Builder.class);
  }

  public static final int PHOTOS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<org.grpc.rangiffler.grpc.Photo> photos_;
  /**
   * <code>repeated .Photo photos = 1;</code>
   */
  @java.lang.Override
  public java.util.List<org.grpc.rangiffler.grpc.Photo> getPhotosList() {
    return photos_;
  }
  /**
   * <code>repeated .Photo photos = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.grpc.rangiffler.grpc.PhotoOrBuilder> 
      getPhotosOrBuilderList() {
    return photos_;
  }
  /**
   * <code>repeated .Photo photos = 1;</code>
   */
  @java.lang.Override
  public int getPhotosCount() {
    return photos_.size();
  }
  /**
   * <code>repeated .Photo photos = 1;</code>
   */
  @java.lang.Override
  public org.grpc.rangiffler.grpc.Photo getPhotos(int index) {
    return photos_.get(index);
  }
  /**
   * <code>repeated .Photo photos = 1;</code>
   */
  @java.lang.Override
  public org.grpc.rangiffler.grpc.PhotoOrBuilder getPhotosOrBuilder(
      int index) {
    return photos_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < photos_.size(); i++) {
      output.writeMessage(1, photos_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < photos_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, photos_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.grpc.rangiffler.grpc.Photos)) {
      return super.equals(obj);
    }
    org.grpc.rangiffler.grpc.Photos other = (org.grpc.rangiffler.grpc.Photos) obj;

    if (!getPhotosList()
        .equals(other.getPhotosList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getPhotosCount() > 0) {
      hash = (37 * hash) + PHOTOS_FIELD_NUMBER;
      hash = (53 * hash) + getPhotosList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.grpc.rangiffler.grpc.Photos parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.grpc.rangiffler.grpc.Photos parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.grpc.rangiffler.grpc.Photos parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.grpc.rangiffler.grpc.Photos prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Photos}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Photos)
      org.grpc.rangiffler.grpc.PhotosOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.grpc.rangiffler.grpc.RangifflerPhotoProto.internal_static_Photos_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.grpc.rangiffler.grpc.RangifflerPhotoProto.internal_static_Photos_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.grpc.rangiffler.grpc.Photos.class, org.grpc.rangiffler.grpc.Photos.Builder.class);
    }

    // Construct using org.grpc.rangiffler.grpc.Photos.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (photosBuilder_ == null) {
        photos_ = java.util.Collections.emptyList();
      } else {
        photos_ = null;
        photosBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.grpc.rangiffler.grpc.RangifflerPhotoProto.internal_static_Photos_descriptor;
    }

    @java.lang.Override
    public org.grpc.rangiffler.grpc.Photos getDefaultInstanceForType() {
      return org.grpc.rangiffler.grpc.Photos.getDefaultInstance();
    }

    @java.lang.Override
    public org.grpc.rangiffler.grpc.Photos build() {
      org.grpc.rangiffler.grpc.Photos result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.grpc.rangiffler.grpc.Photos buildPartial() {
      org.grpc.rangiffler.grpc.Photos result = new org.grpc.rangiffler.grpc.Photos(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(org.grpc.rangiffler.grpc.Photos result) {
      if (photosBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          photos_ = java.util.Collections.unmodifiableList(photos_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.photos_ = photos_;
      } else {
        result.photos_ = photosBuilder_.build();
      }
    }

    private void buildPartial0(org.grpc.rangiffler.grpc.Photos result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.grpc.rangiffler.grpc.Photos) {
        return mergeFrom((org.grpc.rangiffler.grpc.Photos)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.grpc.rangiffler.grpc.Photos other) {
      if (other == org.grpc.rangiffler.grpc.Photos.getDefaultInstance()) return this;
      if (photosBuilder_ == null) {
        if (!other.photos_.isEmpty()) {
          if (photos_.isEmpty()) {
            photos_ = other.photos_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePhotosIsMutable();
            photos_.addAll(other.photos_);
          }
          onChanged();
        }
      } else {
        if (!other.photos_.isEmpty()) {
          if (photosBuilder_.isEmpty()) {
            photosBuilder_.dispose();
            photosBuilder_ = null;
            photos_ = other.photos_;
            bitField0_ = (bitField0_ & ~0x00000001);
            photosBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPhotosFieldBuilder() : null;
          } else {
            photosBuilder_.addAllMessages(other.photos_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              org.grpc.rangiffler.grpc.Photo m =
                  input.readMessage(
                      org.grpc.rangiffler.grpc.Photo.parser(),
                      extensionRegistry);
              if (photosBuilder_ == null) {
                ensurePhotosIsMutable();
                photos_.add(m);
              } else {
                photosBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<org.grpc.rangiffler.grpc.Photo> photos_ =
      java.util.Collections.emptyList();
    private void ensurePhotosIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        photos_ = new java.util.ArrayList<org.grpc.rangiffler.grpc.Photo>(photos_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.grpc.rangiffler.grpc.Photo, org.grpc.rangiffler.grpc.Photo.Builder, org.grpc.rangiffler.grpc.PhotoOrBuilder> photosBuilder_;

    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public java.util.List<org.grpc.rangiffler.grpc.Photo> getPhotosList() {
      if (photosBuilder_ == null) {
        return java.util.Collections.unmodifiableList(photos_);
      } else {
        return photosBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public int getPhotosCount() {
      if (photosBuilder_ == null) {
        return photos_.size();
      } else {
        return photosBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public org.grpc.rangiffler.grpc.Photo getPhotos(int index) {
      if (photosBuilder_ == null) {
        return photos_.get(index);
      } else {
        return photosBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder setPhotos(
        int index, org.grpc.rangiffler.grpc.Photo value) {
      if (photosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePhotosIsMutable();
        photos_.set(index, value);
        onChanged();
      } else {
        photosBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder setPhotos(
        int index, org.grpc.rangiffler.grpc.Photo.Builder builderForValue) {
      if (photosBuilder_ == null) {
        ensurePhotosIsMutable();
        photos_.set(index, builderForValue.build());
        onChanged();
      } else {
        photosBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder addPhotos(org.grpc.rangiffler.grpc.Photo value) {
      if (photosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePhotosIsMutable();
        photos_.add(value);
        onChanged();
      } else {
        photosBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder addPhotos(
        int index, org.grpc.rangiffler.grpc.Photo value) {
      if (photosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePhotosIsMutable();
        photos_.add(index, value);
        onChanged();
      } else {
        photosBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder addPhotos(
        org.grpc.rangiffler.grpc.Photo.Builder builderForValue) {
      if (photosBuilder_ == null) {
        ensurePhotosIsMutable();
        photos_.add(builderForValue.build());
        onChanged();
      } else {
        photosBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder addPhotos(
        int index, org.grpc.rangiffler.grpc.Photo.Builder builderForValue) {
      if (photosBuilder_ == null) {
        ensurePhotosIsMutable();
        photos_.add(index, builderForValue.build());
        onChanged();
      } else {
        photosBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder addAllPhotos(
        java.lang.Iterable<? extends org.grpc.rangiffler.grpc.Photo> values) {
      if (photosBuilder_ == null) {
        ensurePhotosIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, photos_);
        onChanged();
      } else {
        photosBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder clearPhotos() {
      if (photosBuilder_ == null) {
        photos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        photosBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public Builder removePhotos(int index) {
      if (photosBuilder_ == null) {
        ensurePhotosIsMutable();
        photos_.remove(index);
        onChanged();
      } else {
        photosBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public org.grpc.rangiffler.grpc.Photo.Builder getPhotosBuilder(
        int index) {
      return getPhotosFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public org.grpc.rangiffler.grpc.PhotoOrBuilder getPhotosOrBuilder(
        int index) {
      if (photosBuilder_ == null) {
        return photos_.get(index);  } else {
        return photosBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public java.util.List<? extends org.grpc.rangiffler.grpc.PhotoOrBuilder> 
         getPhotosOrBuilderList() {
      if (photosBuilder_ != null) {
        return photosBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(photos_);
      }
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public org.grpc.rangiffler.grpc.Photo.Builder addPhotosBuilder() {
      return getPhotosFieldBuilder().addBuilder(
          org.grpc.rangiffler.grpc.Photo.getDefaultInstance());
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public org.grpc.rangiffler.grpc.Photo.Builder addPhotosBuilder(
        int index) {
      return getPhotosFieldBuilder().addBuilder(
          index, org.grpc.rangiffler.grpc.Photo.getDefaultInstance());
    }
    /**
     * <code>repeated .Photo photos = 1;</code>
     */
    public java.util.List<org.grpc.rangiffler.grpc.Photo.Builder> 
         getPhotosBuilderList() {
      return getPhotosFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.grpc.rangiffler.grpc.Photo, org.grpc.rangiffler.grpc.Photo.Builder, org.grpc.rangiffler.grpc.PhotoOrBuilder> 
        getPhotosFieldBuilder() {
      if (photosBuilder_ == null) {
        photosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.grpc.rangiffler.grpc.Photo, org.grpc.rangiffler.grpc.Photo.Builder, org.grpc.rangiffler.grpc.PhotoOrBuilder>(
                photos_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        photos_ = null;
      }
      return photosBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Photos)
  }

  // @@protoc_insertion_point(class_scope:Photos)
  private static final org.grpc.rangiffler.grpc.Photos DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.grpc.rangiffler.grpc.Photos();
  }

  public static org.grpc.rangiffler.grpc.Photos getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Photos>
      PARSER = new com.google.protobuf.AbstractParser<Photos>() {
    @java.lang.Override
    public Photos parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Photos> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Photos> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.grpc.rangiffler.grpc.Photos getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

