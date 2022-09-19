import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String[] strings = {"5", "5", "2", "C", "D", "+"};
        Calculator calc = new Calculator();
        calc.calculate(strings);
    }
}

class Calculator{
    Stack<Integer> stack = new Stack<>();
    List<Integer> finalList = new ArrayList<>();

    public void calculate(String[] pos){
        for (String check : pos) {
            switch (check) {
                case "C" -> {
                    stack.pop();
                    finalList.remove(finalList.size() - 1);
                }
                case "D" -> {
                    int x = stack.pop();
                    finalList.remove(finalList.size() - 1);
                    stack.push(x * 2);
                    finalList.add(x * 2);
                }
                case "+" -> {
                    int first = stack.pop();
                    int next = stack.pop();
                    finalList.add(first + next);
                    stack.push(next);
                    stack.push(first);
                    stack.push(first + next);
                }
                default -> {
                    stack.push(Integer.parseInt(check));
                    finalList.add(Integer.parseInt(check));
                }
            }


        }

        for(int y : stack){
            System.out.println(y);
        }

        for(int y : finalList){
            System.out.println(y);
        }

        int result = 0;
        for(int y : finalList){
            result += y;
        }

        System.out.println(result);
    }

}