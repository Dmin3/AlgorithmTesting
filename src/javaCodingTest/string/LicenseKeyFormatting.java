package javaCodingTest.string;

// 라이센스 키 포맷
public class LicenseKeyFormatting {

    public static void main(String[] args) {

//        String s = "8F3Z-2e-9-w";
        String s = "8-5g-3-J";
        int k = 2;

        System.out.println(solve(s, k));
    }

    private static String solve(String s, int k) {
        // '-' 제거
        String str = s.replace("-", "");

        // 대문자로 변경
        String newStr = str.toUpperCase();

        StringBuilder sb = new StringBuilder(newStr);
        int len = sb.length();
        for (int i = k; i < len; i = i + k) {
            sb.insert(len-i, "-");
        }

        return sb.toString();
    }


}
