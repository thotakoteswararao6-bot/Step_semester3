package string.assignment_problems12;


class Editor {

    private String[] stack;
    private int top;

    public Editor(int capacity) {
        stack = new String[capacity];
        top = -1;
    }

    public void type(String word) {

        if (top == stack.length - 1) {
            System.out.println("rejected: history full");
            return;
        }

        stack[++top] = word;
        printCurrent();
    }

    public void undo() {

        if (top == -1) {
            System.out.println("rejected: nothing to undo");
            return;
        }

        top--;
        printCurrent();
    }

    private void printCurrent() {
        if (top == -1) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i <= top; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(stack[i]);
        }
        System.out.println();
    }
}