	package com.trie;

public class Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode(' ');
	}
	
	public TrieNode trie_at_level(TrieNode node, Character c) {
		if(c==null || node == null) return null;
		
		TrieNode curr = node;
		
		if(curr.sibling!=null) {
			if(curr.sibling.contains(c))
				return curr;
		}
		return null;
	}
	
	
	public void insert(TrieNode root,String word) {
		if(word == null || word.length() ==0) throw new IllegalArgumentException();
		
		int length = word.length();
		
		TrieNode curr = root;
		for(int i=0;i<length;i++) {
			Character c = word.charAt(i);
			TrieNode child = trie_at_level(curr, c);
			
			if(child != null) {
				curr = child;
			}else {
				curr.child.add(new TrieNode(c));
				curr = trie_at_level(curr, c);
			}
		}
		curr.isEnd = true;
	}
	
	public boolean search(TrieNode root,String word) {
		if(word == null ) return false;
		
		TrieNode curr = root;
		int length = word.length();
		
		for(int i=0;i<length;i++) {
			Character c = word.charAt(i);
			TrieNode child = trie_at_level(curr, c);
			if(child == null)
				return false;
			else {
				curr = trie_at_level(curr, c);
			}
		}
		
		return (curr.isEnd)?true:false;
		
	}

}
