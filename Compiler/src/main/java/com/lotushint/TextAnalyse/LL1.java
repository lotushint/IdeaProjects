package com.lotushint.TextAnalyse;

import java.util.*;
import java.util.Map.Entry;

public class LL1 {
	// 文法开始符
	public char S='E';
	// 存储终结符
	public String[] VT = new String[] { "i","+","*","(",")","#"};
	// 存储非终结符
	public String[] VN = new String[] { "E", "Z", "T", "Y", "F" };
	// 文法G[E]
	public String[] left = { "E", "Z", "T", "Y", "F" };
	public String[] grammar = { "TZ", "+TZ|ε", "FY", "*FY|ε", "(E)|i" };
	// first集
	public HashMap<Character, HashSet<Character>> firstSet = new HashMap<Character, HashSet<Character>>();
	// follow集
	public HashMap<Character, HashSet<Character>> followSet = new HashMap<Character, HashSet<Character>>();
	// 产生式
	public HashMap<Character, ArrayList<String>> expressionSet = new HashMap<>();
	// 分析表
	public String[][] chart;
	// 表的行数
	public int rows;
	// 表的列数
	public int cols;

	// 将各个候选式分开，保存在expressionSet
	public void init() {// 初始化expressionSet
		int i = 0;
		for (String s : grammar) {
			char key = left[i++].charAt(0);// 找到产生式左部
			//System.out.println(key);
			ArrayList<String> list = expressionSet.containsKey(key) ? expressionSet.get(key) : new ArrayList<>();// 获得相应key的ArrayList
			if (s.contains("|")) {
				String[] str = s.split("\\|");
				int len = str.length;
				for (int j = 0; j < len; j++) {// 根据|分割产生式
					//System.out.println(str[j] + ",");
					list.add(str[j]);
				}
			} else {
				//System.out.println(s + ",");
				list.add(s);
			}
			expressionSet.put(key, list);
		}
	}

	// 判断是否为终结符
	public boolean isVT(char c) {
		String s = String.valueOf(c);
		for (String temp : VT) {
			if (s.equals(temp))
				return true;
		}
		return false;
	}

	// 判断是否为空字
	public boolean isEmptyWord(char c) {
		if (c == 'ε')
			return true;
		return false;
	}

	// 判断是否为非终结符
	public boolean isVN(char c) {
		String s = String.valueOf(c);
		for (String temp : VN) {
			if (s.equals(temp))
				return true;
		}
		return false;
	}


	// 计算first集
	public void getFirst(char ch) {//求得字符的first集
		HashSet<Character> set = firstSet.containsKey(ch) ? firstSet.get(ch) : new HashSet<>();
		ArrayList<String> list = expressionSet.get(ch);// 得到ch对应的ArrayList

		for (String s : list) {
			char head = s.charAt(0);
			if (isVT(head)) {// 终结符时
				set.add(head);
				firstSet.put(ch, set);
			} else if (isEmptyWord(head)) {// 空字时
				set.add('ε');
				firstSet.put(ch, set);
			} else {// 非终结符时
				// whenVN(ch, list);
				int i = 0;
				// HashSet<Character> set = null;
				while (i < s.length()) {// 遍历s的字符
					char c = s.charAt(i);
					// System.out.println(c);
					HashSet<Character> tempSet = null;
					if (firstSet.containsKey(c)) {// 得到第i个字符的first集
						tempSet = firstSet.get(c);
					} else {
						if (ch == c)
							continue;// 如果求自身的first集，直接进行下一次循环
						getFirst(c);
						tempSet = firstSet.get(c);
					}
					if (tempSet.contains('ε')) {
						tempSet.remove('ε');
						set.addAll(tempSet);
						firstSet.put(ch, set);// 目的是去掉ε
						i++;
						continue;
					} else {
						// set.remove('ε');
						set.addAll(tempSet);
						firstSet.put(ch, set);
						break;
					}
				}
				if (i == s.length()) {// 都存在ε，则把ε加入first集
					set.add('ε');
					firstSet.put(ch, set);
				}
			}
		}

	}

	public Set<Character> getFirst(String sentence) {// 求字符串的first集
		Set<Character> set = new HashSet<>();
		if (sentence.equals("ε")) {
			set.add('ε');
		} else {
			// 不为空字时，遍历整个句子的字符
			for (int i = 0; i < sentence.length(); i++) {
				if (isVT(sentence.charAt(i))) {// 为终结符时，直接加入first集
					set.add(sentence.charAt(i));
					break;
				} else {
					// 不为终结符时，获取该非终结符的first集合
					HashSet<Character> temp = firstSet.get(sentence.charAt(i));
					if (!temp.contains('ε')) {
						set.addAll(temp);
						break;
					} else {
						// 非终结符含空字时
						if (i == sentence.length() - 1) {
							set.addAll(temp);
						} else {
							temp.remove('ε');
							set.addAll(temp);
						}
					}
				}
			}
		}
		return set;
	}

