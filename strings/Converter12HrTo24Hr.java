package strings;

public class Converter12HrTo24Hr {
	static String timeConversion(String s) {
        char[] c = s.toCharArray();
        int hr;
        String hrs = "";
        if(s.charAt(s.length()-2)=='A'){
            if(s.charAt(0)=='1' && s.charAt(1)=='2'){
            hrs = "00";
            hrs = hrs.concat(s.substring(2,s.length()-2));
            }
            else {
            hrs = "";
            hrs = hrs.concat(s.substring(0,s.length()-2));
            }
        }
        else if(s.charAt(s.length()-2)=='P'){
            if(s.charAt(0)=='1' && s.charAt(1)=='2') {
            hrs = "12";
            hrs = hrs.concat(s.substring(2,s.length()-2));
            }
            else {
            int temp = Character.getNumericValue(c[1]);
            int temp1 = Character.getNumericValue(c[0]);
            hr = (temp1*10) + temp + 12;
            hrs = Integer.toString(hr);
            hrs = hrs.concat(s.substring(2,s.length()-2));
            }
        }
          return hrs;
    }

	public static void main(String[] args) {
		String s = "10:54:31PM";
		timeConversion(s);
		System.out.println(s);
	}

}
