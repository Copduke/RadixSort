import java.util.ArrayList;
import java.util.Scanner;

public class AufgabeB6A1 {

    public int[] data;
    public static int[] readInput() throws NumberFormatException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> dataList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            dataList.add(scanner.nextInt());
        }
        if (dataList.size() == 0) {
            throw new NumberFormatException();
        }
        int[] data = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }

    public AufgabeB6A1(int[] data){
        this.data = data;
    }

    public void sortByByte(int l, int r, int b) {
        int[] freq = new int[256];
        int[] help = new int[r - l + 1];
        int temp;

        for (int i = l; i <= r; i++) {
            temp = (data[i] >> (8*b)) & 0xFF;
            for (int j = temp; j >= 0 ; j--) {
                freq[j]++;
            }
        }

        for (int i = r; i >= l; i--) {
            temp = (data[i] >> (8*b)) & 0xFF;
            freq[temp]--;
            help[freq[temp]] = data[i];
        }

        int count = 0;
        for (int i = l; i <= r; i++) {
            data[i] = help[count];
            count++;
        }
    }

    public void lsdRadix() {
        for (int i = 0; i < 4; i++) {
            sortByByte(0, data.length-1,i);
        }
    }

    public void msdRadix(int l, int r, int b) {

    }

    public static void main(String[] args) {
        int[] freq = {2, 7, 9, 3, 5, 270};
        AufgabeB6A1 test = new AufgabeB6A1(freq);
        test.lsdRadix();
    }
}