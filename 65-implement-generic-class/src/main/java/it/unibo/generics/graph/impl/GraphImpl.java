package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.path.api.PathSearching;
import it.unibo.generics.path.impl.FrontierAlgorithm;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> graph = new HashMap<>();
    
    public GraphImpl () {

    }


    @Override
    public void addNode(final N node) {
        if (!this.graph.containsKey(node)) {
            Set<N> connectedTo = new HashSet<>();
            this.graph.put(node, connectedTo);
        }
    }

    @Override
    public void addEdge(final N source, final N target) {
        if (this.graph.containsKey(source)) {
            this.graph.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return this.graph.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return this.graph.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        PathSearching<N> BFS = new FrontierAlgorithm<N>();
        return BFS.searchingAlgortithm(this, source, target);
    }    
}