package com.negocioBimba.negocioBimba.converters;

import java.util.List;

public interface Converter <D,E>{
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDto(List<E> entityList);
    List<E> toEntity(List<D> dtoList);
}
