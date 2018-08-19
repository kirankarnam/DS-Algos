package com.trie;

import java.util.ArrayList;

public class TrieNode {
	
	Character data;
	boolean isEnd;
	ArrayList<TrieNode> sibling ;
	ArrayList<TrieNode> child;
	
    public TrieNode(char c)
    {
        sibling = new ArrayList<TrieNode>();
        isEnd = false;
        data = c;
        child = new ArrayList<TrieNode>();
    } 

}
