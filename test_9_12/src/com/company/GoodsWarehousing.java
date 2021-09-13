
//这一部分是学习日志：
//C语言的输入使用的是scanf函数，但在Java不知道是如何输入的，就很烦
//然后学习了Java是如何输入的
//直接帖地址：https://blog.csdn.net/qq_41181772/article/details/83653875 到这里学，很舒服
//祥子牛吧！



package com.company;
import java.util.Scanner;//Scanner类位于java.util.Scanner包中，因此在程序前面要加上此包

public class GoodsWarehousing {

    public static void main(String[] args) {

        //华为手机基本信息
        String HuaweiBrand = "华为";//java中有字符串类型，C语言没有
        double HuaweiSize = 6.6;
        double HuaweiPrice = 7488.00;
        String HuaweiConfig = "8+128g 全面刘海屏";

        //小米手机基本信息
        String XiaomiBrand = "小米";
        double XiaomiSize = 6.0;
        double XiaomiPrice = 3000.00;
        String XiaomiConfig = "4+64g 全面屏";

        //华为手机入库
        System.out.println("品牌型号：" + HuaweiBrand);
        System.out.println("尺寸：" + HuaweiSize);
        System.out.println("价格：" + HuaweiPrice);
        System.out.println("配置：" + HuaweiConfig);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入" + HuaweiBrand + "手机的库存");
        int HuaweiCount = sc1.nextInt();//把数量放入变量中
        double HuaweiTotal = HuaweiCount * HuaweiPrice;//华为手机的总金额
        System.out.println("库存" + HuaweiBrand + "手机的总金额：" + HuaweiTotal);

        //小米手机入库
        System.out.println("品牌型号：" + XiaomiBrand);
        System.out.println("尺寸：" + XiaomiSize);
        System.out.println("价格：" + XiaomiPrice);
        System.out.println("配置：" + XiaomiConfig);
        System.out.println("请输入" + XiaomiBrand + "手机的库存");
        int XiaomiCount = sc1.nextInt();
        double XiaomiTotal = XiaomiCount * XiaomiPrice;
        System.out.println("库存" + XiaomiBrand + "手机的总金额：" + XiaomiTotal);

        //库存清单表
        System.out.println("--------------------------库存清单---------------------------");
        System.out.println("品牌型号 尺寸  价格     配置                库存数量   总价");
        System.out.println(HuaweiBrand + "     " + HuaweiSize + "  " + HuaweiPrice + "  " + HuaweiConfig + "    " + HuaweiCount + "         " + HuaweiTotal);
        System.out.println(XiaomiBrand + "     " + XiaomiSize + "  " + XiaomiPrice + "  " + XiaomiConfig + "         " + XiaomiCount + "         " + XiaomiTotal);
        System.out.println("------------------------------------------------------------");

        int Total = HuaweiCount + XiaomiCount;//总数量
        double TotalMoney = HuaweiTotal + XiaomiTotal;//总价
        System.out.println("总库存：" + Total);
        System.out.println("库存总价：" + TotalMoney + "￥");
    }
}


