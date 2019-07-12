package dao;

import entity.Aution;

import java.util.ArrayList;

public interface AutionDao {

    Boolean addAution(Aution aution);
    Boolean DeletAution(int id);
    Boolean UpdateAution(int id, Aution aution);
    Aution findAutionById(int id);

    ArrayList<Aution> findAllAution();
}
