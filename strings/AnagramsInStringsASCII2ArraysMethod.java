package strings;

public class AnagramsInStringsASCII2ArraysMethod {
	public static void main(String[] args) 
	{
		int i,j;
		boolean isAnagram = false;
		String a = "aabsd";
		String b="dsaba";
		int al[]=new int[256];
		int bl[]=new int[256];
		for(char c: a.toCharArray())
		{
			int index = (int) c;
			al[index]++;
		}
		for(char c: b.toCharArray())
		{
			int index = (int) c;
			bl[index]++;
		}
		for(i=0;i<256;i++)
		{
			if(al[i]!=bl[i])
				isAnagram=true;
		}
		if(!isAnagram)
		{
			System.out.println("is an anagram");
		}
		else
			System.out.println("not an anagram");
	
    }
}
