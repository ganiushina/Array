package Lesson7;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;

    private final boolean[][] adjMat;

    private int size;


    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return  getSize() == 0;
    }

    public void addEdges(String start, String second, String... others) {
        addEdge(start, second);
        for (String another : others) {
            addEdge(start, another);
        }
    }

    public void addEdge(String start, String finish) {
        int startIndex =  indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }


    public void addRoadMoscowToVoronej(String start, String finish) {
        int startIndex =  indexOf(start);
        int finishIndex = indexOf(finish);

        LinkedHashMap<Vertex, Vertex> vertexVisitedList = new LinkedHashMap<>(); // создаем дополнительный LinkedHashMap, куда добавляем связь вершин.


        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        vertexVisitedList.put(vertex, null);

        Vertex vertexLast = vertex;

        visitVertex(queue, vertex);

        while ( !queue.isEmpty() ) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
                vertexVisitedList.put(vertex, vertexLast);
            }
            else {
                vertexLast = ((LinkedList<Vertex>) queue).getLast();
                vertexVisitedList.put(vertexLast, ((LinkedList<Vertex>) queue).getFirst());
                queue.remove();
            }
        }

        resetVertexState();

        LinkedHashMap<Vertex, Vertex> vertexVisitedList1;
        vertexVisitedList1 = reverseMap(vertexVisitedList); // переворачиваем LinkedHashMap, чтобы идти от конца

        Vertex vertexStep1;
        Vertex vertexStep2;
        List<String> list = new ArrayList<>();


        for(Map.Entry entry : vertexVisitedList1.entrySet()){
            vertexStep1 = (Vertex) entry.getKey();
            if (vertexStep1.getLabel().equals(finish)){
                vertexStep2 = (Vertex) entry.getValue();
                list.add(vertexStep1.getLabel());
                if (vertexStep2 != null) {
                    finish = vertexStep2.getLabel();
                }
            }
        }

        Collections.reverse(list);
        System.out.println("Кратчайший путь от Москвы до Воронежа : " + list.toString());
    }

    public static LinkedHashMap<Vertex, Vertex> reverseMap(LinkedHashMap<Vertex, Vertex> toReverse)
    {
        LinkedHashMap<Vertex, Vertex> reversedMap = new LinkedHashMap<>();
        List<Vertex> reverseOrderedKeys = new ArrayList<>(toReverse.keySet());
        Collections.reverse(reverseOrderedKeys);
        reverseOrderedKeys.forEach((key)->reversedMap.put(key,toReverse.get(key)));
        return reversedMap;
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while ( !stack.isEmpty() ) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            }
            else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while ( !queue.isEmpty() ) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            }
            else {
                queue.remove();
            }
        }

        resetVertexState();

    }

    private void resetVertexState() {
        for (int i = 0; i < size; i++) {
            vertexList.get(i).setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < size; i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }

}
