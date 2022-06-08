package com.lotushint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
    用于保存递归下降中间过程的数据结构
    同时也是一个极为通用的树结构

    zhenchen@ysu.edu.cn
 */
public class TreeNode {
    Stack<TreeNode> child;
    String val;
    static ArrayList<Integer> nums_dep = new ArrayList<>();

    static final int WIDTH = 2000;
    static final int HEIGHT = 2000;
    static final int FONTSIZE = 30;

    public TreeNode(String val) {
        this.val = val;
        child = new Stack<>();
    }

    public String toDepthString(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            str.append("\t");
        }
        str.append(val).append("\n");
        for (TreeNode node : child)
            str.append(node.toDepthString(depth + 1));
        return str.toString();
    }

    @Override
    public String toString() {
        return toDepthString(0);
    }

    /**
     * 生成树图写到磁盘
     *
     * @param picType  图片类型JPG GIF JPEG PNG
     * @param file     图片文件
     *                 //     * @param list     数据模型 [{name: '', children: [{name: '', children: [{}]}]}]
     * @param rootName 根名称
     */
    public static void writeImage(String picType, File file, TreeNode treeNode, String rootName) {
        BufferedImage bimg = new BufferedImage(WIDTH + 2, HEIGHT + 2, BufferedImage.TYPE_INT_BGR);
        // 拿到画笔
        Graphics2D g = bimg.createGraphics();
        drawTree(g, treeNode, rootName, HEIGHT, WIDTH);
        // 将画好的图片通过流形式写到硬盘上
        boolean val = false;
        try {
            val = ImageIO.write(bimg, picType, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void drawTree(Graphics2D g, TreeNode treeNode, String rootName, int imgHeight, int imgWidth) {
        setNums_dep(treeNode);
        g.setColor(Color.WHITE);
        // 画一个图形系统默认是白色
        g.fillRect(1, 1, imgWidth, imgHeight);
        int fontSize = FONTSIZE;
        // 设置画笔画出的字体风格
        g.setFont(new Font("隶书", Font.ITALIC, fontSize));
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        //消除文字锯齿
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //消除画图锯齿
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//        g.setColor(new Color(0, 0, 200));
//        g.drawString(info, fontSize, 50);
        // 设置画笔颜色
        g.setColor(new Color(12, 123, 88));

        // 写一个字符串
        int margin = 0;
        int parentY = imgHeight / 2;
        g.drawString(rootName, fontSize, parentY);
        int parentX = computeParentX(rootName, fontSize, fontSize);
        if (treeNode.child.size() == 0) {
            g.dispose();
            return;
        }
        int heightL2 = (imgHeight - fontSize) / treeNode.child.size();
        for (int i = 0; i < treeNode.child.size(); i++) {
            TreeNode shareHolderDto = treeNode.child.get(i);
            int height = heightL2 / 2;
            String name = shareHolderDto.val;
            g.drawString(name, parentX + margin, height + heightL2 * i);
            // TODO 这里可以写其他属性， y随属性个数增加而增加 fontSize * i
            // g.drawString("注册资本：" + (shareHolderDto.getRegCapital() == null?"-":shareHolderDto.getRegCapital()), parentX + margin, height + heightL2 * i + fontSize);
            // 设置画笔颜色
            g.setColor(new Color(212, 123, 88));
            g.drawLine(parentX - 60, parentY, parentX + margin, height + heightL2 * i);
            // 设置画笔颜色
            g.setColor(new Color(12, 123, 88));
            if (shareHolderDto.child != null && !shareHolderDto.child.isEmpty()) {
                int myX = computeParentX(shareHolderDto.val, parentX + margin, fontSize);
                // TODO 提前发现某一层结点数，更改 parentHeight
                drawChildrenTransverse(g, shareHolderDto.child, height + heightL2 * i, heightL2, heightL2 * i, fontSize, margin, myX);
            }
        }
        // 释放画笔
        g.dispose();
    }

    /**
     * 循环子树
     *
     * @param g            Graphics2D
     * @param children     子节点
     * @param parentY      父节点的Y坐标
     * @param parentHeight 父区域的高度
     * @param startY       父区域起始Y坐标
     * @param fontSize     字体大小
     * @param margin       兄弟节点的间距
     * @param parentX      父节点的X坐标
     */
    private static void drawChildrenTransverse(Graphics2D g, Stack<TreeNode> children, int parentY, int parentHeight, int startY, int fontSize, int margin, int parentX) {
//        System.out.println("parentY:" + parentY + " parentHeight:" + parentHeight);
        int heightLn = parentHeight / children.size();
        for (int i = 0; i < children.size(); i++) {
            TreeNode shareHolderDto = children.get(i);
            int y = heightLn / 2 + heightLn * i + startY;
            int x = parentX + margin;
            String name = shareHolderDto.val;
            g.drawString(name, x, y);
            // 设置画笔颜色
            g.setColor(new Color(212, 123, 88));
            g.drawLine(parentX - 60, parentY, x, y);
            // 设置画笔颜色
            g.setColor(new Color(12, 123, 88));
            if (shareHolderDto.child != null && !shareHolderDto.child.isEmpty()) {
                int myX = computeParentX(shareHolderDto.val, x, fontSize);
                int myStartY = heightLn * i + startY;
                // TODO
                drawChildrenTransverse(g, shareHolderDto.child, y, heightLn, myStartY, fontSize, margin, myX);
            }
        }
    }

    /**
     * 计算父节点名字末尾X坐标
     *
     * @param str      文本
     * @param patentX  父节点起点X
     * @param fontSize 字体大小
     */
    private static int computeParentX(String str, int patentX, int fontSize) {
        return patentX + str.length() * fontSize;
    }

    public static String getPre(TreeNode treeNode) {
        StringBuilder res = new StringBuilder();
        if (treeNode == null) return "";
        getPre(treeNode, res);
        return res.toString();
    }

    public static void getPre(TreeNode treeNode, StringBuilder res) {
        res.append(treeNode.val).append(" ");
        for (int i = 0; i < treeNode.child.size(); i++) {
            getPre(treeNode.child.get(i), res);
        }
    }

    public static String getSuf(TreeNode treeNode) {
        StringBuilder res = new StringBuilder();
        if (treeNode == null) return "";
        getSuf(treeNode, res);
        return res.toString();
    }

    public static void getSuf(TreeNode treeNode, StringBuilder res) {
        for (int i = 0; i < treeNode.child.size(); i++) {
            getSuf(treeNode.child.get(i), res);
        }
        res.append(treeNode.val).append(" ");
    }

    public static void setNums_dep(TreeNode treeNode) {
        nums_dep.clear();

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(treeNode);
        while (!q.isEmpty()) {
            int len = q.size();
            nums_dep.add(len);
            for (int j = 0; j < len; j++) {
                TreeNode temp = q.peek();
                q.pop();

                assert temp != null;
                for (int i = 0; i < temp.child.size(); i++) {
                    q.offer(temp.child.get(i));
                }
            }
        }
    }
}
