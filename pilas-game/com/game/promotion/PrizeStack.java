package com.game.promotion;

import java.util.*;

public class PrizeStack {
    private final Deque<String> stack = new ArrayDeque<>();

    public void award(String prize) {
        stack.push(prize);
    }
    public String revoke() {
        return stack.isEmpty() ? null : stack.pop();
    }
    public boolean isEmpty() { return stack.isEmpty(); }
    public List<String> getAll() { return new ArrayList<>(stack); }
    public int count() { return stack.size(); }
    public void clear() { stack.clear(); }
}