package RouteGraph;

class Graph {

	private Node vertices[];
	private int count;

	public Graph() {
		vertices = new Node[6];
		count = 0;
	}

	public void addNode(Node g) {
		if (count < 30) {
			vertices[count] = g;
			count++;
		}
		else {
			System.out.println("Graph full");
		}
	}

	public Node[] getNodes() {
		return vertices;
	}
}