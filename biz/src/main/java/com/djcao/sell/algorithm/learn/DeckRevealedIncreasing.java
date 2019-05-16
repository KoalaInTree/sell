package com.djcao.sell.algorithm.learn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/2/17
 */
public class DeckRevealedIncreasing {

    @Test
    public void deckRevealedIncreasing(){
        int[] deck = {1,7,2,9,22,56};
        Arrays.sort(deck);
        if (deck == null || deck.length <= 2)
            return;
        LinkedList<Integer> deque = new LinkedList();
        Integer last;
        for (int i = deck.length - 1; i >= 0;i--){
            if ((last = deque.pollLast()) != null)
             deque.offerFirst(last);
            deque.offerFirst(deck[i]);
        }
        System.out.println(deque.stream().mapToInt(Integer::intValue).toArray());

    }
}
