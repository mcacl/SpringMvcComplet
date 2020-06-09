package com.springmvccomplete.model.common;

/**
 * 创建时间:2020/6/9
 * 创建人:pmc
 * 描述:通用返回值实体
 */
public class ModResult
{
    private int code = -1;//默认失败
    private String msg;
    private Object data;

    public ModResult()
    {
    }

    public ModResult(int code, String msg, Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认失败的构造方法
     *
     * @param msg 错误消息
     * @param data 数据
     */
    public ModResult(String msg, Object data)
    {
        this.code = -1;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认成功的构造方法
     * @param data 数据
     */
    public ModResult(Object data)
    {
        this.code = 1;
        this.data = data;
    }

    /**
     * 结果状态 1:成功 -1:失败
     */
    public int getCode()
    {
        return code;
    }

    /**
     * 结果状态 1:成功 -1:失败
     *
     * @param code
     */
    public void setCode(int code)
    {
        this.code = code;
    }

    /**
     * 结果消息
     */
    public String getMsg()
    {
        return msg;
    }

    /**
     * @param msg 结果消息
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    /**
     * 结果数据
     */
    public Object getData()
    {
        return data;
    }

    /**
     * @param data 结果数据
     */
    public void setData(Object data)
    {
        this.data = data;
    }

}
