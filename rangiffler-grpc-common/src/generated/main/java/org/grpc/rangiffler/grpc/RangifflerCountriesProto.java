// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rangiffler-countries.proto

package org.grpc.rangiffler.grpc;

public final class RangifflerCountriesProto {
  private RangifflerCountriesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Country_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Country_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Countries_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Countries_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CountryByCodeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CountryByCodeRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032rangiffler-countries.proto\032\033google/pro" +
      "tobuf/empty.proto\"?\n\007Country\022\n\n\002id\030\001 \001(\t" +
      "\022\023\n\013countryName\030\002 \001(\t\022\023\n\013countryCode\030\003 \001" +
      "(\t\"+\n\tCountries\022\036\n\014allCountries\030\001 \003(\0132\010." +
      "Country\"$\n\024CountryByCodeRequest\022\014\n\004code\030" +
      "\001 \001(\t2\213\001\n\032RangifflerCountriesService\0224\n\014" +
      "getCountries\022\026.google.protobuf.Empty\032\n.C" +
      "ountries\"\000\0227\n\022getCountriesByCode\022\025.Count" +
      "ryByCodeRequest\032\010.Country\"\000B6\n\030org.grpc." +
      "rangiffler.grpcB\030RangifflerCountriesProt" +
      "oP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_Country_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Country_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Country_descriptor,
        new java.lang.String[] { "Id", "CountryName", "CountryCode", });
    internal_static_Countries_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Countries_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Countries_descriptor,
        new java.lang.String[] { "AllCountries", });
    internal_static_CountryByCodeRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CountryByCodeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CountryByCodeRequest_descriptor,
        new java.lang.String[] { "Code", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}