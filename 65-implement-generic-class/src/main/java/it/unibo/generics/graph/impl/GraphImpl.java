package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl implements Graph<String> {

    Map<String, Set<String>> graph = new HashMap<>();
    
    public GraphImpl () {

    }


    @Override
    public void addNode(String node) {
        if (!this.graph.containsKey(node)) {
            Set<String> connectedTo = new HashSet<>();
            this.graph.put(node, connectedTo);
        }
    }

    @Override
    public void addEdge(String source, String target) {
        if (this.graph.containsKey(source)) {
            this.graph.get(source).add(target);
        }
    }

    @Override
    public Set<String> nodeSet() {
        return this.graph.keySet();
    }

    @Override
    public Set<String> linkedNodes(String node) {
        return this.graph.get(node);
    }

    @Override
    public List<String> getPath(String source, String target) {
        
        return null;
    }    
}