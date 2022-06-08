package com.lotushint.principle.ocp.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 15:31
 * @package com.lotushint.principle.ocp
 * @description 开闭原则
 * 新增功能需要改很多代码，未遵循ocp原则
 */
public class Ocp {

    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }

}

/**
 * 这是一个用于绘图的类 [使用方]
 */
class GraphicEditor {
    /**
     * 接收Shape对象，然后根据type，来绘制不同的图形
     *
     * @param s
     */
    public void drawShape(Shape s) {
        s.draw();
    }
}

/**
 * Shape类，基类
 */
abstract class Shape {
    int m_type;

    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

/**
 * 新增画三角形
 */
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}

/**
 * 新增一个图形
 */
class OtherGraphic extends Shape {
    public OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制其他图形");
    }
}