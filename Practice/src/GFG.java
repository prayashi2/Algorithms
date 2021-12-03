/*package whatever //do not write package name here */

import java.io.*;
import java.util.Stack;

class GFG {
    public static void main(String args[])
    {
        Stack<Character> st =
                new Stack<Character>();

        // push elements into the stack
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');
        st.push('6');
        st.push('7');
        st.push('8');

        /*int k=st.size()/2;
        deleteMid(st, k+1);
        while (!st.empty())
        {
            char p=st.pop();
            System.out.print(p + " ");
        }*/

        // Printing stack after deletion
        // of middle.
        System.out.println(st);
        reverse (st);
        System.out.println(st);
    }

    static void deleteMid(Stack<Character> st,
                          int n)
    {

        // If stack is empty or all items
        // are traversed
        if (st.empty())
            return;

        else {
            char popped = st.pop();
            deleteMid(st,n-1);
            st.push(popped);
        }
    }

    static void reverse(Stack<Character> st)
    {
        if(st.size() > 0)
        {
            char x = st.pop();
            reverse(st);
            insert(st, x);
        }
    }

    static void insert(Stack<Character> st, Character x)
    {
        if(st.isEmpty())
            st.push(x);

        else {
            char a = st.pop();
            insert(st, x);
            st.push(a);
        }
    }
}