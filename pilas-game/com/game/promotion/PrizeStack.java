package com.game.promotion;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PrizeStack {
    private Stack<String> stack = new Stack<>();

    public void award(String prize) {
        stack.push(prize);
    }

    public String revoke() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public List<String> getAll() {
        return new ArrayList<>(stack);
    }
    
     public void clear() {
        stack.clear();
    }
}
