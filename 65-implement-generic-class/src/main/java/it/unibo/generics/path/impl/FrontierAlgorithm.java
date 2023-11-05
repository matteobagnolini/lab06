package it.unibo.generics.path.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.impl.GraphImpl;
import it.unibo.generics.graph.api.Graph;

import it.unibo.generics.path.api.PathSearching;

public class FrontierAlgorithm implements PathSearching<String> {

    Set<String> discovered = new HashSet<>();

    @Override
    public List<String> searchingAlgortithm(Graph<String> graph, String start, String end) {
        Graph<String> parents = new GraphImpl();
        List<String> queue = new LinkedList<>();
        queue.add(start);
        discovered.add(start);

        while(queue.size() != 0) {
            String node = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            if (node.compareTo(end) == 0) {
                return backtrace(parents, start, end);
            }
            for (String adjacent : graph.linkedNodes(node)) {
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

    private List<String> backtrace (Graph<String> parents, String start, String end) {
        List<String> path = new LinkedList<>();
        path.add(end);
        while(path.get(path.size() - 1).compareTo(start) != 0) {
            Set<String> parent = parents.linkedNodes(path.get(path.size() - 1));
            for (String parentNode : parent) {
                path.add(parentNode);
            }
        }

            return this.reverseString(path);
    }

    private List<String> reverseString (List<String> list) {
        List<String> reversedList = new LinkedList<String>();
        for (int i = 0; i < list.size(); i++) {
            reversedList.add(list.get(list.size() - 1 - i));
        }

        return reversedList;
    }

}
