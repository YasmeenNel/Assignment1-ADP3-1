
package za.ac.cput.repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IRepository <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);




}
