package programmingTest2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Vector;

public class UsingMakerModel {

    public static int getNumberOfDifferentMakerModel(Vector<MakerModel> data) {
        HashSet<MakerModel> set = new HashSet<>(data);
        return set.size();
    }
    public static Vector<MakerModel> lengthSort(Vector<MakerModel> data) {
        Vector<MakerModel> copy = new Vector<>(data);
        Collections.sort(copy, new Comparator<MakerModel>() {
            public int compare(MakerModel x, MakerModel y) {
                int difference = (y.maker.length() + y.model.length()) - (x.maker.length() + x.model.length());

                return difference;
            }
        });

        return copy;
    }
    public static Vector<MakerModel> naturalSort(Vector<MakerModel> data) {
        Vector<MakerModel> temp = new Vector<>(data);
        Collections.sort(temp);

        return temp;
    }
    public static void printData(Vector<MakerModel> data, String message) {
        System.out.print(message + System.lineSeparator());
        for (MakerModel z : data) {
            System.out.println(z.toString());
        }
    }

    public static void main(String[] args) {
        String fileName = "MakerModel.txt";
        Vector<MakerModel> data = null;
        Vector<MakerModel> work = null;
        try {
            data = MakerModel.fromFile(fileName);
            work = naturalSort(data);
            printData(work, "natural sort");

            work = lengthSort(data);
            printData(work, "sorted by lengths");

            printData(data, "input sorting of data");
            System.out.println("\n" +getNumberOfDifferentMakerModel(data));
        } catch (Exception e) {
            System.out.print("FILE NOT FOUND " + fileName);
            System.exit(3);
        }
    }
}
