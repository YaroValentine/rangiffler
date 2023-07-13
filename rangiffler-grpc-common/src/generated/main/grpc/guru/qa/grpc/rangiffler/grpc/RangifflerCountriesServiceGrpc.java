package guru.qa.grpc.rangiffler.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: rangiffler-countries.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RangifflerCountriesServiceGrpc {

  private RangifflerCountriesServiceGrpc() {}

  public static final String SERVICE_NAME = "RangifflerCountriesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      guru.qa.grpc.rangiffler.grpc.Countries> getGetCountriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCountries",
      requestType = com.google.protobuf.Empty.class,
      responseType = guru.qa.grpc.rangiffler.grpc.Countries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      guru.qa.grpc.rangiffler.grpc.Countries> getGetCountriesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, guru.qa.grpc.rangiffler.grpc.Countries> getGetCountriesMethod;
    if ((getGetCountriesMethod = RangifflerCountriesServiceGrpc.getGetCountriesMethod) == null) {
      synchronized (RangifflerCountriesServiceGrpc.class) {
        if ((getGetCountriesMethod = RangifflerCountriesServiceGrpc.getGetCountriesMethod) == null) {
          RangifflerCountriesServiceGrpc.getGetCountriesMethod = getGetCountriesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, guru.qa.grpc.rangiffler.grpc.Countries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCountries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rangiffler.grpc.Countries.getDefaultInstance()))
              .setSchemaDescriptor(new RangifflerCountriesServiceMethodDescriptorSupplier("getCountries"))
              .build();
        }
      }
    }
    return getGetCountriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest,
      guru.qa.grpc.rangiffler.grpc.Country> getGetCountriesByCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCountriesByCode",
      requestType = guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest.class,
      responseType = guru.qa.grpc.rangiffler.grpc.Country.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest,
      guru.qa.grpc.rangiffler.grpc.Country> getGetCountriesByCodeMethod() {
    io.grpc.MethodDescriptor<guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest, guru.qa.grpc.rangiffler.grpc.Country> getGetCountriesByCodeMethod;
    if ((getGetCountriesByCodeMethod = RangifflerCountriesServiceGrpc.getGetCountriesByCodeMethod) == null) {
      synchronized (RangifflerCountriesServiceGrpc.class) {
        if ((getGetCountriesByCodeMethod = RangifflerCountriesServiceGrpc.getGetCountriesByCodeMethod) == null) {
          RangifflerCountriesServiceGrpc.getGetCountriesByCodeMethod = getGetCountriesByCodeMethod =
              io.grpc.MethodDescriptor.<guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest, guru.qa.grpc.rangiffler.grpc.Country>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCountriesByCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  guru.qa.grpc.rangiffler.grpc.Country.getDefaultInstance()))
              .setSchemaDescriptor(new RangifflerCountriesServiceMethodDescriptorSupplier("getCountriesByCode"))
              .build();
        }
      }
    }
    return getGetCountriesByCodeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RangifflerCountriesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RangifflerCountriesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RangifflerCountriesServiceStub>() {
        @java.lang.Override
        public RangifflerCountriesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RangifflerCountriesServiceStub(channel, callOptions);
        }
      };
    return RangifflerCountriesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RangifflerCountriesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RangifflerCountriesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RangifflerCountriesServiceBlockingStub>() {
        @java.lang.Override
        public RangifflerCountriesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RangifflerCountriesServiceBlockingStub(channel, callOptions);
        }
      };
    return RangifflerCountriesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RangifflerCountriesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RangifflerCountriesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RangifflerCountriesServiceFutureStub>() {
        @java.lang.Override
        public RangifflerCountriesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RangifflerCountriesServiceFutureStub(channel, callOptions);
        }
      };
    return RangifflerCountriesServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RangifflerCountriesServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCountries(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rangiffler.grpc.Countries> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCountriesMethod(), responseObserver);
    }

    /**
     */
    public void getCountriesByCode(guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rangiffler.grpc.Country> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCountriesByCodeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCountriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                guru.qa.grpc.rangiffler.grpc.Countries>(
                  this, METHODID_GET_COUNTRIES)))
          .addMethod(
            getGetCountriesByCodeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest,
                guru.qa.grpc.rangiffler.grpc.Country>(
                  this, METHODID_GET_COUNTRIES_BY_CODE)))
          .build();
    }
  }

  /**
   */
  public static final class RangifflerCountriesServiceStub extends io.grpc.stub.AbstractAsyncStub<RangifflerCountriesServiceStub> {
    private RangifflerCountriesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RangifflerCountriesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RangifflerCountriesServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCountries(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rangiffler.grpc.Countries> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCountriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCountriesByCode(guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest request,
        io.grpc.stub.StreamObserver<guru.qa.grpc.rangiffler.grpc.Country> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCountriesByCodeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RangifflerCountriesServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RangifflerCountriesServiceBlockingStub> {
    private RangifflerCountriesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RangifflerCountriesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RangifflerCountriesServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public guru.qa.grpc.rangiffler.grpc.Countries getCountries(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCountriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public guru.qa.grpc.rangiffler.grpc.Country getCountriesByCode(guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCountriesByCodeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RangifflerCountriesServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RangifflerCountriesServiceFutureStub> {
    private RangifflerCountriesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RangifflerCountriesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RangifflerCountriesServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rangiffler.grpc.Countries> getCountries(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCountriesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<guru.qa.grpc.rangiffler.grpc.Country> getCountriesByCode(
        guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCountriesByCodeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COUNTRIES = 0;
  private static final int METHODID_GET_COUNTRIES_BY_CODE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RangifflerCountriesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RangifflerCountriesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COUNTRIES:
          serviceImpl.getCountries((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rangiffler.grpc.Countries>) responseObserver);
          break;
        case METHODID_GET_COUNTRIES_BY_CODE:
          serviceImpl.getCountriesByCode((guru.qa.grpc.rangiffler.grpc.CountryByCodeRequest) request,
              (io.grpc.stub.StreamObserver<guru.qa.grpc.rangiffler.grpc.Country>) responseObserver);
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

  private static abstract class RangifflerCountriesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RangifflerCountriesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return guru.qa.grpc.rangiffler.grpc.RangifflerCountriesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RangifflerCountriesService");
    }
  }

  private static final class RangifflerCountriesServiceFileDescriptorSupplier
      extends RangifflerCountriesServiceBaseDescriptorSupplier {
    RangifflerCountriesServiceFileDescriptorSupplier() {}
  }

  private static final class RangifflerCountriesServiceMethodDescriptorSupplier
      extends RangifflerCountriesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RangifflerCountriesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RangifflerCountriesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RangifflerCountriesServiceFileDescriptorSupplier())
              .addMethod(getGetCountriesMethod())
              .addMethod(getGetCountriesByCodeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
