import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         List<List<Integer>> dominoes = new ArrayList<>(List.of(
                 List.of(1,2),
                 List.of(2,3),
                 List.of(3,4),
                 List.of(4,5),
                 List.of(3,3)

         ));
        // List<Integer> count =  new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < dominoes.size(); i++) {
            count.add(i + 1);
        }
        System.out.println(count);
       // List<List<Integer>> news = new ArrayList<>();
      //  int[][] dominoes = {{1, 2}, {2, 4}, {2, 4}, {6, 4}, {2, 1}};
        List<String> listNewCount = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(0,dominoes.get(0).get(0));
        arr.add(1, dominoes.get(0).get(1));
        listNewCount.add(0, String.valueOf(1) + "+");

        dominoes.remove(0);
        count.remove(0);
   //    System.out.println(dominoes.size());
        int right;
        int left;
        int j=0;
       while (!dominoes.isEmpty()) {
        /*    right = dominoes.get(0).get(1);
           left = dominoes.get(0).get(0);*/

            for (int i = 0; i < dominoes.size(); i++) {
                right = dominoes.get(i).get(1);
                left = dominoes.get(i).get(0);
                 if(right!=left) {
                     if (right == arr.get(0)) {
                         arr.add(0, right);
                         arr.add(0, left);
                         listNewCount.add(0, (count.get(i)) + "+");
                         count.remove(i);
                         dominoes.remove(i);

                     } else if (left == arr.get(0)) {
                         arr.add(0, left);
                         arr.add(0, right);
                         listNewCount.add(0, (count.get(i)) + "-");
                         count.remove(i);
                         dominoes.remove(i);

                     } else if (right == arr.get(arr.size() - 1)) {
                         arr.add(right);
                         arr.add(left);
                         listNewCount.add(count.get(i) + "-");
                         count.remove(i);
                         dominoes.remove(i);

                     } else if (left == arr.get(arr.size() - 1)) {
                         arr.add(left);
                         arr.add(right);
                         listNewCount.add(count.get(i) + "+");
                         count.remove(i);
                         dominoes.remove(i);
                     }
                 }
                if (right == left && !dominoes.isEmpty() && !arr.isEmpty()) {
                    for (int k = 0; k < arr.size(); k++) {
                        if (right == arr.get(k) && left==arr.get(k)  && k!=0 && k!=(arr.size()-1)) {
                            arr.add(k, right);
                            arr.add(k, left);
                            listNewCount.add( i+1,(count.get(i) + "+"));
                            count.remove(i);
                            dominoes.remove(i);
                            break;
                        }
                    }
                }/*else {
                        System.out.println("Решения нет");
                        arr.clear();
                    }*/

            }
             j++;
           if (j > 10000) {
               arr.clear();
               listNewCount.clear();
               System.out.println("Решения нет");
               break;
           }
        }
        System.out.println(arr);
        for (int i = 0; i < listNewCount.size(); i++) {
            System.out.println(listNewCount.get(i));
        }
       // System.out.println(listNewCount);
    }
}