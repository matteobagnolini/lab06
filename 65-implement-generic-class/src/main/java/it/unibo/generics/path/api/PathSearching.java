package it.unibo.generics.path.api;

import java.util.List;
import it.unibo.generics.graph.api.Graph;


public interface PathSearching <N> {
    
    List<N> searchingAlgortithm (Graph<N> graph, N start, N end);

}
