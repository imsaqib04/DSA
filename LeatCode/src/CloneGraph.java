import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node> ();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    public Node cloneGraph(Node node) {

        if(node == null){         // if null return
            return null;
        }

        Queue<Node> q = new ArrayDeque<> ();                   //use for BFS

        //The key is the original node, and the value is the cloned node.
        // key  value
        Map<Node,Node> map = new HashMap<> ();    //is used to map the original node to its clone


        q.add(node);  // ADD Starting point

        map.put(node,new Node(node.val,new ArrayList<>())); //We clone the input node (by creating a new node
        //  object with the same value node.val but an empty list of neighbors) and put it in the map.

        while (!q.isEmpty()){
            Node n = q.poll();

            for(Node neighbor : n.neighbors){    //each neighbor of the current node (n),
                // we check if that neighbor  has already been cloned or Not.


                if(!map.containsKey(neighbor)){  //If the neighbor hasn’t been cloned yet

                    //(i.e., it is not present in the map), we clone it by creating a new node with the same value.
                    map.put(neighbor,new Node (neighbor.val,new ArrayList<>()));

                    q.add(neighbor);      //We add this neighbor node to the queue
                    // to process its neighbors in the future.
                }

                // Get the cloned node for 'n' from the map
                Node clonedNode = map.get(n);

                // Get the cloned neighbor from the map
                Node clonedNeighbor = map.get(neighbor);

                // Add the cloned neighbor to the cloned node's neighbors list
                clonedNode.neighbors.add(clonedNeighbor);
            }
        }

        return map.get(node);   // return the clone original starting node
    }
}