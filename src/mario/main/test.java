package mario.main;

public class test {

	public static void main(String[] args) {
		String poemI = "输入首联上句";
		for(int i = 0; i < poemI.length(); i++) {
			char words = poemI.toCharArray()[i];
			String word = String.valueOf(words);
			System.out.println(word);
		}
	}

}
