package strings;

public class AnagramsInStringsON2Method {

	public static void main(String[] args) {
		int i,j;
		String name1 = "naruto";
		String name2="natour";
		int a = name1.length();
		int b = name2.length();
		boolean isAnagram = false;
		boolean visited[]=new boolean[b];
		if(a!=b)
			System.out.println("Not an anagram.");
		else
		{
			for(i=0;i<a;i++)
			{
				isAnagram = false;
				for(j=0;j<b;j++)
				{
					if(name1.charAt(i)==name2.charAt(j) && !visited[j]) 
					{
						visited[j] = true;
						isAnagram = true;
						break;
					}
				}
				if(!isAnagram)
					break;
			}
			if(isAnagram)
			{
				System.out.println("Anagram");
			}
			else
			{
				System.out.println("not an angram");
			}
		}

	}

}
