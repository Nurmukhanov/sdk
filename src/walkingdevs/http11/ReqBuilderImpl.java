package walkingdevs.http11;

import walkingdevs.val.Val;

class ReqBuilderImpl implements ReqBuilder {
    public int readTimeout() {
        return readTimeout;
    }

    public ReqBuilder readTimeout(int readTimeout) {
        this.readTimeout = Val.mk(
            readTimeout,
            "readTimeout",
            () -> readTimeout < 0,
            "Cannot be negative"
        ).get();
        return this;
    }

    public int connectTimeout() {
        return connectTimeout;
    }

    public ReqBuilder connectTimeout(int connectTimeout) {
        this.connectTimeout = Val.mk(
            connectTimeout,
            "connectTimeout",
            () -> connectTimeout < 0,
            "Cannot be negative"
        ).get();
        return this;
    }

    public HttpURI uri() {
        return uri;
    }

    public Method method() {
        return method;
    }

    public ReqBuilder method(Method method) {
        this.method = Val.isNull(method, "method").get();
        return this;
    }

    public HttpHeaders headers() {
        return headers;
    }

    public ReqBuilder headers(HttpHeaders headers) {
        this.headers = Val.isNull(headers, "headers").get();
        return this;
    }

    public Body body() {
        return body;
    }

    public ReqBuilder body(Body body) {
        this.body = Val.isNull(body, "body").get();
        return this;
    }

    public ReqBuilder body(HttpForm form) {
        return body(Body.mk(form));
    }

    public Req build() {
        return Req.mk(
            uri(),
            method(),
            headers(),
            body(),
            readTimeout(),
            connectTimeout()
        );
    }

    ReqBuilderImpl(HttpURI uri) {
        this.uri = uri;
    }

    // 10 minutes
    private static final int Timeout = 60 * 60 * 10;

    private final HttpURI uri;

    private int readTimeout = Timeout;
    private int connectTimeout = Timeout;

    private Method method = Method.GET;
    private HttpHeaders headers = HttpHeaders.mk();
    private Body body = Body.mk();
}