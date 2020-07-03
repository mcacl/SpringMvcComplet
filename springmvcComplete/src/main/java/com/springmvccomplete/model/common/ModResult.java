package com.springmvccomplete.model.common;

/**
 * 创建时间:2020/6/9
 * 创建人:pmc
 * 描述:通用返回值实体
 */
public class ModResult
{
    private ModResultCode code = ModResultCode.Failed;//默认失败
    private String msg;
    private Object data;

    /**
     * Code内部枚举
     */
    public enum ModResultCode
    {
        Success(1),//成功
        Failed(-1);//失败

        private int tcode;

        private ModResultCode(int code)
        {
            this.tcode = code;
        }

        public int getTcode()
        {
            return tcode;
        }
    }

    public ModResult()
    {
    }

    public ModResult(ModResultCode code, String msg, Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认失败的构造方法
     *
     * @param msg 错误消息
     */
    public ModResult(String msg)
    {
        this.code = ModResultCode.Failed;
        this.msg = msg;
    }

    /**
     * 无数据的返回
     *
     * @param code code
     * @param msg  消息
     */
    public ModResult(ModResultCode code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 设置默认状态的构造方法
     *
     * @param code code
     */
    public ModResult(ModResultCode code)
    {
        this.code = code;
    }

    /**
     * 默认成功的构造方法
     *
     * @param data 数据
     * @param msg  消息
     */
    public ModResult(Object data, String msg)
    {
        this.code = ModResultCode.Success;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 结果状态 1:成功 -1:失败
     */
    public int getCode()
    {
        return code.getTcode();
    }

    /**
     * 结果状态 1:成功 -1:失败
     *
     * @param code
     */
    public void setCode(ModResultCode code)
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
