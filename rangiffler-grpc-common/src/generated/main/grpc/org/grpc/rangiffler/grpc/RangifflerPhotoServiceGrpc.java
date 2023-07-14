package org.grpc.rangiffler.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: rangiffler-photo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RangifflerPhotoServiceGrpc {

  private RangifflerPhotoServiceGrpc() {}

  public static final String SERVICE_NAME = "RangifflerPhotoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.UsernameRequest,
      org.grpc.rangiffler.grpc.Photos> getGetPhotosForUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhotosForUser",
      requestType = org.grpc.rangiffler.grpc.UsernameRequest.class,
      responseType = org.grpc.rangiffler.grpc.Photos.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.UsernameRequest,
      org.grpc.rangiffler.grpc.Photos> getGetPhotosForUserMethod() {
    io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.UsernameRequest, org.grpc.rangiffler.grpc.Photos> getGetPhotosForUserMethod;
    if ((getGetPhotosForUserMethod = RangifflerPhotoServiceGrpc.getGetPhotosForUserMethod) == null) {
      synchronized (RangifflerPhotoServiceGrpc.class) {
        if ((getGetPhotosForUserMethod = RangifflerPhotoServiceGrpc.getGetPhotosForUserMethod) == null) {
          RangifflerPhotoServiceGrpc.getGetPhotosForUserMethod = getGetPhotosForUserMethod =
              io.grpc.MethodDescriptor.<org.grpc.rangiffler.grpc.UsernameRequest, org.grpc.rangiffler.grpc.Photos>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhotosForUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.UsernameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.Photos.getDefaultInstance()))
              .setSchemaDescriptor(new RangifflerPhotoServiceMethodDescriptorSupplier("GetPhotosForUser"))
              .build();
        }
      }
    }
    return getGetPhotosForUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.UsernameRequest,
      org.grpc.rangiffler.grpc.Photos> getGetAllFriendsPhotosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllFriendsPhotos",
      requestType = org.grpc.rangiffler.grpc.UsernameRequest.class,
      responseType = org.grpc.rangiffler.grpc.Photos.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.UsernameRequest,
      org.grpc.rangiffler.grpc.Photos> getGetAllFriendsPhotosMethod() {
    io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.UsernameRequest, org.grpc.rangiffler.grpc.Photos> getGetAllFriendsPhotosMethod;
    if ((getGetAllFriendsPhotosMethod = RangifflerPhotoServiceGrpc.getGetAllFriendsPhotosMethod) == null) {
      synchronized (RangifflerPhotoServiceGrpc.class) {
        if ((getGetAllFriendsPhotosMethod = RangifflerPhotoServiceGrpc.getGetAllFriendsPhotosMethod) == null) {
          RangifflerPhotoServiceGrpc.getGetAllFriendsPhotosMethod = getGetAllFriendsPhotosMethod =
              io.grpc.MethodDescriptor.<org.grpc.rangiffler.grpc.UsernameRequest, org.grpc.rangiffler.grpc.Photos>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllFriendsPhotos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.UsernameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.Photos.getDefaultInstance()))
              .setSchemaDescriptor(new RangifflerPhotoServiceMethodDescriptorSupplier("GetAllFriendsPhotos"))
              .build();
        }
      }
    }
    return getGetAllFriendsPhotosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.Photo,
      org.grpc.rangiffler.grpc.Photo> getAddPhotoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddPhoto",
      requestType = org.grpc.rangiffler.grpc.Photo.class,
      responseType = org.grpc.rangiffler.grpc.Photo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.Photo,
      org.grpc.rangiffler.grpc.Photo> getAddPhotoMethod() {
    io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.Photo, org.grpc.rangiffler.grpc.Photo> getAddPhotoMethod;
    if ((getAddPhotoMethod = RangifflerPhotoServiceGrpc.getAddPhotoMethod) == null) {
      synchronized (RangifflerPhotoServiceGrpc.class) {
        if ((getAddPhotoMethod = RangifflerPhotoServiceGrpc.getAddPhotoMethod) == null) {
          RangifflerPhotoServiceGrpc.getAddPhotoMethod = getAddPhotoMethod =
              io.grpc.MethodDescriptor.<org.grpc.rangiffler.grpc.Photo, org.grpc.rangiffler.grpc.Photo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddPhoto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.Photo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.Photo.getDefaultInstance()))
              .setSchemaDescriptor(new RangifflerPhotoServiceMethodDescriptorSupplier("AddPhoto"))
              .build();
        }
      }
    }
    return getAddPhotoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.Photo,
      org.grpc.rangiffler.grpc.Photo> getEditPhotoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EditPhoto",
      requestType = org.grpc.rangiffler.grpc.Photo.class,
      responseType = org.grpc.rangiffler.grpc.Photo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.Photo,
      org.grpc.rangiffler.grpc.Photo> getEditPhotoMethod() {
    io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.Photo, org.grpc.rangiffler.grpc.Photo> getEditPhotoMethod;
    if ((getEditPhotoMethod = RangifflerPhotoServiceGrpc.getEditPhotoMethod) == null) {
      synchronized (RangifflerPhotoServiceGrpc.class) {
        if ((getEditPhotoMethod = RangifflerPhotoServiceGrpc.getEditPhotoMethod) == null) {
          RangifflerPhotoServiceGrpc.getEditPhotoMethod = getEditPhotoMethod =
              io.grpc.MethodDescriptor.<org.grpc.rangiffler.grpc.Photo, org.grpc.rangiffler.grpc.Photo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EditPhoto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.Photo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.Photo.getDefaultInstance()))
              .setSchemaDescriptor(new RangifflerPhotoServiceMethodDescriptorSupplier("EditPhoto"))
              .build();
        }
      }
    }
    return getEditPhotoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.PhotoIdRequest,
      com.google.protobuf.Empty> getDeletePhotoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePhoto",
      requestType = org.grpc.rangiffler.grpc.PhotoIdRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.PhotoIdRequest,
      com.google.protobuf.Empty> getDeletePhotoMethod() {
    io.grpc.MethodDescriptor<org.grpc.rangiffler.grpc.PhotoIdRequest, com.google.protobuf.Empty> getDeletePhotoMethod;
    if ((getDeletePhotoMethod = RangifflerPhotoServiceGrpc.getDeletePhotoMethod) == null) {
      synchronized (RangifflerPhotoServiceGrpc.class) {
        if ((getDeletePhotoMethod = RangifflerPhotoServiceGrpc.getDeletePhotoMethod) == null) {
          RangifflerPhotoServiceGrpc.getDeletePhotoMethod = getDeletePhotoMethod =
              io.grpc.MethodDescriptor.<org.grpc.rangiffler.grpc.PhotoIdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePhoto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.grpc.rangiffler.grpc.PhotoIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RangifflerPhotoServiceMethodDescriptorSupplier("DeletePhoto"))
              .build();
        }
      }
    }
    return getDeletePhotoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RangifflerPhotoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RangifflerPhotoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RangifflerPhotoServiceStub>() {
        @java.lang.Override
        public RangifflerPhotoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RangifflerPhotoServiceStub(channel, callOptions);
        }
      };
    return RangifflerPhotoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RangifflerPhotoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RangifflerPhotoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RangifflerPhotoServiceBlockingStub>() {
        @java.lang.Override
        public RangifflerPhotoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RangifflerPhotoServiceBlockingStub(channel, callOptions);
        }
      };
    return RangifflerPhotoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RangifflerPhotoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RangifflerPhotoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RangifflerPhotoServiceFutureStub>() {
        @java.lang.Override
        public RangifflerPhotoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RangifflerPhotoServiceFutureStub(channel, callOptions);
        }
      };
    return RangifflerPhotoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RangifflerPhotoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPhotosForUser(org.grpc.rangiffler.grpc.UsernameRequest request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photos> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPhotosForUserMethod(), responseObserver);
    }

    /**
     */
    public void getAllFriendsPhotos(org.grpc.rangiffler.grpc.UsernameRequest request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photos> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllFriendsPhotosMethod(), responseObserver);
    }

    /**
     */
    public void addPhoto(org.grpc.rangiffler.grpc.Photo request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddPhotoMethod(), responseObserver);
    }

    /**
     */
    public void editPhoto(org.grpc.rangiffler.grpc.Photo request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEditPhotoMethod(), responseObserver);
    }

    /**
     */
    public void deletePhoto(org.grpc.rangiffler.grpc.PhotoIdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePhotoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPhotosForUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.grpc.rangiffler.grpc.UsernameRequest,
                org.grpc.rangiffler.grpc.Photos>(
                  this, METHODID_GET_PHOTOS_FOR_USER)))
          .addMethod(
            getGetAllFriendsPhotosMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.grpc.rangiffler.grpc.UsernameRequest,
                org.grpc.rangiffler.grpc.Photos>(
                  this, METHODID_GET_ALL_FRIENDS_PHOTOS)))
          .addMethod(
            getAddPhotoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.grpc.rangiffler.grpc.Photo,
                org.grpc.rangiffler.grpc.Photo>(
                  this, METHODID_ADD_PHOTO)))
          .addMethod(
            getEditPhotoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.grpc.rangiffler.grpc.Photo,
                org.grpc.rangiffler.grpc.Photo>(
                  this, METHODID_EDIT_PHOTO)))
          .addMethod(
            getDeletePhotoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.grpc.rangiffler.grpc.PhotoIdRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_PHOTO)))
          .build();
    }
  }

  /**
   */
  public static final class RangifflerPhotoServiceStub extends io.grpc.stub.AbstractAsyncStub<RangifflerPhotoServiceStub> {
    private RangifflerPhotoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RangifflerPhotoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RangifflerPhotoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPhotosForUser(org.grpc.rangiffler.grpc.UsernameRequest request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photos> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPhotosForUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllFriendsPhotos(org.grpc.rangiffler.grpc.UsernameRequest request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photos> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllFriendsPhotosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addPhoto(org.grpc.rangiffler.grpc.Photo request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddPhotoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editPhoto(org.grpc.rangiffler.grpc.Photo request,
        io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEditPhotoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deletePhoto(org.grpc.rangiffler.grpc.PhotoIdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePhotoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RangifflerPhotoServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RangifflerPhotoServiceBlockingStub> {
    private RangifflerPhotoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RangifflerPhotoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RangifflerPhotoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.grpc.rangiffler.grpc.Photos getPhotosForUser(org.grpc.rangiffler.grpc.UsernameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhotosForUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.grpc.rangiffler.grpc.Photos getAllFriendsPhotos(org.grpc.rangiffler.grpc.UsernameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllFriendsPhotosMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.grpc.rangiffler.grpc.Photo addPhoto(org.grpc.rangiffler.grpc.Photo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddPhotoMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.grpc.rangiffler.grpc.Photo editPhoto(org.grpc.rangiffler.grpc.Photo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEditPhotoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deletePhoto(org.grpc.rangiffler.grpc.PhotoIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePhotoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RangifflerPhotoServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RangifflerPhotoServiceFutureStub> {
    private RangifflerPhotoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RangifflerPhotoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RangifflerPhotoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.grpc.rangiffler.grpc.Photos> getPhotosForUser(
        org.grpc.rangiffler.grpc.UsernameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPhotosForUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.grpc.rangiffler.grpc.Photos> getAllFriendsPhotos(
        org.grpc.rangiffler.grpc.UsernameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllFriendsPhotosMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.grpc.rangiffler.grpc.Photo> addPhoto(
        org.grpc.rangiffler.grpc.Photo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddPhotoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.grpc.rangiffler.grpc.Photo> editPhoto(
        org.grpc.rangiffler.grpc.Photo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEditPhotoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deletePhoto(
        org.grpc.rangiffler.grpc.PhotoIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePhotoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PHOTOS_FOR_USER = 0;
  private static final int METHODID_GET_ALL_FRIENDS_PHOTOS = 1;
  private static final int METHODID_ADD_PHOTO = 2;
  private static final int METHODID_EDIT_PHOTO = 3;
  private static final int METHODID_DELETE_PHOTO = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RangifflerPhotoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RangifflerPhotoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PHOTOS_FOR_USER:
          serviceImpl.getPhotosForUser((org.grpc.rangiffler.grpc.UsernameRequest) request,
              (io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photos>) responseObserver);
          break;
        case METHODID_GET_ALL_FRIENDS_PHOTOS:
          serviceImpl.getAllFriendsPhotos((org.grpc.rangiffler.grpc.UsernameRequest) request,
              (io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photos>) responseObserver);
          break;
        case METHODID_ADD_PHOTO:
          serviceImpl.addPhoto((org.grpc.rangiffler.grpc.Photo) request,
              (io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photo>) responseObserver);
          break;
        case METHODID_EDIT_PHOTO:
          serviceImpl.editPhoto((org.grpc.rangiffler.grpc.Photo) request,
              (io.grpc.stub.StreamObserver<org.grpc.rangiffler.grpc.Photo>) responseObserver);
          break;
        case METHODID_DELETE_PHOTO:
          serviceImpl.deletePhoto((org.grpc.rangiffler.grpc.PhotoIdRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RangifflerPhotoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RangifflerPhotoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.grpc.rangiffler.grpc.RangifflerPhotoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RangifflerPhotoService");
    }
  }

  private static final class RangifflerPhotoServiceFileDescriptorSupplier
      extends RangifflerPhotoServiceBaseDescriptorSupplier {
    RangifflerPhotoServiceFileDescriptorSupplier() {}
  }

  private static final class RangifflerPhotoServiceMethodDescriptorSupplier
      extends RangifflerPhotoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RangifflerPhotoServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RangifflerPhotoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RangifflerPhotoServiceFileDescriptorSupplier())
              .addMethod(getGetPhotosForUserMethod())
              .addMethod(getGetAllFriendsPhotosMethod())
              .addMethod(getAddPhotoMethod())
              .addMethod(getEditPhotoMethod())
              .addMethod(getDeletePhotoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
