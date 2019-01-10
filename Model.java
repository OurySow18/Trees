package com.assignment3.projekt;

public class Model {
	
	private int treeSelected;
	public static final int BLACK_RED_ID = 1;
	public static final int PATRICIA_ID = 2;
	public static final int ROBDD_ID = 3;
	public static final int TOP_DOWN_ID = 4;
	
	private BlackRedTree<String, String> brt = new BlackRedTree<String, String>();
	
	
	public Model() {
		treeSelected = 0;
	}
	

	void add(String input) {
		switch(treeSelected) {
		case BLACK_RED_ID:
			brt.insert(input, input);
			break;
		case PATRICIA_ID:
			break;
		case ROBDD_ID:
			break;
		case TOP_DOWN_ID:
			break;
		}
	}
	
	void remove(String input) {
		switch(treeSelected) {
		case BLACK_RED_ID:
			brt.remove(input);
			break;
		case PATRICIA_ID:
			break;
		case ROBDD_ID:
			break;
		case TOP_DOWN_ID:
			break;
		}
	}
	
	
	String generateUdrawString() throws Exception {
		System.out.println(treeSelected);
		System.out.println(BLACK_RED_ID);
		
		switch(treeSelected) {
		case BLACK_RED_ID:
			return udgRBT();
		case PATRICIA_ID:
			return udgPatricia();
		case ROBDD_ID:
			return udgROBDD();
		case TOP_DOWN_ID:
			return udgTopDown();
		default: throw new Exception("no tree selected");
		}
	}
	
	private String udgROBDD() {
		// TODO Auto-generated method stub
		return null;
	}


	private String udgTopDown() {
		// TODO Auto-generated method stub
		return null;
	}


	private String udgPatricia() {
		// TODO Auto-generated method stub
		return null;
	}


	private String udgRBT() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		addNodeToString(brt.m_Root.m_Key, sb);
		sb.append("[");
		addEdgeToRedBlackString(brt.m_Root, brt.m_Root.m_Left, sb);
		addNodeToString(brt.m_Root.m_Left.m_Key, sb);
		sb.append("[])))),");
		sb.append("]");
		
		sb.append("))]");
		return sb.toString();
	}

	void addNodeToString(String key, StringBuilder sb) {
		sb.append("l(\"" + key + "\",n(\"\", [a(\"OBJECT\",\"" + key + "\")],");
	}
	
	void addEdgeToRedBlackString(BlackRedTree.Node fromNode, BlackRedTree.Node toNode, StringBuilder sb) {
		String color = toNode.m_bIsRed ?  "red" : "black";
		sb.append("l(\"" + fromNode.m_Key + toNode.m_Key + "\", e(\"\", [a(\"EDGECOLOR\", \"" + color + "\")],");
	}

	void setSelectedTree(int treeID) {
		System.out.println(treeID);
		this.treeSelected = treeID;
	}
	
}
