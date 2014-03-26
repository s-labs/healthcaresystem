package com.healthcare.util;

public interface GenericDao<T1, T2> {

	Object findById(Long valueOf);

}
