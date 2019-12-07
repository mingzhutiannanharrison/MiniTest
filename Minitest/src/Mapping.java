
import java.util.LinkedList;
import java.util.List;

public class Mapping {

    public List<String> resolve(int [] digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits == null || digits.length == 0) {
            return ans;
        }
        String[] intToStringArray = new String[]{"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int x, n = digits.length;
        String s;
        ans.add("");
        for (int i = 0; i < n; i++) {
            while (ans.peek().length() == i) {
                s = ans.remove();
                x = digits[i];
                for (char c : intToStringArray[x].toCharArray()) {
                    ans.add(s + c);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Mapping().resolve(new int[]{0,2}));//[0A, 0B, 0C]
        System.out.println(new Mapping().resolve(new int[]{2,3,4}));//[ADG, ADH, ADI, AEG, AEH, AEI, AFG, AFH, AFI, BDG, BDH, BDI, BEG, BEH, BEI, BFG, BFH, BFI, CDG, CDH, CDI, CEG, CEH, CEI, CFG, CFH, CFI]
    }
}

