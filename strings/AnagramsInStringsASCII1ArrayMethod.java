package strings;

public class AnagramsInStringsASCII1ArrayMethod {
	public static void main(String[] args) 
	{
		int i,j;
		boolean isAnagram = false;
		String a = "listen";
		String b="silent";
		int al[]=new int[256];
		for(char c: a.toCharArray())
		{
			int index = (int) c;
			al[index]++;
		}
		for(char c: b.toCharArray())
		{
			int index = (int) c;
			al[index]--;
		}
		for(i=0;i<256;i++)
		{
			if(al[i]!=0) {
				isAnagram=true;
			break;
			}
		}
		if(isAnagram)
		{
			System.out.println("is an anagram");
		}
		else
			System.out.println("not an anagram");
	
    }
}
