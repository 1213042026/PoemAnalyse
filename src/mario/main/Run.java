package mario.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import mario.beans.ChineseWord;
import mario.data.ChineseWordService;

public class Run {
	/*
	测试样例诗句
	  剑外忽传收蓟北
      初闻涕泪满衣裳
      却看妻子愁何在
      漫卷诗书喜欲狂
      白日放歌须纵酒
      青春作伴好还乡
      即从巴世穿巫水
      便下襄阳向洛阳
    
    韵部：唐
    
    格式： 4.仄起首句不入韵
    
    数据库补充字：
    INSERT INTO `tt` (`id`, `zi`, `sheng`, `yun`) VALUES
    (2667, '剑', 0, '7'),
	(2668, '忽', 1, 'A'),
	(2669, '传', 1, '7'),
	(2670, '蓟', 0, 'B'),
	(2671, '初', 1, 'D'),
	(2672, '闻', 1, '8'),
	(2673, '涕', 0, 'B'),
	(2674, '满', 0, '7'),
	(2675, '衣', 1, 'B'),
	(2676, '裳', 1, '9'),
	(2677, '看', 1, '7'),
	(2678, '妻', 0, 'B'),
	(2679, '子', 0, 'C'),
	(2680, '漫', 0, '7'),
	(2681, '卷', 0, '7'),
	(2682, '诗', 1, 'C'),
	(2683, '书', 1, 'D'),
	(2684, '喜', 0, 'B'),
	(2685, '欲', 0, 'B'),
	(2686, '狂', 1, '9'),
	(2687, '日', 0, 'C'),
	(2688, '放', 1, '9'),
	(2689, '须', 1, 'B'),
	(2690, '纵', 0, 'A'),
	(2691, '青', 1, 'A'),
	(2692, '春', 1, '8'),
	(2693, '伴', 0, '7'),
	(2694, '还', 1, '7'),
	(2695, '乡', 1, '9'),
	(2696, '即', 1, 'B'),
	(2697, '从', 1, 'A'),
	(2698, '世', 0, 'C'),
	(2699, '穿', 1, '7'),
	(2700, '巴', 0, '0'),
	(2701, '便', 0, '7'),
	(2702, '襄', 1, '9'),
	(2703, '阳', 1, '9'),
	(2704, '向', 0, '9')，
	(2705, '却', 1, 'B')，
	(2706, '巫', 1, 'D');
	 */
	
	public static String POEM_SENTENCE_LENGTH_ERROR = "诗句长度不正确!";
	public static String POEM_SENTENCE_TONE_ERROR = "诗句声调顺序不正确!";
	public static String POEM_SENTENCE_RHYTHM_ERROR = "诗句韵部不正确!";

