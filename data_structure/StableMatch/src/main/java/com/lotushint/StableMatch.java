package com.lotushint;

/**
 * @author com.lotushint
 * @version 1.0
 * @date 2022/3/1 18:46
 * @package com.com.lotushint
 * @description 稳定匹配
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 人类
 */
class Man {
    /**
     * 本人id
     */
    int id;
    /**
     * 是否已配对的标志，初始为 0，已配对则为对象的id
     */
    int ifMatched;
    /**
     * 对异性的满意排名
     */
    List<Integer> man;

    /**
     * 初始化人：id,ifMatch
     *
     * @param n 人数
     */
    public Man(int n) {
        ifMatched = 0;
        //man = new HashSet();
        //man = getRandomSet(n,n);
        man = new ArrayList();
        man = getRandomList(n, n);
    }

    /**
     * 获取随机数
     *
     * @param size 要获取的随机数个数
     * @param max  随机数的最大数
     * @return 随机数列表
     */
    public List getRandomList(int size, int max) {
        man = new ArrayList<>();
        Random random = new Random();
        while (man.size() < size) {
            int item = random.nextInt(max) + 1;
            boolean addFlag = true;
            for (int i = 0; i < man.size(); i++) {
                int itemNum = man.get(i);
                if (item == itemNum) {
                    addFlag = false;
                }
            }
            if (addFlag) {
                man.add(item);
            }
        }
        return man;
    }

    /**
     * 随机
     */
	 /*
	public Set<Integer> getRandomSet(int size,int max){
		Random random = new Random();
		Set<Integer> result = new LinkedHashSet<Integer>();
		while(man.size() < size){
			Integer next = random.nextInt(max)+1;
			man.add(next);
		}
		return man;
	}
	*/

    /**
     * 打印对异性的满意排名列表
     */
    public void printList() {
        System.out.println(man);
    }
}

/**
 * 男女匹配类
 */
class ManToWoman {

    /**
     * 男嘉宾列表
     */
    List<Man> man;
    /**
     * 女嘉宾列表
     */
    List<Man> woman;
    /**
     * 判断是否再进行一次匹配的标志
     */
    boolean flagAgain = false;

    /**
     * 打印男（女）嘉宾心目中理想的嘉宾排名
     *
     * @param manOrWoman 男嘉宾：0，女嘉宾：1
     * @param man        男（女）嘉宾列表
     */
    public static void printGuestRanking(int manOrWoman, List<Man> man) {
        if (manOrWoman == 0) {
            System.out.println("男嘉宾与他心中的理想女嘉宾排名：");
        } else if (manOrWoman == 1) {
            System.out.println("女嘉宾与她心中的理想男嘉宾排名：");
        }
        for (Man m : man) {
            System.out.print(m.id);
            m.printList();
        }
    }

    /**
     * 打印男女嘉宾匹配元组
     *
     * @param man 男（女）嘉宾(输入女嘉宾列表则表示格式为（女嘉宾id,男嘉宾id）)
     */
    public static void printMatchedTuple(List<Man> man) {
        System.out.println("男女嘉宾配对分别为（男嘉宾id,女嘉宾id）：");
        for (Man mp : man) {
            System.out.println("(" + String.format("%2d", mp.id) + "," + String.format("%2d", mp.ifMatched) + ")");
        }
    }

    /**
     * 初始化男,女嘉宾
     *
     * @param man   男嘉宾列表
     * @param woman 女嘉宾列表
     * @param n     男（女）嘉宾人数
     */
    public static void initializeGuest(List<Man> man, List<Man> woman, int n) {
        for (int i = 1; i <= n; i++) {
            Man oneMan = new Man(n);
            oneMan.id = i;
            man.add(oneMan);

            Man oneWoman = new Man(n);
            oneWoman.id = i;
            woman.add(oneWoman);
        }
    }

    /**
     * 打印未匹配信息
     *
     * @param man 男（女）嘉宾列表
     */
    public void printUnmatchedInfo(List<Man> man) {
        for (Man m : man) {
            if (m.ifMatched == 0) {
                //未全部匹配完成
                flagAgain = true;
                System.out.println("男生未匹配完成，继续匹配");
                break;
            } else {
                flagAgain = false;
            }
        }
    }

    /**
     * 对男女嘉宾进行匹配
     *
     * @param man   男嘉宾
     * @param woman 女嘉宾
     */
    public ManToWoman(List<Man> man, List<Man> woman) {

        while (true) {
            printUnmatchedInfo(man);
            printUnmatchedInfo(woman);
            if (flagAgain) {
                //遍历所有男嘉宾
                for (Man m : man) {
                    //遍历该男嘉宾的理想女嘉宾 id
                    for (Integer i : m.man) {
                        //如果该女嘉宾未匹配
                        if (woman.get(i - 1).ifMatched == 0) {
                            //将该男嘉宾心目中的最理想的未匹配的女嘉宾与他匹配
                            m.ifMatched = i;
                            //将该男嘉宾的id赋值给匹配的女嘉宾
                            woman.get(i - 1).ifMatched = m.id;
                            break;
                        } else if (woman.get(i - 1).ifMatched != 0) {
                            //遍历该女嘉宾心中的最理想的男嘉宾排名，看两个男嘉宾谁更满意则选谁
                            for (Integer j : woman.get(i - 1).man) {
                                //喜欢后面的男嘉宾
                                if (m.id == j) {
                                    for (Man ma : man) {
                                        //将前面的与女嘉宾匹配的男嘉宾置为未匹配
                                        if (ma.ifMatched == woman.get(i - 1).id) {
                                            ma.ifMatched = 0;
                                            break;
                                        }
                                    }
                                    woman.get(i - 1).ifMatched = m.id;
                                    m.ifMatched = i;
                                    break;
                                } //喜欢前面的男嘉宾
                                else if (woman.get(i - 1).ifMatched == j) {
                                    break;
                                }
                            }

                        }
                        //该男嘉宾匹配了一个女嘉宾，则继续下一个男嘉宾
                        if (m.ifMatched != 0) {
                            break;
                        }
                    }
                }
                this.man = man;
                this.woman = woman;
            } else {
                break;
            }
        }
    }
}

/**
 * @author hefan
 */
public class StableMatch {

    public static void main(String[] args) {
        /**
         * 男/女的人数
         */
        int n;
        /**
         * 男嘉宾集合
         */
        List<Man> man = new ArrayList<Man>();
        /**
         * 女嘉宾集合
         */
        List<Man> woman = new ArrayList<Man>();

        System.out.println("请输入男（女）嘉宾的人数：");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        ManToWoman.initializeGuest(man, woman, n);
        ManToWoman.printGuestRanking(0, man);
        ManToWoman.printGuestRanking(1, woman);
        new ManToWoman(man, woman);
        ManToWoman.printMatchedTuple(man);
    }
}