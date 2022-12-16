package com.gokalp.casgembootcamp.gen.services.entityServices;

import com.gokalp.casgembootcamp.emp.dao.EmpEmployeeDao;
import com.gokalp.casgembootcamp.emp.entity.EmpEmployee;
import com.gokalp.casgembootcamp.gen.entity.BaseAdditionalFields;
import com.gokalp.casgembootcamp.gen.entity.BaseEntity;
import com.gokalp.casgembootcamp.gen.enums.GenErrorMessage;
import com.gokalp.casgembootcamp.gen.exceptions.ItemNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Gokalp on 14.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository> {
    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }
    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E save(E entity){
        return  (E)dao.save(entity);
    }

    public void delete(E e){
        dao.delete(e);
    }


    public E getByIdWithControl(Long id){
        Optional<E> entityOptional = findById(id);

        E entity;

        if(entityOptional.isPresent()){
            entity=entityOptional.get();
        }else {
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOTFOUND);
        }
        return entity;
    }

    public boolean existById(Long id){
        return dao.existsById(id);
    }

    private void setAdditional(E entity) {
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();

        Long currentCustomerId = getCurrentCustomerId();

        if (baseAdditionalFields == null) {
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }
        if (entity.getId() == null) {
            baseAdditionalFields.setCreateDate(new Date());
            baseAdditionalFields.setCreatedBy(currentCustomerId);
        }

        baseAdditionalFields.setUpdateDate(new Date());
        baseAdditionalFields.setUpdatedBy(currentCustomerId);
    }

    public Long getCurrentCustomerId() {
        //todo jwt
        Long currentCustomerId = null;
        return currentCustomerId;
    }

    public JpaRepository getDao(){
        return dao;
    }
}
