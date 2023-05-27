package DAO; 
import java.util.ArrayList; 
public interface IDAO<T> { 
public int insert(T Obj) ; 
public int update(T Obj) ; 
public int delete(T Obj) ; 
public ArrayList<T> Select(String type) ; 
} 