	public static void main(String[] args) {
		ChineseWordService chineseWordService = new ChineseWordService();
		
		String FORMAT_I_SENTENCE_I = "1100011";
		String FORMAT_I_SENTENCE_II = "0011001";
		String FORMAT_I_SENTENCE_III = "0011100";
		String FORMAT_I_SENTENCE_IV = "1100011";
		String FORMAT_I_SENTENCE_V = "1100110";
		String FORMAT_I_SENTENCE_VI = "0011001";
		String FORMAT_I_SENTENCE_VII = "0011100";
		String FORMAT_I_SENTENCE_VIII = "1100011";
		
		String FORMAT_II_SENTENCE_I = "1100110";
		String FORMAT_II_SENTENCE_II = "0011001";
		String FORMAT_II_SENTENCE_III = "0011100";
		String FORMAT_II_SENTENCE_IV = "1100011";
		String FORMAT_II_SENTENCE_V = "1100110";
		String FORMAT_II_SENTENCE_VI = "0011001";
		String FORMAT_II_SENTENCE_VII = "0011100";
		String FORMAT_II_SENTENCE_VIII = "1100011";
		
		String FORMAT_III_SENTENCE_I = "0011001";
		String FORMAT_III_SENTENCE_II = "1100011";
		String FORMAT_III_SENTENCE_III = "1100110";
		String FORMAT_III_SENTENCE_IV = "0011001";
		String FORMAT_III_SENTENCE_V = "0011100";
		String FORMAT_III_SENTENCE_VI = "1100011";
		String FORMAT_III_SENTENCE_VII = "1100110";
		String FORMAT_III_SENTENCE_VIII = "0011001";
		
		String FORMAT_IV_SENTENCE_I = "0011100";
		String FORMAT_IV_SENTENCE_II = "1100011";
		String FORMAT_IV_SENTENCE_III = "1100110";
		String FORMAT_IV_SENTENCE_IV = "0011001";
		String FORMAT_IV_SENTENCE_V = "0011100";
		String FORMAT_IV_SENTENCE_VI = "1100011";
		String FORMAT_IV_SENTENCE_VII = "1100110";
		String FORMAT_IV_SENTENCE_VIII = "0011001";
		
		Map<String, String> yuns = new HashMap<String, String>();
		yuns.put("麻", "0");
		yuns.put("波", "1");
		yuns.put("皆", "2");
		yuns.put("开", "3");
		yuns.put("微", "4");
		yuns.put("豪", "5");
		yuns.put("尤", "6");
		yuns.put("寒", "7");
		yuns.put("开", "8");
		yuns.put("唐", "9");
		yuns.put("庚", "A");
		yuns.put("齐", "B");
		yuns.put("支", "C");
		yuns.put("姑", "D");

		String Y = "";
		String formatNumber = "";
		String inputYun = "";
		
		System.out.println("start------");
		System.out.println("请选择韵部------");
		System.out.println("麻");
		System.out.println("波");
		System.out.println("皆");
		System.out.println("开");
		System.out.println("微");
		System.out.println("豪");
		System.out.println("尤");
		System.out.println("寒");
		System.out.println("开");
		System.out.println("唐");
		System.out.println("庚");
		System.out.println("齐");
		System.out.println("支");
		System.out.println("姑");
		
		InputStreamReader in = new InputStreamReader(System.in);
		
		try {
			inputYun = new BufferedReader(in).readLine();
			Y = yuns.get(inputYun);

			if (Y == null) {
				System.out.println("韵部输入不正确.");
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(Y);

		System.out.println("请选择格式(输入格式前标，例如选择'平起首句入韵'就输入'1')------");
		System.out.println("1.平起首句入韵");
		System.out.println("2.平起首句不入韵");
		System.out.println("3.仄起首句入韵");
		System.out.println("4.仄起首句不入韵");
		
		try {
			formatNumber = new BufferedReader(in).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(formatNumber);

		switch (formatNumber) {
			case "1":
				System.out.println("请输入首联上句(第一句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_I_SENTENCE_I);
				
				System.out.println("请输入首联下句(第二句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_I_SENTENCE_II);
				
				System.out.println("请输入颔联上句(第三句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_I_SENTENCE_III);
				
				System.out.println("请输入颔联下句(第四句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_I_SENTENCE_IV);
				
				System.out.println("请输入颈联上句(第五句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_I_SENTENCE_V);
				
				System.out.println("请输入颈联下句(第六句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_I_SENTENCE_VI);
				
				System.out.println("请输入尾联上句(第七句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_I_SENTENCE_VII);
				
				System.out.println("请输入尾联下句(第八句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_I_SENTENCE_VIII);
				
			    break;
			case "2":
				System.out.println("请输入首联上句(第一句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_II_SENTENCE_I);
				
				System.out.println("请输入首联下句(第二句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_II_SENTENCE_II);
				
				System.out.println("请输入颔联上句(第三句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_II_SENTENCE_III);
				
				System.out.println("请输入颔联下句(第四句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_II_SENTENCE_IV);
				
				System.out.println("请输入颈联上句(第五句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_II_SENTENCE_V);
				
				System.out.println("请输入颈联下句(第六句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_II_SENTENCE_VI);
				
				System.out.println("请输入尾联上句(第七句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_II_SENTENCE_VII);
				
				System.out.println("请输入尾联下句(第八句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_II_SENTENCE_VIII);
				
			    break;
			case "3":
				System.out.println("请输入首联上句(第一句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_III_SENTENCE_I);
				
				System.out.println("请输入首联下句(第二句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_III_SENTENCE_II);
				
				System.out.println("请输入颔联上句(第三句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_III_SENTENCE_III);
				
				System.out.println("请输入颔联下句(第四句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_III_SENTENCE_IV);
				
				System.out.println("请输入颈联上句(第五句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_III_SENTENCE_V);
				
				System.out.println("请输入颈联下句(第六句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_III_SENTENCE_VI);
				
				System.out.println("请输入尾联上句(第七句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_III_SENTENCE_VII);
				
				System.out.println("请输入尾联下句(第八句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_III_SENTENCE_VIII);
				
			    break;
			case "4":
				System.out.println("请输入首联上句(第一句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_IV_SENTENCE_I);
				
				System.out.println("请输入首联下句(第二句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_IV_SENTENCE_II);
				
				System.out.println("请输入颔联上句(第三句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_IV_SENTENCE_III);
				
				System.out.println("请输入颔联下句(第四句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_IV_SENTENCE_IV);
				
				System.out.println("请输入颈联上句(第五句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_IV_SENTENCE_V);
				
				System.out.println("请输入颈联下句(第六句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_IV_SENTENCE_VI);
				
				System.out.println("请输入尾联上句(第七句)");
				checkSentenceWithoutYun(in, chineseWordService, FORMAT_IV_SENTENCE_VII);
				
				System.out.println("请输入尾联下句(第八句)");
				checkYunSentence(in, chineseWordService, Y, FORMAT_IV_SENTENCE_VIII);
				
			    break;
			default:
				System.exit(0);
		}
		
		System.out.println("格式正确");
	}
	
	public static void checkYunSentence(InputStreamReader in, ChineseWordService chineseWordService, String Y, String inputTone) {
		String poemI = "";
		
		try {
			poemI = new BufferedReader(in).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (checkSentenceLength(poemI)) {
			System.out.println(POEM_SENTENCE_LENGTH_ERROR);
			System.exit(0);
		}
		
		String lastWord = Run.getLastWordOfSentence(poemI);
		
		ChineseWord chineseWord = chineseWordService.getChineseWordInfo(lastWord);
		
		if (chineseWord == null) {
			System.out.println(lastWord);
			System.out.println("字库内容有限，未查找到.");
			System.exit(0);
		}
		
		String Z = chineseWord.getYun();
		
		System.out.println("Y " + Y);
		System.out.println("Z " + Z);
		
		if (!Y.equals(Z)) {
			System.out.println(POEM_SENTENCE_RHYTHM_ERROR);
			System.exit(0);
		}
		
		if (!checkSentenceTone(poemI, chineseWordService, inputTone)) {
			System.out.println(POEM_SENTENCE_TONE_ERROR);
			System.exit(0);
		}
	}
	
	public static void checkSentenceWithoutYun(InputStreamReader in, ChineseWordService chineseWordService, String inputTone) {
		String poemI = "";
		
		try {
			poemI = new BufferedReader(in).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (checkSentenceLength(poemI)) {
			System.out.println(POEM_SENTENCE_LENGTH_ERROR);
			System.exit(0);
		}
		
		if (!checkSentenceTone(poemI, chineseWordService, inputTone)) {
			System.out.println(POEM_SENTENCE_TONE_ERROR);
			System.exit(0);
		}
	}
	
	public static boolean checkSentenceLength(String poem) {
		return poem.length() != 7 ? true : false;
	}
	
	public static String getLastWordOfSentence(String poem) {
		return poem.substring(poem.length() - 1);
	}
	
	public static boolean checkSentenceTone(String poem, ChineseWordService chineseWordService, String standTone) {
		char words[] = poem.toCharArray();
		
		String tone = "";
		
		for (int i = 0; i < poem.length(); i++) {
			ChineseWord chineseWord = chineseWordService.getChineseWordInfo(String.valueOf(words[i]));

			if (chineseWord == null) {
				System.out.println("字库内容有限，未查找到.");
				System.exit(0);
			}
			
			tone += chineseWord.getSheng();
		}
		
		System.out.println("cust " + tone);
		System.out.println("stand " + standTone);
		
		return tone.equals(standTone) ? true : false;
	}
}
