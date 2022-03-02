import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static Double avg(List<Double> nums) {
        double result = 0.0;
        for (double num: nums) {
            result += num;
        }
        return result / nums.size();
    }

    public static void main(String[] args) {
        List<Double> nums = new ArrayList<Double>();
        nums.add(1.0);
        nums.add(2.0);
        System.out.println(avg(nums).toString());


    }

    public class Queue {
        private LinkedList<Integer> nums;

        // конструктор
        public Queue(){
            this.nums = new LinkedList<>();
        }
        public Queue(LinkedList<Integer> nums){
            this.nums = nums;
        }

        public void push(Integer num) {
            nums.addFirst(num);
        }

        public LinkedList<Integer> get() {
            return this.nums;
        }

        public String toString() {
            return nums.toString();
        }
    }

    public class Stack {
        private List<Integer> nums;

        public Stack(List<Integer> nums){
            this.nums = nums;
        }

        public Integer pop() {
            // возвращает первый элемент списка и его удаляет
            Integer num = nums.get(0);
            nums.remove(0);
            return num;
        }

        public void push(Integer num) {
            // добавляет элемент в конец списка
            nums.add(num);
        }

        public Integer peek() {
            // возвращет последний элемент
            int n = nums.size() - 1;
            Integer num = nums.get(n);
            nums.remove(n);
            return num;
        }

        public List<Integer> get() {
            return this.nums;
        }

        public String toString() {
            return nums.toString();
        }
    }
}



