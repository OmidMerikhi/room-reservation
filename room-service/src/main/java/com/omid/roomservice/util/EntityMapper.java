package com.omid.roomservice.util;

import java.util.List;

public interface EntityMapper<V,E> {
    V toViewModel(E entity);
    E toEntity(V viewModel);
    List<V> toViewModel(List<E> entity);
    List<E> toEntity(List<V> viewModel);
}
