// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rangiffler-photo.proto

package org.grpc.rangiffler.grpc;

public final class RangifflerPhotoProto {
  private RangifflerPhotoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Photos_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Photos_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UsernameRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UsernameRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Photo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Photo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PhotoIdRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PhotoIdRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026rangiffler-photo.proto\032\032rangiffler-cou" +
      "ntries.proto\032\033google/protobuf/empty.prot" +
      "o\" \n\006Photos\022\026\n\006photos\030\001 \003(\0132\006.Photo\"#\n\017U" +
      "sernameRequest\022\020\n\010username\030\001 \001(\t\"d\n\005Phot" +
      "o\022\n\n\002id\030\001 \001(\t\022\020\n\010username\030\002 \001(\t\022\023\n\013descr" +
      "iption\030\003 \001(\t\022\r\n\005photo\030\004 \001(\t\022\031\n\007country\030\005" +
      " \001(\0132\010.Country\"\034\n\016PhotoIdRequest\022\n\n\002id\030\001" +
      " \001(\t2\364\001\n\026RangifflerPhotoService\022/\n\020GetPh" +
      "otosForUser\022\020.UsernameRequest\032\007.Photos\"\000" +
      "\0222\n\023GetAllFriendsPhotos\022\020.UsernameReques" +
      "t\032\007.Photos\"\000\022\034\n\010AddPhoto\022\006.Photo\032\006.Photo" +
      "\"\000\022\035\n\tEditPhoto\022\006.Photo\032\006.Photo\"\000\0228\n\013Del" +
      "etePhoto\022\017.PhotoIdRequest\032\026.google.proto" +
      "buf.Empty\"\000B2\n\030org.grpc.rangiffler.grpcB" +
      "\024RangifflerPhotoProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.grpc.rangiffler.grpc.RangifflerCountriesProto.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_Photos_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Photos_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Photos_descriptor,
        new java.lang.String[] { "Photos", });
    internal_static_UsernameRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_UsernameRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UsernameRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_Photo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Photo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Photo_descriptor,
        new java.lang.String[] { "Id", "Username", "Description", "Photo", "Country", });
    internal_static_PhotoIdRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_PhotoIdRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PhotoIdRequest_descriptor,
        new java.lang.String[] { "Id", });
    org.grpc.rangiffler.grpc.RangifflerCountriesProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
