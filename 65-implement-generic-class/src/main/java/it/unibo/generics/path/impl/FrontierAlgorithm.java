package it.unibo.generics.path.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.impl.GraphImpl;
import it.unibo.generics.graph.api.Graph;

import it.unibo.generics.path.api.PathSearching;

public class FrontierAlgorithm<N> implements PathSearching<N> {

    Set<N> discovered = new HashSet<>();

    @Override
    public List<N> searchingAlgortithm(Graph<N> graph, N start, N end) {
        Graph<N> parents = new GraphImpl<>();
        List<N> queue = new LinkedList<>();
        queue.add(start);
        discovered.add(start);

        while(queue.size() != 0) {
            N node = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            if (node.equals(end)) { //node.compareTo(end) == 0
                return backtrace(parents, start, end);
            }
            for (N adjacent : graph.linkedNodes(node)) {
                if (!queue.contains(node) && !discovered.contains(adjacent)) {
                    parents.addNode(node);
                    parents.addNode(adjacent);
                    parents.addEdge(adjacent, node);
                    queue.add(adjacent);
                    discovered.add(adjacent);
                }
            }
        }
        return null;
    }

    private List<N> backtrace (Graph<N> parents, N start, N end) {
        List<N> path = new LinkedList<>();
        path.add(end);
        while(!path.get(path.size() - 1).equals(start)) {
            Set<N> parent = parents.linkedNodes(path.get(path.size() - 1));
            for (N parentNode : parent) {
                path.add(parentNode);
            }
        }

            return this.reverseString(path);
    }

    private List<N> reverseString (List<N> list) {
        List<N> reversedList = new LinkedList<N>();
        for (int i = 0; i < list.size(); i++) {
            reversedList.add(list.get(list.size() - 1 - i));
        }

        return reversedList;
    }

}