	public void getFollow(char ch) {
		HashSet<Character> set = followSet.containsKey(ch) ? followSet.get(ch) : new HashSet<>();
		if (S == ch) {// 对于文法开始符，将#放在follow集
			set.add('#');
			followSet.put(ch, set);
		}
		for (Map.Entry<Character, ArrayList<String>> entry : expressionSet.entrySet()) {// 遍历experssionSet，找到出现字符ch的位置
			char key = entry.getKey();
			ArrayList<String> value = entry.getValue();
			for (String s : value) {// 对键值遍历
				for (int i = 0; i < s.length(); i++) {// 找到字符ch的位置
					if (s.charAt(i) == ch) {
						if (i == (s.length() - 1)) {// 非终结符后没有字符，使用规则3
							HashSet<Character> tempSet = null;
							if (ch != key) {// 避免出现套娃求follow(ch)
								if (followSet.containsKey(key)) {// 得到follow(key)加入到set中
									tempSet = followSet.get(key);
								} else {
									getFollow(key);
									tempSet = followSet.get(key);
								}
								set.addAll(tempSet);
								followSet.put(ch, set);
							}
						} else {// 非终结符后有字符，使用规则2
							int j = i + 1;
							String tempStr = s.substring(j);
							Set<Character> tempSet = getFirst(tempStr);
							if (tempSet.contains('ε')) {
								tempSet.remove('ε');
								set.addAll(tempSet);
								HashSet<Character> tempSet3 = null;
								if (ch != key) {// 避免出现套娃求follow(ch)
									if (followSet.containsKey(key)) {
										tempSet3 = followSet.get(key);
									} else {
										getFollow(key);
										tempSet3 = followSet.get(key);
									}
									set.addAll(tempSet3);
									// followSet.put(ch, set);
								}
							} else {// 不包含ε
								set.addAll(tempSet);
							}
							followSet.put(ch, set);
						}
						// break;
					}

				}
			}
		}
	}

	public void print() {// 打印first集和follow集
		for (Entry<Character, HashSet<Character>> entry : firstSet.entrySet()) {/// first(A)
			char key = entry.getKey();
			System.out.print("FIRST(" + key + ")= ");
			HashSet<Character> set = firstSet.get(key);
			Iterator<Character> iterator = set.iterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next()+" ");
			}
			System.out.println();
		}
		for (Entry<Character, HashSet<Character>> entry : followSet.entrySet()) {
			char key = entry.getKey();
			System.out.print("FOLLOW(" + key + ")= ");
			HashSet<Character> set = followSet.get(key);
			Iterator<Character> iterator = set.iterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next()+" ");
			}
			System.out.println();
		}
	}

	public void LLChart() {// 定义分析表
		rows = VN.length + 1;
		cols = VT.length + 1;
		chart = new String[rows][cols];
		chart[0][0] = "VN/VT";
		for (int i = 1; i < rows; i++) {// 构造表的第一行
			chart[i][0] = VN[i - 1];
		}
		for (int j = 1; j < cols; j++) {// 构造表的第一列
			chart[0][j] = VT[j - 1];
		}
		initChart();
		printChart();
	}

	public void initChart() {// 构造分析表的内容
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				char row = chart[i][0].charAt(0); // 非终结符，表行
				char col = chart[0][j].charAt(0); // 终结符，表列
				// 非终结符的first集合包含该终结符时
				if (firstSet.get(row).contains(col)) {
					ArrayList<String> list = expressionSet.get(row);
					if (list.size() == 1) {
						chart[i][j] = list.get(0);
					} else {
						// 非唯一候选式时，加入对应的候选式，对应的候选式即首字母为终结符的候选式
						for (String str : list) {
							if (str.indexOf(col) == 0) {
								chart[i][j] = str;
								break;
							}
						}
					}
				} else if (firstSet.get(row).contains('ε')) {
					HashSet<Character> set = followSet.get(row);
					// 若该follow集合包含该终结符时
					if (set.contains(col)) {
						chart[i][j] = "ε"; // 表元素添加推导空字的候选式
					}

				}
			}
		}
	}
	public void blank(String s) {
		int i;
		for(i=0;i<(8-s.length());i++) {
			System.out.print(" ");
		}
	}
	public void printChart() {
		System.out.println("LL(1)分析表为");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(chart[i][j]==null) {
					System.out.print("        ");
				}else {
					System.out.print(chart[i][j]);
					blank(chart[i][j]);
				}			
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LL1 d = new LL1();
		d.init(); 
		for (String str : d.left) { 
			char ch = str.charAt(0); 
			d.getFirst(ch); 
		}
		for (String str : d.left) { 
			char ch = str.charAt(0);	
			d.getFollow(ch); 
		}
		d.print();
		d.LLChart();
	}
}

