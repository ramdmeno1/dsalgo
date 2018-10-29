import java.util.ArrayList;
import java.util.List;

public class Bipartite {
    public boolean isBipartite(Graph graph) {
        for(Node node: graph.getNodes()) {
            if (node.getState() == State.UNVISITED) {
                if (!dfsVisit(node))
                    return false;
            }
        }
        return true;
    }

    public boolean dfsVisit(Node node) {
        node.setState(State.VISITING);
        for(Node neighbor: node.neighbors) {
            if (neighbor.getState() == State.UNVISITED) {
                neighbor.setColor(!node.getColor());
                if (!dfsVisit(neighbor)) return false;
            } else {
                if (node.getColor() == neighbor.getColor())
                    return false;
            }
        }
        node.setState(State.VISITED);
        return true;
    }

    public static class Graph {
        List<Node> nodes;

        public Graph(List<Node> nodes) {
            this.nodes = nodes;
        }

        public void addNode(Node node) {
            nodes.add(node);
        }

        public List<Node> getNodes() {
            return nodes;
        }
    }

    public static enum State {
        UNVISITED,
        VISITING,
        VISITED
    }

    public static class Node {
        int data;
        List<Node> neighbors;
        State state;
        boolean color;

        public Node(int data) {
            this.data = data;
            this.state = State.UNVISITED;
            this.neighbors = new ArrayList<Node>();
            this.color = false;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void addNeighbor(Node node) {
            neighbors.add(node);
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public boolean getColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }
}
