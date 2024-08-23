import java.util.Stack;

    class MyQueue {

        Stack<Integer> stk = new Stack<> ();
        Stack<Integer> stk2 = new Stack<> ();


        public MyQueue() {

        }

        public void push(int x) {

            stk.push ( x );

        }

        public int pop() {

            peek ();

            return stk2.pop ();
        }

        public int peek() {

            if (stk2.isEmpty ()) {
                while (!stk.isEmpty ())
                    stk2.push ( stk.pop () );
            }
            return stk2.peek ();
        }

        public boolean empty() {
            return stk.isEmpty () && stk2.isEmpty ();
        }

    }