package leetcode;
 
import java.util.*;

class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
    	
    	Hashtable<UndirectedGraphNode, UndirectedGraphNode> map = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();
    	
    	ArrayList<UndirectedGraphNode> nodelist = new ArrayList<UndirectedGraphNode>();
    	
    	    	
    	nodelist.add(node);
		UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
		map.put(node, new_node);

    	UndirectedGraphNode res = new_node;


    	while (nodelist.isEmpty() == false) {
    		UndirectedGraphNode now = nodelist.remove(0);
    		new_node = map.get(now);
    		new_node.neighbors = new ArrayList<UndirectedGraphNode>();

    		for (UndirectedGraphNode tmp:now.neighbors) {
    			
    			if (map.containsKey(tmp)) { //already created
    				new_node.neighbors.add(map.get(tmp));
    			}
    			else {
    				UndirectedGraphNode new_tmp = new UndirectedGraphNode(tmp.label);
    				map.put(tmp, new_tmp);
    				nodelist.add(tmp);
    				new_node.neighbors.add(new_tmp);
    			}
    		}

    		
    	}
    	
    	return res;
    }
}
