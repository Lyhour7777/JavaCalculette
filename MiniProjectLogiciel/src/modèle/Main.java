package modèle;

public class Main {
    public static void main(String[] args) {
        CalculatorModel calc = new CalculatorModel();

        System.out.println("=== TEST 1: PUSH & STACK SETUP ===");
        calc.setAccu("10");
        calc.push(); // Stack: [10.0], Accu: "0"
        calc.setAccu("20");
        calc.push(); // Stack: [10.0, 20.0], Accu: "0"
        System.out.println("Stack size (Expected 2): " + calc.getMemory().size());
        System.out.println("Stack content: " + calc.getMemory());

        System.out.println("\n=== TEST 2: SWAP OPERATION ===");
        calc.setAccu("5"); // Accu: "5", Stack top: 20.0
        calc.swap();       // Swap Accu ("5") with Stack top (20.0) -> Accu: "20.0", Stack: [10.0, 5.0]
        System.out.println("Accu after SWAP (Expected 20.0): " + calc.getAccu());
        System.out.println("Stack top after SWAP (Expected 5.0): " + calc.getMemory().peek());

        System.out.println("\n=== TEST 3: POP OPERATION ===");
        calc.pop(); // Restores top of stack (5.0) into Accu -> Accu: "5.0", Stack: [10.0]
        System.out.println("Accu after POP (Expected 5.0): " + calc.getAccu());
        System.out.println("Stack size (Expected 1): " + calc.getMemory().size());

        System.out.println("\n=== TEST 4: DROP OPERATION ===");
        calc.drop(); // Removes 10.0 from stack without touching Accu
        System.out.println("Stack size after DROP (Expected 0): " + calc.getMemory().size());

        System.out.println("\n=== TEST 5: ARITHMETIC (RPN Subtraction: 15 - 3) ===");
        calc.setAccu("15");
        calc.push();
        calc.setAccu("3");
        calc.substract(); // 15.0 - 3.0
        System.out.println("Result (Expected 12.0): " + calc.getAccu());

        System.out.println("\n=== TEST 6: OPPOSITE & CLEAR ===");
        calc.opposite();
        System.out.println("Accu opposite (Expected -12.0): " + calc.getAccu());
        calc.clear();
        System.out.println("Accu after CLEAR (Expected 0): " + calc.getAccu());
        System.out.println("Stack size after CLEAR (Expected 0): " + calc.getMemory().size());

        System.out.println("\n=== TEST 7: SAFE EMPTY STACK HANDLER ===");
        // Ensure calling operations on an empty stack won't throw exceptions
        calc.pop();
        calc.drop();
        calc.swap();
        calc.add();
        System.out.println("No crash on empty stack operations! Tests Passed Successfully.");
    }
}