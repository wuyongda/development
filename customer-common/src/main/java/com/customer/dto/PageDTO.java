package com.customer.dto;

public class PageDTO<T, P> {

    /**
     * 查询参数
     */
    private T t;

    /**
     * 分页参数
     */
    private P p;

    public PageDTO() {
        super();
    }

    public PageDTO(T t, P p) {
        super();
        this.t = t;
        this.p = p;
    }

    public T getModel() {
        return t;
    }

    public P getPage() {
        return p;
    }

    public T getT() {
        return t;
    }

    public P getP() {
        return p;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setP(P p) {
        this.p = p;
    }

}
