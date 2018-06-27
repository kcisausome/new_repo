package project5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DfsDriver {
	
	public static ArrayList<Integer> st = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			exit();
		}
		
		
		//make new graph g, from the input
		StronglyConn g = new StronglyConn(args[0]);
		System.out.print(g);
		for (int i = 0; i < g.getOrder(); i++) {
			if (!g.getVertex(i).isMarked()) {
				g.dfs(i);
			}
		}
		
		//make new graph h, a reverse version of g
		StronglyConn h = new StronglyConn(g.getName(), g.getOrder(), g.getSize(), g.isDirected(), g.isWeighted());
		for (int i = 0; i < g.getSize(); i++) {
			h.addEdge(g.getEdges()[i].getHead(), g.getEdges()[i].getTail());
		}
		
		

		/*
		// puts stack from g into h
		for (int i = 0; i < g.st.size(); i++) {
			h.st.add(g.st.get(i));
		}*/
		System.out.println("before");
		for(int i: st){
			System.out.print(i);
		}
		/*
		h.preVisit(0);
		System.out.println("\nafter");
		for(int i: h.st){
			System.out.print(i);
		}
		h.preVisit(1);
		System.out.println("\nxxxx"+h.st.get(0));
		for(int i: h.st){
			System.out.print(i);
		}*/
		///*	
		//int x = 0;// position in stack because stuff doesn't get deleted for some reason
		while (!st.isEmpty()){ //&& x < h.st.size() ) {
			int i =  st.get(0);
			//System.out.println("i: "+ i);
			if (!h.getVertex(i).isMarked()) {
				
				System.out.println("\nbefore");
				for(int j:  st){
					System.out.print(j);
				}
				
				System.out.print("\n"+ "Component: ");
				h.dfs(i);
				
				System.out.println("\nafter");
				for(int k:  st){
					System.out.print(k);
				}
			}
			//x++;
		}//*/
	}
	public void preVisit(int v) {
		if(! st.isEmpty() &&  st.contains(v)){
			System.out.print(v);
			 st.remove( st.indexOf(v));
		}
	}
	
	public void postVisit(int v) {
		 st.add(0, v);
	}
	public static void exit() {
		System.out.println("Usage:Java shop <item.file>");
		System.exit(0);
	}
}
