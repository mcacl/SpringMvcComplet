package com.springmvccomplete.tool;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * 创建时间:2020/5/7
 * 创建人:pmc
 * 描述:
 */
public class VerificationCode
{
    public enum VerifyCodeType
    {
        /**
         * 仅数字
         */
        ONLY_NUM,
        /**
         * 仅字母 大小写混合
         */
        ONLY_LETTER,
        /**
         * 数字和大小写字母混合
         */
        ALL_MIXED,
        /**
         * 数字和大写字母混合
         */
        NUM_UPPER,
        /**
         * 数字和小写字母混合
         */
        NUM_LOWER,
        /**
         * 仅大写字母
         */
        ONLY_UPPER,
        /**
         * 仅小写字母
         */
        ONLY_LOWER
    }

    private VerificationCode()
    {
    }

    private static Character[] _num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static Character[] _az = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static Character[] _AZ = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 生成随机颜色
     */
    private static Color generateRandomColor()
    {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /**
     * 生成图片验证码
     *
     * @param type           验证码类型,本类的枚举
     * @param length         验证码字符长度,要求大于0的整数
     * @param excludeString  需排除的特殊字符
     * @param width          图片宽度(注意此宽度若过小,容易造成验证码文本显示不全,如4个字符的文本可使用85到90的宽度)
     * @param height         图片高度
     * @param interLine      图片中干扰线的条数
     * @param randomLocation 每个字符的高低位置是否随机
     * @param backColor      图片颜色,若为null则表示采用随机颜色
     * @param foreColor      字体颜色,若为null则表示采用随机颜色
     * @param lineColor      干扰线颜色,若为null则表示采用随机颜色
     * @return 图片缓存对象
     */
    public static BufferedImage generateImageCode(VerifyCodeType type, int length, String excludeString, int width, int height, int interLine, boolean randomLocation, Color backColor, Color foreColor, Color lineColor)
    {
        String textCode = generateTextCode(type, length, excludeString);
        return generateImageCode(textCode, width, height, interLine, randomLocation, backColor, foreColor, lineColor);
    }


    /**
     * 生成验证码字符串
     *
     * @param type          验证码类型,本类的枚举
     * @param length        验证码长度,要求大于0的整数
     * @param excludeString 需排除的特殊字符（无需排除则为null）
     * @return 验证码字符串
     */
    public static String generateTextCode(VerifyCodeType type, int length, String excludeString)
    {
        if (length <= 0)
        {
            return "";
        }
        StringBuffer verifyCode = new StringBuffer();
        int i = 0;
        Random random = new Random();
        List<Character> list = new ArrayList();
        switch (type)
        {
            case ONLY_NUM:
                while (i < length)
                {
                    int t = random.nextInt(10);
                    //排除特殊字符
                    if (null == excludeString || excludeString.indexOf(t + "") < 0)
                    {
                        verifyCode.append(t);
                        i++;
                    }
                }
                break;
            case ONLY_LETTER:
                Collections.addAll(list, _az);
                Collections.addAll(list, _AZ);
                while (i < length)
                {
                    int t = random.nextInt(list.size());
                    if (null == excludeString || excludeString.indexOf(list.get(t)) < 0)
                    {
                        verifyCode.append(list.get(t));
                        i++;
                    }
                }
                break;
            case ONLY_UPPER:
                Collections.addAll(list, _AZ);
                while (i < length)
                {
                    int t = random.nextInt(list.size());
                    if ((null == excludeString || excludeString.indexOf(list.get(t)) < 0))
                    {
                        verifyCode.append(list.get(t));
                        i++;
                    }
                }
                break;
            case ONLY_LOWER:
                Collections.addAll(list, _az);
                while (i < length)
                {
                    int t = random.nextInt(list.size());
                    if ((null == excludeString || excludeString.indexOf(list.get(t)) < 0))
                    {
                        verifyCode.append(list.get(t));
                        i++;
                    }
                }
                break;
            case ALL_MIXED:
                Collections.addAll(list, _num);
                Collections.addAll(list, _az);
                Collections.addAll(list, _AZ);
                while (i < length)
                {
                    int t = random.nextInt(list.size());
                    if ((null == excludeString || excludeString.indexOf(list.get(t)) < 0))
                    {
                        verifyCode.append(list.get(t));
                        i++;
                    }
                }
                break;
            case NUM_UPPER:
                Collections.addAll(list, _num);
                Collections.addAll(list, _AZ);
                while (i < length)
                {
                    int t = random.nextInt(list.size());
                    if ((null == excludeString || excludeString.indexOf(list.get(t)) < 0))
                    {
                        verifyCode.append(list.get(t));
                        i++;
                    }
                }
                break;
            case NUM_LOWER:
                Collections.addAll(list, _num);
                Collections.addAll(list, _az);
                while (i < length)
                {
                    int t = random.nextInt(list.size());
                    if ((null == excludeString || excludeString.indexOf(list.get(t)) < 0))
                    {
                        verifyCode.append(list.get(t));
                        i++;
                    }
                }
                break;
        }
        return verifyCode.toString();
    }

    /**
     * 已有验证码,生成验证码图片
     *
     * @param textCode       文本验证码
     * @param width          图片宽度(注意此宽度若过小,容易造成验证码文重叠,如4个字符的文本可使用85到90的宽度)
     * @param height         图片高度
     * @param interLine      图片中干扰线的条数
     * @param randomLocation 每个字符的高低位置是否随机
     * @param backColor      图片颜色,若为null则表示采用随机颜色
     * @param foreColor      字体颜色,若为null则表示采用随机颜色
     * @param lineColor      干扰线颜色,若为null则表示采用随机颜色
     * @return 图片缓存对象
     */
    public static BufferedImage generateImageCode(String textCode, int width, int height, int interLine, boolean randomLocation, Color backColor, Color foreColor, Color lineColor)
    {
        //创建内存图像
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取图形上下文
        Graphics graphics = bufferedImage.getGraphics();
        //画背景图
        graphics.setColor(null == backColor ? generateRandomColor() : backColor);
        graphics.fillRect(0, 0, width, height);
        //画干扰线
        Random random = new Random();
        if (interLine > 0)
        {
            int x = 0, y = 0, x1 = width, y1 = 0;
            for (int i = 0; i < interLine; i++)
            {
                graphics.setColor(null == lineColor ? generateRandomColor() : lineColor);
                y = random.nextInt(height);
                y1 = random.nextInt(height);
                graphics.drawLine(x, y, x1, y1);
            }
        }

        int unitw = (int) (width * 0.95 / textCode.length());//每个字符的平均宽度
        int fx = (int) (width * 0.08 / 2);//开始和结尾的留白
        int hmax = (int) (height * 0.8);//字体最大用高度的80%计算
        int hmin = (int) (height * 0.4);//字体最小用高度的40%计算
        //写验证码字符
        for (int i = 0; i < textCode.length(); i++)
        {
            int fsize = random.nextInt(hmax - hmin + 1) + hmin;//随机字体大小
            int fy = fsize;
            //设定字体
            graphics.setFont(new Font("Default", Font.PLAIN, fsize));
            fy = randomLocation ? (int) ((Math.random() * 0.3 + 0.6) * height) : fy;
            graphics.setColor(null == foreColor ? generateRandomColor() : foreColor);
            //将验证码字符显示到图象中
            graphics.drawString(textCode.charAt(i) + "", fx, fy);
            fx += unitw;
        }
        graphics.dispose();
        return bufferedImage;
    }
}
