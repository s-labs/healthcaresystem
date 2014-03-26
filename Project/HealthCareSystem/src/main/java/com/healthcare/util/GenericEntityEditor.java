package com.healthcare.util;

import java.beans.PropertyEditorSupport;

public class GenericEntityEditor<ENTITY extends GenericEntity<Long>> extends PropertyEditorSupport{
	
	private GenericDao<ENTITY, Long> genericDao;

    public GenericEntityEditor(GenericDao<ENTITY, Long> genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(genericDao.findById(Long.valueOf(text)));
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getAsText() {
    	System.out.println("------------------- get as Txt ----------------- ");
        ENTITY entity = (ENTITY) getValue();
        if(entity == null) {
        	System.out.println(" *****************getting null ***************");
            return null;
        } 

        return String.valueOf(entity.getId());
    }

}
