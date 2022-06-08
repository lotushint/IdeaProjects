package com.lotushint.principle.inversion.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/19 12:53
 * @package com.lotushint.principle.inversion.improve
 * @description 依赖传递的三种方式
 */
public class DependencyPass {

    public static void main(String[] args) {
        //通过接口传递实现依赖
        ChangHong1 changHong1 = new ChangHong1();
        OpenAndClose1 openAndClose1 = new OpenAndClose1();
        openAndClose1.open(changHong1);

        //通过构造器进行依赖传递
        ChangHong2 changHong2 = new ChangHong2();
        OpenAndClose2 openAndClose2 = new OpenAndClose2(changHong2);
        openAndClose2.open();

        //通过setter方法进行依赖传递
        ChangHong3 changHong3 = new ChangHong3();
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setTv(changHong3);
        openAndClose3.open();

    }

}

/**
 * 方式1： 通过接口传递实现依赖
 */
interface IOpenAndClose1 {// 开关的接口

    public void open(ITV1 tv); //抽象方法,接收接口
}

interface ITV1 { //ITV接口
    public void play();
}

class ChangHong1 implements ITV1 {

    @Override
    public void play() {
        System.out.println("长虹电视机1，打开");
    }

}

class OpenAndClose1 implements IOpenAndClose1 {
    @Override
    public void open(ITV1 tv1) {
        tv1.play();
    }
}

/**
 * 方式2: 通过构造方法依赖传递
 */
interface IOpenAndClose2 {
    /**
     * 抽象方法
     */
    public void open();
}

interface ITV2 {
    public void play();
}

class OpenAndClose2 implements IOpenAndClose2 {
    /**
     * 成员
     */
    public ITV2 tv2;

    public OpenAndClose2(ITV2 tv2) { //构造器
        this.tv2 = tv2;
    }

    @Override
    public void open() {
        this.tv2.play();
    }
}

class ChangHong2 implements ITV2 {
    @Override
    public void play() {
        System.out.println("长虹电视机2，打开");
    }
}

/**
 * 方式3 , 通过setter方法传递
 */
interface IOpenAndClose3 {
    public void open(); // 抽象方法

    public void setTv(ITV3 tv3);
}

interface ITV3 { // ITV接口
    public void play();
}

class OpenAndClose3 implements IOpenAndClose3 {
    private ITV3 tv3;

    @Override
    public void setTv(ITV3 tv3) {
        this.tv3 = tv3;
    }

    @Override
    public void open() {
        this.tv3.play();
    }
}

class ChangHong3 implements ITV3 {
    @Override
    public void play() {
        System.out.println("长虹电视机3，打开");
    }
}