
import java.util.LinkedList;
import java.util.List;

public class Mapping {

    public static List<String> resolve(int [] digits) {
        LinkedList<String> linkedList = new LinkedList<String>();
        if (digits == null || digits.length == 0) {
            return linkedList;
        }
        String[] mappingArray = new String[]{"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int x, n = digits.length;
        String s;
        linkedList.add("");
        for (int i = 0; i < n; i++) {
            while (linkedList.peek().length() == i) {
                s = linkedList.remove();
                x = digits[i];
                for (char c : mappingArray[x].toCharArray()) {
                    linkedList.add(s + c);
                }
            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        System.out.println(resolve(new int[]{0,2}));//[0A, 0B, 0C]
        System.out.println(resolve(new int[]{2,3,4}));//[ADG, ADH, ADI, AEG, AEH, AEI, AFG, AFH, AFI, BDG, BDH, BDI, BEG, BEH, BEI, BFG, BFH, BFI, CDG, CDH, CDI, CEG, CEH, CEI, CFG, CFH, CFI]
    }
}

